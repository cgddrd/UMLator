package uk.ac.aber.dcs.cs124.clg11.fileIO;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;


public class FileIO {
    private XMLDecoder xmlDecode;
    private XMLEncoder xmlEncode;
    
    private File projectDir;
    private JFileChooser fc = new JFileChooser();
    
    private void saveNewProject(Vector<Drawable> v) {
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	fc.addChoosableFileFilter(new FileNameExtensionFilter("XML files", "xml"));
	int returnVal = fc.showSaveDialog(null);
	
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    projectDir = fc.getSelectedFile();
	    writeObject(v);
	}
    }

    public void saveProject(Vector<Drawable> v) {	
	if (projectDir == null) {
	    saveNewProject(v);
	} else {
	    writeObject(v);
	}
    }
    
    public Vector<Drawable> openProject() {
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	fc.addChoosableFileFilter(new FileNameExtensionFilter("XML files", "xml"));
        int returnVal = fc.showOpenDialog(null);
        
        Vector<Drawable> vec = new Vector<Drawable>();
	
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            projectDir = fc.getSelectedFile();
            vec = readObject();
        }
	
        return vec;
    }
    
    private void writeObject(Object obj) {
	try {
	    xmlEncode = new XMLEncoder (new BufferedOutputStream(new FileOutputStream(projectDir.getAbsoluteFile())));
	    xmlEncode.writeObject(obj);
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, e, "File Not Found", JOptionPane.ERROR_MESSAGE);
	} finally {
	    xmlEncode.close();
	}
    }
    
    private Vector<Drawable> readObject () {
	try {
	    xmlDecode = new XMLDecoder(new BufferedInputStream(new FileInputStream(projectDir.getAbsolutePath())));
	    Vector<Drawable> obj = (Vector<Drawable>) xmlDecode.readObject();
	    return obj;
	} catch(FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, e, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
	} finally {
	    xmlDecode.close();
	}
	
	return null;
    }
}
