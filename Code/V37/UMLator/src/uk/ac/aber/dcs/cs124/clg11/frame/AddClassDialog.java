package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.Dimension;
import java.awt.GridLayout;
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
import uk.ac.aber.dcs.cs124.clg11.panel.ButtonPanel;
import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

public class AddClassDialog extends JFrame implements ActionListener{

	private JPanel dialogPanel = new JPanel();
	private JPanel buttonPanel;
	private JTextField methodText, objectText, textt, mettextt, className;
	private DefaultListModel listObject, listMethod;
	private String name;
	private JList obList, metList;
	private CanvasPanel canvasPanel;
	private int x, y;
	private JLabel newClass, objectTitle, methodTitle, newVar, newMet, panelTitle, obAcTitle, obTypeTitle, metAcTitle, metTypeTitle;
	private JScrollPane scrollOb, scrollMeth;
	private JButton OK, CANCEL, addObject, removeObject, addMethod, removeMethod, addParam;
	private String[] status = { "Public", "Private", "Protected", "Defualt" };
	private String[] varType = { "Int", "String", "Bool", "Double", "Void","Other" };
	private JComboBox objects1, objects2, methods1, methods2;
	private SpringLayout layout;
	private JSeparator titleSep = new JSeparator(JSeparator.HORIZONTAL);
	private JSeparator objSep = new JSeparator(JSeparator.HORIZONTAL);
	private JSeparator metSep = new JSeparator(JSeparator.HORIZONTAL);

	public AddClassDialog(CanvasPanel cp, int x, int y) {

		layout = new SpringLayout();
		canvasPanel = cp;
		dialogPanel.setLayout(layout);
		dialogPanel.setPreferredSize(new Dimension(400,425));
		this.x = x;
		this.y = y;
		this.add(dialogPanel);

		initComponents();
		setLayout();

		pack();
		this.setVisible(true);

	}

	public void initComponents() {

		panelTitle = new JLabel("Create New Class");
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
		textt = new JTextField();
		mettextt = new JTextField();

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

		objects1 = new JComboBox(status);
		objects2 = new JComboBox(varType);
		methods1 = new JComboBox(status);
		methods2 = new JComboBox(varType);
		
		dialogPanel.add(panelTitle);
		dialogPanel.add(newClass);
		dialogPanel.add(className);
		dialogPanel.add(scrollOb);
		dialogPanel.add(scrollMeth);
		dialogPanel.add(objectText);
		dialogPanel.add(methodText);
		//dialogPanel.add(textt);
		//dialogPanel.add(mettextt);
	//	dialogPanel.add(objectTitle);
	//	dialogPanel.add(methodTitle);
		dialogPanel.add(newVar);
		dialogPanel.add(newMet);
		dialogPanel.add(addParam);
		dialogPanel.add(OK);
		dialogPanel.add(CANCEL);
		dialogPanel.add(addObject);
		dialogPanel.add(removeObject);
		dialogPanel.add(addMethod);
		dialogPanel.add(removeMethod);
		dialogPanel.add(objects1);
		dialogPanel.add(objects2);
		dialogPanel.add(methods1);
		dialogPanel.add(methods2);
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
		layout.putConstraint(SpringLayout.WEST,newClass,90,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, newClass,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,className,10,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,className,5,SpringLayout.EAST, newClass);
		//layout.putConstraint(SpringLayout.EAST, className,-80,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,titleSep,10,SpringLayout.SOUTH, className);
		layout.putConstraint(SpringLayout.WEST,titleSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleSep,-25,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,newVar,10,SpringLayout.SOUTH, titleSep);
		layout.putConstraint(SpringLayout.WEST,newVar,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, newVar,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,objectText,10,SpringLayout.SOUTH, titleSep);
		layout.putConstraint(SpringLayout.WEST,objectText,5,SpringLayout.EAST, newVar);
		//layout.putConstraint(SpringLayout.EAST, objectText,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,obAcTitle,13,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obAcTitle,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, objectText,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,objects1,10,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,objects1,5,SpringLayout.EAST, obAcTitle);
		//layout.putConstraint(SpringLayout.EAST, objects1,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,obTypeTitle,13,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,obTypeTitle,15,SpringLayout.EAST, objects1);
		//layout.putConstraint(SpringLayout.EAST, objects1,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,objects2,10,SpringLayout.SOUTH, objectText);
		layout.putConstraint(SpringLayout.WEST,objects2,5,SpringLayout.EAST, obTypeTitle);
	//	layout.putConstraint(SpringLayout.EAST, objects2,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,scrollOb,10,SpringLayout.SOUTH, obTypeTitle);
		layout.putConstraint(SpringLayout.WEST,scrollOb,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, scrollOb,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,addObject,10,SpringLayout.SOUTH, scrollOb);
		layout.putConstraint(SpringLayout.WEST,addObject,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, addObject,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,removeObject,10,SpringLayout.SOUTH, scrollOb);
		layout.putConstraint(SpringLayout.WEST,removeObject,5,SpringLayout.EAST, addObject);
		//layout.putConstraint(SpringLayout.EAST, removeObject,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,objSep,10,SpringLayout.SOUTH, removeObject);
		layout.putConstraint(SpringLayout.WEST,objSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, objSep,-25,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,newMet,10,SpringLayout.SOUTH, objSep);
		layout.putConstraint(SpringLayout.WEST,newMet,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, newVar,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,methodText,10,SpringLayout.SOUTH, objSep);
		layout.putConstraint(SpringLayout.WEST,methodText,5,SpringLayout.EAST, newMet);
		//layout.putConstraint(SpringLayout.EAST, objectText,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,metAcTitle,13,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,metAcTitle,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, objectText,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,methods1,10,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,methods1,5,SpringLayout.EAST, metAcTitle);
		//layout.putConstraint(SpringLayout.EAST, methods1,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,metTypeTitle,13,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,metTypeTitle,15,SpringLayout.EAST, methods1);
		//layout.putConstraint(SpringLayout.EAST, objects1,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,methods2,10,SpringLayout.SOUTH, methodText);
		layout.putConstraint(SpringLayout.WEST,methods2,5,SpringLayout.EAST, metTypeTitle);
	//	layout.putConstraint(SpringLayout.EAST, objects2,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,scrollMeth,10,SpringLayout.SOUTH, metTypeTitle);
		layout.putConstraint(SpringLayout.WEST,scrollMeth,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, scrollMeth,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,addMethod,10,SpringLayout.SOUTH, scrollMeth);
		layout.putConstraint(SpringLayout.WEST,addMethod,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST, addObject,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,removeMethod,10,SpringLayout.SOUTH, scrollMeth);
		layout.putConstraint(SpringLayout.WEST,removeMethod,5,SpringLayout.EAST, addMethod);
		//layout.putConstraint(SpringLayout.EAST, removeObject,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,addParam,10,SpringLayout.SOUTH, scrollMeth);
		layout.putConstraint(SpringLayout.WEST,addParam,5,SpringLayout.EAST, removeMethod);
		//layout.putConstraint(SpringLayout.EAST, addParam,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,metSep,10,SpringLayout.SOUTH, addParam);
		layout.putConstraint(SpringLayout.WEST,metSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, metSep,-25,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,OK,10,SpringLayout.SOUTH, metSep);
		layout.putConstraint(SpringLayout.WEST,OK,5,SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.EAST,OK,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,CANCEL,10,SpringLayout.SOUTH, metSep);
		layout.putConstraint(SpringLayout.WEST,CANCEL,5,SpringLayout.EAST, OK);
		//layout.putConstraint(SpringLayout.EAST, CANCEL,-5,SpringLayout.EAST, this);
			

	}
	

	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		if (actionCommand.equals("Add Object")) {
			String sign = null;
			String type = null;
			String space = " ";
			String result = (String) objects1.getSelectedItem();
			String result1 = (String) objects2.getSelectedItem();

			if (!"Public".equals(result) && !"Private".equals(result)
					&& !"Protected".equals(result)
					&& !"Default".equals(result)) {
				String message = "You did not select a type! Select one before continuing.(Public etc.)";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Input!", JOptionPane.ERROR_MESSAGE);
			}

			else if (!"Int".equals(result1) && !"String".equals(result1)
					&& !"Bool".equals(result1) && !"Double".equals(result1)
					&& !"Void".equals(result1) && !"Other".equals(result1)) {
				String message = "You did not select an of type! Select one before continuing.(Int etc.)";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Input!", JOptionPane.ERROR_MESSAGE);
			}

			else {
				if ("Public".equals(result)) {
					sign = "+";
				}
				if ("Private".equals(result)) {
					sign = "-";
				}
				if ("Protected".equals(result)) {
					sign = "#";
				}
				if ("Default".equals(result)) {
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
				if ("Other".equals(result1)) {
					type = ": " + textt.getText();
				}

				listObject.add(0, sign + space + objectText.getText() + space + type);
			}
		} else if (actionCommand.equals("Add Method")) {

			String sign = null;
			String type = null;
			String space = " ";
			String result = (String) methods1.getSelectedItem();
			String result1 = (String) methods2.getSelectedItem();

			if (!"Public".equals(result) && !"Private".equals(result)
					&& !"Protected".equals(result)
					&& !"Default".equals(result)) {
				String message = "You did not select a type! Select one before continuing.(Public etc.)";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Input!", JOptionPane.ERROR_MESSAGE);
			}

			else if (!"Int".equals(result1) && !"String".equals(result1)
					&& !"Bool".equals(result1) && !"Double".equals(result1)
					&& !"Void".equals(result1) && !"Other".equals(result1)) {
				String message = "You did not select an of type! Select one before continuing.(Int etc.)";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Input!", JOptionPane.ERROR_MESSAGE);
			}

			else {
				if ("Public".equals(result)) {
					sign = "+";
				}
				if ("Private".equals(result)) {
					sign = "-";
				}
				if ("Protected".equals(result)) {
					sign = "#";
				}
				if ("Default".equals(result)) {
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
				if ("Other".equals(result1)) {
					type = ": " + textt.getText();
				}
				listMethod.add(0, sign + space + methodText.getText() + "()" + space + type);
			}

		} else if (actionCommand.equals("Remove Method")) {
			int test = listMethod.getSize();
			if (test == 0) {
				String message = "The list is empty!";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Command!", JOptionPane.ERROR_MESSAGE);
			} else {
				listMethod.remove(metList.getSelectedIndex());
			}
		} else if (actionCommand.equals("Remove Object")) {
			int test = listObject.getSize();
			if (test == 0) {
				String message = "The list is empty!";
				JOptionPane.showMessageDialog(new JFrame(), message,
						"Invalid Command!", JOptionPane.ERROR_MESSAGE);
			} else {
				listMethod.remove(metList.getSelectedIndex());
			}
		} else if (actionCommand.equals("Add Parameter")) {
			ParamWindow paramWindow = new ParamWindow(this,metList.getSelectedIndex());
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
			// input
			// 'template'
			// and populate
			// with use
			// inputted data
		}

		for (int i = 0; i < opNo; i++) {
			cDD.addMethod(listMethod.get(i).toString()); // Create new data
			// input 'template'
			// and populate with
			// use inputted data

		}

		cDD.setAccessModifier("+");

		ClassDiag e = new ClassDiag(x, y, varNo, opNo); // Create a new class
		// object and set the
		// details of it
		e.setData(cDD); // Set the associated data with from the cDD.

		canvasPanel.addDrawable(e);
		canvasPanel.repaint();

	}

	public void addParams(String params, int index) {
		String s = (String) listMethod.get(index);
		StringTokenizer token = new StringTokenizer(s, ")");
		String output = token.nextToken() + params + ")" + token.nextElement();
		listMethod.set(index, output);
	}
}