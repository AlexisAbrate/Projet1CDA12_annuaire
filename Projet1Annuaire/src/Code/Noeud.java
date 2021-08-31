package Code;

public class Noeud < E extends Comparable<E>> {
	
	E donnee;
	Noeud <E> droite,gauche ;
	
	public Noeud(E donnee, Noeud<E> droite, Noeud<E> gauche) {
		super();
		this.donnee = donnee;
		this.droite = droite;
		this.gauche = gauche;
	}
	
	public Noeud(E donnee) {
		this.donnee = donnee;
		this.droite = null;
		this.gauche = null;
	}
	
	

}
