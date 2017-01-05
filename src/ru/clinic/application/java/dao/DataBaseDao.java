package ru.clinic.application.java.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Artem Siatchinov on 1/2/2017.
 */

@Component
public class DataBaseDao {

    private final static Logger LOGGER = Logger.getLogger(DataBaseDao.class.getName());

    private final static String ADMIN_CHECK_TABLE = "SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC' AND TABLE_NAME = 'ADMIN'";
    private final static String DROP_ADMIN_TABLE = "DROP TABLE ADMIN";
    private final static String ADMIN_CREATE_TABLE ="CREATE TABLE IF NOT EXISTS ADMIN("+
            "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"+
            "fio varchar(125),"+
            "dob date,"+
            "cellphone varchar(25),"+
            "cellphone2 varchar(25),"+
            "homephone varchar(25),"+
            "email varchar(25),"+
            "user_name varchar(25),"+
            "password varchar(25),"+
            "creator int,"+
            "created timestamp,"+
            "who_modified int,"+
            "modified timestamp,"+
            "who_removed int,"+
            "when_removed timestamp,"+
            "removed boolean)";

    private final static String DOCTOR_CHECK_TABLE = "SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC' AND TABLE_NAME = 'DOCTOR'";
    private final static String DROP_DOCTOR_TABLE = "DROP TABLE DOCTOR";
    private final static String DOCTOR_CREATE_TABLE ="CREATE TABLE IF NOT EXISTS DOCTOR("+
            "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"+
            "fio varchar(125),"+
            "dob date,"+
            "cellphone varchar(25),"+
            "cellphone2 varchar(25),"+
            "homephone varchar(25),"+
            "email varchar(25),"+
            "comment varchar(500),"+
            "creator int,"+
            "created timestamp,"+
            "who_modified int,"+
            "modified timestamp,"+
            "who_removed int,"+
            "when_removed timestamp,"+
            "removed boolean)";

    private final static String PATIENT_CHECK_TABLE = "SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC' AND TABLE_NAME = 'PATIENT'";
    private final static String DROP_PATIENT_TABLE = "DROP TABLE PATIENT";
    private final static String PATIENT_CREATE_TABLE ="CREATE TABLE IF NOT EXISTS PATIENT("+
            "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"+
            "firstName varchar(125),"+
            "lastName varchar(125),"+
            "middleName varchar(125),"+
            "phone varchar(25),"+
            "phoneTwo varchar(25),"+
            "email varchar(25),"+
            "comment varchar(500),"+
            "creator int,"+
            "created timestamp,"+
            "who_modified int,"+
            "modified timestamp,"+
            "who_removed int,"+
            "when_removed timestamp,"+
            "removed boolean)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataBaseDao(){

    }

    public boolean checkAdminTable(){
        LOGGER.debug("[DataBaseDao][checkAdminTable]");
        Integer count = jdbcTemplate.queryForObject(ADMIN_CHECK_TABLE, Integer.class);
        return count == 1;
    }

    public boolean checkDoctorsTable() {
        LOGGER.debug("[DataBaseDao][checkDoctorsTable]");
        Integer count = jdbcTemplate.queryForObject(DOCTOR_CHECK_TABLE, Integer.class);
        return count == 1;
    }

    public boolean checkPatientsTable() {
        LOGGER.debug("[DataBaseDao][checkPatientsTable]");
        Integer count = jdbcTemplate.queryForObject(PATIENT_CHECK_TABLE, Integer.class);
        return count == 1;
    }

    public boolean checkAppointmentTable() {
        return false;
    }

    public boolean checkSettingsTable() {
        return false;
    }

    public void dropAdminTable() {
        jdbcTemplate.execute(DROP_ADMIN_TABLE);
    }

    public void createAdminTable() {
        jdbcTemplate.execute(ADMIN_CREATE_TABLE);
    }

    public void dropDoctorsTable() {
        jdbcTemplate.execute(DROP_DOCTOR_TABLE);
    }

    public void createDoctorsTable() {
        jdbcTemplate.execute(DOCTOR_CREATE_TABLE);
    }

    public void dropPatientTable() {
        jdbcTemplate.execute(DROP_PATIENT_TABLE);
    }

    public void createPatientTable() {
        jdbcTemplate.execute(PATIENT_CREATE_TABLE);
    }


}
