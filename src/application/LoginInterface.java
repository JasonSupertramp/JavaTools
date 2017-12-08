package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginInterface extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		//primaryStage.getIcons().add(new Image(new FileInputStream("E:\\JavaProject\\JavaTools\\src\\resources\\logo.png")));
		primaryStage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("resources/logo.png")));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
