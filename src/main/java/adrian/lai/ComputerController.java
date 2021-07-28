package adrian.lai;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


public class ComputerController implements Initializable {

        @FXML private TableView<Computer> computerTable;

        @FXML private TableColumn idColumn;

        @FXML private TableColumn creationColumn;

        @FXML private TableColumn lastColumn;

        @FXML private TableColumn nextColumn;

        @FXML private TableColumn revisionColumn;

         ComputerDAO computerDao = new ComputerDAO();

        @Override @FXML
       public void initialize(URL location, ResourceBundle resources){
                setCellTable();
                computerTable.setItems(getCompList());
}

        private void setCellTable(){
                idColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("id"));
                creationColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("creationDate"));
                lastColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("lastRevisionDate"));
                nextColumn.setCellValueFactory(new PropertyValueFactory<Computer, LocalDate>("nextRevisionDate"));
                revisionColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("needsRevision"));
        }
        public ObservableList<Computer>  getCompList (){
                ObservableList<Computer> compObsList= FXCollections.observableArrayList();
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<Computer> compList = session.createQuery("from computer", Computer.class).list();
                for(Computer comp : compList){
                        compObsList.add(comp);
                }
                return compObsList;
        }

    public void  addRow(){
            Computer computer = new Computer();
            computer.setLastRevisionDate(LocalDate.now());
            computer.setNextRevisionDate(LocalDate.now().plusYears(2));
            computerDao.saveComputer(computer);
             computerTable.setItems(getCompList());
    }
    public void deleteRow(){
            int getID = computerTable.getSelectionModel().getSelectedItem().getId();
            Computer computer = new Computer();
            computer.setId(getID);
            computerDao.deleteComputer(computer);
            computerTable.setItems(getCompList());
    }

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

}
