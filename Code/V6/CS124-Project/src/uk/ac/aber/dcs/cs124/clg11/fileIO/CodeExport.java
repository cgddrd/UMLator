package uk.ac.aber.dcs.cs124.clg11.fileIO;

import java.io.*;
import java.util.ArrayList;

public class CodeExport {

	public CodeExport() {
	
	}
	
	public void printOut(int varNo, int opNo, String className, ArrayList<String> varArray, ArrayList<String> opArray) throws Exception{
	PrintWriter out = new PrintWriter(new FileWriter("C:\\" + className + ".java"));
	out.write("public class " + className + " {\r\n");
	out.write("\r\n");
	
	for (int i = 0; i < varArray.size(); i++) {
		out.write("	private " + varArray.get(i) + ";\r\n");
		out.write("\r\n");
	}
	
	for (int i = 0; i < opArray.size(); i++) {
		out.write("\r\n");
		out.write("	public void " + opArray.get(i) + "() {\r\n");
		out.write("\r\n");
		out.write("	}\r\n");
	}
	
	out.write("}");
	out.close();
	}
}
