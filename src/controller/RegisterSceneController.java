package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Pattern;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterSceneController {

	@FXML
	private TextField registerUserName;
	@FXML
	private TextField registerPassword;
	@FXML
	private PasswordField registerPasswordRepeat;

	@FXML
	private Button registerButton2;
	@FXML
	private Button cancelButton2;
	@FXML
	private Button resetButton2;

	@FXML
	public void resetButtonPress(ActionEvent event) {
		registerUserName.setText("");
		registerPassword.setText("");
		registerPasswordRepeat.setText("");
	}

	@FXML
	public void cancelButtonPress(ActionEvent event) throws IOException {
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml")));
		stage.get(0).setScene(scene);
	}

	@FXML
	public void registerButtonPress(ActionEvent event) throws IOException {
		registerVerify();
	}

	public void registerVerify() throws IOException {
		if (Pattern.matches("^[a-zA-Z]{6,16}$", registerUserName.getText())
				& Pattern.matches("^(?![a-zA-Z]+$)(?![0-9]+$)[a-zA-Z_0-9]{6,16}$", registerPassword.getText())
				& registerPassword.getText().equals(registerPasswordRepeat.getText())) {
			Properties prop = new Properties();
			FileReader fr = new FileReader("src/resources/user.txt");
			//InputStream fr=this.getClass().getClassLoader().getResourceAsStream("src/resources/user.txt");
			prop.load(fr);
			if (prop.getProperty(registerUserName.getText()) == null) {
				prop.setProperty(registerUserName.getText(), registerPassword.getText());
				FileWriter fw = new FileWriter("src/resources/user.txt", true);	
				prop.store(fw, null);
				Alert alert = new Alert(AlertType.CONFIRMATION, "�Ƿ�Ҫ��ת��½���棿");
				alert.setTitle("ע��ɹ�");
				alert.setHeaderText("ע��ɹ�");
				// Caused by: java.lang.IllegalStateException: Stage already visible
				// alert.show();
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					ObservableList<Stage> stage = FXRobotHelper.getStages();
					Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml")));
					stage.get(0).setScene(scene);
				}
			} else {
				Alert alert2 = new Alert(AlertType.CONFIRMATION, "�˺��Ѵ��ڣ��Ƿ���ת��½��");
				alert2.setTitle("�˺��Ѵ���");
				alert2.setHeaderText("�˺��Ѵ���");
				Optional<ButtonType> result2 = alert2.showAndWait();
				if (result2.get() == ButtonType.OK) {
					ObservableList<Stage> stage = FXRobotHelper.getStages();
					Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml")));
					stage.get(0).setScene(scene);
				}
			}
		} else {
			Alert alert3 = new Alert(AlertType.ERROR, "�˺Ż���������������ע��");
			alert3.setTitle("ע��ʧ��");
			alert3.setHeaderText("ע��ʧ��");
			alert3.show();
		}
	}
}
