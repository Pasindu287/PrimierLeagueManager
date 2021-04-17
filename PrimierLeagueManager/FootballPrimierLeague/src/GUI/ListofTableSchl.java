package GUI;

import Core.SchoolFootBallClub;
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
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListofTableSchl {
    public static ObservableList<SchoolFootBallClub> scllist = FXCollections.observableArrayList();

    @FXML
    TableView pointsTable;

    @FXML
    TableColumn clubname, won, lost, draw, played, clubpoints, goals;

    @FXML
    Button btnclose;

    @FXML
    public void initialize () {
        clubname.setCellValueFactory(new PropertyValueFactory<>("sclftballclbName"));
        won.setCellValueFactory(new PropertyValueFactory<>("Won"));
        lost.setCellValueFactory(new PropertyValueFactory<>("Lost"));
        draw.setCellValueFactory(new PropertyValueFactory<>("Draw"));
        played.setCellValueFactory(new PropertyValueFactory<>("played"));
        clubpoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        goals.setCellValueFactory(new PropertyValueFactory<>("goals"));
        try{
            File file = new File("SclFootball.text");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            scllist = FXCollections.observableArrayList((ArrayList) obj);
            objectInputStream.close();
            fileInputStream.close();
            pointsTable.setItems(scllist);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Close(ActionEvent event) {
        Stage close = (Stage)((Node) event.getSource()).getScene().getWindow();
        close.close();

    }
}
