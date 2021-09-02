package application;

import Code.Stagiaire;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

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
	}

}
//
//public void afficherStagiaire()
//{
//	try {
//		
//	
//		ObservableList<Stagiaire> list = getStagiaire();
//		
//		colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
//		colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
//		tvStagiaire.getItems().clear();
//		tvStagiaire.getItems().addAll(list);
//		
//		
//		
//	}
//	catch (Exception e) {
//		System.err.println("Error" + e);
//		
//	}
//}
//ObservableList<Stagiaire>list = FXCollections.observableArrayList(
//		
//		
//		new Stagiaire("dfdfg","dfsfs"),
//		new Stagiaire("ggggg","uuuuuuu")
//		);
//
//public void initialize(URL url, ResourceBundle resources) {
//	
//	colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("colNom"));
//	colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
//	tvStagiaire.getItems().addAll(list);
//}
//

//
//public void afficherStagiaire()
//
//{
//	try {
//	ObservableList<Stagiaire> list= FXCollections.observableArrayList();	
//	//tvStagaire.getItems().add(list);
//	//String nomDuFichier = "Fichiertxt/annuaire.txt";
//	//List<String> liste = new ArrayList<>();
//	//liste = Fichier.initFichier(nomDuFichier);
//
//	colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Nom"));
//	colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Prenom"));
////	colNom.setSortType(TableColumn.SortType.DESCENDING);
////	colPrenom.setSortable(false);
//	
//     table.setItems(list);
//     
//     table.getColumns().addAll(colNom, colPrenom);
//	
//
//}
//	catch (Exception e) {
//		System.err.println("Error" + e);
//	
//}
// tvStagaire.getItems().add(list);}
