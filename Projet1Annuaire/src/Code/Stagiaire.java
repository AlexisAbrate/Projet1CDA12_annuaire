package Code;

import java.io.Serializable;

public class Stagiaire implements Serializable, Comparable<Stagiaire> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7173599606200030834L;
	private String prenom,nom,genre,age,adresse,mail,tel,formation,debutFormation,finFormation;

	public Stagiaire(String prenom, String nom, String genre, String age, String adresse, String mail, String tel,
			String formation, String debutFormation, String finFormation) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.genre = genre;
		this.age = age;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
		this.formation = formation;
		this.debutFormation = debutFormation;
		this.finFormation = finFormation;
	}


	@Override
	public String toString() {
		return "[prenom=" + prenom + ", nom=" + nom + ", genre=" + genre + ", age =" + age + ", adresse=" + adresse + ", mail=" + mail + ", tel=" + tel + ", formation=" + formation + ", debutFormation=" + debutFormation + ", finFormation=" + finFormation+ "]";
	}
	
	@Override
	public int compareTo(Stagiaire o) {
		return this.getPrenom().compareTo(o.getPrenom()) ;
	}
	
	public Boolean recherche(String recherche) {
		
		if (prenom.equals(recherche) || nom.equals(recherche) || genre.equals(recherche) || age.equals(recherche)
				|| adresse.equals(recherche) || mail.equals(recherche) || tel.equals(recherche) 
				|| formation.equals(recherche) || debutFormation.equals(recherche) || finFormation.equals(recherche)) {
			return true;
		}
		else { return false; }
	}

	public Boolean rechercheLarge(String recherche) {
		
		if (prenom.indexOf(recherche) !=1 || nom.indexOf(recherche) !=-1 || genre.indexOf(recherche) != -1 || 
				age.indexOf(recherche) != -1 || adresse.indexOf(recherche) != -1 || mail.indexOf(recherche) != -1  || 
				tel.indexOf(recherche) != -1 || formation.indexOf(recherche) != -1  || debutFormation.indexOf(recherche) != -1  
				|| finFormation.indexOf(recherche) != -1 ) {
			return true;
		}
		else { return false; }
	}
	
	
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getFormation() {
		return formation;
	}


	public void setFormation(String formation) {
		this.formation = formation;
	}


	public String getDebutFormation() {
		return debutFormation;
	}


	public void setDebutFormation(String debutFormation) {
		this.debutFormation = debutFormation;
	}


	public String getFinFormation() {
		return finFormation;
	}


	public void setFinFormation(String finFormation) {
		this.finFormation = finFormation;
	}




}
