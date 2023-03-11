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

public class Bangladesh implements Initializable {

    private static Team banTeam;
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
        TableView.setItems(banPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> banPlayers = FXCollections.observableArrayList(
            new Player(1, "45",  "Mustafizur Rahman"),
            new Player(2, "44",   "Soumya Sarkar"),
            new Player(3, "43",  "Taskin Ahmed"),
            new Player(4, "46",   "Liton Das"),
            new Player(5, "56",  "Mohammad Saifuddin"),
            new Player(6, "67",   "Mohammad Naim"),
            new Player(7, "63",   "Mahedi Hasan"),
            new Player(9, "58",   "Afif Hossain"),
            new Player(8, "53",  "Mosaddek Hossain"),
            new Player(10, "23",  "Rubel Hossain"),
            new Player(11, "13",  "Mahmudullah")
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

        ArrayList<String> banNames = new ArrayList<String>();
        ArrayList<Integer> banCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            banNames.add(player.name.get());
            banCaps.add(Integer.parseInt(player.cap.get()));
        }
        banTeam = new Team(banCaps, banNames);
    }

    public static Team getBanTeam() {
        return banTeam;
    }

    public static int getSelected() {
        return selected;
    }
}

