package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TestSerialisation {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String nomDuFichier = "Fichiertxt/annuaire.txt";
		
		List<Stagiaire> liste = new ArrayList<>();
		
		String nomDuFichier2 = "Fichiertxt/annuaire_copie.txt";
		
		Stagiaire alexis = new Stagiaire("Alexis", "Abrate","M","28","124 Rue Hoche - Montreuil","abrate.alexis@gmail.com","0685221445","ISIKA","02/04/2021","18/05/2022");

		Stagiaire jenny = new Stagiaire("Jenny", "Guevel","F","28","124 Rue Hoche - Montreuil","jennifer.guevel@hotmail.fr","0615784853","VAE","05/05/2021","01/01/2022");
		Stagiaire loulou = new Stagiaire("Loulou", "Guevel","M","27","17 Rue Veron - Alfortville","kev.guev@gmail.com","0615874411","Happy Dog","14/09/2021","25/11/2022");
		Stagiaire nono = new Stagiaire("Nono", "Guevel","F","21","58 Rue Charles de Gaulle - Vaureal","nono.g@outlook.fr","0785142233","EducSpe","04/04/2020","25/07/2022");
		Stagiaire max = new Stagiaire("Max","Lonne","M","28","10 Rue Docteur Nekache - Paris","max.lonne@gmail.com","0617178552","ESSEC","08/09/2021","19/05/2022");
		Stagiaire max3 = new Stagiaire("Max","Lonne","M","28","10 Rue Docteur Nekache - Paris","max.lonne@gmail.com","0617178552","ESSEC","08/09/2021","19/05/2022");

		Stagiaire Lee = new Stagiaire("Lee","Lonne","M","28","10 Rue Docteur Nekache - Paris","lee.lonne@gmail.com","0617178874","ESSEC","08/09/2021","19/05/2022");
		
		
		liste.add(jenny);
		liste.add(alexis);	
		liste.add(loulou);		
		liste.add(nono);
		liste.add(max);
		liste.add(Lee);
		liste.add(max3);
		
	/*	List<Stagiaire> list = new ArrayList();
		
		list.add(Jenny);
		list.add(Alexis);
		list.add(Loulou);
		list.add(Loulou2);*/
		
		System.out.println(liste);
		
		
		Fichier.serialisation(liste);
		
//		FileOutputStream fos = new FileOutputStream("Fichiertxt/annuaire.ser");
//		
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		
//		oos.writeObject(liste);
//		Fichier.clearFichier(nomDuFichier);
//		for(int i = 0; i<liste.size();i++) {
//		Fichier.addLine(nomDuFichier, liste.get(i));}
//		
//		oos.close();
		
	
		
		}

}
