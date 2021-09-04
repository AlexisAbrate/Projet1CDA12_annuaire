package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Code.Fichier;
import Code.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerUser {

	@FXML
	private TextField tfRech;

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
	private TableColumn<Stagiaire, String> colGenre;

	@FXML
	private TableColumn<Stagiaire, String> colAge;

	@FXML
	private TableColumn<Stagiaire, String> colTel;

	@FXML
	private CheckBox cbRecherche;

	@FXML
	private Button btnConnecter;

	@FXML
	private Button btnRechercher;

	@FXML
	private Button btnRechercheLarge;

	@FXML
	private Button btnImprimer;

	@FXML
	private Button btnAfficher;

	@FXML
	void initialize() throws Throwable, Exception, ClassNotFoundException, IOException {

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

		btnConnecter.setOnAction(event -> {
			final Node source = (Node) event.getSource();
			final Stage stage = (Stage) source.getScene().getWindow();
			stage.close();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/ApiConnexion.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage1 = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();

		});

	}

	@FXML
	public void itemStateChanged(ActionEvent event) {

		if (cbRecherche.isSelected()) {
			btnRechercher.setOnAction(actionEvent -> {

				ObservableList<Stagiaire> items = FXCollections.observableArrayList();
				try {
					items.addAll(chercherStagiaireLarge(tfRech.getText()));
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
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
			});

		}

		else {
			btnRechercher.setOnAction(actionEvent -> {

				ObservableList<Stagiaire> items = FXCollections.observableArrayList();
				try {
					items.addAll(chercherStagiaire(tfRech.getText()));
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
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
			});

		}

	}

	
	private static List<Stagiaire> chercherStagiaire(String rech) throws ClassNotFoundException, IOException {

		List<Stagiaire> triListe = new ArrayList<>();

		triListe.clear();
		Boolean result = false;

		System.out.println(rech);

		for (int i = 0; i < (Fichier.deserialisation().size()); i++) {

			Stagiaire stag = Fichier.deserialisation().get(i);
			result = stag.recherche(rech);

			if (result == true) {
				triListe.add(stag);
			}

			result = false;
		}

		System.out.println(triListe);
		return triListe;

	}

	
	private static List<Stagiaire> chercherStagiaireLarge(String rech) throws ClassNotFoundException, IOException {

		List<Stagiaire> triListe = new ArrayList<>();

		triListe.clear();
		Boolean result = false;

		System.out.println(rech);

		for (int i = 0; i < (Fichier.deserialisation().size()); i++) {

			Stagiaire stag = Fichier.deserialisation().get(i);
			result = stag.rechercheLarge(rech);

			if (result == true) {
				triListe.add(stag);
			}

			result = false;
		}

		System.out.println(triListe);
		return triListe;

	}
}