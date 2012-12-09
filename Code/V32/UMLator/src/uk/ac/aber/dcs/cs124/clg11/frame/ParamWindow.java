
package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class ParamWindow extends JFrame implements ActionListener, ItemListener {
    private NewClassDialog parent;
    
    private JPanel listPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private JPanel inputPanel= new JPanel();
    private JPanel radPanel = new JPanel();
    
    private JButton submit, cancel, add, remove;
    private JRadioButton radInt, radDouble, radFloat, radBool, radString, radOther;
    private JTextField name, other;
    private ButtonGroup types = new ButtonGroup();
    private JScrollPane scrollingList;
    private DefaultListModel listModel;
    private JList params;
    private int parentIndex = 0;
    
    public ParamWindow(NewClassDialog parent, int pI) {
        //init window
        setTitle("Parameters");
        setLocation(200,200);
        setSize(500,500);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        this.parent = parent;
        this.parentIndex = pI;
        
        //create JList
        listModel = new DefaultListModel();
        params = new JList(listModel);
        params.setFixedCellWidth(400);
        scrollingList = new JScrollPane(params);
        
        
        listPanel.setSize(500, 200);
        listPanel.add(scrollingList);
       
        add(listPanel, BorderLayout.NORTH);
        
        
        //create input field
        name = new JTextField(10);
        other = new JTextField(10);
        other.setEnabled(false);
        
        radInt = new JRadioButton("Int");
        radDouble = new JRadioButton("Double");
        radBool = new JRadioButton("Bool");
        radString = new JRadioButton("String");
        radFloat = new JRadioButton("Float");
        radOther = new JRadioButton("Other:");
        
        radOther.addItemListener(this);
        radInt.setSelected(true);

        types.add(radInt);
        types.add(radDouble);
        types.add(radFloat);
        types.add(radBool);
        types.add(radString);
        types.add(radOther);
        
        radPanel.add(radInt);
        radPanel.add(radDouble);
        radPanel.add(radFloat);
        radPanel.add(radBool);
        radPanel.add(radString);
        radPanel.add(radOther);
        
        inputPanel.setLayout(new BorderLayout());
        
        inputPanel.add(name, BorderLayout.NORTH);
        inputPanel.add(radPanel, BorderLayout.CENTER);
        inputPanel.add(other, BorderLayout.SOUTH);
        
        
        add(inputPanel, BorderLayout.CENTER);
        
        //Create the button panel
        add = new JButton("Add");
        remove = new JButton("Remove");
        cancel = new JButton("Cancel");
        submit = new JButton("Submit");
        
        add.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
        submit.addActionListener(this);
        
        btnPanel.add(add);
        btnPanel.add(remove);
        btnPanel.add(cancel);
        btnPanel.add(submit);
        
        add(btnPanel, BorderLayout.SOUTH);
        pack();
    }
    
    public void clearFields() {
        types.clearSelection();
        radInt.setSelected(true);
        other.setEnabled(false);
        name.setText("");
        other.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String n = name.getText();
            String type = "";
            
            if(radInt.isSelected()) { type = "int"; }
            else if (radDouble.isSelected()) { type = "double"; }
            else if (radBool.isSelected()) { type = "bool"; }
            else if (radFloat.isSelected()) { type = "float"; }
            else if (radString.isSelected()) { type = "String"; }
            else if (radOther.isSelected()) { type = other.getText(); }
            
            listModel.add(listModel.getSize(), n + " : "+ type);
            
            clearFields();
        } else if (e.getActionCommand().equals("Submit")) {
            String parameters = "";
            
            for (Object v : listModel.toArray()) {
                parameters += v + ",";
            }
            
            parameters = parameters.substring(0, parameters.length()-1);
          
            //add link to parent dialog here.
            parent.addParams(parameters, parentIndex);
            
            clearFields();
            dispose();
        } else if (e.getActionCommand().equals("Cancel")) {
            dispose();
        } else if (e.getActionCommand().equals("Remove")) {
            listModel.remove(params.getSelectedIndex());
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItem().equals(radOther)) {
            other.setEnabled(!other.isEnabled());
        }
    }
}
