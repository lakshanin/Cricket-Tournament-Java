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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Pakistan implements Initializable {

    private static Team pakTeam;
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
        TableView.setItems(pakPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected =1;
    }

    ObservableList<Player> pakPlayers = FXCollections.observableArrayList(
            new Player(1, "87",  "Haider Ali"),
            new Player(2, "73",   "Shadab Khan"),
            new Player(3, "70",  "Babar Azam"),
            new Player(4, "71",   "Hasan Ali"),
            new Player(5, "60",  "Mohammad Rizwan"),
            new Player(6, "74",   "Fakhar Zaman"),
            new Player(7, "78",  "Shaheen Afridi"),
            new Player(9, "86",   "Haris Rauf"),
            new Player(8, "69",  "Iftikhar Ahmed"),
            new Player(10, "62",  "Imad Wasim"),
            new Player(11, "57",  "Sharjeel Khan")
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

        ArrayList<String> pakNames = new ArrayList<String>();
        ArrayList<Integer> pakCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            pakNames.add(player.name.get());
            pakCaps.add(Integer.parseInt(player.cap.get()));
        }

        pakTeam = new Team(pakCaps, pakNames);
    }

    public static Team getPakTeam() {
        return pakTeam;
    }

    public static int getSelected() {
        return selected;
    }
}

