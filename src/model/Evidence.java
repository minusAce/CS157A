package src.model;

import java.time.LocalDate;

public class Evidence {
    private int evidenceID;
    private String title;
    private String description;
    private String evidenceType;
    private LocalDate dateCollected;
    private String evidenceImage;

    public int getEvidenceID() {
        return evidenceID;
    }
    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEvidenceType() {
        return evidenceType;
    }
    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }
    public LocalDate getDateCollected() {
        return dateCollected;
    }
    public void setDateCollected(LocalDate dateCollected) {
        this.dateCollected = dateCollected;
    }
    public String getEvidenceImage() {
        return evidenceImage;
    }
    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }
}