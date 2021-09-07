package Code;

import java.util.ArrayList;
import java.util.List;

public class Arbre <E extends Comparable<E>> {

	  // Attribut de la classe : c'est un noeud qui est la racine de l'arbre binaire
    // de recherche
    public Noeud<E> racine;

    // Constructeur vide de l'abre binaire, on initialise juste la racine à null
    public Arbre() {
        this.racine = null;
    }

    
    
    
private static void chercherStagiaire(String rech, List<Stagiaire> liste) {
		
		Boolean result = false;
		long temp1 = System.currentTimeMillis();
				
				for(int i=0; i<liste.size(); i++) {
					
					Stagiaire stag = liste.get(i);
					
					if (rech.equals(stag.getPrenom()) || rech.equals(stag.getNom()) || rech.equals(stag.getFormation())) {
						System.out.println(stag.toString()); result = true;
					}
								
				}
				
				if (result == false) { System.out.println("Aucun Résultat trouvé"); }
				
				long temp2 = System.currentTimeMillis();
				System.out.println();
				System.out.println("durée de la recherche en mSec : " + (temp2-temp1));
			}

    
    
    
    
    
    // Méthode qui affiche de façon indentée l'arbre binaire de recherche
    public void affichagePrefixe() {
        racine.afficherNoeud();
    }

    // Méthode qui supprime un noeud contenant valeur dans l'arbre binaire de
    // recherche
    public void supprimerValeur(E valeur) {

        supprimerValeur(racine, valeur);

    }

    // Méthode qui supprime un noeud contenant valeur dans le sous-arbre ayant pour
    // racine currentNoeud
    public Noeud<E> supprimerValeur(Noeud<E> currentNoeud, E valeur) {
        if (currentNoeud == null)
            return null;
        if (currentNoeud.donnee.compareTo(valeur) == 0) {
            return supprimerRacine(currentNoeud);
        }
        if (currentNoeud.donnee.compareTo(valeur) > 0) {
            // System.out.println("fIlsG\n");
            currentNoeud.gauche = supprimerValeur(currentNoeud.gauche, valeur);
            return currentNoeud;
        }
        if (currentNoeud.donnee.compareTo(valeur) < 0) {
            // System.out.println("filsD\n");
            currentNoeud.droit = supprimerValeur(currentNoeud.droit, valeur);
            return currentNoeud;
        } else
            return currentNoeud;
    }

    // Méthode qui supprime la racine d'un sous-arbre binaire de recherche à partir
    // de ce même noeud racine
    public Noeud<E> supprimerRacine(Noeud<E> currentNoeud) {
        if ((currentNoeud.gauche == null) && (currentNoeud.droit == null)) {
            return null;
        } else if (currentNoeud.gauche != null && currentNoeud.droit == null)
            return currentNoeud.gauche;
        else if (currentNoeud.gauche == null && currentNoeud.droit != null)
            return currentNoeud.droit;
        else {
            currentNoeud.donnee = successeur(currentNoeud).donnee;
            currentNoeud.droit = supprimerValeur(currentNoeud.droit, currentNoeud.donnee);
            return currentNoeud;
        }

    }

    // Méthode de recherche du noeud contenant la valeur qui succède à la valeur du
    // noeud courrant (dans l'ordre croissant)
    public Noeud<E> successeur(Noeud<E> currentNoeud) {
        currentNoeud = currentNoeud.droit;
        while (currentNoeud.gauche != null) {
            currentNoeud = currentNoeud.gauche;
        }
        return currentNoeud;
    }

    // Méthode d'ajout d'une valeur au niveau des feuilles dans un arbre binaire de
    // recherche
    public void ajouterValeur(E valeur) {
        this.racine = ajouterValeur(racine, valeur);
    }

    // Méthode d'ajout d'une valeur au niveau des feuilles dans un sous-arbre
    // binaire de recherche à partir de son noeud racine
    public Noeud<E> ajouterValeur(Noeud<E> currentNoeud, E valeur) {
        if (currentNoeud == null)
            currentNoeud = new Noeud<E>(valeur);
        else if (currentNoeud.donnee.compareTo(valeur) > 0) {
            // System.out.println("fIlsG\n");
            currentNoeud.gauche = ajouterValeur(currentNoeud.gauche, valeur);
        } else if (currentNoeud.donnee.compareTo(valeur) <= 0) {
            // System.out.println("filsD\n");
            currentNoeud.droit = ajouterValeur(currentNoeud.droit, valeur);
        }

        return currentNoeud;
    }

    // Méthode permettant de retourner la hauteur d'un arbre
    public int hauteur() {
        return hauteurSousArbre(racine);
    }

    // Méthode permettant de retourner la hauteur d'un arbre à partir d'un noeud
    // racine
    private int hauteurSousArbre(Noeud<E> currentNoeud) {
        if (currentNoeud != null)
            return 1 + java.lang.Math.max(hauteurSousArbre(currentNoeud.gauche), hauteurSousArbre(currentNoeud.droit));
        else
            return 0;
    }

    // Méthode qui affiche un arbre de manière infixe
    public void afficherArbre() {
        System.out.println("Affichage de l'arbre :\n\n");
        afficherNoeud(racine, 0, this.hauteur());
        System.out.println();
    }

    // Méthode d'affichage de sous-arbre à partir d'un noeud racine
    // Cette méthode est dpendante de l'objet stocké et de l'arbre que l'on souhaite
    // afficher, n'hésitez pas à la modifier en fnction de vos besoins.
    // Dans la première version, on indente le noeud affiché.
    // Le nombre d'espaces ajoutés avant d'afficher la valeur du noeud est égale à
    // la hauteur du noeud moins sa profondeur

    public void afficherNoeud(Noeud<E> currentNoeud, int currentLevel, int maxLevel) {

        if (currentNoeud != null) {
            afficherNoeud(currentNoeud.gauche, currentLevel + 1, maxLevel);
            // C'est ici qu'on créé l'indentation
            for (int i = 0; i < (maxLevel - currentLevel - 1); i++) {
                System.out.print("       ");
            }
            System.out.println(currentNoeud.donnee);
            afficherNoeud(currentNoeud.droit, currentLevel + 1, maxLevel);
        } else {
            if (currentLevel < maxLevel) {
                afficherNoeud(null, currentLevel + 1, maxLevel);
                // !!!Modification par rapport à la version faite ensemble, tester de l'ajouter
                // ou l'enlever en fonction de vos besoin d'affichage
                // System.out.println("");
                afficherNoeud(null, currentLevel + 1, maxLevel);
            }
        }

    }

    // Méthode de recherche du noeud contenant "valeur" dans tout l'arbre
    // Note : cette méthode n'est pas récursive, on se contente d'appeler une
    // méthode annexe
    // prenant en paramètre un noeud courrant currentNoeud, qui elle sera récursive.
    // Si la valeur est compris dans l'arbe, elle retourne le noeud contenant la
    // valeur et null sinon
    public boolean rechercher_naive(E valeur) {
        return rechercher_naive_annexe(racine, valeur);
    }

    // Méthode de recherche de valeur dans le sous-arbre ayant pour racine
    // currentNoeud
    public boolean rechercher_naive_annexe(Noeud<E> currentNoeud, E valeur) {

        if (currentNoeud == null)
            return false;
        else if (currentNoeud.donnee.compareTo(valeur) == 0) {
            return true;
        } else if (currentNoeud.donnee.compareTo(valeur) > 0) {
            return rechercher_naive_annexe(currentNoeud.gauche, valeur);
        } else {
            return rechercher_naive_annexe(currentNoeud.droit, valeur);
        }
    }

    // Méthode de recherche dans le cas où on aurait plusieur résultats positif,
    // retournant une liste de noeuds
    public List<E> rechercher_liste(E valeur) {
        List<E> listeRetour = new ArrayList<E>();
        return rechercher_liste_annexe(listeRetour, racine, valeur);
    }

    // Méthode de recherche dans le cas où on aurait plusieur résultats positif,
    // retournant une liste de noeuds
    public List<E> rechercher_liste_annexe(List<E> listRetour, Noeud<E> currentNoeud, E valeur) {

        if (currentNoeud == null)
            return listRetour;
        else if (currentNoeud.donnee.compareTo(valeur) == 0) {
            listRetour.add(currentNoeud.donnee);
            rechercher_liste_annexe(listRetour, currentNoeud.droit, valeur);
            rechercher_liste_annexe(listRetour, currentNoeud.gauche, valeur);
            return listRetour;
        } else if (currentNoeud.donnee.compareTo(valeur) > 0) {
            return rechercher_liste_annexe(listRetour, currentNoeud.gauche, valeur);
        } else {
            return rechercher_liste_annexe(listRetour, currentNoeud.droit, valeur);
        }

    }

    // Méthode de rotation droite autours de la racine currenNoeud d'un sous arbre
    public void rotation_droite(Noeud<E> currentNoeud) {

        E a, b;
        Noeud<E> y, c, d, e;

        // Création des 6 variables annexes
        // Dans cette fonction, x est appelé currentNoeud
        a = currentNoeud.donnee;
        y = currentNoeud.gauche;
        b = y.donnee;
        c = y.gauche;
        d = y.droit;
        e = currentNoeud.droit;

        // remplacer a par b dans x
        currentNoeud.donnee = b;
        // remplacer le sous-arbre gauche de x par C.
        currentNoeud.gauche = c;
        // remplacer le sous-arbre droite de x par y et la valeur de y par a.
        currentNoeud.droit = y;
        y.donnee = a;
        // remplacer le sous-arbre gauche de y par D et le sous-arbre droite de y par E.
        y.gauche = d;
        y.droit = e;

    }

    // Méthode de rotation gauche autours de la racine currenNoeud d'un sous arbre
    public void rotation_gauche(Noeud<E> currentNoeud) {

        E a, b;
        Noeud<E> y, c, d, e;

        // Création des 6 variables annexes
        // Dans cette fonction, x est appelé currentNoeud
        b = currentNoeud.donnee;
        y = currentNoeud.droit;
        a = y.donnee;
        c = currentNoeud.gauche;
        d = y.gauche;
        e = y.droit;

        // remplacer b par a dans x
        currentNoeud.donnee = a;
        // remplacer le sous-arbre droite de x par E.
        currentNoeud.droit = e;
        // remplacer le sous-arbre gauche de x par y et la valeur de y par b.
        currentNoeud.gauche = y;
        y.donnee = b;
        // remplacer le sous-arbre gauche de y par C et le sous-arbre droite de y par D.
        y.gauche = c;
        y.droit = d;
    }

    // Méthode qui teste l'équilibre d'un arbre et retourne 0 si l'arbre est
    // équilibré et la différence des hauteurs des sous arres sinon

    public int getEquilibre(Noeud<E> currentNoeud) {
        int result = 0;
        if (currentNoeud != null) {
            int hauteurSousArbreDroit = hauteurSousArbre(currentNoeud.droit);
            int hauteurSousArbreGauche = hauteurSousArbre(currentNoeud.gauche);
            result = hauteurSousArbreGauche - hauteurSousArbreDroit;
        }
        return result;
    }

    // méthode d'équilibrage d'un arbre à partir de son noeud racine

    public Noeud<E> equilibrage(Noeud<E> currentNoeud) {
        if (currentNoeud != null) {

            currentNoeud.gauche = equilibrage(currentNoeud.gauche);
            currentNoeud.droit = equilibrage(currentNoeud.droit);

            /* si branche droite trop longue */
            if (getEquilibre(currentNoeud) < -1) {
                rotation_gauche(currentNoeud);
            }
            /* si branche gauche trop longue */
            else if (getEquilibre(currentNoeud) > 1) {
                rotation_droite(currentNoeud);
            }

        }

        return currentNoeud;
    }

    // Méthode d'ajout d'une valeur dans un arbre binaire de
    // recherche de manière à obtenir un arbre équilibré
    public void ajouterValeurEquilibre(E valeur) {
        this.racine = ajouterValeurEquilibre(racine, valeur);
    }

    // Méthode d'ajout d'une valeur dans un sous-arbre binaire de
    // recherche de manière à obtenir un sous-arbre équilibré à partir de son noeud
    // racine
    public Noeud<E> ajouterValeurEquilibre(Noeud<E> currentNoeud, E valeur) {
        if (currentNoeud == null)
            currentNoeud = new Noeud<E>(valeur);
        else if (currentNoeud.donnee.compareTo(valeur) > 0) {
            // System.out.println("fIlsG\n");
            currentNoeud.gauche = equilibrage(ajouterValeurEquilibre(currentNoeud.gauche, valeur));
        } else if (currentNoeud.donnee.compareTo(valeur) <= 0) {
            // System.out.println("filsD\n");
            currentNoeud.droit = equilibrage(ajouterValeurEquilibre(currentNoeud.droit, valeur));
        }

        return equilibrage(currentNoeud);
    }

}