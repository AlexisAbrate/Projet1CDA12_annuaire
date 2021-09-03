package Code;

import java.io.IOException;
import java.util.List;


public class Maintest4 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ArbreTest<Stagiaire> monArbre1 = new ArbreTest<Stagiaire>();
		
		Stagiaire Selim = new Stagiaire("Selim","Korat","M","48","84 Rue Sergent Bichot - Paris","selim.k@gmail.com","0688132325","C#","07/02/2019","02/12/2022");
		Stagiaire Clement = new Stagiaire("Clem","Hezon","M","29","17 Rue Champetre - Sevran","clem.cook@hotmail.fr","0788503621","Java","02/10/2021","07/03/2022");
		Stagiaire Angie = new Stagiaire("Angie","Tancre","F","28","28 Rue des Pruneaux - Romainville","ang.t@orange.fr","0622003344","SQL","02/11/2020","07/03/2022");
		Stagiaire Lorine = new Stagiaire("Lorine","Vandeswalme","F","27","13 Rue Alban Michel - Saint Ouen l'Aumone","lo.v@gmail.com","0655771126","Java Script","07/11/2021","06/06/2022");
		Stagiaire Marion = new Stagiaire("Marion","Gruel","F","24","10 Rue Docteur Nekache - Paris","marion.gruel@gmail.com","0688202036","Java Script","07/11/2021","06/06/2022");
		Stagiaire Femy = new Stagiaire("Femy","Nassirou","M","30","77 Rue des Delices - Acheres","femy.n@outlook.fr","0741415858","Java","02/10/2021","07/03/2022");
		Stagiaire Dom = new Stagiaire("Dom","Adil","M","41","58 Rue Pere Dodu - Montauban","d.a@gmail.com","0548414243","Java","02/10/2021","07/03/2022");
		
		
		Noeud<Stagiaire> n1 = new Noeud<Stagiaire>(Selim);
		
		List<Stagiaire> liste = Fichier.deserialisation();
				
		monArbre1.racine = n1;
		
		for (Stagiaire stagiaire : liste) {
			if(stagiaire != Selim)
			monArbre1.ajouterValeurEquilibre(stagiaire);
		}
		monArbre1.afficherArbre();

		
		System.out.println();
		
		
		

	}

}
