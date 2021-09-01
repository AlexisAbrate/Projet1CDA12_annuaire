package Code;

public class Noeud<T extends Comparable<T>> {

    // L'�l�ment du noeud, par ex. Personne
   public T donnee;

   // Le fils gauche r�f�rence un objet de type Noeud<E>, adresse m�moire sp�cifique
   public Noeud<T> gauche;

   // Le fils droit r�f�rence un objet de type Noeud<E>, adresse m�moire sp�cifique
   public Noeud<T> droit;

   // Constructeur
   public Noeud(T t) {
       this.donnee = t;
       this.gauche = null;
       this.droit = null;
   }
   
   public Noeud(T t, Noeud<T> gauche, Noeud<T> droit) {
       this.donnee = t;
       this.gauche = gauche;
       this.droit = droit;
   }
   
   public void afficherNoeud() {
           System.out.println(this.donnee.toString());
          if (this.gauche != null) this.gauche.afficherNoeud();
          if (this.droit != null) this.droit.afficherNoeud();
   }

}