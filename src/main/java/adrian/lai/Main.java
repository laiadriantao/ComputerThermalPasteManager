package adrian.lai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane myPane =  FXMLLoader.load(getClass().getClassLoader().getResource("ComputerTableView.fxml"));
        primaryStage.setTitle("Computer ThermalPaste Manager");
        Scene myScene = new Scene(myPane);
        myScene.getStylesheets().add("ComputerTableView.css");
        primaryStage.setScene(myScene);
        myScene.getStylesheets().add("ComputerTableView.css");
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);

    }
}
