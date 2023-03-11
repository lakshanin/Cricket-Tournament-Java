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

public class India implements Initializable {

    private static Team indTeam;
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
        TableView.setItems(inPlayers);

        TableView.setEditable(true);
        capCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        selected = 1;
    }

    ObservableList<Player> inPlayers = FXCollections.observableArrayList(
            new Player(1, "31",  "Virat Kohli"),
            new Player(2, "45",   "Bhuvneshwar"),
            new Player(3, "60",  "Yuzvendra Chahal"),
            new Player(4, "68",   "Rishabh Pant"),
            new Player(5, "36",  "Shikhar Dhawan"),
            new Player(6, "57",   "Jasprit Bumrah"),
            new Player(7, "73",   "Shardul Thakur"),
            new Player(9, "30",   "Ravichandran Ashwin"),
            new Player(8, "58",  "Hardik Pandya"),
            new Player(10, "70",  "Shreyas Iyer"),
            new Player(11, "82",  "Shivam Dube")
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

        ArrayList<String> indNames = new ArrayList<String>();
        ArrayList<Integer> indCaps = new ArrayList<Integer>();

        for (int i=0; i<TableView.getItems().size(); i++){
            player = TableView.getItems().get(i);
            indNames.add(player.name.get());
            indCaps.add(Integer.parseInt(player.cap.get()));
        }

        indTeam = new Team(indCaps, indNames);
    }

    public static Team getIndTeam() {
        return indTeam;
    }

    public static int getSelected() {
        return selected;
    }
}

