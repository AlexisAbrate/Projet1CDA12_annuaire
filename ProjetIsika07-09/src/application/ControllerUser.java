package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Code.Arbre;
import Code.Fichier;
import Code.Noeud;
import Code.Stagiaire;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	private Button btnImprimer;

	@FXML
	private Button btnAfficher;

	@FXML
	private Button btnParametre;
	
	@FXML
	private Button btnHelp;
	
	@FXML
	private CheckMenuItem cbPrenomAdmin;
	@FXML
	private CheckMenuItem cbNomAdmin;
	@FXML
	private CheckMenuItem cbGenreAdmin;
	@FXML
	private CheckMenuItem cbAgeAdmin;
	@FXML
	private CheckMenuItem cbAdresseAdmin;
	@FXML
	private CheckMenuItem cbMailAdmin;
	@FXML
	private CheckMenuItem cbTelAdmin;
	@FXML
	private CheckMenuItem cbThemeAdmin;
	@FXML
	private CheckMenuItem cbDebutAdmin;
	@FXML
	private CheckMenuItem cbFinAdmin;
	
	private int affichageColTb = 0;
	
	
	void affichageColTb() {
	
		if (affichageColTb == 0) {
			
			cbPrenomAdmin.setSelected(true);
			cbNomAdmin.setSelected(true);
			cbGenreAdmin.setSelected(true);
			cbAgeAdmin.setSelected(true);
			cbAdresseAdmin.setSelected(true);
			cbMailAdmin.setSelected(true);
			cbTelAdmin.setSelected(true);
			cbThemeAdmin.setSelected(true);
			cbDebutAdmin.setSelected(true);
			cbFinAdmin.setSelected(true);
			
			colPrenom.setVisible(true);
			colNom.setVisible(true);
			colGenre.setVisible(true);
			colAge.setVisible(true);
			colAdresse.setVisible(true);
			colMail.setVisible(true);
			colTel.setVisible(true);
			colTheme.setVisible(true);
			colDebut.setVisible(true);
			colDuree.setVisible(true);
			
			affichageColTb++;
		}
	}
	
	@FXML
	private void cbParametreAdmin(ActionEvent event) throws Exception, Throwable {
		System.out.println("cbParametreAdmin");

//		colDebut.getPrefWidth();
		
		if (cbPrenomAdmin.isSelected()) {
			colPrenom.setVisible(true);
		}
		
		else if (!cbPrenomAdmin.isSelected()) {
			colPrenom.setVisible(false);
		}

		if (cbNomAdmin.isSelected()) {
			colNom.setVisible(true);
		}
		
		else if (!cbNomAdmin.isSelected()) {
			colNom.setVisible(false);
		}

		if (cbGenreAdmin.isSelected()) {
			colGenre.setVisible(true);
		}
		
		else if (!cbGenreAdmin.isSelected()) {
			colGenre.setVisible(false);
		}
		
		if (cbAgeAdmin.isSelected()) {
			colAge.setVisible(true);
		}
		
		else if (!cbAgeAdmin.isSelected()) {
			colAge.setVisible(false);
		}
		
		if (cbAdresseAdmin.isSelected()) {
			colAdresse.setVisible(true);
		}
		
		else if (!cbAdresseAdmin.isSelected()) {
			colAdresse.setVisible(false);
		}
		
		if (cbMailAdmin.isSelected()) {
			colMail.setVisible(true);
		}
		
		else if (!cbMailAdmin.isSelected()) {
			colMail.setVisible(false);
		}
		
		if (cbTelAdmin.isSelected()) {
			colTel.setVisible(true);
		}
		
		else if (!cbTelAdmin.isSelected()) {
			colTel.setVisible(false);
		}
		
		if (cbThemeAdmin.isSelected()) {
			colTheme.setVisible(true);
		}
		
		else if (!cbThemeAdmin.isSelected()) {
			colTheme.setVisible(false);
		}
		
		if (cbDebutAdmin.isSelected()) {
			colDebut.setVisible(true);
		}
		
		else if (!cbDebutAdmin.isSelected()) {
			colDebut.setVisible(false);
		}
		
		if (cbFinAdmin.isSelected()) {
			colDuree.setVisible(true);
		}
		
		else if (!cbFinAdmin.isSelected()) {
			colDuree.setVisible(false);
		}
	}
	
	@FXML
	public void keyContact(KeyEvent evt) {
		System.out.println("key event detected");
		
		if (cbRecherche.isSelected()) {
		itemStateChanged();
		}	
	}
	
	public static String upperCaseFirst(String val) {
		char[] arr = val.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
	}
	
	public void formatageStagiaire(Stagiaire ancienS) {
		
		//Stagiaire newStag = new Stagiaire("","",genre,age,adresse,mail,tel,formation,debutFormation,finFormation);
		
		ancienS.setPrenom(upperCaseFirst(ancienS.getPrenom().toLowerCase()));
		
		ancienS.setNom(ancienS.getNom().toUpperCase());
		
	}
	
	void actualiserTableView(ObservableList<Stagiaire> items) {
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
	}
	
	@FXML
	void initialize() throws Throwable, Exception, ClassNotFoundException, IOException {

		ObservableList<Stagiaire> items = FXCollections.observableArrayList();
		items.addAll(Fichier.deserialisation());

		for (int i = 0; i < items.size(); i++) {
		      formatageStagiaire(items.get(i));
		    }
		
		Collections.sort(items, Stagiaire.ComparatorPrenom);
		
		affichageColTb();
		
		actualiserTableView(items);

		btnRechercher.setDefaultButton(true);
		btnConnecter.setCancelButton(true);
		

	}

	@FXML
	private void connexionUser(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnConnecter.getScene().getWindow();
		stage.close();
//		
		stage.onCloseRequestProperty().setValue(e -> Platform.exit());

		Parent root = FXMLLoader.load(getClass().getResource("/application/ApiConnexion.fxml"));

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(btnConnecter.getScene().getWindow());
		primaryStage.show();
	}

	@FXML
	private void handleButtonAction(ActionEvent event) throws Exception, Throwable {
		System.out.println("test");

		if  (event.getSource() == btnRechercher) {
			itemStateChanged();
		}
		
		else if (event.getSource() == btnAfficher) {
			tfRech.clear();
			initialize();
		}
		else if (event.getSource() == btnHelp) {
			afficherPdf();
		}
		
	}
	
	@FXML
	public void itemStateChanged() {

		if (cbRecherche.isSelected()) {
		
			System.out.println("case selectionnée");
			
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
				actualiserTableView(items);

		}

		else {
			
			System.out.println("case non selectionné");

				ObservableList<Stagiaire> items = FXCollections.observableArrayList();
				String rech = tfRech.getText();
				
				System.out.println(!rech.contains(" "));
				
				if (!rech.contains(" ") ) {
					
					System.out.println("1 seul mot");
					
					try {
						items.addAll(rechercheArbre(rech));
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					actualiserTableView(items);
					
					System.out.println("arbre de recherche lancé");
					
					if (items.isEmpty()) {
						
						System.out.println("Pas de correspondance avec recherche dans l'arbre : on passe à la recherche dans toute la liste");
						
						try {
							items.addAll(chercherStagiaire(tfRech.getText()));
						} catch (ClassNotFoundException e) {
							// TODO Bloc catch généré automatiquement
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Bloc catch généré automatiquement
							e.printStackTrace();
						}
						actualiserTableView(items);
						
					}

				}
				
				else {
					System.out.println("plusieurs mots");
					
				try {
					items.addAll(chercherStagiaire(tfRech.getText()));
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				actualiserTableView(items);
				
				}

		}

	}

	private static List<Stagiaire> chercherStagiaire(String rech) throws ClassNotFoundException, IOException {

		List<Stagiaire> triListe = new ArrayList<>();

		triListe.clear();
		Boolean result = false;

		//System.out.println(rech);

		if (rech.contains(" ")) {
			String[] tabRech = rech.split(" ");
			List<String> listRech = Arrays.asList(tabRech);
		
			System.out.println("taille liste : " + (listRech.size()-1));
			
		for (int i = 0; i < (Fichier.deserialisation().size()); i++) {
			Stagiaire stag = Fichier.deserialisation().get(i);
			int compteur = 0;
			
			for(int n=0; n<(listRech.size()); n++) {
				
				result = stag.recherche(listRech.get(n));
				
				if (result == true) {
					compteur++;
					result = false;
					System.out.println("compteur" + compteur);
				}
				
				if (compteur == listRech.size()) {
					System.out.println("Entrée dans la boucle condition conmpteur validé");

					triListe.add(stag);
				}
					
					
			}
			
		}

	}
		
		else {
			for (int i = 0; i < (Fichier.deserialisation().size()); i++) {

				Stagiaire stag = Fichier.deserialisation().get(i);
				result = stag.recherche(rech);

				if (result == true) {
					triListe.add(stag);
				}

				result = false;
			}
				
		}
		//System.out.println(triListe);
		return triListe;
	}

	
	
	private static List<Stagiaire> chercherStagiaireLarge(String rech) throws ClassNotFoundException, IOException {

		List<Stagiaire> triListe = new ArrayList<>();

		triListe.clear();
		Boolean result = false;

		//System.out.println(rech);

		if (rech.contains(" ")) {
			String[] tabRech = rech.split(" ");
			List<String> listRech = Arrays.asList(tabRech);
		
		for (int i = 0; i < (Fichier.deserialisation().size()); i++) {
			Stagiaire stag = Fichier.deserialisation().get(i);
			int compteur = 0;
			
			for(int n=0; n<(listRech.size()); n++) {
				
				result = stag.rechercheLarge(listRech.get(n));
				
				if (result == true) {
					compteur++;
					result = false;
					
					}
				
				if (compteur == listRech.size()) {
					System.out.println("Entrée dans la boucle condition conmpteur validé");

					triListe.add(stag);

				}
			
			}

		}
	}
		
		else {
			for (int i = 0; i < (Fichier.deserialisation().size()); i++) {

				Stagiaire stag = Fichier.deserialisation().get(i);
				result = stag.rechercheLarge(rech);

				if (result == true) {
					triListe.add(stag);
				}

				result = false;
			}
				
		}
		
		return triListe;

	}
	
private static List<Stagiaire> rechercheArbre(String rech) throws ClassNotFoundException, IOException {
		
	Arbre<Stagiaire> monArbre = new Arbre<Stagiaire>();
	Stagiaire pere = new Stagiaire("Pere","Korat","M","48","84 Rue Sergent Bichot - Paris","selim.k@gmail.com","0688132325","C#","07/02/2019","02/12/2022");
	Noeud<Stagiaire> n1 = new Noeud<Stagiaire>(pere);	
	monArbre.racine = n1;
	List<Stagiaire> liste = Fichier.deserialisation();
			
	for (Stagiaire stagiaire : liste) {
		monArbre.ajouterValeurEquilibre(stagiaire);
	}

	monArbre.supprimerValeur(pere);
	
		Stagiaire stagTemp = new Stagiaire(rech,"Nom","Genre","Age","Adresse","mail","tel","Formation","Debut","Fin");
		return monArbre.rechercher_liste(stagTemp);
   	
}




public void imprimeTable(ActionEvent event) throws IOException {
	Stage stage = (Stage) btnImprimer.getScene().getWindow();
//	stage.close();
////	
//	stage.onCloseRequestProperty().setValue(e -> Platform.exit());

	Parent root = FXMLLoader.load(getClass().getResource("/application/ApplicationPrint.fxml"));

	Scene scene = new Scene(root);
	Stage primaryStage = new Stage();
	primaryStage.setTitle("Liste des stagiaires");
	primaryStage.setScene(scene);
	primaryStage.initModality(Modality.WINDOW_MODAL);
	primaryStage.initOwner(btnImprimer.getScene().getWindow());
	primaryStage.show();
}

private void afficherPdf() throws Exception {
	
	
	if (Desktop.isDesktopSupported()) {
		try {
		File theUMFile = new File("FichierTxt/nu.pdf");
		 Desktop.getDesktop().open(theUMFile);
		}
		catch (FileNotFoundException fnf){
	
		}
		catch (IllegalArgumentException fnf) {
		
		        }
		        catch (IOException ex) {
		           
		        }
	}
		    
}

}