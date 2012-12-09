package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;
import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

public class AddClassDialog extends JFrame implements ActionListener{

	private JPanel dialogPanel = new JPanel();
	private JTextField methodText, objectText, className;
	private DefaultListModel listObject, listMethod;
	private JList obList, metList;
	private CanvasPanel canvasPanel;
	private int x, y;
	private JLabel newClass, objectTitle, methodTitle, newVar, newMet, obAcTitle, obTypeTitle, metAcTitle, metTypeTitle;
	private JScrollPane scrollOb, scrollMeth;
	private JButton OK, CANCEL, addObject, removeObject, addMethod, removeMethod, addParam;
	private String[] accessModArr = { "Public", "Private", "Protected", "No Modifier" };
	private String[] varType = { "String", "Int", "Bool", "Double", "Void" };
	private String[] methType = { "Void", "Int", "String", "Bool", "Double",  };
	private JComboBox obModCombo, obTypeCombo, methModCombo, methTypeCombo;
	private SpringLayout layout;
	private JSeparator titleSep = new JSeparator(JSeparator.HORIZONTAL);
	private JSeparator objSep = new JSeparator(JSeparator.HORIZONTAL);
	private JSeparator metSep = new JSeparator(JSeparator.HORIZONTAL);

	public AddClassDialog(CanvasPanel cp, int x, int y) {

		layout = new SpringLayout();
		canvasPanel = cp;
		dialogPanel.setLayout(layout);
		dialogPanel.setPreferredSize(new Dimension(320,630));
		this.x = x;
		this.y = y;

		this.setTitle("UMLator | Create New Class");
		this.add(dialogPanel);
		
		Toolkit k=Toolkit.getDefaultToolkit();
		Dimension d=k.getScreenSize();
		this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2 - 300);

		initComponents();
		setLayout();

		pack();
		this.setVisible(true);

	}

	public void initComponents() {

		newClass = new JLabel("Class Name:");
		className = new JTextField(10);

		listObject = new DefaultListModel();
		listMethod = new DefaultListModel();

		obList = new JList(listObject);
		metList = new JList(listMethod);

		scrollOb = new JScrollPane(obList);
		scrollMeth = new JScrollPane(metList);

		objectText = new JTextField(15);
		methodText = new JTextField(15);

		objectTitle = new JLabel("Instance Variables:");
		methodTitle = new JLabel("Methods:");
		newVar = new JLabel("Variable Name:");
		newMet = new JLabel("Method Name:");
		obAcTitle = new JLabel("Access:");
		obTypeTitle = new JLabel("Type:");
		metAcTitle = new JLabel("Access:");
		metTypeTitle = new JLabel("Type:");

		addParam = new JButton("Add Parameter");
		addParam.addActionListener(this);
		OK = new JButton("OK");
		OK.addActionListener(this);
		CANCEL = new JButton("CANCEL");
		CANCEL.addActionListener(this);
		addObject = new JButton("Add Object");
		addObject.addActionListener(this);
		removeObject = new JButton("Remove Object");
		removeObject.addActionListener(this);
		addMethod = new JButton("Add Method");
		addMethod.addActionListener(this);
		removeMethod = new JButton("Remove Method");
		removeMethod.addActionListener(this);

		obModCombo = new JComboBox(accessModArr);
		obTypeCombo = new JComboBox(varType);
		methModCombo = new JComboBox(accessModArr);
		methTypeCombo = new JComboBox(methType);

		dialogPanel.add(newClass);
		dialogPanel.add(className);
		dialogPanel.add(scrollOb);
		dialogPanel.add(scrollMeth);
		dialogPanel.add(objectText);
		dialogPanel.add(methodText);
		dialogPanel.add(newVar);
		dialogPanel.add(newMet);
		dialogPanel.add(addParam);
		dialogPanel.add(OK);
		dialogPanel.add(CANCEL);
		dialogPanel.add(addObject);
		dialogPanel.add(removeObject);
		dialogPanel.add(addMethod);
		dialogPanel.add(removeMethod);
		dialogPanel.add(obModCombo);
		dialogPanel.add(obTypeCombo);
		dialogPanel.add(methModCombo);
		dialogPanel.add(methTypeCombo);
		dialogPanel.add(titleSep);
		dialogPanel.add(objSep);
		dialogPanel.add(metSep);
		dialogPanel.add(obAcTitle);
		dialogPanel.add(obTypeTitle);
		dialogPanel.add(metAcTitle);
		dialogPanel.add(metTypeTitle);

	}

	public void setLayout() {

		layout.putConstraint(SpringLayout.NORTH,newClass,10,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,newClass,60,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,className,10,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,className,5,SpringLayout.EAST, newClass);

		layout.putConstraint(SpringLayout.NORTH,titleSep,10,SpringLayout.SOUTH, className);
		layout.putConstraint(SpringLayout.WEST,titleSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleSep,-25,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,newVar,10,SpringLayout.SOUTH, titleSep);
		layout.putConstraint(SpringLayout.WEST,newVar,28,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,objectText,10,SpringLayout.SOUTH, titleSep);
		layout.putConstraint(SpringLayout.WEST,objectText,5,SpringLayout.EAST, newVar);

		layout.putConstraint(SpringLayout.NORTH,obAcTitle,13,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obAcTitle,31,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,obModCombo,10,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obModCombo,5,SpringLayout.EAST, obAcTitle);

		layout.putConstraint(SpringLayout.NORTH,obTypeTitle,13,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obTypeTitle,15,SpringLayout.EAST, obModCombo);

		layout.putConstraint(SpringLayout.NORTH,obTypeCombo,10,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obTypeCombo,5,SpringLayout.EAST, obTypeTitle);

		layout.putConstraint(SpringLayout.NORTH,scrollOb,20,SpringLayout.SOUTH, obTypeTitle);
		layout.putConstraint(SpringLayout.WEST,scrollOb,30,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,addObject,10,SpringLayout.SOUTH, scrollOb);
		layout.putConstraint(SpringLayout.WEST,addObject,50,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,removeObject,10,SpringLayout.SOUTH, scrollOb);
		layout.putConstraint(SpringLayout.WEST,removeObject,5,SpringLayout.EAST, addObject);

		layout.putConstraint(SpringLayout.NORTH,objSep,10,SpringLayout.SOUTH, removeObject);
		layout.putConstraint(SpringLayout.WEST,objSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, objSep,-25,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,newMet,10,SpringLayout.SOUTH, objSep);
		layout.putConstraint(SpringLayout.WEST,newMet,28,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,methodText,10,SpringLayout.SOUTH, objSep);
		layout.putConstraint(SpringLayout.WEST,methodText,5,SpringLayout.EAST, newMet);

		layout.putConstraint(SpringLayout.NORTH,metAcTitle,13,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,metAcTitle,28,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,methModCombo,10,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,methModCombo,5,SpringLayout.EAST, metAcTitle);

		layout.putConstraint(SpringLayout.NORTH,metTypeTitle,13,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,metTypeTitle,15,SpringLayout.EAST, methModCombo);

		layout.putConstraint(SpringLayout.NORTH,methTypeCombo,10,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,methTypeCombo,5,SpringLayout.EAST, metTypeTitle);

		layout.putConstraint(SpringLayout.NORTH,scrollMeth,10,SpringLayout.SOUTH, metTypeTitle);
		layout.putConstraint(SpringLayout.WEST,scrollMeth,30,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,addMethod,10,SpringLayout.SOUTH, scrollMeth);
		layout.putConstraint(SpringLayout.WEST,addMethod,45,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,removeMethod,10,SpringLayout.SOUTH, scrollMeth);
		layout.putConstraint(SpringLayout.WEST,removeMethod,5,SpringLayout.EAST, addMethod);

		layout.putConstraint(SpringLayout.NORTH,addParam,10,SpringLayout.SOUTH, removeMethod);
		layout.putConstraint(SpringLayout.WEST,addParam,50,SpringLayout.WEST, addMethod);

		layout.putConstraint(SpringLayout.NORTH,metSep,10,SpringLayout.SOUTH, addParam);
		layout.putConstraint(SpringLayout.WEST,metSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, metSep,-25,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,CANCEL,10,SpringLayout.SOUTH, metSep);
		layout.putConstraint(SpringLayout.WEST,CANCEL,85,SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH,OK,10,SpringLayout.SOUTH, metSep);
		layout.putConstraint(SpringLayout.WEST,OK,5,SpringLayout.EAST, CANCEL);
	}


	@Override
	public void actionPerformed(ActionEvent evt) {

		String actionCommand = evt.getActionCommand();

		if (actionCommand.equals("Add Object")) {
			String sign = null;
			String type = null;
			String result = (String) obModCombo.getSelectedItem();
			String result1 = (String) obTypeCombo.getSelectedItem();

			if (objectText.getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Please enter a variable name","UMLator | Error", JOptionPane.ERROR_MESSAGE);
			} else {
				if ("Public".equals(result)) {
					sign = "+";
				}
				if ("Private".equals(result)) {
					sign = "-";
				}
				if ("Protected".equals(result)) {
					sign = "#";
				}
				if ("No Modifier".equals(result)) {
					sign = "~";
				}
				if ("String".equals(result1)) {
					type = ": String";
				}
				if ("Int".equals(result1)) {
					type = ": int";
				}
				if ("Bool".equals(result1)) {
					type = ": Bool";
				}
				if ("Double".equals(result1)) {
					type = ": double";
				}
				if ("Void".equals(result1)) {
					type = ": void";
				}

				listObject.add(0, sign + " " + objectText.getText() + " " + type);
				this.objectText.setText("");
			}
		} else if (actionCommand.equals("Add Method")) {

			String sign = null;
			String type = null;
			String result = (String) methModCombo.getSelectedItem();
			String result1 = (String) methTypeCombo.getSelectedItem();

			if (methodText.getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Please enter a method name","UMLator | Error", JOptionPane.ERROR_MESSAGE);	
			} else {
				if ("Public".equals(result)) {
					sign = "+";
				}
				if ("Private".equals(result)) {
					sign = "-";
				}
				if ("Protected".equals(result)) {
					sign = "#";
				}
				if ("No Modifier".equals(result)) {
					sign = "~";
				}
				if ("String".equals(result1)) {
					type = ": String";
				}
				if ("Int".equals(result1)) {
					type = ": int";
				}
				if ("Bool".equals(result1)) {
					type = ": Bool";
				}
				if ("Double".equals(result1)) {
					type = ": double";
				}
				if ("Void".equals(result1)) {
					type = ": void";
				}

				listMethod.add(0, sign + " " + methodText.getText() + "()" + " " + type);
				this.methodText.setText("");
			}

		} else if (actionCommand.equals("Remove Method")) {

			if (listMethod.size() == 0) {

				JOptionPane.showMessageDialog(null, "No methods available to remove","UMLator | Error", JOptionPane.ERROR_MESSAGE);

			} else {

				listMethod.remove(metList.getSelectedIndex());
			}

		} else if (actionCommand.equals("Remove Object")) {

			if (listObject.size() == 0) {

				JOptionPane.showMessageDialog(null, "No variables available to remove", "UMLator | Error", JOptionPane.ERROR_MESSAGE);

			} else {

				listObject.remove(obList.getSelectedIndex());

			}

		} else if (actionCommand.equals("Add Parameter")) {

			if (listMethod.size() == 0) {

				ParamWindow paramWindow = new ParamWindow(this,metList.getSelectedIndex());

			} else {
				JOptionPane.showMessageDialog(null, "Please select a method to edit", "UMLator | Error", JOptionPane.WARNING_MESSAGE);
			}

		} else if (actionCommand.equals("OK")) {

			this.addClass();
			this.dispose();

		} else if (actionCommand.equals("CANCEL")) {

			this.dispose();

		}
	}

	public void addClass() {

		int varNo = listObject.getSize();
		int opNo = listMethod.getSize();

		ClassDiagData cDD = new ClassDiagData();

		cDD.setClassName(className.getText());

		for (int i = 0; i < varNo; i++) {

			cDD.addInstanceVar(listObject.get(i).toString()); // Create new data
		}

		for (int i = 0; i < opNo; i++) {
			cDD.addMethod(listMethod.get(i).toString()); // Create new data
		}

		cDD.setAccessModifier("+");

		ClassDiag e = new ClassDiag(x, y, varNo, opNo); // Create a new class

		e.setData(cDD); // Set the associated data with from the cDD.

		canvasPanel.addDrawable(e);
		canvasPanel.repaint();

	}

	public void addParams(String params, int index) {
		try {
			String s = (String) listMethod.get(index);
			StringTokenizer token = new StringTokenizer(s, ")");
			String output = token.nextToken() + params + ")" + token.nextElement();
			listMethod.set(index, output);	
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(new JFrame(), "No methods available - Parameter cannot be created", "UMLator | Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}