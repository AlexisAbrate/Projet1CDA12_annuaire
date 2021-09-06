package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class bdd {
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws Exception, Throwable {
		System.out.println("test");

		if (event.getSource() == btnAjouter) {

			AjouterEnregistrement();
		}

		else if (event.getSource() == btnSuprimer) {

			DeleteEnregistrement();
		}

		else if (event.getSource() == btnSauvegarder) {
			
			sauvegarder();
		}
		else {
			UpdateEnregistrement();
		}
	}

	
	private void AjouterEnregistrement() throws Exception, Throwable {
		
		ObservableList<Stagiaire> list = tvStagiaire.getItems(); //1 recuperation de la liste des contact deja presents
		System.out.println(list);
		Stagiaire stagiaire = new Stagiaire(tfPrenom.getText(),tfNom.getText(),tfGenre.getText(),tfAge.getText(),tfAdresse.getText(),tfMail.getText(),tfTel.getText(),tfTheme.getText(),tfDebut.getText(),tfDuree.getText());
		System.out.println(stagiaire.toString());
		list.add(stagiaire); // 2 ajout du nouvel eelement dans la liste
		System.out.println("stagiaire ajouté");
		System.out.println(list);
		List<Stagiaire> listS = new ArrayList<>();
		listS.addAll(list);
		Fichier.serialisation(listS);; // 3 mise a jour du fichier
		System.out.println("fin serialisation");
		initialize(); // reimportation de la liste mise à jour dans l'interface
		
	}

	private void UpdateEnregistrement() {

	}

	private void DeleteEnregistrement() throws Exception, Throwable {
		
		ObservableList<Stagiaire> list = tvStagiaire.getItems(); //1 recuperation de la liste des contact deja presents
		
		List<Stagiaire> listS = new ArrayList<>();
		List<Stagiaire> choix = new ArrayList<Stagiaire>();
		List<Stagiaire> temp = new ArrayList<Stagiaire>();
		List<Stagiaire> temp2 = new ArrayList<Stagiaire>();
		
		
		
		
		choix.addAll(chercherStagiaire2(tfPrenom.getText(), tfNom.getText()));
		
//		if (tfPrenom != null && tfNom != null) {
//			temp.addAll(chercherStagiaire(tfPrenom.getText()));
//			
//			temp2.addAll(chercherStagiaire(tfNom.getText()));
//			
//			for (Stagiaire stagiaire : temp) {
//				
//				for(Stagiaire stagiaire2 : temp2) {
//			
//				 {
//					if ((stagiaire.toString()).equals(stagiaire2.toString())) 
//								choix.add(stagiaire2);
//					else;	
//				}
//			}	
//			}
//		}
		
//		else { Alert confirm = new Alert(AlertType.ERROR);
//		confirm.setTitle("Information");
//		confirm.setHeaderText("Suppression impossible");
//		confirm.setContentText("Il faut indiquer le prenom et nom pour effectuer une suppresion");
//		confirm.showAndWait();
//		}

//		System.out.println(choix);
//		
//		for (Stagiaire stagiaire : choix) {
//			
//			for(Stagiaire stagiaire2 : list) {
//		
//				System.out.println("Je suis dans la boucle");
//				if ((stagiaire.toString()).equals(stagiaire2.toString())) {
//					System.out.println(stagiaire.equals(stagiaire2));
//					Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer le contact" + stagiaire.toString());
//					Optional<ButtonType> result = alert.showAndWait();
//					if (result.isPresent() && result.get() == ButtonType.OK) {
//							list.remove(stagiaire2);
//							System.out.println(list);}
//				}
//		
//			
//		}	
//		
		
		
		for (Stagiaire stagiaire : choix) {
		
				System.out.println("Je suis dans la boucle");
					Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer le contact" + stagiaire.toString());
					Optional<ButtonType> result = alert.showAndWait();
					if (result.isPresent() && result.get() == ButtonType.OK) {
							list.remove(stagiaire);
							System.out.println(list);}
				}
		
			
			
		
		listS.addAll(list);
		System.out.println(listS);
		//Fichier.serialisation(listS);
		//initialize();
	}

}
