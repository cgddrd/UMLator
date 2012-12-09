package uk.ac.aber.dcs.cs124.clg11.fileIO;


import java.io.File;
import java.io.FilenameFilter;

//FilenameFilter extension.
//Filters filenames by the file extension only.

public class FilterExt implements FilenameFilter{
    private String ext;
    
    public FilterExt(String ext){
        this.ext="." + ext;
    }
  
    @Override
    public boolean accept(File dir,String name){
         return name.endsWith(ext);
    }
}
