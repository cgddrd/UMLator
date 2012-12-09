package uk.ac.aber.dcs.cs124.clg11.data;

import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;
import java.io.Serializable;
import java.util.ArrayList;


public class ClassDiagData implements ObjectData, Serializable {
	private String className;
	private boolean isAbstract;
	private String classAccessModifer;
	private ArrayList<String> instanceVariables = new ArrayList<String>();
        private ArrayList<String> associatedInstanceVariables = new ArrayList<String>();
	private ArrayList<String> methods = new ArrayList<String>();
	private String parentName;
	
	public String getParentName() {
            return parentName;
	}

	public void setParentName(String parentName) {
            this.parentName = parentName;
	}

	public void addInstanceVariable(String var) {
            instanceVariables.add(var);
	}
        
        public void addAssocInstanceVar(String var) {
            associatedInstanceVariables.add(var);
        }
	
	public void addMethod(String m) {
            methods.add(m);
	}
	 
	public ArrayList<String> getInstanceVariables() {
            return instanceVariables;
	}
	
	public void setInstanceVariables(ArrayList<String> args) {
	    this.instanceVariables = args;
	}
        
        public ArrayList<String> getAssocInstanceVariables() {
            return associatedInstanceVariables;
        }
	
	public void setAssocInstanceVariables(ArrayList<String> args) {
	    this.associatedInstanceVariables= args;
	}
	
	public ArrayList<String> getMethods () {
            return methods;
	}
	
	public void setMethods(ArrayList<String> args) {
	    this.methods = args;
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
