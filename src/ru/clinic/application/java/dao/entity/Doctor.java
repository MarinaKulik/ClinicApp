package ru.clinic.application.java.dao.entity;

import javafx.beans.property.SimpleStringProperty;

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        setFioProp(fio);
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

    //Todo Add to string method
}
