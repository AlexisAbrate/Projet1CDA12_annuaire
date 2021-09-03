package application;

import java.io.IOException;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
		void initialize() {
			
			///
			btnAdmin.setOnAction(event -> {
				//btnAdmin.getScene().getWindow().hide();
				
				
				//En cliquant sur le bouton,Administrateur la fenêtre Login s'ouvre
				
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/Login.fxml"));
				try {
					loader.load();
				} catch (IOException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				
				Parent root = loader.getRoot();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setResizable(false);
				stage.setTitle("Login");
				stage.showAndWait();
				
				
			});
			
			//En cliquant sur le bouton,Invite la fenêtre pour utilisateur s'ouvre
			
			btnInvite.setOnAction(event -> {
				btnInvite.getScene().getWindow().hide();
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/ApplicationUser.fxml"));
				try {
					loader.load();
				} catch (IOException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				
				Parent root = loader.getRoot();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Annuaire");
				stage.showAndWait();
				
				
			});
			
		}

		

		
}
