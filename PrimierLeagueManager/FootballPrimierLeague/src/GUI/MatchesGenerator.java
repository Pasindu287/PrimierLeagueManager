package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class MatchesGenerator {
    @FXML
    Button generate;

    @FXML
    TextField txtclubOneName;

    @FXML
    TextField txtclubTwoName;

    @FXML
    TextField txtScoreOne;

    @FXML
    TextField txtScoreTwo;



    @FXML
    public void Generate(ActionEvent event) throws Exception{
        boolean Clubonename = txtclubOneName.getText().equalsIgnoreCase("club1Name");
        boolean Clubonescore = txtScoreOne.getText().equalsIgnoreCase("club1Score");
        boolean Clubtwoname = txtclubTwoName.getText().equalsIgnoreCase("club2Name");
        boolean Clubtwoscore = txtScoreTwo.getText().equalsIgnoreCase("club2Score");

        if (Clubonename == true|Clubonescore == true|Clubtwoname == true) {

        }

    }
}
