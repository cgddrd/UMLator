
package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;
import uk.ac.aber.dcs.cs124.clg11.diag.RelationshipDiag;
import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

/**
 *
 * @author Craig
 */
public class NewRelDialog implements ActionListener{

	JFrame guiFrame;
	JPanel buttonPanel;
	JTextField classA;
	JTextField classB;
	JTextField assVar;
	JComboBox relType;
	private String class1;
	private String class2;
	private ClassDiag classObject1;
	private ClassDiag classObject2;
	private JLabel displayClass2;
	private RelationshipDiag rel;

	private CanvasPanel canvasPane;

	public NewRelDialog(CanvasPanel cp, int x1, int y1, int x2, int y2) {
		guiFrame = new JFrame();
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("New Relationship");
		guiFrame.setSize(300, 200);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true); 

		canvasPane = cp;
		
		this.addRel(x1, y1, x2, y2);

		JPanel optionPanel= new JPanel(new GridLayout(3,1));
		JPanel optionPanel2 = new JPanel(new GridLayout(3,1));
		JPanel optionPanel4 = new JPanel(new GridLayout(4,1));
		JPanel optionPanel3 = new JPanel(new GridLayout(2,1));
		Border outline = BorderFactory.createLineBorder(Color.black);        
		optionPanel.setBorder(outline);
		optionPanel2.setBorder(outline);
		optionPanel3.setBorder(outline);
		optionPanel4.setBorder(outline);

		JButton OK = new JButton("OK");
		JButton CANCEL = new JButton("CANCEL"); 

		JLabel help = new JLabel("Use '*' for many multiplicities");
		JLabel class1 = new JLabel("Class A:");
		JLabel class2 = new JLabel("Class B:");
		String getclassANAME = "(Test)";
		JLabel displayClass1 = new JLabel(this.class1); 
		displayClass2 = new JLabel(this.class2);
		JLabel var = new JLabel("          Associated Variable:");
		classA = new JTextField(8);
		classB = new JTextField(8);
		assVar = new JTextField(8);
		final String[] relTypes = { "ASSOCIATION", "AGGREGATION", "INHERITANCE", "COMPOSITION"};
		final JComboBox relType = new JComboBox(relTypes);

		CANCEL.setActionCommand("CANCEL");
		CANCEL.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{

				guiFrame.dispose();
			}
		});
		OK.setActionCommand("OK");
		OK.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{
				String classANum, classBNum;
				String RelType = (String) relType.getSelectedItem();

				String assV = assVar.getText();
				classANum = classA.getText();
				classBNum = classB.getText();
				if ("".equals(classANum) || "".equals(classBNum)){
					String message = "You Did Not Enter Both Class Multiplicities!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);;}

				if ("".equals(assVar.getText())){
					String message = "You Did Not Enter An Associated Variable!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);}

					else { 
						
						
					if (classANum.indexOf("*") > 0 || classBNum.indexOf("*") > 0) {
					
						
						rel = new RelationshipDiag(classObject1, classObject2, "private Arraylist<" + displayClass2.getText() + "> " + assVar.getText(),classANum, classBNum, RelType);				
					
					} else {
						rel = new RelationshipDiag(classObject1, classObject2, "private " + displayClass2.getText() + " " + assVar.getText(),classANum, classBNum, RelType);
					}
					canvasPane.addDrawable(rel);
					canvasPane.repaint(); 
					canvasPane.setStatus("Relationship Created Successfully");
					guiFrame.dispose();
				}}});

		optionPanel.setLayout(new BoxLayout(optionPanel,BoxLayout.Y_AXIS));
		optionPanel2.setLayout(new BoxLayout(optionPanel2,BoxLayout.Y_AXIS));


		CANCEL.setAlignmentX(Component.CENTER_ALIGNMENT);
		OK.setAlignmentX(Component.CENTER_ALIGNMENT);
		class1.setAlignmentX(Component.CENTER_ALIGNMENT);
		class2.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayClass1.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayClass2.setAlignmentX(Component.CENTER_ALIGNMENT);
		classA.setAlignmentX(Component.CENTER_ALIGNMENT);
		classB.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayClass1.setForeground(Color.red);
		displayClass2.setForeground(Color.red);

		optionPanel.add(class1);
		optionPanel.add(displayClass1);
		optionPanel.add(classA);
		optionPanel2.add(class2);
		optionPanel2.add(displayClass2);
		optionPanel2.add(classB);
		optionPanel4.add(var);
		optionPanel4.add(assVar);
		optionPanel4.add(OK);
		optionPanel4.add(CANCEL);
		optionPanel3.add(relType);
		optionPanel3.add(help);

		guiFrame.add(optionPanel, BorderLayout.WEST);
		guiFrame.add(optionPanel2, BorderLayout.EAST);
		guiFrame.add(optionPanel3, BorderLayout.NORTH);
		guiFrame.add(optionPanel4, BorderLayout.SOUTH);
		guiFrame.pack();
		
		
	}


	@Override
	public void actionPerformed(ActionEvent event)
	{


	}

	public void addRel(int x1, int y1, int x2, int y2) {
		
		try {
		
		ClassDiag class1 = canvasPane.findNearestClass(x1, y1);
		ClassDiag class2 = canvasPane.findNearestClass(x2, y2);
		
		ClassDiagData d = (ClassDiagData) class1.getData(); //How to obtain data from a class that you want...
		this.class1 = d.getClassName();
		
		d = (ClassDiagData) class2.getData(); //How to obtain data from a class that you want...
		this.class2 = d.getClassName();
	
		this.classObject1 = class1;
		this.classObject2 = class2;
		
	} catch (NullPointerException nPE) {
		JOptionPane.showMessageDialog(new JFrame(), "No classes created - Relationship not possible", "UMLator | Relationship Error", JOptionPane.ERROR_MESSAGE);
		guiFrame.dispose();	
	}
	}
	
}