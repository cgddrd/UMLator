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
		
	/*	for (int i = 0; i < asocArray.size(); i++) {
			StringTokenizer token = new StringTokenizer(asocArray.get(i), " : ");
			String name = token.nextToken();
			String type = token.nextToken();

			out.write("	private " + type + " " + name + ";\r\n");
			out.write("\r\n");
		
		} */
		
		for (int i = 0; i < asocArray.size(); i++) {
			out.write("	" + asocArray.get(i) + ";\r\n");
			out.write("\r\n");	
		}
		
		for (int i = 0; i < opArray.size(); i++) {
			
			String s = opArray.get(i);
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
			
			System.out.println(amod);
			System.out.println(name);
			System.out.println(type);
			
			switch (amod) {
			case "+": access = "public";
			break;
			case "-": access = "private";
			break;
			case "#": access = "protected";
			break;
			default: access = " ";
		}
			
			System.out.println("THIS IS THE TYPE: " + access);

			if (name.equals("main()")) {

				out.write("\r\n");
				out.write("	public static void " + name + "(String[] args) {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");

			} else {
				out.write("\r\n");
				out.write("	" + access + " " + type + " " + name + " {\r\n");
				out.write("\r\n");
				out.write("	}\r\n");
			}
			
		}

		out.write("}");
		out.close();
		
		
	}
	}


