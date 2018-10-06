package sampleAdressBook;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sampleAdressBook.interfaces.impls.CollectionAdressBook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    private CollectionAdressBook adressBookImpl = new CollectionAdressBook();
    private Stage mainStage;

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private TableView tableAdressBook;
    @FXML
    private TableColumn<Person, String> columnName;
    @FXML
    private TableColumn<Person, String> columnSurname;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Label lableCount;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;

        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        initListeners();
        fillData();
        initLoader();
    }

    public void setMainStage(Stage mainStage){ this.mainStage = mainStage; }

    private void fillData() {
        adressBookImpl.fillTestData();
        tableAdressBook.setItems(adressBookImpl.getPersonList());
    }

    private void initListeners(){
        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLable();
            }
        });

        tableAdressBook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    editDialogController.setPerson((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        }));
    }

    private void initLoader(){
        try {
            fxmlLoader.setLocation(getClass().getResource("fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void updateCountLable() {
        lableCount.setText(resourceBundle.getString("count") + ": " + adressBookImpl.getPersonList().size());
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button cluckedBtn = (Button) source;

        Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();

        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        editDialogController.setPerson(selectedPerson);

        switch (cluckedBtn.getId()) {
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showDialog();
                adressBookImpl.add(editDialogController.getPerson());
                break;

            case "btnDelete":
                adressBookImpl.delete((Person)tableAdressBook.getSelectionModel().getSelectedItem());
                break;

            case "btnEdit":
                editDialogController.setPerson((Person)tableAdressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
        }
    }

        private void showDialog(){
        if (editDialogStage ==null){
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait();
    }


}
