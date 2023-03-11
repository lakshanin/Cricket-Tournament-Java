package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class England implements Initializable {

    private static Team engTeam;
    private static int selected = 0;
    @FXML
    private TableView<Player> TableView;
    @FXML
    private TableColumn<Player, Integer> indexCol;
    @FXML
    private TableColumn<Player, String> capCol;
    @FXML
    private TableColumn<Player, String> nameCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        indexCol.setCellValueFactory(new PropertyValueFactory<>("Index"));
        capCol.setCellValueFactory(new PropertyValueFactory<>("Cap"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableView.setItems(engPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> engPlayers = FXCollections.observableArrayList(
            new Player(1, "81",  "Dawid Malan"),
            new Player(2, "83",   "Jake Ball"),
            new Player(3, "79",  "Tom Curran"),
            new Player(4, "70",   "Jason Roy"),
            new Player(5, "54",  "Jos Buttler"),
            new Player(6, "58",   "Ben Stokes"),
            new Player(7, "65",  "Chris Jordan"),
            new Player(9, "66",   "Moeen Ali"),
            new Player(8, "56",  "Jonny Bairstow"),
            new Player(10, "46",   "Adil Rashid"),
            new Player(11, "71",  "Sam Billings")
    );

    public void editCap(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent) {
        Player player = TableView.getSelectionModel().getSelectedItem();
        player.setCap(playerStringCellEditEvent.getNewValue());
    }

    public void editName(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent) {
        Player player = TableView.getSelectionModel().getSelectedItem();
        player.setName(playerStringCellEditEvent.getNewValue());
    }

    public void Toss(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Toss.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Player player = new Player();

        ArrayList<String> engNames = new ArrayList<String>();
        ArrayList<Integer> engCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            engNames.add(player.name.get());
            engCaps.add(Integer.parseInt(player.cap.get()));
        }

        engTeam = new Team(engCaps, engNames);
    }

    public static Team getEngTeam() {
        return engTeam;
    }

    public static int getSelected() {
        return selected;
    }
}
