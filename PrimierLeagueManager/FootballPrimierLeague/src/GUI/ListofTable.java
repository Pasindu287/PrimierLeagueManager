package GUI;

import Core.FootballClub;
;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListofTable {
    public static ObservableList<FootballClub> list = FXCollections.observableArrayList();

    @FXML
    TableView pointsTable;

    @FXML
    TableColumn clubname, won, lost, draw, played, clubpoints, goals;

    @FXML
    Button btnclose;

    @FXML
    public void initialize () {
        clubname.setCellValueFactory(new PropertyValueFactory<>("ftballclbName"));
        won.setCellValueFactory(new PropertyValueFactory<>("Won"));
        lost.setCellValueFactory(new PropertyValueFactory<>("Lost"));
        draw.setCellValueFactory(new PropertyValueFactory<>("Draw"));
        played.setCellValueFactory(new PropertyValueFactory<>("played"));
        clubpoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        goals.setCellValueFactory(new PropertyValueFactory<>("goals"));
        try{
            File file = new File("Football.text");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            list = FXCollections.observableArrayList((ArrayList) obj);
            objectInputStream.close();
            fileInputStream.close();
            pointsTable.setItems(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Close(ActionEvent event) {
        Stage close = (Stage)((Node) event.getSource()).getScene().getWindow();
        close.close();

    }
}
