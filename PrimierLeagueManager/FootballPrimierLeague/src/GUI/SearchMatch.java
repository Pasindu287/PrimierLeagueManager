package GUI;

import Core.FootballClub;
import Core.Match;
import Core.SchoolFootBallClub;
import Core.UniversityFootballClub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchMatch {
    public static ObservableList<FootballClub> list = FXCollections.observableArrayList();
    public static ObservableList<SchoolFootBallClub> scllist = FXCollections.observableArrayList();
    public static ObservableList<UniversityFootballClub> unilist = FXCollections.observableArrayList();

    @FXML
    TableView searchTable;

    @FXML
    TableColumn club1name,club1score,club2name,club2score,date,winorlose ;

    @FXML
    Button btnSearch;

    @FXML
    TextField txtdate;

    @FXML
    public void initialize () {

    }

    @FXML
    public void display(){
//        searchTable.setItems(scllist);
//        searchTable.setItems(unilist);
    }

    public void readData (String filename, int type) {
        try{
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            switch (type) {
                case 1:
                    list = FXCollections.observableArrayList((ArrayList) obj);
                    break;
                case 2:
                    scllist = FXCollections.observableArrayList((ArrayList) obj);
                    break;
                case 3:
                    unilist = FXCollections.observableArrayList((ArrayList) obj);
                    break;
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Search(javafx.event.ActionEvent event) throws Exception {
        readData("Football.text", 1);
        Date enteredDate = new SimpleDateFormat("dd/MM/yyyy").parse(txtdate.getText());
//        readData("SclFootball.text", 2);
//        readData("UniFootball.text", 3);
        club1name.setCellValueFactory(new PropertyValueFactory<>("club1Name"));
        club1score.setCellValueFactory(new PropertyValueFactory<>("club1Score"));
        club2name.setCellValueFactory(new PropertyValueFactory<>("club2Name"));
        club2score.setCellValueFactory(new PropertyValueFactory<>("club2Score"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        winorlose.setCellValueFactory(new PropertyValueFactory<>("result"));

        ObservableList<Match> matches = FXCollections.observableArrayList();
        for(FootballClub club: list) {
            List<Match> matchList = club.getMatches();
            for (Match match: matchList) {
                if(!match.isDuplicate() && match.getDate().equals(enteredDate)) {
                    matches.add(match);
                }
            }
        }
        searchTable.setItems(matches);

        txtdate.clear();
    }

    public void Close(ActionEvent event) {
        Stage close = (Stage)((Node) event.getSource()).getScene().getWindow();
        close.close();
    }
}
