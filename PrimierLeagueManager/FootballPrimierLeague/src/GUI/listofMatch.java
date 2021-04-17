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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static Core.PremierLeagueManager.readData;

public class listofMatch {
    public static List<FootballClub> list = new ArrayList<>();
    public static List<SchoolFootBallClub> scllist = new ArrayList<>();
    public static List<UniversityFootballClub> unilist = new ArrayList<>();

    @FXML
    TableView viewTable;

    @FXML
    TableColumn club1name,club1score,club2name,club2score,date,winorlose;

    @FXML
    Button btnclose;

    @FXML
    public void initialize () {
        club1name.setCellValueFactory(new PropertyValueFactory<>("club1Name"));
        club1score.setCellValueFactory(new PropertyValueFactory<>("club1Score"));
        club2name.setCellValueFactory(new PropertyValueFactory<>("club2Name"));
        club2score.setCellValueFactory(new PropertyValueFactory<>("club2Score"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        winorlose.setCellValueFactory(new PropertyValueFactory<>("result"));
        readData("Football.text", 1);
        readData("SclFootball.text", 2);
        readData("UniFootball.text", 3);
        display();
    }
    @FXML
    public void display(){
        ObservableList<Match> matches = FXCollections.observableArrayList();
        for(FootballClub club: list) {
            List<Match> matchList = club.getMatches();
            for (Match match: matchList) {
                if(!match.isDuplicate()) {
                    matches.add(match);
                }
            }
        }
        viewTable.setItems(matches);


    }

    public void readData (String filename, int type) {
        try{
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            switch (type) {
                case 1:
                    list = (ArrayList) obj;
                    break;
                case 2:
                    scllist = (ArrayList) obj;
                    break;
                case 3:
                    unilist = (ArrayList) obj;
                    break;
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Close(ActionEvent event) {
        Stage close = (Stage)((Node) event.getSource()).getScene().getWindow();
        close.close();
    }
}
