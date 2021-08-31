package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fichier {

	public static void main(String[] args) throws IOException {


		Path path = Paths.get("Fichiertxt/annuaire.txt");
		
		List<String> liste = new ArrayList<>();
		
		// Lire les noms d'un fichier (Methodes de Files)
		
		liste = Files.readAllLines(path);
		
		System.out.println(liste);
		
		afficher(liste);
		
		// Lire les noms d'un fichier (Scanner)
		
		String nomDuFichier = "Fichiertxt/annuaire.txt";
		File file = new File(nomDuFichier);
		
		String nomDuFichierCopie = "Fichiertxt/annuaire_copie.txt";
		File fileCopie = new File(nomDuFichierCopie);
		
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine()); 
		}
		
		// Lire chaque élément un par un (exemple si l'on veut mettre les donnes d'un objet)  
		
		/*while(sc.hasNext()) {
			System.out.println(sc.next());
		}*/
		
		
		
		// Ajout d'un prenom dans le fichier
		String text = "Simon";
		Files.write(path, text.getBytes(), StandardOpenOption.WRITE,StandardOpenOption.APPEND);
		
		// Suppression d'un prenom
	
		deleteLine(nomDuFichier, "Loic");
		
	
		
		
		

	}
	
	public static void afficher(List<String> liste) {

		for (String element : liste) {
			System.out.println(element);
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
	
	    public static void voidDeleteLine2(File file, String remove ) throws IOException{

	        File tempFile = new File("FichierTxt/myTempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String lineToRemove = remove;
	        String currentLine;

	        while((currentLine = reader.readLine()) != null) {
	           //trim newline when comparing with lineToRemove
	            String trimmedLine = currentLine.trim();
	            if(trimmedLine.equals(lineToRemove)) continue;
	            writer.write(currentLine + System.getProperty("line.separator"));
	        }
	        writer.close(); 
	        reader.close(); 
	        Files.delete(file);
	        boolean successful = tempFile.renameTo(file);
	        System.out.println(successful);

	    }
	}


