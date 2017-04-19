package application;
	
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	private Music music;
	private static Main instance;
	private Dialog dialog;
	private Alert alert;
	private Alert alert2;
	public static Game x;
	@Override
	public void start(Stage primaryStage) {
		try {
			x = new Game();
			createDialogs();
			primaryStage.setTitle("Cowboy Bepbop");
			Parent root = FXMLLoader.load(getClass().getResource("/application/Scene1.fxml"));
			Scene scene = new Scene(root);
			music = new Music(getClass().getResource("/application/sounds/maintheme3.mp3"));
			music.play();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	public void createDialogs() {
		//dialog = new Dialog<Void>();
		//dialog.setTitle("About the game");
		//dialog.setContentText("test");
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About the game");
		alert.setHeaderText(null);
		alert.setContentText("Welcome to Cowboy Bebop text adventure game. "
				+ "You are an ex-sheriff who has come out of retirement due to new trouble brewing up in town."
				+ " You must find your way through this puzzle game and collect various items and perform certain"
				+ " tasks before taking on the Mafia gang who has taken over.");
		alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("Creators");
		alert2.setHeaderText(null);
		alert2.setContentText("Nick Tang, Colson Craig, Emily Ponson, Stefana Mason");
	}
	
	public Dialog getDialog() {
		return dialog;
	}
	
	public Alert getAlert() {
		return alert;
	}
	public Alert getAlertTwo() {
		return alert2;
	}
	public Music getMusic() {
		return music;
	}
	
	public Main() {
		instance = this;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
