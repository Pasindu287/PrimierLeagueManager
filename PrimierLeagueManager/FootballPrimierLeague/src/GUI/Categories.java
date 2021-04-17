package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Categories {
    @FXML
    Button btnftballclub;

    @FXML
    Button btnsclftballclub;

    @FXML
    Button btnuniftball;

    public void mainFootBall(ActionEvent event) throws Exception {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofTable.fxml"));
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.setTitle("Played Match Table");

        playedmatch.showAndWait();
    }
    public void sclFootBall(ActionEvent event)throws Exception  {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofTableSchl.fxml"));
        playedmatch.setTitle("Played School Match Table");
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.showAndWait();
    }

    public void uniFootBall(ActionEvent event)throws Exception  {
        Stage playedmatch = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListofTableUni.fxml"));
        playedmatch.setTitle("Played University Match Table");
        playedmatch.setScene(new Scene(root, 600, 500));
        playedmatch.showAndWait();
    }
}
