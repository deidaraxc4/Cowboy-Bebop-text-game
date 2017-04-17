package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene1Controller implements Initializable{
	@FXML
	private AnchorPane anchor;
	@FXML
	private Button playBtn;
	@FXML
	private Label titleLabel;
	@FXML
	private Button aboutBtn;
	@FXML
	private Button creatorBtn;
	@FXML
	private Button soundBtn;
	
	Stage prevStage;
	private static Scene1Controller instance;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public Scene1Controller() {
		instance = this;
	}
	
	public void setPrevStage(Stage stage) {
		this.prevStage = stage;
	}
	
	public static Scene1Controller getInstance() {
		return instance;
	}
	
	@FXML
	public void playEvent(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/Scene2.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		stage.setScene(scene);
		stage.show();
		Main.getInstance().getMusic().stop();
	}
	
	@FXML
	public void aboutEvent(ActionEvent event) {
		//Main.getInstance().getDialog().show();
	}
	
	@FXML
	public void creatorEvent(ActionEvent event) {
		
	}
	@FXML
	public void soundEvent(ActionEvent event) {
		if(Main.getInstance().getMusic().getStatus()==true) {
			Main.getInstance().getMusic().pause();
		} else {
			Main.getInstance().getMusic().play();
		}
		
	}
	

}
