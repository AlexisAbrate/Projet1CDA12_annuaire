package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerLogin {
	
	
	@FXML
	private TextField tfLogin;

	@FXML
	private PasswordField tfMotPasse;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnAnnuler;
	
	
	public void login() throws IOException {
		String NomUtilisateur = tfLogin.getText();
		String MotPasse = tfMotPasse.getText();
		
		Alert message = new Alert(AlertType.INFORMATION);
		if(NomUtilisateur.equals("admin") && MotPasse.equals("1234")) {
			message.setContentText("Bienvenue " + NomUtilisateur);
			message.setTitle("Bienvenue");
			message.showAndWait();
			btnLogin.getScene().getWindow().hide();
			Parent root = FXMLLoader.load(getClass().getResource("/application/ApplicationAdmin.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Annuaire");
			stage.showAndWait();
		}
		else {
			message.setContentText("Nom d'utilisateur ou mot de passe est incorrect");
			message.setTitle("Un problème est survenu");
			message.showAndWait();
		}
		
		tfLogin.setText("");
		tfMotPasse.setText("");
	}
	
	public void fermerLogin(ActionEvent event) {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
	    stage.hide();
	    
	}

}

