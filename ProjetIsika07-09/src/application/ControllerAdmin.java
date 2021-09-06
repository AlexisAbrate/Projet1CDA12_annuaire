package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Code.Fichier;
import Code.Stagiaire;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerAdmin {


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
	private TextField tfRech;

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
	private CheckBox cbRecherche;

	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnModifier;

	@FXML
	private Button btnSuprimer;

	@FXML
	private Button btnRechercher;
	
	@FXML
	private Button btnRechercheLarge;

	@FXML
	private Button btnImprimer;
	
	@FXML
	private Button btnDeconnecter;
	
	@FXML
	private Button btnAfficher;
	
	@FXML
	private Button btn;
	
	
	@FXML
	public void choixContact() {
	tvStagiaire.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() >1 ) {
				onEdit();
			}
		});
	}
		
		
	
	public void onEdit() {
	    // check the table's selected item and get selected item
	    if (tvStagiaire.getSelectionModel().getSelectedItem() != null) {
	    	
	        Stagiaire selectedPerson = tvStagiaire.getSelectionModel().getSelectedItem();
	        System.out.println(selectedPerson);
	        tfNom.setText(selectedPerson.getNom());
	        String prenom = selectedPerson.getPrenom();
	        System.out.println(prenom);
	        tfPrenom.setText(prenom);
	        tfGenre.setText(selectedPerson.getGenre());
	        tfAge.setText(selectedPerson.getAge());
	        tfAdresse.setText(selectedPerson.getAdresse());
	        tfTel.setText(selectedPerson.getTel());
	        tfMail.setText(selectedPerson.getMail());
	        tfTheme.setText(selectedPerson.getFormation());
	        tfDebut.setText(selectedPerson.getDebutFormation());
	        tfDuree.setText(selectedPerson.getFinFormation());
	        
	    }
	}
	
	
	
	

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

	
	}
	
	@FXML
	private void deconnecteAdmin(ActionEvent event) throws IOException{
		Stage stage = (Stage) btnDeconnecter.getScene().getWindow();
		stage.close();	
		stage.onCloseRequestProperty().setValue(e -> Platform.exit());
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/ApiConnexion.fxml"));
		
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(btnDeconnecter.getScene().getWindow());
		primaryStage.show();
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

		
		@FXML
		
		private void AjouterEnregistrement() throws Exception, Throwable {
			
			ObservableList<Stagiaire> list = tvStagiaire.getItems(); //1 recuperation de la liste des contact deja presents
			System.out.println(list);
			Stagiaire stagiaire = new Stagiaire(tfPrenom.getText(),tfNom.getText(),tfGenre.getText(),tfAge.getText(),tfAdresse.getText(),tfMail.getText(),tfTel.getText(),tfTheme.getText(),tfDebut.getText(),tfDuree.getText());
			System.out.println(stagiaire.toString());
			
			if (stagiaire.getNom().equals("") || stagiaire.getPrenom().equals("") || stagiaire.getGenre().equals("") 
					|| stagiaire.getAge().equals("") || stagiaire.getAdresse().equals("") || stagiaire.getMail().equals("")  
					|| stagiaire.getTel().equals("") || stagiaire.getFormation().equals("") || stagiaire.getDebutFormation().equals("")
					|| stagiaire.getFinFormation().equals(""))   {
				Alert message = new Alert(AlertType.INFORMATION);
				message.setTitle("Attention");
				message.setHeaderText("Le stagiaire ne peut pas être ajouté");
				message.setContentText("Pour ajouter un nouveau stagiaire doit remplir tous les champs");
				message.showAndWait();
			}
			else {
				list.add(stagiaire); // 2 ajout du nouvel eelement dans la liste
				System.out.println("stagiaire ajouté");
				System.out.println(list);
				List<Stagiaire> listS = new ArrayList<>();
				listS.addAll(list);
				Fichier.serialisation(listS); // 3 mise a jour du fichier
				System.out.println("fin serialisation");
				initialize(); // reimportation de la liste mise à jour dans l'interface
				clear();
			}
		}

		private void UpdateEnregistrement() throws ClassNotFoundException, Exception, Throwable {
			
			 Stagiaire selectedPerson = tvStagiaire.getSelectionModel().getSelectedItem();
		     System.out.println(selectedPerson);    
		     
		     selectedPerson.setPrenom(tfPrenom.getText());
		     selectedPerson.setNom(tfNom.getText());
		     selectedPerson.setGenre(tfGenre.getText());
		     selectedPerson.setAge(tfAge.getText());
		     selectedPerson.setAdresse(tfAdresse.getText());
		     selectedPerson.setMail(tfMail.getText());
		     selectedPerson.setTel(tfTel.getText());
		     selectedPerson.setFormation(tfTheme.getText());
		     selectedPerson.setDebutFormation(tfDebut.getText());
		     selectedPerson.setFinFormation(tfDuree.getText());
		     
		     
		     ObservableList<Stagiaire> list = tvStagiaire.getItems();
		     List<Stagiaire> listS = new ArrayList<>();
		     listS.addAll(list);
			 Fichier.serialisation(listS);
		     clear();
		     initialize();
			
			

		}

		private void DeleteEnregistrement() throws Exception, Throwable {
			
			ObservableList<Stagiaire> list = tvStagiaire.getItems();
			Stagiaire temp = new Stagiaire(tfPrenom.getText(),tfNom.getText(),tfGenre.getText(),tfAge.getText(),tfAdresse.getText(),tfMail.getText(),tfTel.getText(),tfTheme.getText(),tfDebut.getText(),tfDuree.getText());
			List<Stagiaire> liste = new ArrayList<>();
			liste.addAll(list);
			System.out.println(temp);
			for (Stagiaire stagiaire : liste) {
				
				if((stagiaire.toString()).equals(temp.toString())) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer le contact" + stagiaire.toString());
				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					list.remove(stagiaire);
				}
					
				
			}
		
		
			}
			
			
			List<Stagiaire> listS = new ArrayList<>();
			listS.addAll(list);
			Fichier.serialisation(listS);
			clear();
		
		}
		
		
		private void clear() {
			
			tfNom.setText(null);
			tfPrenom.setText(null);
			tfGenre.setText(null);
			tfAdresse.setText(null);
			tfAge.setText(null);
			tfMail.setText(null);
			tfTel.setText(null);
			tfTheme.setText(null);
			tfDebut.setText(null);
			tfDuree.setText(null);
			
		
		}
		
//		@FXML
//		private void imprimerTable(){
//		
//		btnImprimer.setOnAction(new EventHandler<ActionEvent>() {
//	        public void handle(ActionEvent e){
//	            Printer printer = Printer.getDefaultPrinter();
//	            Stage dialogStage = new Stage(StageStyle.DECORATED);            
//	            PrinterJob job = PrinterJob.createPrinterJob(printer);
//	                if (job != null) {                    
//	                    boolean showDialog = job.showPageSetupDialog(dialogStage);
//	                    if (showDialog) {                        
//	                        tvStagiaire.setScaleX(0.60);
//	                        tvStagiaire.setScaleY(0.60);
//	                        tvStagiaire.setTranslateX(-220);
//	                        tvStagiaire.setTranslateY(-70);
//	                    boolean success = job.printPage(tvStagiaire);
//	                        if (success) {
//	                             job.endJob(); 
//	                        } 
//	                        tvStagiaire.setTranslateX(0);
//	                        tvStagiaire.setTranslateY(0);               
//	                        tvStagiaire.setScaleX(1.0);
//	                        tvStagiaire.setScaleY(1.0);                                              
//	                        System.out.println(tvStagiaire);
//	                    }    
//	                                }
//	        }});
//	    ContextMenu menu = new ContextMenu();
//	    menu.getItems().addAll();
//	    tvStagiaire.setContextMenu(menu);
//
//}
}

