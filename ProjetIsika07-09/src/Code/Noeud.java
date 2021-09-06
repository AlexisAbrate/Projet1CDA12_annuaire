package Code;

public class Noeud < E extends Comparable<E>> {
	
	E donnee;
	Noeud <E> droit,gauche ;
	
	public Noeud(E donnee, Noeud<E> droite, Noeud<E> gauche) {
		super();
		this.donnee = donnee;
		this.droit = droite;
		this.gauche = gauche;
	}
	
	public Noeud(E donnee) {
		this.donnee = donnee;
		this.droit = null;
		this.gauche = null;
	}
	
	 public void afficherNoeud() {
          System.out.println(this.donnee.toString());
          if (this.gauche != null) this.gauche.afficherNoeud();
          if (this.droit != null) this.droit.afficherNoeud();
   }


}
