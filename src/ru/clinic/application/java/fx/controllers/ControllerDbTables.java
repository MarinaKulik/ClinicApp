package ru.clinic.application.java.fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.clinic.application.java.fx.frames.FrameDbTables;
import ru.clinic.application.java.service.AdminService;
import ru.clinic.application.java.service.dataBaseModel.TableAdmins;
import ru.clinic.application.java.service.dataBaseModel.TableDoctors;

import java.util.Optional;

/**
 * Created by Artem Siatchinov on 1/2/2017.
 */

@Component
public class ControllerDbTables {

    private final static Logger LOGGER = Logger.getLogger(ControllerDbTables.class.getName());

    private final static String CREATED = "создана";
    private final static String NOT_CREATED = "не создана";
    private final static Color POS_COLOR = Color.GREEN;
    private final static Color NEG_COLOR = Color.BLUE;

    private final static String CONFIRMATION_TITLE = "Подтверждение";
    private final static String CONFIRMATION_HEADER = "Вы собираетесь изменить структуру базы данных. \nЕсли удаляется таблица, то это приведет к потери всех данных";
    private final static String CONFIRMATION_CONTENT = "Вы уверены, что хотите продолжить?";

    /*Information Dialog not authorised*/
    private static final String INFORMATION_TITLE = "Информационное окно";
    private static final String INFORMATION_CONTEXT = "У Вас не хватает прав для выполнения данной операции. \nЗайдите под главным администратором.";

    @Autowired
    TableAdmins tableAdmins;

    @Autowired
    TableDoctors tableDoctors;

    @Autowired
    FrameDbTables frameDbTables;

    @Autowired
    AdminService adminService;

    @FXML
    private Label adminStatus;

    @FXML
    private Button createAdmin;

    @FXML
    private Button dropAdmin;

    @FXML
    private Button refreshAdmin;

    @FXML
    private Button closeFrameBtn;

    @FXML
    private Label doctorStatus;

    @FXML
    private Button createDoctor;

    @FXML
    private Button dropDoctor;

    @FXML
    private Button updateDoctor;




    public void startController() {
        setAdminStatus();
        setDoctorsStatus();
    }

    private void alertNoAuth() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(INFORMATION_TITLE);
        alert.setHeaderText(null);
        alert.setContentText(INFORMATION_CONTEXT);

        alert.showAndWait();
    }

    private void setCreatedStatus(boolean created, Label labelStatus, Button createBtn, Button dropBtn){
        if (created){
            labelStatus.setText(CREATED);
            labelStatus.setTextFill(POS_COLOR);
            createBtn.setDisable(true);
            dropBtn.setDisable(false);
            return;
        }
        labelStatus.setText(NOT_CREATED);
        labelStatus.setTextFill(NEG_COLOR);
        createBtn.setDisable(false);
        dropBtn.setDisable(true);
    }

    private boolean confirmAction(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(CONFIRMATION_TITLE);
        alert.setHeaderText(CONFIRMATION_HEADER);
        alert.setContentText(CONFIRMATION_CONTENT);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        }
        return false;
    }

    @FXML
    void closeFrameAction(ActionEvent event) {
        frameDbTables.stop();
    }

    public void setAdminStatus() {
        if (adminStatus != null && createAdmin != null && dropAdmin != null){
            setCreatedStatus(tableAdmins.isCreated(), adminStatus, createAdmin, dropAdmin);
        }
    }

    @FXML
    void createAdminAction(ActionEvent event) {
        if (confirmAction()) {
            tableAdmins.createTable();
        }
    }

    @FXML
    void dropAdminAction(ActionEvent event) {
        if (adminService.getCurrentAdmin().getId() == 0) {
            if (confirmAction()) {
                tableAdmins.dropTable();
            }
        }else {
            alertNoAuth();
        }
    }

    @FXML
    void refreshAdminAction(ActionEvent event) {
        tableAdmins.checkIfCreated();
    }

    public void setDoctorsStatus() {
        if (doctorStatus != null && createDoctor != null && dropDoctor != null){
            setCreatedStatus(tableDoctors.isCreated(), doctorStatus, createDoctor, dropDoctor);
        }
    }

    @FXML
    void createDoctorAction(ActionEvent event) {
        if (confirmAction()) {
            tableDoctors.createTable();
        }
    }

    @FXML
    void dropDoctorAction(ActionEvent event) {
        if (adminService.getCurrentAdmin().getId() == 0) {
            if (confirmAction()) {
                tableDoctors.dropTable();
            }
        }else {
            alertNoAuth();
        }
    }

    @FXML
    void updateDoctorAction(ActionEvent event) {
        tableDoctors.checkIfCreated();
    }
}
