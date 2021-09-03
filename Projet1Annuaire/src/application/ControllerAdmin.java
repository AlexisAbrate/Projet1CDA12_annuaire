package application;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Code.Fichier;
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

public class ControllerAdmin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2370195552200756732L;

	@FXML
	private TextField tfNom;
	
	@FXML
	private TextField tfGenre;

	@FXML
	private TextField tfAge;
	
	@FXML
	private TextField tfTel;
	
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
	private TableColumn<Stagiaire, String> colGenre;
	
	@FXML
	private TableColumn<Stagiaire, String> colAge;
	
	@FXML
	private TableColumn<Stagiaire, String> colTel;

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
	private void handleButtonAction(ActionEvent event) throws Exception, Throwable {
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

	
	private void AjouterEnregistrement() throws Exception, Throwable {
		
		List<Stagiaire> list = tvStagiaire.getItems(); //1 recuperation de la liste des contact deja presents
		System.out.println(list);
		Stagiaire stagiaire = new Stagiaire(tfPrenom.getText(),tfNom.getText(),tfGenre.getText(),tfAge.getText(),tfAdresse.getText(),tfMail.getText(),tfTel.getText(),tfTheme.getText(),tfDebut.getText(),tfDuree.getText());
		System.out.println(stagiaire.toString());
		list.add(stagiaire); // 2 ajout du nouvel eelement dans la liste
		System.out.println(list.get(2));
		System.out.println(list);
		Fichier.serialisation(list);; // 3 mise a jour du fichier
		//initialize(); // reimportation de la liste mise à jour dans l'interface
		
	}

	private void UpdateEnregistrement() {

	}

	private void DeleteEnregistrement() {

	}

	@FXML
	public void initialize() throws Throwable, Exception {

		ObservableList<Stagiaire> items = FXCollections.observableArrayList();
		items.addAll(Fichier.deserialisation());
	
		tvStagiaire.setItems(items);
		colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		colGenre.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("genre"));
		colAge.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("age"));
		colAdresse.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("adresse"));
		colMail.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("mail"));
		colTel.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("tel"));
		colTheme.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("formation"));
		colDebut.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("debutFormation"));
		colDuree.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("finFormation"));

		
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