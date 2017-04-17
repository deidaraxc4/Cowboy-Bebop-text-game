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
	public static Game x;
	@Override
	public void start(Stage primaryStage) {
		try {
			x = new Game();
			primaryStage.setTitle("Cowboy Bepbop");
			Parent root = FXMLLoader.load(getClass().getResource("/application/Scene1.fxml"));
			Scene scene = new Scene(root);
			music = new Music(getClass().getResource("/application/sounds/maintheme.mp3"));
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
		dialog = new Dialog<Void>();
		dialog.setTitle("About the game");
		dialog.setContentText("test");
	}
	
	public Dialog getDialog() {
		return dialog;
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
