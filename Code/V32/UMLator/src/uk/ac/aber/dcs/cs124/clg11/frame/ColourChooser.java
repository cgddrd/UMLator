package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

public class ColourChooser extends JPanel implements ChangeListener {

	   protected JColorChooser tcc;
	   protected JLabel banner;
	   private CanvasPanel cvPanel;
	 
	    public ColourChooser(CanvasPanel cp) {
	    
	      this.cvPanel = cp;
	        //Set up color chooser for setting text color
	        tcc = new JColorChooser(cvPanel.getForeground());
	        tcc.getSelectionModel().addChangeListener(this);
	        tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
	 
	        add(tcc, BorderLayout.PAGE_END);
	    }
	 
	    public void stateChanged(ChangeEvent e) {
	        Color newColor = tcc.getColor();
	        cvPanel.setBackground(newColor);
	    }
	 
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("ColorChooserDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	//        ColourChooser newContentPane = new ColourChooser(cvPanel);
	//        newContentPane.setOpaque(true); //content panes must be opaque
	//        frame.setContentPane(newContentPane);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}


