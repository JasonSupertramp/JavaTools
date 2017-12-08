package controller;

import java.io.IOException;

import com.sun.javafx.robot.impl.FXRobotHelper;

import application.CheckLogin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
/*
 * 每个FXML只有一个控制器，用于响应页面的各种事件
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Button loginButton;
	@FXML
	private Button registerButton;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField userNameField;
	@FXML
	private Button cancelButton;
	@FXML
	private Button resetButton;
	@FXML
	private AnchorPane loginScene;
	@FXML
	private Button exitButton;

	@FXML
	public void loginButtonClick(ActionEvent event) throws IOException {
		if (CheckLogin.isLogin(userNameField.getText(), passwordField.getText())) {
			ObservableList<Stage> stage = FXRobotHelper.getStages();
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainScene.fxml")));
			stage.get(0).setScene(scene);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("登录失败");
			alert.setHeaderText("登录失败");
			alert.setContentText("账号或密码错误");
			alert.show();
		}
	}

	@FXML
	public void registerButtonClick(ActionEvent event) throws IOException {
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterScene.fxml")));
		stage.get(0).setScene(scene);
	}

	@FXML
	public void resetButtonClick(ActionEvent event) {
		userNameField.setText("");
		passwordField.setText("");
		userNameField.requestFocus();
	}

	@FXML
	public void exitButtonClick(ActionEvent event) {
		Stage stage = (Stage) exitButton.getScene().getWindow();
		stage.close();
	}
}
