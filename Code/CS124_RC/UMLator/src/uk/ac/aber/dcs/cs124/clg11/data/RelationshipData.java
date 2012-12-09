package uk.ac.aber.dcs.cs124.clg11.data;

import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;

/**
 * Storage class used to contain information about a particular
 * relationship created by a user. 
 * 
 * Stored of type 'ObjectData' in VectorOfDrawables
 * 
 * @author Connor Goddard (clg11), Sam Jackson (???), Craig Hepinsthall (???)
 *
 */

public class RelationshipData implements ObjectData {
	private ClassDiag a, b;
	private String assocVar;
	private String classAMulti;
	private String classBMulti;
	private String relType;
	

	/**
	 *
	 * @return relType Type of relationship 
	 */
	public String getRelType() {
		return relType;
	}

	public ClassDiag getClassA() {
		return a;
	}

	public void setClassA(ClassDiag a) {
		this.a = a;
	}

	public ClassDiag getClassB() {
		return b;
	}

	public void setClassB(ClassDiag b) {
		this.b = b;
	}

	public String getAssocVar() {
		return assocVar;
	}

	public void setAssocVar(String assocVar) {
		this.assocVar = assocVar;
	}

	public String getClassAMulti() {
		return classAMulti;
	}

	public void setClassAMulti(String classAMulti) {
		this.classAMulti = classAMulti;
	}

	public String getClassBMulti() {
		return classBMulti;
	}

	public void setClassBMulti(String classBMulti) {
		this.classBMulti = classBMulti;
	}

	/**
	 * @param relType Type of relationship 
	 */
	public void setRelType(String relType) {
		this.relType = relType;
	}
	
}
