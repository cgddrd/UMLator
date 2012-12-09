package uk.ac.aber.dcs.cs124.clg11.diag;
import java.util.ArrayList;

import uk.ac.aber.dcs.cs124.clg11.data.ObjectData;


public class ClassDiagData implements ObjectData {
	private String className;
	private boolean isAbstract;
	private String classAccessModifer;
	private ArrayList<String> instanceVariables = new ArrayList<String>();
	private ArrayList<String> methods = new ArrayList<String>();
	private String parentName;
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void addInstanceVar(String var) {
		instanceVariables.add(var);
	}
	
	public void addMethod(String m) {
		methods.add(m);
	}
	
	public ArrayList<String> getInstanceVariables() {
		return instanceVariables;
	}
	
	public ArrayList<String> getMethods () {
		return methods;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public boolean isAbstract() {
		return isAbstract;
	}
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	public String getAccessModifier() {
		return classAccessModifer;
	}
	public void setAccessModifier(String accessModifier) {
		this.classAccessModifer = accessModifier;
	}

}
