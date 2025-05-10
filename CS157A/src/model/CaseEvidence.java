package src.model;

public class CaseEvidence {
    private int caseID;
    private int evidenceID;

    public CaseEvidence(int caseID, int evidenceID) {
        this.caseID = caseID;
        this.evidenceID = evidenceID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
    
    public int getEvidenceID() {
        return evidenceID;
    }

    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }
}