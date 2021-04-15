package test;

//IMPORTATION des packages
import libtest.*;
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test de JeuShoot
 *
 * A COMPLETER
 */

//INITIALISATION de la classe TestJeuShoot
public class TestJeuShoot {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		JeuShoot j = new JeuShoot();
		Monstre monstre = j.getEnnemi();
		Vaisseau v = j.getJoueur();
		int s = j.getScore();
		boolean b=j.getPerdu();
		j.evoluer(0);
		j.setEnnemi(new Monstre(2,2));
		j.setJoueur(new Vaisseau(2,2));
		assertEquals("score nul au depart",s,0);
	}

	public void test_JeuShoot(){
		// preparation des données
		JeuShoot j = new JeuShoot();
		Vaisseau v = j.getJoueur();
		// vérification des données
		assertEquals("Coordonnée de X du Vaisseau",0,v.getX());
		assertEquals("Coordonnée de Y du Vaisseau",5,v.getY());
		Monstre m = j.getEnnemi();
		// vérification des données
		assertEquals("Coordonnée de X du Monstre",10,m.getX());
		assertEquals("Coordonnée de y du Monstre",5,m.getY());
		// vérification des données
		assertEquals("valeur du score",0,j.getScore());
		assertEquals("perdu ou non?",false,j.getPerdu());
	}

	public void test_gererCollision_LorsDUneCollision(){
		// preparation des données
		JeuShoot j = new JeuShoot();
		//methode a tester pour que le tir arrive à hauteur du monstre
		j.getJoueur().tirer();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		// vérification des données
		assertEquals("Le tir doit être a la même position que le monstre", 10, j.getJoueur().getTirCourant().getX());
		//methode a tester pour voir s'il y a collision
		j.gererCollision();
		// vérification des données
		assertEquals("Le score doit augmenter de 1",1,j.getScore());
		assertEquals("Le monstre en X doit se replacer",10,j.getEnnemi().getX());
		assertEquals("Le monstre en Y doit se replacer",5,j.getEnnemi().getY());
		assertEquals("Le tir doit être détruit",null,j.getJoueur().getTirCourant());
	}

	public void test_gererCollision_PasDeCollision(){
		// preparation des données
		JeuShoot j = new JeuShoot();
		//methode a tester pour que le tir n'arrive pas à hauteur du monstre
		j.getJoueur().tirer();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		j.getJoueur().evoluerTir();
		// vérification des données
		assertEquals("Le tir ne doit pas avoir la même valeur que le monstre",3,j.getJoueur().getTirCourant().getX());
		//methode a tester pour voir s'il y a collision
		j.gererCollision();
		// vérification des données
		assertEquals("Le score ne doit pas augmenter",0,j.getScore());
	}

	public void test_evoluer(){
		// preparation des données
		JeuShoot j = new JeuShoot();
		Monstre m = new Monstre(1,0);
		//methode a tester pour voir si la partie se finit quand le monstre arrive a la fin
		j.setEnnemi(m);
		j.getEnnemi().evoluer();
		j.evoluer(0);
		// vérification des données
		assertEquals("La fin de la partie",true,j.getPerdu());
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeuShoot(), args);
	}

}
