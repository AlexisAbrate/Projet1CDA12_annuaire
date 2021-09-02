package application;

import Code.Arbre;
import Code.Noeud;
import Code.Stagiaire;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root=FXMLLoader.load(getClass().getResource("/application/ApplicationAdmin.fxml"));
			Scene scene = new Scene(root,800,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Annuaire");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
}
