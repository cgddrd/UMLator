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
        guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guiFrame.setTitle("Class Options...");
        guiFrame.setSize(400,425);
        guiFrame.setLocationRelativeTo(null);
        
        canvasPanel = cp;
        this.x = x;
        this.y = y;
        
        JPanel optionPanel= new JPanel();
        JPanel optionPanel2 = new JPanel();
        JPanel optionPanel3 = new JPanel();
        JPanel optionPanel4 = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel,BoxLayout.Y_AXIS));    
        optionPanel2.setLayout(new BoxLayout(optionPanel2,BoxLayout.Y_AXIS)); 
        className = new JTextField(8);
        JLabel newClass = new JLabel("NewClass:");
        
        listObject = new DefaultListModel();
        final JList obList = new JList(listObject);  
        JScrollPane scrollPane = new JScrollPane(obList);
        objectt = new JTextField();        
        JLabel object = new JLabel("            Instance Variables");
        methodt = new JTextField();        
        JLabel method = new JLabel("                   Methods");
        listMethod = new DefaultListModel();
        final JList metList = new JList(listMethod);
        JScrollPane scrollPane2 = new JScrollPane(metList);       

        JLabel newVar = new JLabel("New Variable Name:                           ") ;
JLabel newMet = new JLabel("New Method Name:                               ");
JButton OK = new JButton("OK");
JButton CANCEL = new JButton("CANCEL");
JLabel ofType = new JLabel("Of Type:");        
JLabel type = new JLabel("Type:");
JLabel metofType = new JLabel("Of Type:");        
JLabel mettype = new JLabel("Type:");
final String[] status = { "Public", "Private", "Protected", "Defualt"};
final String[] varType = { "Int", "String", "Bool", "Double", "Void", "Other"};
final JComboBox objects1 = new JComboBox(status);
final JComboBox objects2 = new JComboBox(varType);
final JComboBox methods1 = new JComboBox(status);
final JComboBox methods2 = new JComboBox(varType);

textt = new JTextField();
        textt.disable();
        objects2.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String result = (String) objects2.getSelectedItem();
                if ("Other".equals(result)) {textt.enable();}
                else textt.disable();
                //disable when not using!!!******************************************************                
                
            }
        });
 mettextt = new JTextField();
        mettextt.setEnabled(false);
        methods2.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String result = (String) methods2.getSelectedItem();
                if ("Other".equals(result)) {mettextt.enable();}
                else mettextt.disable();
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
      String result = (String) objects1.getSelectedItem();
      String result1 = (String) objects2.getSelectedItem();
      
      if (!"Public".equals(result) && !"Private".equals(result) && !"Protected".equals(result) && !"Default".equals(result) ){
      String message = "You did not select a type! Select one before continuing.(Public etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
      
      else if (!"Int".equals(result1) && !"String".equals(result1) && !"Bool".equals(result1) && !"Double".equals(result1) && !"Void".equals(result1) && !"Other".equals(result1)){
      String message = "You did not select an of type! Select one before continuing.(Int etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
            
      else {          if ("Public".equals(result)){sign = "+";}
                      if ("Private".equals(result)) {sign = "-";}
                      if ("Protected".equals(result)) {sign = "#";}
                      if ("Default".equals(result)) {sign = "~";}
                      if ("String".equals(result1)) {type = ": String";}
                      if ("Int".equals(result1)) {type = ": int";}
                      if ("Bool".equals(result1)) {type = ": Bool";}
                      if ("Double".equals(result1)) {type = ": double";}   
                      if ("Void".equals(result1)) {type = ": void";} 
                      if ("Other".equals(result1)) {type = ": " + textt.getText() ;}              
        
         
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
                
      String sign= null;
      String type =null;
      String space = " ";
      String result = (String) methods1.getSelectedItem();
      String result1 = (String) methods2.getSelectedItem();
      
      if (!"Public".equals(result) && !"Private".equals(result) && !"Protected".equals(result) && !"Default".equals(result) ){
      String message = "You did not select a type! Select one before continuing.(Public etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
      
      else if (!"Int".equals(result1) && !"String".equals(result1) && !"Bool".equals(result1) && !"Double".equals(result1) && !"Void".equals(result1) && !"Other".equals(result1)){
      String message = "You did not select an of type! Select one before continuing.(Int etc.)";
          JOptionPane.showMessageDialog(new JFrame(), message, "Invalid Input!",
        JOptionPane.ERROR_MESSAGE);}
            
      else {          if ("Public".equals(result)){sign = "+";}
                      if ("Private".equals(result)) {sign = "-";}
                      if ("Protected".equals(result)) {sign = "#";}
                      if ("Default".equals(result)) {sign = "~";}
                      if ("String".equals(result1)) {type = ": String";}
                      if ("Int".equals(result1)) {type = ": int";}
                      if ("Bool".equals(result1)) {type = ": Bool";}
                      if ("Double".equals(result1)) {type = ": double";}   
                      if ("Void".equals(result1)) {type = ": void";} 
                      if ("Other".equals(result1)) {type = ": " + textt.getText() ;} 
                       listMethod.add(0,sign + space + methodt.getText() + space + type);}
                
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
       Dimension Size = new Dimension(175,100);
       newVar.setMaximumSize(Size);
       newVar.setAlignmentX(Component.LEFT_ALIGNMENT);
       objectt.setMaximumSize(Size);
       type.setMaximumSize(Size);
       objects1.setMaximumSize(Size);
       ofType.setMaximumSize(Size);
       objects2.setMaximumSize(Size);
       textt.setMaximumSize(Size);
       newMet.setMaximumSize(Size);
       methodt.setMaximumSize(Size);
       mettype.setMaximumSize(Size);
       methods1.setMaximumSize(Size);
       metofType.setMaximumSize(Size);
       methods2.setMaximumSize(Size);
       mettextt.setMaximumSize(Size);
       addObject.setMaximumSize(Size);
       changeObject.setMaximumSize(Size);
       removeObject.setMaximumSize(Size);
       addMethod.setMaximumSize(Size);
       changeMethod.setMaximumSize(Size);
       removeMethod.setMaximumSize(Size);
       scrollPane.setMaximumSize(Size);
       scrollPane2.setMaximumSize(Size);
       
       scrollPane2.setAlignmentX(Component.LEFT_ALIGNMENT);
       scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
       newVar.setAlignmentX(Component.CENTER_ALIGNMENT);
       newMet.setAlignmentX(Component.CENTER_ALIGNMENT);      

       optionPanel.add(newVar);
        optionPanel.add(objectt);
        optionPanel.add(type);
        optionPanel.add(objects1);
        optionPanel.add(ofType);
        optionPanel.add(objects2);
        optionPanel.add(textt);
        
        optionPanel.add(newMet);
        optionPanel.add(methodt);
        optionPanel.add(mettype);
        optionPanel.add(methods1);
        optionPanel.add(metofType);
        optionPanel.add(methods2);
        optionPanel.add(mettextt);

        optionPanel2.add(object);
        optionPanel2.add(scrollPane);
        optionPanel2.add(addObject);
        optionPanel2.add(changeObject);
        optionPanel2.add(removeObject);
        
        optionPanel2.add(method);
        optionPanel2.add(scrollPane2);
        optionPanel2.add(addMethod);
        optionPanel2.add(changeMethod);
        optionPanel2.add(removeMethod);
        
        optionPanel3.add(CANCEL);
        optionPanel3.add(OK);
        optionPanel4.add(newClass);
        optionPanel4.add(className);
             
           
        
        
        guiFrame.add(optionPanel, BorderLayout.WEST);
        
        guiFrame.add(optionPanel2, BorderLayout.CENTER);
        
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
		
			cDD.addInstanceVar(listObject.get(i).toString()); //Create new data input 'template' and populate with use inputted data	
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