package Code;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;

public class TestDeserialisation {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String nomDuFichier = "Fichiertxt/annuaire.txt";
		
		FileInputStream fis = new FileInputStream("Fichiertxt/annuaire.ser");
		
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Stagiaire> list = (List<Stagiaire>) ois.readObject();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
//		for (Stagiaire stagiaire : list) {
//			System.out.println(stagiaire);
//			Stagiaire sta = new Stagiaire (stagiaire.getPrenom(),stagiaire.getNom());
//		}
		
		
		
		ois.close();
		}

}