package uk.ac.aber.dcs.cs124.clg11.panel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import uk.ac.aber.dcs.cs124.clg11.listener.*;

public class ButtonPanel extends JPanel {

	private JLabel titleText = new JLabel("--System Menu--");
	private JButton addButton, delButton, relButton, resetButton, exportButton, saveButton, loadButton, exitButton, undoButton;
	private JSeparator titleSep = new JSeparator(JSeparator.HORIZONTAL);
	private JSeparator menuSep = new JSeparator(JSeparator.HORIZONTAL);

	public Boolean addVar = false; // NEED TO CHANGE THESE FROM PUBLIC!!
	public Boolean addRel = false;
	public Boolean delItem = false;

	public ButtonPanel(CanvasPanel cP) {

		ButtonListener buttonList = new ButtonListener(this, cP);
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout); //Create new grid
		this.add(titleText);

		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

		addButton = new JButton("Add Class");
		this.add(addButton);
		addButton.addActionListener(buttonList);

		delButton = new JButton("Remove Class");
		this.add(delButton);
		delButton.addActionListener(buttonList);

		relButton = new JButton("Add Relationship");
		this.add(relButton);
		relButton.addActionListener(buttonList);

		resetButton = new JButton("Reset Canvas");
		this.add(resetButton);
		resetButton.addActionListener(buttonList);

		exportButton = new JButton("Export Java");
		this.add(exportButton);
		exportButton.addActionListener(buttonList);

		saveButton = new JButton("Save Project");
		this.add(saveButton);
		saveButton.addActionListener(buttonList);

		loadButton = new JButton("Load Project");
		this.add(loadButton);
		loadButton.addActionListener(buttonList);

		exitButton = new JButton("Quit Program");
		this.add(exitButton);
		exitButton.addActionListener(buttonList);

		undoButton = new JButton("Undo Last Action");
		this.add(undoButton);
		undoButton.addActionListener(buttonList);


		this.add(titleSep);
		this.add(menuSep);

		layout.putConstraint(SpringLayout.NORTH,titleText,10,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,titleText,30,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleText,-30,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,titleSep,30,SpringLayout.NORTH, titleText);
		layout.putConstraint(SpringLayout.WEST,titleSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleSep,-5,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,addButton,20,SpringLayout.NORTH, titleSep);
		layout.putConstraint(SpringLayout.WEST, addButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, addButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,relButton,40,SpringLayout.NORTH, addButton);
		layout.putConstraint(SpringLayout.WEST, relButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, relButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,delButton,40,SpringLayout.NORTH, relButton);
		layout.putConstraint(SpringLayout.WEST, delButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, delButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,resetButton,40,SpringLayout.NORTH, delButton);
		layout.putConstraint(SpringLayout.WEST, resetButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, resetButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,exportButton,40,SpringLayout.NORTH, resetButton);
		layout.putConstraint(SpringLayout.WEST, exportButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, exportButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,saveButton,40,SpringLayout.NORTH, exportButton);
		layout.putConstraint(SpringLayout.WEST, saveButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, saveButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,loadButton,40,SpringLayout.NORTH, saveButton);
		layout.putConstraint(SpringLayout.WEST,loadButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, loadButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,exitButton,40,SpringLayout.NORTH, loadButton);
		layout.putConstraint(SpringLayout.WEST, exitButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, exitButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,undoButton,40,SpringLayout.NORTH, exitButton);
		layout.putConstraint(SpringLayout.WEST, undoButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, undoButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,menuSep,40,SpringLayout.NORTH, undoButton);
		layout.putConstraint(SpringLayout.WEST,menuSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, menuSep,-5,SpringLayout.EAST, this);


	}


}
