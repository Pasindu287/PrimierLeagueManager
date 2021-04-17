package GUI;

import Core.SchoolFootBallClub;
import Core.UniversityFootballClub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Core.FootballClub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    public static List<FootballClub> footballClubs = new ArrayList<>();
    public static List<SchoolFootBallClub> schoolFootballClubs = new ArrayList<>();
    public static List<UniversityFootballClub> universityFootballClubs = new ArrayList<>();

    @FXML
    Button btnleaugetable;

    @FXML
    Button btnplayedmatch;

    @FXML
    Button btnsearchmtches;

    @FXML
    Button btngenerator;

    @FXML
    Button btnexit;

    public void openGui () throws IOException {
        Stage mainMenu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Main Menu.fxml"));
        mainMenu.setTitle("Main Menu");
        mainMenu.setScene(new Scene(root, 600, 500));
        mainMenu.showAndWait();
    }

    @FXML
    public void Navigateleaugetable(ActionEvent event) throws Exception{
        Stage leaugetable = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Categories.fxml"));
        leaugetable.setTitle("Selection");
        leaugetable.setScene(new Scene(root, 460, 500));
        leaugetable.showAndWait();
    }

    @FXML
    public void Navigateplayedmatch(ActionEvent event) throws Exception{

        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Selection.fxml"));
        playedmatch.setTitle("Selection");
        playedmatch.setScene(new Scene(root, 460, 500));
        playedmatch.showAndWait();
    }

    @FXML
    public void NavigateSearchMatch(ActionEvent event) throws Exception{

        Stage searchmatch  = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/SearchMatch.fxml"));
        searchmatch.setTitle("Search Match");
        searchmatch.setScene(new Scene(root, 600, 500));
        searchmatch.showAndWait();
    }

    @FXML
    public void Navigategenerator(ActionEvent event) throws Exception{

        Stage  matchesgenerator = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/MatchesGenerator.fxml"));
        matchesgenerator.setTitle("Random Match Generator");
        matchesgenerator.setScene(new Scene(root, 600, 500));
        matchesgenerator.showAndWait();
    }


    @FXML
    public void NavigateExit(ActionEvent event) throws Exception{

        Stage close = (Stage)((Node) event.getSource()).getScene().getWindow();
        close.close();
    }
    }

