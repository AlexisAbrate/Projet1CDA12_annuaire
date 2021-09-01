package Code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maintest {

	public static void main(String[] args) throws IOException {

		String nomDuFichier = "Fichiertxt/annuaire.txt";
		
		List<String> liste = new ArrayList<>();
		
		Arbre<String> monArbre = new Arbre<String>();
		Noeud<String> noeudRacine = new Noeud<String>("Monique");
		monArbre.racine = noeudRacine;
				
		liste = Fichier.initFichier(nomDuFichier);
		
		System.out.println(liste);
		
		for (String string : liste) {
			
			monArbre.ajouterValeur(string);
			
		}
		
		monArbre.supprimerValeur("Monique");
		
		
		monArbre.afficherArbre();
		System.out.println(noeudRacine.donnee);
		
		monArbre.equilibrage(noeudRacine);
		monArbre.afficherArbre();
		
		}

}
