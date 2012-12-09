package uk.ac.aber.dcs.cs124.clg11.fileIO;

import java.io.*;
import java.util.*;

public class CodeExport {

	public CodeExport() {

	}

	public void printOut(int varNo, int opNo, String className, ArrayList<String> varArray, ArrayList<String> opArray) throws Exception{

		PrintWriter out = new PrintWriter(new FileWriter("C:\\" + className + ".java"));
		out.write("public class " + className + " {\r\n");
		out.write("\r\n");

		for (int i = 0; i < varArray.size(); i++) {
			StringTokenizer token = new StringTokenizer(varArray.get(i), " : ");
			String name = token.nextToken();
			String type = token.nextToken();
			
			if (type.equals("bool") || type.equals("Bool")){
				out.write("	private boolean " + name + ";\r\n");
				out.write("\r\n");
				
			} else {

			out.write("	private " + type + " " + name + ";\r\n");
			out.write("\r\n");
		}
		}
		for (int i = 0; i < opArray.size(); i++) {

			if (opArray.get(i).equals("main")) {

				out.write("\r\n");
				out.write("	public static void " + opArray.get(i) + "(String[] args) {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");

			} else {
				out.write("\r\n");
				out.write("	public void " + opArray.get(i) + "() {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");
			}
		}

		out.write("}");
		out.close();
	}

}
