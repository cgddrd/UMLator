package uk.ac.aber.dcs.cs124.clg11.data;


public class RelationshipDiagData implements ObjectData {
	private int endx, endy;
	private RelType relType;

	public RelType getRelType() {
		return relType;
	}

	public void setRelType(RelType relType) {
		this.relType = relType;
	}

	public int getEndx() {
		return endx;
	}

	public void setEndx(int endx) {
		this.endx = endx;
	}

	public int getEndy() {
		return endy;
	}

	public void setEndy(int endy) {
		this.endy = endy;
	}
	
}
