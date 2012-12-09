package uk.ac.aber.dcs.cs124.clg11.fileIO;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;
import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;
import uk.ac.aber.dcs.cs124.clg11.diag.RelationshipDiag;


public class FileIO {
    private XMLDecoder xmlDecode;
    private XMLEncoder xmlEncode;
    
    private File projectDir;
    private JFileChooser fc = new JFileChooser();
    
    public FileIO () {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    public void saveProject(Vector<Drawable> v) {
        int returnVal = fc.showSaveDialog(null); //change null to this in application
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	System.out.println("option chosen");
            projectDir = fc.getSelectedFile();
            writeVector(v);
        }
    }
    
    public Vector<Drawable> openProject() {
        int returnVal = fc.showOpenDialog(null); //change null to this in application
        
        Vector<Drawable> vec = new Vector<Drawable>();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            projectDir = fc.getSelectedFile();
            vec = readVector();
        }
        return vec;
    }
    
    private void writeVector(Vector<Drawable> vec) {
        try {
            for (Drawable e : vec) {
            	Object data = e.getData();
                writeObject(e);
                writeObject(data);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "File Not Found: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Vector<Drawable> readVector() {
        Vector<Drawable> vec = new Vector<Drawable>();
        String[] filenames = projectDir.list(new FilterExt("xml")); //get only the xml filenames
        System.out.println(filenames.length);
        try {
            for (String s : filenames) {
                Drawable obj = readObject(s);
                vec.add(obj); 
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "File Not Found: ", JOptionPane.ERROR_MESSAGE);
        }
         
         return vec;
    }
    
    private void writeObject(Object obj) throws FileNotFoundException {
        String fname = obj.toString();
        xmlEncode = new XMLEncoder (new BufferedOutputStream(new FileOutputStream(projectDir.getAbsoluteFile() + "/" + fname + ".xml")));
        xmlEncode.writeObject(obj);
        xmlEncode.close();
    }
    
    private Drawable readObject (String fname) throws FileNotFoundException {
         xmlDecode = new XMLDecoder(new BufferedInputStream(new FileInputStream(projectDir.getAbsolutePath() + "/" + fname)));
         Object obj = xmlDecode.readObject();
         xmlDecode.close();
         return (Drawable) obj;
    }
}
