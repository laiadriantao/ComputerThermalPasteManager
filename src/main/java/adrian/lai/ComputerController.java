package adrian.lai;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ComputerController implements Initializable {

        //Table object
        @FXML private TableView<Computer> computerTable;

        //Column objects
        @FXML private TableColumn idColumn;

        @FXML private TableColumn creationColumn;

        @FXML private TableColumn lastColumn;

        @FXML private TableColumn nextColumn;

        @FXML private TableColumn revisionColumn;

        //Data Access Object
         ComputerDAO computerDao = new ComputerDAO();

         //initialize application
        @Override @FXML
       public void initialize(URL location, ResourceBundle resources){
                setCellTable();
                //computerTable sets all the Computer Objects from the list to the Table
                computerTable.setItems(getCompList());
}

        //Method to specify how to populate columns
        private void setCellTable(){
                idColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("id"));
                creationColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("creationDate"));
                lastColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("lastRevisionDate"));
                nextColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("nextRevisionDate"));
                revisionColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("needsRevision"));
        }

        //Method to get and put all computers in form of the list
        // This method is also used to refresh the list
        public ObservableList<Computer>  getCompList (){
                ObservableList<Computer> compObsList= FXCollections.observableArrayList();
                for(Computer comp : computerDao.getComputers()){
                        compObsList.add(comp);
                }
                return compObsList;
        }

        //Method to add new computer object instantly
    public void  addRow(){
            Computer computer = new Computer();
            computerDao.saveComputer(computer);
            computerTable.setItems(getCompList());

    }

    //Method to add new computer based on picked date
    public  void slowAddRow(){
            //create new popup style window
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Add new computer");
            // datepicker calendar
            DatePicker datePicker = new DatePicker();
            //button that adds new computer
            Button button = new Button("Add new computer");
            button.setOnAction(e -> {
                Computer computer = new Computer(datePicker.getValue());
                computerDao.saveComputer(computer);
                computerTable.setItems(getCompList());
            });
            //styling
            VBox vbox = new VBox(datePicker);
            vbox.getChildren().add(button);
            Scene scene = new Scene(vbox, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();

    }

    //Method to delete computer
    public void deleteRow(){
            int getID = computerTable.getSelectionModel().getSelectedItem().getId();
            Computer computer = new Computer();
            computer.setId(getID);
            computerDao.deleteComputer(computer);
            computerTable.setItems(getCompList());
    }

    //Method to modify computer revision status
    public void updateRowRevision(){
            Computer computer = new Computer();
            int getID = computerTable.getSelectionModel().getSelectedItem().getId();
            LocalDate getCreateD= computerTable.getSelectionModel().getSelectedItem().getCreationDate();
            computer.setId(getID);
            computer.setCreationDate(getCreateD);
            computer.setLastRevisionDate(LocalDate.now());
            computer.setNextRevisionDate(LocalDate.now().plusYears(2));
            computer.setNeedsRevision(false);
            computerDao.updateComputer(computer);
            computerTable.setItems(getCompList());

    }

    //Alert method that checks for computers in case they need fixing
    @FXML
    public void checkingForRevision(ActionEvent event){
        Alert cfr = new Alert(Alert.AlertType.INFORMATION);

            //Creates list of all Computers that needs a revision
            ObservableList<Computer> revisionList= FXCollections.observableArrayList();
            for(Computer comp : computerDao.getAllDefectiveComputers()){
                revisionList.add(comp);
            }
            //Checks if the revisionList is empty to display the appropriate message
            if(revisionList.isEmpty() == false){
                cfr.setTitle("Revision status");
                cfr.setHeaderText("There is some work to do today");
                cfr.setContentText("Remember, it's important for our computers to run cool!");
                cfr.showAndWait();
                //The list will be filled with the Computer Objects  that need revision
                setCellTable();
                computerTable.setItems(revisionList);
            } else{
                cfr.setTitle("Revision status");
                cfr.setHeaderText("All cool (;");
                cfr.setContentText("Remember, it's important for our computers to run cool!");
                cfr.showAndWait();
            }

        }

}
