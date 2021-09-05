package model;

import java.time.LocalDate;

public class PersonalInformation {
    private String id;
    private String name;
    private LocalDate dateOfBirth;

    public PersonalInformation() {
    }

    public PersonalInformation(String id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + dateOfBirth;
    }
}