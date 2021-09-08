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
	import javafx.event.EventHandler;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.print.PageLayout;
	import javafx.print.PageOrientation;
	import javafx.print.Paper;
	import javafx.print.Printer;
	import javafx.print.PrinterJob;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.transform.Scale;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	import javafx.stage.StageStyle;

	public class ControllerPrint {

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
		private Button btnImprimer;

		@FXML
		private Button btnAnnuler;
		
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


		}
		
		
		@FXML
		private void imprimerTable() {
			btnImprimer.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					Printer printer = Printer.getDefaultPrinter();
					PrinterJob job = PrinterJob.createPrinterJob();
					PageLayout pageLayout = job.getPrinter().createPageLayout(Paper.A4, PageOrientation.LANDSCAPE,
							Printer.MarginType.DEFAULT);
					 Stage dialogStage = new Stage(StageStyle.DECORATED);
					job.getJobSettings().setPageLayout(pageLayout);
//				double scaleX = pageLayout.getPrintableWidth() / tvStagiaire.getBoundsInParent().getWidth();
//	            double scaleY = pageLayout.getPrintableHeight() / tvStagiaire.getBoundsInParent().getHeight();
//	            tvStagiaire.getTransforms().add(new Scale(scaleX, scaleY));
					
					
					if (job != null) {
						boolean successPrintDialog = job.showPrintDialog(dialogStage.getOwner());
						if (successPrintDialog) {
							boolean success = job.printPage(pageLayout, tvStagiaire);
							if (success) {
								job.endJob();
								Stage stage = (Stage) btnImprimer.getScene().getWindow();
								stage.close();
							//	
//								stage.onCloseRequestProperty().setValue(e -> Platform.exit());

//								Parent root;
//								try {
//									root = FXMLLoader.load(getClass().getResource("/application/ApplicationUser.fxml"));
//									Scene scene = new Scene(root);
//									Stage primaryStage = new Stage();
//									primaryStage.setTitle("Annuaire");
//									primaryStage.setScene(scene);
//									primaryStage.initModality(Modality.WINDOW_MODAL);
//									primaryStage.initOwner(btnImprimer.getScene().getWindow());
//									primaryStage.show();
//								} catch (IOException e1) {
//									// TODO Bloc catch généré automatiquement
//									e1.printStackTrace();
//								}
							}
							
						}
					}
				}
			});
		
			
		}
		public void fermerPrint(ActionEvent event) {
			Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		    stage.hide();
		    
		    btnImprimer.setDefaultButton(true);
		    btnAnnuler.setCancelButton(true);
		}
		
	}
	
