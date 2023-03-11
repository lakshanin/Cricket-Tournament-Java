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

public class NewZealand implements Initializable {

    private static Team nzTeam;
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
        TableView.setItems(nzPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected =1;
    }

    ObservableList<Player> nzPlayers = FXCollections.observableArrayList(
            new Player(1, "90",  "Rachin Ravindra"),
            new Player(2, "83",   "Hamish Bennett"),
            new Player(3, "74",  "Glenn Phillips"),
            new Player(4, "37",   "Martin Guptilll"),
            new Player(5, "30",  "Tim Southee"),
            new Player(6, "64",    "Ish Sodhi"),
            new Player(7, "59",  "James Neesham"),
            new Player(9, "51",   "Colin de Grandhomme"),
            new Player(8, "84",  "Devon Conway"),
            new Player(10, "80",  "Scott Kuggeleijin"),
            new Player(11, "70",  "Tom Bruce")
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

        ArrayList<String> nzNames = new ArrayList<String>();
        ArrayList<Integer> nzCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            nzNames.add(player.name.get());
            nzCaps.add(Integer.parseInt(player.cap.get()));
        }

        nzTeam = new Team(nzCaps, nzNames);
    }

    public static Team getNzTeam() {
        return nzTeam;
    }

    public static int getSelected() {
        return selected;
    }
}