package test;

//IMPORTATION des packages
import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;


/**
 * test classe Vaisseau
 *
 * A COMPLETER
 */

//INITIALISATION de la classe TestVaisseau
public class TestVaisseau {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Vaisseau v = new Vaisseau();
		v = new Vaisseau(1, 2);
		v.evoluerTir();
		v.faireAction(0);
		Tir t = v.getTirCourant();
		v.getX();
		v.getY();
		v.tirer();
	}

	public void test_Vaisseau_SansParametre(){
		// preparation des données
		Vaisseau v = new Vaisseau();
		// vérification des données sans paramètres
		assertEquals("Test de X sans parametre",5,v.getX());
		assertEquals("Test de Y sans parametre",5,v.getY());
		assertEquals("Test de tirCourant",null,v.getTirCourant());
	}

//METHODE test du Vaiiseau avec des paramètre hors et dans l'arène
	public void test_Vaisseau_AvecParametres(){
		// preparation des données avec paramètres dans l'arène
		Vaisseau v1 = new Vaisseau (6,4);
		// preparation des données avec paramètres hors de l'arène
		Vaisseau v2 = new Vaisseau (14,-2);

		// vérification des données avec les paramètre dans l'arène
		assertEquals("Test de X dans l'arene",6,v1.getX());
		assertEquals("Test de Y dans l'arene",4,v1.getY());

		// vérification des données avec les paramètres dans l'arène
		assertEquals("Test de X hors de l'arene",5,v2.getX());
		assertEquals("Test de Y hors de l'arene",5,v2.getY());
	}

//METHODE test tirer
	public void test_tirer(){
		//preparation des données
		Vaisseau v = new Vaisseau();
		//methode à tester
		v.tirer();
		v.getTirCourant();
		//vérification des valeurs du tir qui correspondent à celles du vaisseau
		assertEquals("Valeur de X du tirCourant",5,v.getX());
		assertEquals("Valeur de Y du tirCourant",5,v.getY());
	}

//METHODE test de faireAction pour la touche 0
	public void test_faireAction_Touche0(){
		// preparation des données sans parametres
		Vaisseau v = new Vaisseau();

		//Touche 0
		v.faireAction(0);

		//vérification des données
		assertEquals("Coordonnée de X ne doit pas changer",5,v.getX());
		assertEquals("Coordonnée de Y ne doit pas changer",5,v.getY());
	}

//METHODE test de faireAction pour la touche 4
	public void test_faireAction_Touche4(){
		//preparation des données avec et sans parametre
		Vaisseau v1 = new Vaisseau();
		Vaisseau v2 = new Vaisseau(0,7);
		//Touche 4
		v1.faireAction(4);
		v2.faireAction(4);

		//vérification des données sans paramètre
		assertEquals("Coordonnée de X réduit de 1",4,v1.getX());
		assertEquals("Coordonnée de Y ne doit pas changer",5,v1.getY());

		//vérification des données avec paramètres
		assertEquals("Coordonneé de X ne doit pas changer car rester dans l'arène",0,v2.getX());
		assertEquals("Coordonneé de Y ne doit pas changer",7,v2.getY());
	}

//METHODE test de faireAction pour la touche 6
	public void test_faireAction_Touche6(){
		//preparation des données avec et sans parametre
		Vaisseau v1 = new Vaisseau();
		Vaisseau v2 = new Vaisseau(10,7);
		//Touche 4
		v1.faireAction(6);
		v2.faireAction(6);

		//vérification des données sans paramètre
		assertEquals("Coordonnée de X réduit de 1",6,v1.getX());
		assertEquals("Coordonnée de Y ne doit pas changer",5,v1.getY());

		//vérification des données avec paramètres
		assertEquals("Coordonneé de X ne doit pas changer car rester dans l'arène",10,v2.getX());
		assertEquals("Coordonneé de Y ne doit pas changer",7,v2.getY());
	}

//METHODE test de faireAction pour la touche 8
	public void test_faireAction_Touche8(){
		//preparation des données avec et sans parametre
		Vaisseau v1 = new Vaisseau();
		Vaisseau v2 = new Vaisseau(7,0);
		//Touche 4
		v1.faireAction(8);
		v2.faireAction(8);

		//vérification des données sans paramètre
		assertEquals("Coordonnée de X réduit de 1",5,v1.getX());
		assertEquals("Coordonnée de Y ne doit pas changer",4,v1.getY());

		//vérification des données avec paramètres
		assertEquals("Coordonneé de X ne doit pas changer car rester dans l'arène",7,v2.getX());
		assertEquals("Coordonneé de Y ne doit pas changer",0,v2.getY());
	}

//METHODE test de faireAction pour la touche 2
	public void test_faireAction_Touche2(){
		//preparation des données avec et sans parametre
		Vaisseau v1 = new Vaisseau();
		Vaisseau v2 = new Vaisseau(7,10);
		//Touche 4
		v1.faireAction(2);
		v2.faireAction(2);

		//vérification des données sans paramètre
		assertEquals("Coordonnée de X réduit de 1",5,v1.getX());
		assertEquals("Coordonnée de Y ne doit pas changer",6,v1.getY());

		//vérification des données avec paramètres
		assertEquals("Coordonneé de X ne doit pas changer car rester dans l'arène",7,v2.getX());
		assertEquals("Coordonneé de Y ne doit pas changer",10,v2.getY());
	}

//METHODE test de faireAction pour la touche 5
	public void test_faireAction_Touche5(){
		//preparation des données sans parametre
		Vaisseau v = new Vaisseau();
		//Touche 5
		v.faireAction(5);

		//obtention des coordonnées du tir
		v.getTirCourant();

		//vérification des données du tir
		assertEquals("Coordonneé de X du tir",5,v.getX());
		assertEquals("Coordonneé de Y du tir",5,v.getY());
	}

//METHODE test de evoluerTir quand le tir évolue dans l'arène
	public void test_evoluerTir(){
		//preparation des données sans parametre
		Vaisseau v1 = new Vaisseau(5,5);
		//On fait apparaître un tir et on le fait évoluer d'une case
		v1.tirer();
		v1.evoluerTir();
		Tir t1 = v1.getTirCourant();
		//vérification des données du tir
		assertEquals("Coordonnee de X du tir dans larene",6,t1.getX());
		assertEquals("Coordonnee de Y du tir dans larene",5,t1.getY());
	}

//METHODE test de evoluerTir quand le tir risque de sortir de l'arène
	public void test_evoluerTir_SortirDeLArene(){
		//preparation des données sans parametre
		Vaisseau v1 = new Vaisseau(10,6);
		//On fait apparaître un tir et on le fait évoluer d'une case
		v1.tirer();
		v1.evoluerTir();
		//vérification des données du tir
		assertEquals("La coordonnee de X doit etre null",null,v1.getTirCourant());

	}

//METHODE test de toString avec le vaisseau et le tir
	public void test_toString_AvecUnTir(){
		//preparation des données
		Vaisseau v = new Vaisseau(5,5);
		v.tirer();
		Tir t1 = v.getTirCourant();
		assertEquals("La phrase n'est pas juste","Vaisseau(5,5)-T(5,5)",v.toString());
	}

//METHODE test de toString seulement avec le vaisseau
	public void test_toString_SansTir(){
		Vaisseau v = new Vaisseau();
		assertEquals("La phrase n'est pas juste","Vaisseau(5,5)",v.toString());
	}
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestVaisseau(), args);
	}

}
