package uk.ac.aber.dcs.cs124.clg11.fileIO;

import java.io.*;
import java.util.*;

public class CodeExport {

	public CodeExport() {

	}

	public void printOut(int varNo, int opNo, int asocNo, String className, ArrayList<String> varArray, ArrayList<String> opArray, ArrayList<String> asocArray) throws Exception{

		PrintWriter out = new PrintWriter(new FileWriter("C:\\" + className + ".java"));
		out.write("public class " + className + " {\r\n");
		out.write("\r\n");

		for (int i = 0; i < varArray.size(); i++) {
			String s = varArray.get(i);
			String access = s.substring(0,1);
			String rest = s.substring(2);
			String output = access + " : " + rest;
			
			StringTokenizer token = new StringTokenizer(output, " : ");
			String amod = token.nextToken();
			String name = token.nextToken();
			String type = token.nextToken();
			
			
			if (type.equals("Bool") || type.equals("bool")) {
				type = "boolean";
			}
			
			switch (amod) {
				case "+": access = "public";
				break;
				case "-": access = "private";
				break;
				case "#": access = "protected";
				break;
				default: access = " ";
			}
			

			out.write("	 " + access + " " + type + " " + name + ";\r\n");
			out.write("\r\n");
		
		}
		
		for (int i = 0; i < asocArray.size(); i++) {
			out.write("	" + asocArray.get(i) + ";\r\n");
			out.write("\r\n");	
		}
		
		for (int i = 0; i < opArray.size(); i++) {
			
			String s = opArray.get(i);
			
			String constructVar = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
			System.out.println("Pulled Value: " + constructVar);
			
			StringTokenizer token = new StringTokenizer(constructVar, " : ");
			
			String constName = token.nextToken();
			String constType = token.nextToken();
			
			String remove = s.substring(s.indexOf("("), s.lastIndexOf(")") + 1);
			
			String tmpString = s.replace(remove,""); 
			
			String access = tmpString.substring(0,1);
			String rest = tmpString.substring(2);
			String output = access + " : " + rest;
			
			token = new StringTokenizer(output, " : ");
			String amod = token.nextToken();
			String name = token.nextToken();
			String type = token.nextToken();
			
			
			if (type.equals("Bool") || type.equals("bool")) {
				type = "boolean";
			}
			
			System.out.println("Acces Mod: " + amod);
			System.out.println("Name: " + name);
			System.out.println("Type: " + type);
			
			switch (amod) {
			case "+": access = "public";
			break;
			case "-": access = "private";
			break;
			case "#": access = "protected";
			break;
			default: access = " ";
		}

			if (name.equals("main")) {

				out.write("\r\n");
				out.write("	public static void " + name + "(String[] args) {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");

			} else {
				out.write("\r\n");
				out.write("	" + access + " " + type + " " + name + " (" + constType + " " + constName + ")" + " {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");
			}
			
		}

		out.write("}");
		out.close();
		
		
	}
	}


