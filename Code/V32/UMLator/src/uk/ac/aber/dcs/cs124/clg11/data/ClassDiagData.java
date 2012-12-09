package uk.ac.aber.dcs.cs124.clg11.data;

import java.util.ArrayList;


public class ClassDiagData implements ObjectData {
	private String className;
	private boolean isAbstract;
	private String classAccessModifer;
	private ArrayList<String> instanceVariables = new ArrayList<>();
        private ArrayList<String> associatedInstanceVariables = new ArrayList<>();
	private ArrayList<String> methods = new ArrayList<>();
	private String parentName;
	
	public String getParentName() {
            return parentName;
	}

	public void setParentName(String parentName) {
            this.parentName = parentName;
	}

	public void addInstanceVar(String var) {
            getInstanceVariables().add(var);
	}
        
        public void addAssocInstanceVar(String var) {
            getAssociatedInstanceVariables().add(var);
        }
	
	public void addMethod(String m) {
            getMethods().add(m);
	}
	
	public ArrayList<String> getInstanceVariables() {
            return instanceVariables;
	}
        
        public ArrayList<String> getAssocInstanceVariables() {
            return getAssociatedInstanceVariables();
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
		return isIsAbstract();
	}
	public void setAbstract(boolean isAbstract) {
		this.setIsAbstract(isAbstract);
	}
	public String getAccessModifier() {
		return getClassAccessModifer();
	}
	public void setAccessModifier(String accessModifier) {
		this.setClassAccessModifer(accessModifier);
	}

    /**
     * @return the isAbstract
     */
    public boolean isIsAbstract() {
	return isAbstract;
    }

    /**
     * @param isAbstract the isAbstract to set
     */
    public void setIsAbstract(boolean isAbstract) {
	this.isAbstract = isAbstract;
    }

    /**
     * @return the classAccessModifer
     */
    public String getClassAccessModifer() {
	return classAccessModifer;
    }

    /**
     * @param classAccessModifer the classAccessModifer to set
     */
    public void setClassAccessModifer(String classAccessModifer) {
	this.classAccessModifer = classAccessModifer;
    }

    /**
     * @param instanceVariables the instanceVariables to set
     */
    public void setInstanceVariables(ArrayList<String> instanceVariables) {
	this.instanceVariables = instanceVariables;
    }

    /**
     * @return the associatedInstanceVariables
     */
    public ArrayList<String> getAssociatedInstanceVariables() {
	return associatedInstanceVariables;
    }

    /**
     * @param associatedInstanceVariables the associatedInstanceVariables to set
     */
    public void setAssociatedInstanceVariables(ArrayList<String> associatedInstanceVariables) {
	this.associatedInstanceVariables = associatedInstanceVariables;
    }

    /**
     * @param methods the methods to set
     */
    public void setMethods(ArrayList<String> methods) {
	this.methods = methods;
    }

}
