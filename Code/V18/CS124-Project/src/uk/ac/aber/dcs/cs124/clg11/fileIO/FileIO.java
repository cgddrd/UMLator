package uk.ac.aber.dcs.cs124.clg11.fileIO;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;


public class FileIO {
    private XMLDecoder xmlDecode;
    private XMLEncoder xmlEncode;
    
    private File projectDir;
    private String projectName = "";
    private JFileChooser fc = new JFileChooser();
    
    private boolean projectLoaded = false;

    public void saveNewProject(Vector<Drawable> v) {
	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	projectName = JOptionPane.showInputDialog("Enter Project Name: ");
	int returnVal = fc.showSaveDialog(null);
	
       if (returnVal == JFileChooser.APPROVE_OPTION) {
	    projectDir = fc.getSelectedFile();
	    writeObject(v);
        }
    }
    public void saveProject(Vector<Drawable> v){
	if(projectLoaded) {
	    writeObject(v);
	} else {
	    saveNewProject(v);
	} 
    }
    
    public Vector<Drawable> openProject() {
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	int returnVal = fc.showOpenDialog(null);
	
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    projectDir = fc.getSelectedFile();
	    
	    if(projectDir.exists() && projectDir.isFile()) {
		return readObject(projectDir.getAbsolutePath());
	    }
	}
	
	return null;
    }
    
    private void writeObject(Object obj) {
	try {
	    xmlEncode = new XMLEncoder (new BufferedOutputStream(new FileOutputStream(projectDir.getAbsoluteFile() + "/" + projectName + ".xml")));
	    xmlEncode.writeObject(obj);
	} catch (FileNotFoundException ex) {
	    JOptionPane.showMessageDialog(null, ex, "File Not Found", JOptionPane.ERROR_MESSAGE);
	} finally {
	    xmlEncode.close();
	}
    }
    
    private Vector<Drawable> readObject (String fname) {
	Vector<Drawable> v = null;
	try {
	    xmlDecode = new XMLDecoder (new BufferedInputStream(new FileInputStream(fname)));
	     v = (Vector<Drawable>) xmlDecode.readObject();
	} catch (FileNotFoundException e ) {
	     JOptionPane.showMessageDialog(null, e, "File Not Found", JOptionPane.ERROR_MESSAGE);
	} finally {
	    xmlDecode.close();
	}
	
	return v;
    }
}
