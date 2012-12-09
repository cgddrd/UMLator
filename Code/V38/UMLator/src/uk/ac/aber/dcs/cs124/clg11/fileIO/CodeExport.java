package uk.ac.aber.dcs.cs124.clg11.fileIO;

import java.io.*;
import java.util.*;

public class CodeExport {

	private boolean isParam;
	private String constructVar;
	private StringTokenizer token;
	private String output, access, rest, constName, constType, directEnd;
	private String[] paramArray;
	private int count;

	public CodeExport() {

	}

	public void printOut(String filePath, int varNo, int opNo, int asocNo, String className, ArrayList<String> varArray, ArrayList<String> opArray, ArrayList<String> asocArray) throws Exception{

		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.indexOf("win") >= 0) {
			directEnd = "\\";
		} else {
			directEnd = "/";
		}
		
		PrintWriter out = new PrintWriter(new FileWriter(filePath + directEnd + className + ".java"));
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

			constructVar = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
			System.out.println("Pulled Value: " + constructVar);


			if (constructVar.length() > 0) {

				if (constructVar.indexOf(",") > 0) {

					count = 0;

					token = new StringTokenizer(constructVar, ",");

					paramArray = new String[token.countTokens()];

					while (token.hasMoreTokens() == true) {
						paramArray[count] = token.nextToken();
						count++;
					}

				} else {

					token = new StringTokenizer(constructVar, " : ");
					constName = token.nextToken();
					constType = token.nextToken();
				}

				String remove = s.substring(s.indexOf("("), s.lastIndexOf(")") + 1);

				String tmpString = s.replace(remove,""); 

				access = tmpString.substring(0,1);
				rest = tmpString.substring(2);
				output = access + " : " + rest;

			} else {

				access = s.substring(0,1);
				rest = s.substring(2);
				output = access + " : " + rest;

			}

			token = new StringTokenizer(output, " : ");
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

			if (constructVar.length() > 0) {

				if (constructVar.indexOf(",") > 0) {

					String compParam = "(";

					for (int p = 0; p < paramArray.length; p++) {

						token = new StringTokenizer(paramArray[p], " : ");
						String paramName = token.nextToken();
						String paramType = token.nextToken();

						if (paramType.equals("Bool") || paramType.equals("bool")) {
							paramType = "boolean";
						}

						compParam = compParam + paramType + " " + paramName + ", ";
					}

					compParam = compParam.substring(0, compParam.length()-2);

					out.write("\r\n");
					out.write("	" + access + " " + type + " " + name + " " + compParam + ")" + " {\r\n");
					out.write("\r\n");
					out.write("	}\r\n");

				} else {

					if (name.equals("main()")) {

						name = name.replace("()","");

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

			} else {

				if (name.equals("main()")) {

					name = name.replace("()","");

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
		}

		out.write("}");
		out.close();
	}
}


