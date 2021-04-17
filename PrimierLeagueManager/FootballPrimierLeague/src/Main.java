import Core.PremierLeagueManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.close();
        PremierLeagueManager manager = new PremierLeagueManager();
       try {
            manager.premierLeague();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
