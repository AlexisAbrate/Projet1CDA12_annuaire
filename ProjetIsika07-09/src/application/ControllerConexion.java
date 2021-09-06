package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ControllerConexion {
	

		@FXML
		private TextField tfMail;

		@FXML
		private TextField tfMotPasse;

		

		@FXML
		private Button btnInvite;

		@FXML
		private Button btnAdmin;
		
		@FXML
		private void connexionAdmin(ActionEvent event) throws IOException{
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(btnAdmin.getScene().getWindow());
			primaryStage.show();
		}
		
		@FXML
		private void connexionUser(ActionEvent event) throws IOException{
			Stage stage = (Stage) btnInvite.getScene().getWindow();
			stage.close();
//			
			stage.onCloseRequestProperty().setValue(e -> Platform.exit());
			Parent root = FXMLLoader.load(getClass().getResource("/application/ApplicationUser.fxml"));
			
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Annuaire");
			primaryStage.setScene(scene);
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(btnInvite.getScene().getWindow());
			primaryStage.show();
		}
		
}