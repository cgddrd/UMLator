package uk.ac.aber.dcs.cs124.clg11.frame;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;
import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;


public class NewClassDialog implements ActionListener{
    JRadioButton StrButton;
    JRadioButton IntButton;
    JRadioButton DoubButton;
    JRadioButton BoolButton;
    JRadioButton OthButton;
    JRadioButton strButton2;
    JRadioButton intButton2;
    JRadioButton doubButton2;
    JRadioButton boolButton2;
    JRadioButton othButton2;
    JRadioButton aButton;
    JRadioButton bButton;
    JRadioButton cButton;
    JRadioButton dButton;
    JRadioButton aButton2;
    JRadioButton bButton2;
    JRadioButton cButton2;
    JRadioButton dButton2;
    JFrame guiFrame;
    JPanel buttonPanel;
    JTextField methodt;
    JTextField objectt;
    JTextField textt;
    JTextField mettextt;
    JTextField className;
    DefaultListModel listObject;
    DefaultListModel listMethod;
    String name;
    JList obList;
    JList metList;
    
    private CanvasPanel canvasPanel;
    private int x, y;


    
    public NewClassDialog(CanvasPanel cp, int x, int y)
    {
        guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Class Options...");
        guiFrame.setSize(270,550);
        guiFrame.setLocationRelativeTo(null);
        
        canvasPanel = cp;
        this.x = x;
        this.y = y;
        
        JPanel optionPanel= new JPanel();
        JPanel optionPanel2 = new JPanel();
        JPanel optionPanel3 = new JPanel();
        JPanel optionPanel4 = new JPanel();
        Border outline = BorderFactory.createLineBorder(Color.black);
        optionPanel.setBorder(outline);
        optionPanel2.setBorder(outline);
        optionPanel.setLayout(new BoxLayout(optionPanel,BoxLayout.Y_AXIS));    
        optionPanel2.setLayout(new BoxLayout(optionPanel2,BoxLayout.Y_AXIS));    
        optionPanel2.setBorder(outline);
        className = new JTextField(8);
        JLabel newClass = new JLabel("NewClass:");
        listObject = new DefaultListModel();
        listObject.addElement("item1");
        listObject.addElement("item2");
        final JList obList = new JList(listObject);  
        JScrollPane scrollPane = new JScrollPane(obList);
        objectt = new JTextField();        
        JLabel object = new JLabel("Instance Variables");

        methodt = new JTextField();        
        JLabel method = new JLabel("Methods");
        listMethod = new DefaultListModel();
        listMethod.addElement("item1");
        listMethod.addElement("item2");
        final JList metList = new JList(listMethod);
        JScrollPane scrollPane2 = new JScrollPane(metList);       
JLabel newVar = new JLabel("New Variable Name:") ;
JLabel newMet = new JLabel("New Method Name:");
JButton OK = new JButton("OK");
JButton CANCEL = new JButton("CANCEL");
JLabel ofType = new JLabel("Of Type:");        
JLabel type = new JLabel("Type:");
JLabel metofType = new JLabel("Of Type:");        
JLabel mettype = new JLabel("Type:");
aButton = new JRadioButton("Public");
bButton = new JRadioButton("Private");
cButton = new JRadioButton("Protected");
dButton = new JRadioButton("Defualt");
IntButton = new JRadioButton("Int");
StrButton = new JRadioButton("String");
BoolButton = new JRadioButton("Bool");
DoubButton = new JRadioButton("Double");
OthButton = new JRadioButton("Other");
aButton2 = new JRadioButton("Public");
bButton2 = new JRadioButton("Private");
cButton2 = new JRadioButton("Protected");
dButton2 = new JRadioButton("Defualt");
intButton2 = new JRadioButton("Int");
strButton2 = new JRadioButton("String");
boolButton2 = new JRadioButton("Bool");
doubButton2 = new JRadioButton("Double");
othButton2= new JRadioButton("Other");
//Create a ButtonGroup object, add buttons to the group
ButtonGroup sign = new ButtonGroup();
sign.add(aButton);
sign.add(bButton);
sign.add(cButton);
sign.add(dButton);

ButtonGroup oftype = new ButtonGroup();
oftype.add(IntButton);
oftype.add(StrButton);
oftype.add(BoolButton);
oftype.add(DoubButton);
oftype.add(OthButton);

ButtonGroup metsign = new ButtonGroup();
metsign.add(aButton2);
metsign.add(bButton2);
metsign.add(cButton2);
metsign.add(dButton2);

ButtonGroup metoftype = new ButtonGroup();
metoftype.add(intButton2);
metoftype.add(strButton2);
metoftype.add(boolButton2);
metoftype.add(doubButton2);
metoftype.add(othButton2);

textt = new JTextField();
        textt.disable();
        OthButton.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
                if (OthButton.isSelected()) {textt.enable();}
                //disable when not using!!!******************************************************                
                
            }
        });
 mettextt = new JTextField();
        mettextt.disable();
        othButton2.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
                if (othButton2.isSelected()) {mettextt.enable();}
                //disable when not using!!!******************************************************                
                
            }
        });       
 JButton addObject = new JButton("Add Object        ");
        addObject.setActionCommand("Add Object");
        addObject.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
               
      String sign= null;
      String type =null;
      String space = " ";
      
      if (!aButton.isSelected()&& !bButton.isSelected() && !cButton.isSelected() && !dButton.isSelected()){
      String message = "You did not select a type! Select one before continuing.(Public etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
      
      else if (!StrButton.isSelected() && !IntButton.isSelected() && !BoolButton.isSelected() && !DoubButton.isSelected() && !OthButton.isSelected()){
      String message = "You did not select an of type! Select one before continuing.(Int etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
            
      else {          if (aButton.isSelected()){sign = "+";}
                      if (bButton.isSelected()) {sign = "-";}
                      if (cButton.isSelected()) {sign = "#";}
                      if (dButton.isSelected()) {sign = "~";}
                      if (StrButton.isSelected()) {type = ": String";}
                      if (IntButton.isSelected()) {type = ": int";}
                      if (BoolButton.isSelected()) {type = ": Bool";}
                      if (DoubButton.isSelected()) {type = ": double";}             
                      if (OthButton.isSelected()) {type = ": " + textt.getText() ;}              
        
         
            listObject.add(0,sign + space + objectt.getText() + space + type);} 
            }});
            
        
        JButton removeObject = new JButton("Remove Object");
        removeObject.setActionCommand("Remove Object");
        removeObject.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
               
               listObject.remove(obList.getSelectedIndex());
               
                
                
            }
        });
                JButton changeObject = new JButton("Change Object ");
        changeObject.setActionCommand("Change Object");
        changeObject.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
               
                               
            }
        });
        JButton addMethod = new JButton("Add Method        ");
        addMethod.setActionCommand("Add Method");
        addMethod.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
      String sign2= null;
      String type2 =null;
      String space2 = " ";
      String brackets = "()";
              
      if (!aButton2.isSelected()&& !bButton2.isSelected() && !cButton2.isSelected() && !dButton2.isSelected()){
      String message = "You did not select a type! Select one before continuing.(Public etc.) ";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
      
      else if (!strButton2.isSelected() && !intButton2.isSelected() && !boolButton2.isSelected() && !doubButton2.isSelected() && !othButton2.isSelected()){
      String message = "You did not select an of type! Select one before continuing.(Int etc.) ";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
      else{
                      if (aButton2.isSelected()) {sign2 = "+";} 
                      if (bButton2.isSelected()) {sign2 = "-";}
                      if (cButton2.isSelected()) {sign2 = "#";}
                      if (dButton2.isSelected()) {sign2 = "~";}
                      if (strButton2.isSelected()) {type2 = ": String";}
                      if (intButton2.isSelected()) {type2 = ": int";}
                      if (boolButton2.isSelected()) {type2 = ": Bool";}
                      if (doubButton2.isSelected()) {type2 = ": double";}
                      if (othButton2.isSelected()) {type2 = ": " + mettextt.getText() ;}
               listMethod.add(0, sign2 + space2 + methodt.getText()+ brackets+ space2 + type2);
      }
                
            }
        });
                 JButton removeMethod = new JButton("Remove Method");
        removeMethod.setActionCommand("Remove Method");
        removeMethod.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
            listMethod.remove(metList.getSelectedIndex());
                
            }
        });
                JButton changeMethod = new JButton("Change Method ");
        changeMethod.setActionCommand("Change Method");
        removeObject.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {

                
            }
        });
        //settiong size of panels
        Dimension Size = new Dimension(300,100);
        objectt.setMaximumSize(Size);
        methodt.setMaximumSize(Size);  
        className.setMaximumSize(Size);
        optionPanel.setMaximumSize(Size);
        optionPanel2.setMaximumSize(Size);

        scrollPane2.setMaximumSize(Size);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        method.setMaximumSize(Size);
        scrollPane.setMaximumSize(Size);
        scrollPane2.setAlignmentX(Component.LEFT_ALIGNMENT);
        object.setMaximumSize(Size);
       
        optionPanel.add(object);
        optionPanel.add(scrollPane); 
        optionPanel.add(newVar);
        optionPanel.add(objectt);
        optionPanel.add(type);
        optionPanel.add(aButton);
        optionPanel.add(bButton);
        optionPanel.add(cButton);
        optionPanel.add(dButton);
        optionPanel.add(ofType);
        optionPanel.add(IntButton);
        optionPanel.add(StrButton);
        optionPanel.add(BoolButton);
        optionPanel.add(DoubButton);
        optionPanel.add(OthButton);
        optionPanel.add(textt);
        optionPanel.add(addObject);
        optionPanel.add(changeObject);
        optionPanel.add(removeObject);
        optionPanel2.add(method);
        optionPanel2.add(scrollPane2);
        optionPanel2.add(newMet);
        optionPanel2.add(methodt);
        optionPanel2.add(mettype);
        optionPanel2.add(aButton2);
        optionPanel2.add(bButton2);
        optionPanel2.add(cButton2);
        optionPanel2.add(dButton2);
        optionPanel2.add(metofType);
        optionPanel2.add(intButton2);
        optionPanel2.add(strButton2);
        optionPanel2.add(boolButton2);
        optionPanel2.add(doubButton2);
        optionPanel2.add(othButton2);
        optionPanel2.add(mettextt);
        optionPanel2.add(addMethod);
        optionPanel2.add(changeMethod);
        optionPanel2.add(removeMethod);
        optionPanel3.add(CANCEL);
        optionPanel3.add(OK);
        optionPanel4.add(newClass);
        optionPanel4.add(className) ;

        
           
        
        
        guiFrame.add(optionPanel, BorderLayout.WEST);
        
        guiFrame.add(optionPanel2, BorderLayout.EAST);
        
        guiFrame.add(optionPanel3, BorderLayout.SOUTH);
        
        guiFrame.add(optionPanel4, BorderLayout.NORTH);
        buttonPanel = new JPanel();
               
        guiFrame.setVisible(true);  
        
                       
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
        OK.addActionListener(this);
        
    }
   

    @Override
    public void actionPerformed(ActionEvent evt)
    {
	String actionCommand = evt.getActionCommand();
		
		if (actionCommand.equals("OK")) {
			this.addClass();
			guiFrame.dispose();
		} 
       
        
    }
    
    public void addClass() {


			int varNo = listObject.getSize();
			int opNo = listMethod.getSize();
			

		ClassDiagData cDD = new ClassDiagData();

		cDD.setClassName(className.getText());

		for (int i = 0; i < varNo; i++) {
		
			cDD.addInstanceVariable(listObject.get(i).toString()); //Create new data input 'template' and populate with use inputted data	
		}

		for (int i = 0; i < opNo; i++) {
			cDD.addMethod(listMethod.get(i).toString()); //Create new data input 'template' and populate with use inputted data	
			
		}

		cDD.setAccessModifier("+");

		ClassDiag e = new ClassDiag(x, y, varNo, opNo); //Create a new class object and set the details of it
		e.setData(cDD); //Set the associated data with from the cDD.

		canvasPanel.addDrawable(e);
		canvasPanel.repaint();

	}
}