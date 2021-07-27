package adrian.lai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.time.LocalDate;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane myPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("ComputerTableView.fxml"));
        primaryStage.setTitle("FXML TableView Example");
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);

//        ComputerDAO computerDAO = new ComputerDAO();
//
//        List<Computer> computers = computerDAO.getAllComputers();
//        computers.forEach(computerget -> System.out.println(computerget.toString()));
//
//        List<Computer> defectivecomputers = computerDAO.getAllDefectiveComputers();
//        defectivecomputers.forEach(dcomputerget -> System.out.println(dcomputerget.toString()));



        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);

    }
}
