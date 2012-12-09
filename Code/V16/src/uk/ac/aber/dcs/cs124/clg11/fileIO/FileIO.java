package uk.ac.aber.dcs.cs124.clg11.fileIO;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileIO {
    private XMLDecoder xmlDecode;
    private XMLEncoder xmlEncode;
    
    private File projectDir;
    private JFileChooser fc = new JFileChooser();
    
    public FileIO () {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    public void saveProject(Vector<Object> v) {
        int returnVal = fc.showSaveDialog(null); //change null to this in application
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            projectDir = fc.getSelectedFile();
            writeVector(v);
        }
    }
    
    public Vector<Object> openProject() {
        int returnVal = fc.showOpenDialog(null); //change null to this in application
        
        Vector<Object> vec = new Vector<Object>();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            projectDir = fc.getSelectedFile();
            vec = readVector();
        }
        return vec;
    }
    
    private void writeVector(Vector<Object> vec) {
        try {
            for (Object e : vec) {
                writeObject(e);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "File Not Found: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Vector<Object> readVector() {
        Vector<Object> vec = new Vector<Object>();
        String[] filenames = projectDir.list(new FilterExt("xml")); //get only the xml filenames
        System.out.println(filenames.length);
        try {
            for (String s : filenames) {
                Object obj = readObject(s);
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
    
    private Object readObject (String fname) throws FileNotFoundException {
         xmlDecode = new XMLDecoder(new BufferedInputStream(new FileInputStream(projectDir.getAbsolutePath() + "/" + fname)));
         Object obj = xmlDecode.readObject();
         xmlDecode.close();
         return obj;
    }
}
