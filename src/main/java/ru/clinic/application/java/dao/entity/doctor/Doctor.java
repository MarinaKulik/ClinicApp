package ru.clinic.application.java.dao.entity.doctor;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by Artem Siatchinov on 1/4/2017.
 */
public class Doctor {

    private int id;
    private String fio;
    private LocalDate dob;
    private String cellPhone;
    private String cellPhoneTwo;
    private String homePhone;
    private String email;
    private String comment;

    private SimpleStringProperty fioProp = new SimpleStringProperty();
    private SimpleStringProperty cellPhoneProp = new SimpleStringProperty();
    private SimpleStringProperty homePhonePro = new SimpleStringProperty();
    private SimpleStringProperty emailProp = new SimpleStringProperty();

    private LocalDate startDate;
    private LocalDate endDate;
    private ObservableList<WorkingDay> workingDays;

    public Doctor(){
        workingDays = FXCollections.observableArrayList();
        startDate = null;
        endDate = null;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        setFioProp(fio);
    }

    public WorkingDay getWorkingDay(LocalDate date){
        return workingDays.stream().filter(workingDay -> workingDay.getWorkingDay().equals(date)).findFirst().orElse(null);
    }

    public boolean isDateInBounds(LocalDate date) {
        if (startDate == null || endDate == null) {
            return false;
        }
        return date != null && date.isAfter(startDate) && date.isBefore(endDate);
    }

    public void setWorkingDays(ObservableList<WorkingDay> workingDays, LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
        this.workingDays = workingDays;
    }

    public ObservableList<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        setCellPhoneProp(cellPhone);
    }

    public String getCellPhoneTwo() {
        return cellPhoneTwo;
    }

    public void setCellPhoneTwo(String cellPhoneTwo) {
        this.cellPhoneTwo = cellPhoneTwo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        setHomePhonePro(homePhone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        setEmailProp(email);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", dob=" + dob +
                ", cellPhone='" + cellPhone + '\'' +
                ", cellPhoneTwo='" + cellPhoneTwo + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

/*Properties*/

    public String getFioProp() {
        return fioProp.get();
    }

    public SimpleStringProperty fioPropProperty() {
        return fioProp;
    }

    public void setFioProp(String fioProp) {
        this.fioProp.set(fioProp);
    }

    public String getCellPhoneProp() {
        return cellPhoneProp.get();
    }

    public SimpleStringProperty cellPhonePropProperty() {
        return cellPhoneProp;
    }

    public void setCellPhoneProp(String cellPhoneProp) {
        this.cellPhoneProp.set(cellPhoneProp);
    }

    public String getHomePhonePro() {
        return homePhonePro.get();
    }

    public SimpleStringProperty homePhoneProProperty() {
        return homePhonePro;
    }

    public void setHomePhonePro(String homePhonePro) {
        this.homePhonePro.set(homePhonePro);
    }

    public String getEmailProp() {
        return emailProp.get();
    }

    public SimpleStringProperty emailPropProperty() {
        return emailProp;
    }

    public void setEmailProp(String emailProp) {
        this.emailProp.set(emailProp);
    }


}
