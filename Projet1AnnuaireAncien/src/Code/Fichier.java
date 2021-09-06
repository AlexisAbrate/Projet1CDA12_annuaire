package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.ObservableList;

public class Fichier {

	
	// Sauvegarde (pour ajout)
	
	public static void serialisation(List<Stagiaire> liste) throws IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fichiertxt/annuaire.ser"));
		
		Fichier.clearFichier("Fichiertxt/annuaire.txt");
		System.out.println("Fichier Clear");
		for(int i = 0; i<liste.size();i++) {
		Fichier.addLine("Fichiertxt/annuaire.txt", liste.get(i));
		System.out.println("une ligne ecrite");
		}
		oos.writeObject(liste);
		System.out.println("Serialisé");

		oos.close();
				
	}
	
	// Chargement
	
	public static List<Stagiaire> deserialisation() throws IOException, ClassNotFoundException {
		
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Fichiertxt/annuaire.ser"));
	
	
	List<Stagiaire> list = (List<Stagiaire>) ois.readObject();
	
	ois.close();
	
	return list;
	}
	
	
	
	//Ajout
	
	
	public static void ajoutObjet (Stagiaire stagiaire) throws IOException {
		
		
		FileOutputStream fos = new FileOutputStream("Fichiertxt/annuaire.ser");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(stagiaire);
		
		oos.close();	
		
		
	}

	
	
	
	
	
	// Sauvegarde (pour modification)
//	
//public static void serialisationSupp(List<Stagiaire> liste) throws IOException {
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fichiertxt/annuaire.ser"));
//		
//		
//		oos.writeObject(liste);
//		Fichier.clearFichier("Fichiertxt/annuaire.txt");
//		for(int i = 0; i<liste.size();i++) {
//		Fichier.addLine("Fichiertxt/annuaire.txt", liste.get(i));}
//		
//		oos.close();
//				
//	}
	
	
	
	
//	// Sauvegarde (pour suppression)

public static void serialisationSupp(List<Stagiaire> liste) throws IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fichiertxt/annuaire.ser"));
		
		Fichier.clearFichier("Fichiertxt/annuaire.txt");
		System.out.println("Fichier Clear");
		for(int i = 0; i<liste.size();i++) {
		Fichier.addLine("Fichiertxt/annuaire.txt", liste.get(i));
		System.out.println("une ligne ecrite");
		}
		oos.writeObject(liste);
		System.out.println("Serialisé");

		oos.close();
				
	}
	
	

	
	public static void afficher(List<String> liste) {

		for (String element : liste) {
			System.out.println(element);
		}
	}
	
	public static List<String> initFichier(String fileName) throws IOException {
		
		Path path = Paths.get(fileName);
		List<String> liste = new ArrayList<>();
		liste = Files.readAllLines(path);
		return liste;	
	}
	
	

	
	public static void addLine(String fileName, Stagiaire nom)
	{
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		StringBuffer sb = new StringBuffer();
		String line;
		
		while((line = reader.readLine()) !=null){
			sb.append(line + "\n");			
		}
		sb.append(nom + "\n");
		
		reader.close();
		
		
		BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
		bf.write(sb.toString());
		bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean deleteLine(String fileName, String delete) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
 
            StringBuffer sb = new StringBuffer(); 
            String line;    
            
            while ((line = reader.readLine()) != null) {
                if (!line.equals(delete)) {
                    sb.append(line + "\n");
                }
            }
            reader.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(sb.toString());
            out.close();
 
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	public static void clearFichier(String fileName) throws IOException {
		
	String clear = "";
	Path path = Paths.get(fileName);
	Files.write(path, clear.getBytes());
		
		
	}
	
	public static void updateLine(String fileName, String delete, String add) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			StringBuffer sb = new StringBuffer();
			String line;
			
			while((line= br.readLine()) != null) {
				if(!line.equals(delete))
					sb.append(line + "\n");
				else
					sb.append(add + "\n");
			}
			br.close();
			
			BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
			bf.write(sb.toString());
			bf.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	

	
}



