package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Code.Arbre;
import Code.Fichier;
import Code.Noeud;
import Code.Stagiaire;
import javafx.application.Platform;
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
import javafx.stage.Modality;
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
		
		return triListe;

	}

	
	private static List<Stagiaire> chercherStagiaireLarge(String rech) throws ClassNotFoundException, IOException {

		List<Stagiaire> triListe = new ArrayList<>();

		triListe.clear();
		Boolean result = false;

		if (rech.contains(" ")) {
			String[] tabRech = rech.split(" ");
			List<String> listRech = Arrays.asList(tabRech);
		
		for (int i = 0; i < (Fichier.deserialisation().size()); i++) {
			Stagiaire stag = Fichier.deserialisation().get(i);
			
			for(int n=0; n<(listRech.size()); n++) {
				
				result = stag.rechercheLarge(listRech.get(n));
				
				if (result == true) {
					triListe.add(stag);
					result = false;
					break;
					}

				result = false;
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

@FXML
private void imprimerTable() {
	btnImprimer.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			Printer printer = Printer.getDefaultPrinter();
			PrinterJob job = PrinterJob.createPrinterJob();
			PageLayout pageLayout = job.getPrinter().createPageLayout(Paper.A4, PageOrientation.PORTRAIT,
					Printer.MarginType.DEFAULT);
			 Stage dialogStage = new Stage(StageStyle.DECORATED);
			job.getJobSettings().setPageLayout(pageLayout);
		double scaleX = pageLayout.getPrintableWidth() / tvStagiaire.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / tvStagiaire.getBoundsInParent().getHeight();
        tvStagiaire.getTransforms().add(new Scale(scaleX, scaleY));
			
			
			if (job != null) {
				boolean successPrintDialog = job.showPrintDialog(dialogStage.getOwner());
				if (successPrintDialog) {
					boolean success = job.printPage(pageLayout, tvStagiaire);
					if (success) {
						job.endJob();
					}
					
				}
			}
		}
	});
}
}