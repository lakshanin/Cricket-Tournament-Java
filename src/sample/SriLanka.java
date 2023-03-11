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

public class SriLanka implements Initializable {

    private static Team slTeam;
    private static int selected = 0;
    @FXML
    private TableView<Player> tableView;
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
        tableView.setItems(slPlayers);

        tableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> slPlayers = FXCollections.observableArrayList(
            new Player(1, "58",  "Dasun Shanaka"),
            new Player(2, "79",  "Avishka Fernando"),
            new Player(3, "80",  "Wanidu Hasaranga"),
            new Player(4, "59",   "Dushmantha  Chameera"),
            new Player(5, "87",  "Charith Asalanka"),
            new Player(6, "60",  "Danushka Gunathilaka"),
            new Player(7, "88",  "Chamika Karunaratne"),
            new Player(9, "78",   "Lahiru Kumara"),
            new Player(8, "90",  "Maheesh Theekshana"),
            new Player(10, "70",  "Bhanuka Rajapaksa"),
            new Player(11, "83",  "Dhananjaya de Silva")
    );

    public void editCap(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent) {
        Player player = tableView.getSelectionModel().getSelectedItem();
        player.setCap(playerStringCellEditEvent.getNewValue());
    }

    public void editName(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent) {
        Player player = tableView.getSelectionModel().getSelectedItem();
        player.setName(playerStringCellEditEvent.getNewValue());
    }

    public void Toss(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Toss.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Player player = new Player();

        ArrayList<String> slNames = new ArrayList<String>();
        ArrayList<Integer> slCaps = new ArrayList<Integer>();

        for (int i=0; i<tableView.getItems().size(); i++){
            player = tableView.getItems().get(i);
            slNames.add(player.name.get());
            slCaps.add(Integer.parseInt(player.cap.get()));
        }
        slTeam = new Team(slCaps, slNames);

    }

    public static Team getSlTeam() {
        return slTeam;
    }

    public static int getSelected() {
        return selected;
    }
}

