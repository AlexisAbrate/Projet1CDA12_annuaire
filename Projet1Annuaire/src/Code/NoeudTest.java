package Code;

public class NoeudTest < E extends Comparable<E>> {
	
	E donnee;
	NoeudTest <E> droit,gauche ;
	
	public NoeudTest(E donnee, NoeudTest<E> droite, NoeudTest<E> gauche) {
		super();
		this.donnee = donnee;
		this.droit = droite;
		this.gauche = gauche;
	}
	
	public NoeudTest(E donnee) {
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
