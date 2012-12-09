package uk.ac.aber.dcs.cs124.clg11.diag;
import uk.ac.aber.dcs.cs124.clg11.data.ObjectData;
import uk.ac.aber.dcs.cs124.clg11.data.RelType;


public class RelationshipDiagData implements ObjectData {
        private String assocVar;
	private RelType relType;

	public RelType getRelType() {
		return relType;
	}

	public void setRelType(RelType relType) {
		this.relType = relType;
	}
        
        public void setAsscoVar(String a) {
            assocVar = a;
        }
        
        public String getAssocVar() {
            return assocVar;
        }
	
}
