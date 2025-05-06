package src.model;

import java.time.LocalDate;

public class Case {
    private int id;
    private String title;
    private String description;
    private LocalDate dateOpened;
    private LocalDate dateClosed;

    public Case(int id, String title, String description, LocalDate dateOpened, LocalDate dateClosed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDateOpened() { return dateOpened; }
    public LocalDate getDateClosed() { return dateClosed; }
}