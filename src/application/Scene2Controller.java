package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Scene2Controller implements Initializable {
	@FXML
	private TextArea console;
	@FXML
	private Button soundBtn;
	@FXML
	private Button testBtn;
	@FXML 
	private TextField cmdArea;
	
	private static Scene2Controller instance;
	private String text;
	Parser parser;
	Game x;
	
	public Scene2Controller() {
		instance = this;
		parser = new Parser();
	}
	
	public String getText() {
		return text;
	}
	
	public static Scene2Controller getInstance() {
		return instance;
	}
	
	public TextField getTextField() {
		return cmdArea;
	}

	// Event Listener on Button[#soundBtn].onAction
	@FXML
	public void soundEvent(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#testBtn].onAction
	@FXML
	public void testEvent(ActionEvent event) {
		// TODO Autogenerated
		console.appendText("hello world!\n");
	}
	
	public void setOnKeyPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER) {
			text = cmdArea.getText();
			console.appendText(text+"\n");
			Command command = parser.getCommand(text);
			String results = Main.x.processCommand(command);
			console.appendText(results);
			if(results.equals("Goodbye!")) {
				Platform.exit();
			}
			//console.appendText(text+"\n"); tester, real one would send command
			cmdArea.setText("");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		console.setEditable(false);
		console.setWrapText(true);
		console.appendText(Main.x.printWelcome());
		console.appendText(Main.x.getRoomDesc());
	}

	
}