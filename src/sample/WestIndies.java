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

public class WestIndies implements Initializable {

    private static Team wiTeam;
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
        TableView.setItems(wiPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> wiPlayers = FXCollections.observableArrayList(
            new Player(1, "77",  "Oshane Thomas"),
            new Player(2, "75",   "Fabian Allen"),
            new Player(3, "66",  "Rovman Powell"),
            new Player(4, "69",   "Shimron Hetmyer"),
            new Player(5, "82",  "Hayden Waish"),
            new Player(6, "61",   "Jason Holder"),
            new Player(7, "79",  "Obed McCoy"),
            new Player(9, "65",   "Chris Gayle"),
            new Player(8, "13",  "Ravi Rampaul"),
            new Player(10, "18",  "Lendl Simmons"),
            new Player(11, "26",  "Kieron Pollard")
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

        ArrayList<String> wiNames = new ArrayList<String>();
        ArrayList<Integer> wiCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            wiNames.add(player.name.get());
            wiCaps.add(Integer.parseInt(player.cap.get()));
        }

        wiTeam = new Team(wiCaps, wiNames);
    }

    public static Team getWiTeam() {
        return wiTeam;
    }

    public static int getSelected() {
        return selected;
    }
}

