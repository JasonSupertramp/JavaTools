package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainSceneController {

	@FXML
	MenuItem aboutItem;
	@FXML
	MenuBar menuBar;
	@FXML
	MenuItem closeMenuItem;
	@FXML
	MenuItem closeMenuItem1;
	@FXML
	MenuItem logoffMenuItem;

	@FXML
	public void aboutItemClick(ActionEvent event) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.INFORMATION, "    这是一个小Demo");
		alert.setTitle("关于");
		// alert.setGraphic(new ImageView(new Image(new
		// FileInputStream("./src/resources/logo.png"))));
		alert.setGraphic(
				new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/logo.png"))));
		alert.setHeaderText("     Author:" + " Jason" + "\n\r" + "     Version: 1.0");
		alert.show();
	}

	@FXML
	public void closeMenuItemClick(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void logoffMenuItemClick(ActionEvent event) throws IOException {
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml")));
		stage.get(0).setScene(scene);
	}

}
