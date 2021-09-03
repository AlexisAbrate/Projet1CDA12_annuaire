package application;

import java.io.IOException;

import Code.Stagiaire;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerAdmin {

	@FXML
	private TextField tfNom;

	@FXML
	private TextField tfPrenom;

	@FXML
	private TextField tfAdresse;

	@FXML
	private TextField tfMail;

	@FXML
	private TextField tfTheme;

	@FXML
	private TextField tfDebut;

	@FXML
	private TextField tfDuree;

	@FXML
	private TextField tfRecherche;

	@FXML
	private TableView<Stagiaire> tvStagiaire;

	@FXML
	private TableColumn<Stagiaire, String> colNom;

	@FXML
	private TableColumn<Stagiaire, String> colPrenom;

	@FXML
	private TableColumn<Stagiaire, String> colAdresse;

	@FXML
	private TableColumn<Stagiaire, String> colMail;

	@FXML
	private TableColumn<Stagiaire, String> colTheme;

	@FXML
	private TableColumn<Stagiaire, String> colDebut;

	@FXML
	private TableColumn<Stagiaire, String> colDuree;

	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnModifier;

	@FXML
	private Button btnSuprimer;

	@FXML
	private Button btnRechercher;

	@FXML
	private Button btnImprimer;
	
	@FXML
	private Button btnDeconnecter;
	
	

	@FXML
	private void handleButtonAction(ActionEvent event) {
		System.out.println("test");

		if (event.getSource() == btnAjouter) {

			AjouterEnregistrement();
		}

		else if (event.getSource() == btnSuprimer) {

			DeleteEnregistrement();
		}

		else {
			UpdateEnregistrement();
		}
	}

	private void AjouterEnregistrement() {

	}

	private void UpdateEnregistrement() {

	}

	private void DeleteEnregistrement() {

	}

	@FXML
	public void initialize() {

		ObservableList<Stagiaire> items = FXCollections.observableArrayList();
		items.add(new Stagiaire("bob", "fdfdff"));
		items.add(new Stagiaire("dfgfd", "zzzzz"));
		items.add(new Stagiaire("aaaaaaaaa", "rrrrrrr"));
		tvStagiaire.setItems(items);
		colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		
		
		btnDeconnecter.setOnAction(event -> {
			btnDeconnecter.getScene().getWindow().hide();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/ApiConnexion.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
			
			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
		});
	}

}
