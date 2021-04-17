package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Selection {
    @FXML
    Button btnftballclub;

    @FXML
    Button btnsclftballclub;

    @FXML
    Button btnuniftball;

    public void mainFootBall(ActionEvent event) throws IOException {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofMatch.fxml"));
        playedmatch.setTitle("Mathes Table");
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.showAndWait();
    }


    public void sclFootBall(ActionEvent event)throws IOException {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofsclMatch.fxml"));
        playedmatch.setTitle("Mathes Table");
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.showAndWait();
    }


    public void uniFootBall(ActionEvent event)throws IOException {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofuniMatch.fxml"));
        playedmatch.setTitle("Mathes Table");
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.showAndWait();
    }
}
