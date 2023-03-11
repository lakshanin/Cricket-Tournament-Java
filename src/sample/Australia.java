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

public class Australia implements Initializable {

    private static  Team ausTeam;
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
        TableView.setItems(ausPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> ausPlayers = FXCollections.observableArrayList(
            new Player(1, "53",  "Matthew Wade"),
            new Player(2, "59",   "Mitchell Starc"),
            new Player(3, "58",  "Glenn Maxwell"),
            new Player(4, "61",   "Nathan Coulter-Nile"),
            new Player(5, "85",  "Billy Stanlake"),
            new Player(6, "74",   "Marcus Stoinis"),
            new Player(7, "90",  "D'Arcy Short"),
            new Player(9, "32",   "David Warner"),
            new Player(8, "43",  "Steve Smith"),
            new Player(10, "75",  "Travis Head"),
            new Player(11, "51",  "Pat Cummins")
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

        ArrayList<String> ausNames = new ArrayList<String>();
        ArrayList<Integer> ausCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            ausNames.add(player.name.get());
            ausCaps.add(Integer.parseInt(player.cap.get()));
        }

        ausTeam = new Team(ausCaps, ausNames);
    }

    public static Team getAusTeam() {
        return ausTeam;
    }

    public static int getSelected() {
        return selected;
    }
}
