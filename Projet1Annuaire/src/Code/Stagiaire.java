package Code;

public class Stagiaire {

	private String prenom;

	public Stagiaire(String prenom) {
		super();
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return prenom + " , ";
	}
	
	
	
	
}
