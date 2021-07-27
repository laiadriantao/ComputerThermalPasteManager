package adrian.lai;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


public class ComputerController implements Initializable {

        @FXML private TableView computerTable;

        @FXML private TableColumn idColumn;

        @FXML private TableColumn creationColumn;

        @FXML private TableColumn lastColumn;

        @FXML private TableColumn nextColumn;

        @FXML private TableColumn revisionColumn;

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
              //  compList.forEach(comp -> compList.add(comp));
                return compObsList;
        }
}
