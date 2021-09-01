package application;
	
import java.util.ArrayList;
import java.util.List;

import Code.Arbre;
import Code.Noeud;
import Code.Stagiaire;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main<E> extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1120,630);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
	
		
		Stagiaire stagiaire1 = new Stagiaire("Simon");
		Stagiaire stagiaire2 = new Stagiaire("Alexis");
		Stagiaire stagiaire3 = new Stagiaire("Evgeniia");
		Stagiaire stagiaire4 = new Stagiaire("Anthony");
		Stagiaire stagiaire5 = new Stagiaire("Bruno");
		Stagiaire stagiaire6 = new Stagiaire("Naziha");
		Stagiaire stagiaire7 = new Stagiaire("Cécile");
		Stagiaire stagiaire8 = new Stagiaire("Ines");
		Stagiaire stagiaire9 = new Stagiaire("Valentin");
		Stagiaire stagiaire10 = new Stagiaire("Cheyma");
		Stagiaire stagiaire11 = new Stagiaire("Philippe");
		Stagiaire stagiaire12 = new Stagiaire("Tania");
	
		List<Stagiaire> stagiaire = new ArrayList<>();
		

				stagiaire.add(stagiaire1);
				stagiaire.add(stagiaire2);
				stagiaire.add(stagiaire3);
				stagiaire.add(stagiaire4);
				stagiaire.add(stagiaire5);
				stagiaire.add(stagiaire6);
				stagiaire.add(stagiaire7);
				stagiaire.add(stagiaire8);
				stagiaire.add(stagiaire9);
				stagiaire.add(stagiaire10);
				stagiaire.add(stagiaire11);
				stagiaire.add(stagiaire12);
	
	
		System.out.println(stagiaire);
		
		Arbre<String> monArbre = new Arbre<String>();
		monArbre.racine = new Noeud<String>("Pere");
		
		for(int i=0; i<stagiaire.size(); i++) {
			  System.out.println(stagiaire.get(i));
			  
			  monArbre.ajouterValeur((stagiaire.get(i)).getPrenom());
		}
          
		
	//	for
		
		
		
		Noeud<String> noeudBlanche = new Noeud<String>(stagiaire1.getPrenom());
		Noeud<String> noeudDavid = new Noeud<String>("David");
		Noeud<String> noeudCaro = new Noeud<String>("Caro",noeudBlanche,noeudDavid);	
		
		Noeud<String> noeudXavier = new Noeud<String>("Xavier", new Noeud<String>("Stefanie"), new Noeud<String>("Zorglub"));
		
		//monArbre.affichagePrefixe();
		
		monArbre.afficherArbre();
		monArbre.supprimerValeur("Pere");
		monArbre.afficherArbre();
		
		monArbre.ajouterValeur("Arnold");
		monArbre.ajouterValeur("Tania");
		monArbre.ajouterValeur("Xavier");
		monArbre.afficherArbre();
	}

}
