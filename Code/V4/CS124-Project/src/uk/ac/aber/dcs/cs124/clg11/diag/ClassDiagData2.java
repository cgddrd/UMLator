package uk.ac.aber.dcs.cs124.clg11.diag;

public class ClassDiagData2 {
	
	public String Name;
	public String[] variables;
	public String[] operations;
	private int count = 0;
	

	public void setVarArray (int varSize) {
		variables = new String [varSize];
	}
	
	public String[] getVariables() {
		return variables;
	}

	public void addVar(String var) {
		variables[count] = var;
		count++;
	}
		
		
	
	public void printVar() {
		for (int i = 0; i < variables.length; i++) {
			System.out.println(variables[i]);
		}
 	}	
}
	
	


