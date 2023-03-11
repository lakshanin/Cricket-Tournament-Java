package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML Button sl;
    @FXML Button ind;
    @FXML Button pak;
    @FXML Button wi;
    @FXML Button nz;
    @FXML Button eng;
    @FXML Button ban;
    @FXML Button aus;


    public void viewSlTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sri Lanka.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewAusTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Australia.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewEngTeam(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("England.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void viewBanTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bangladesh.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewIndTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("India.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewNzTeam(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("New Zealand.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewPakTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pakistan.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewWiTeam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("West Indies.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
