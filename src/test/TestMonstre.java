package test;

//IMPORTATION des packages
import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Monstre
 *
 * A COMPLETER
 */

//INITIALISATION de la classe TestMonstre
public class TestMonstre {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Monstre m = new Monstre(2, 3);
		boolean b = m.avoirCollision(new Tir(2, 2));
		b = m.avoirTraverse();
		m.evoluer();
		b = m.getEtreMort();
		int x = m.getX();
		int y = m.getY();
	}

public void test_Monstre_SortirDeLArene(){
	// preparation des données
	Monstre m1 = new Monstre(-2,5);
	Monstre m2 = new Monstre(4,12);
	// vérification des données
	assertEquals("La coordonnee de X doit valoir 10",10,m1.getX());
	assertEquals("La coordonnee de Y doit valoir 5",5,m1.getY());
	assertEquals("Le monstre doit etre vivant",false,m1.getEtreMort());
	// vérification des données
	assertEquals("La coordonnee de X doit valoir 10",10,m2.getX());
	assertEquals("La coordonnee de Y doit valoir 5",5,m2.getY());
	assertEquals("Le monstre doit etre vivant",false,m2.getEtreMort());
}

public void test_Monstre_DansLArene(){
	// preparation des données
	Monstre m = new Monstre(4,6);
	// vérification des données
	assertEquals("Verification de la valeur de X",4,m.getX());
	assertEquals("Verification de la valeur de Y",6,m.getY());
	assertEquals("Le monstre doit etre vivant",false,m.getEtreMort());
}

public void test_evoluer_MonstreDansLArene(){
	// preparation des données
	Monstre m = new Monstre(4,6);
	//methode à tester quand le monstre est dans l'arene
	m.evoluer();
	// vérification des données
	assertEquals("Verification de Y qui doit réduire de 1",5,m.getY());
}

public void test_evoluer_ALaLimiteDeLAreneEn0(){
	// preparation des données
	Monstre m = new Monstre(4,0);
	//methode à tester quand le monstre a comme coordonnee en Y : 0
	m.evoluer();
	// vérification des données
	assertEquals("Verification de X qui doit reduire de 1",3,m.getX());
}

public void test_evoluer_ChangementDeSens(){
	// preparation des données
	Monstre m = new Monstre(4,0);
	//methode à tester pour que le monstre se décale à gauche
	m.evoluer();
	// vérification des données
	assertEquals("Verification de X qui doit reduire de 1",3,m.getX());
	//methode à tester pour que le monstre change de sens
	m.evoluer();
	// vérification des données
	assertEquals("vérification de Y qui doit augmenter de 1",1,m.getY());
}

public void test_evoluer_ALaLimiteDeLAreneEn10(){
	// preparation des données
	Monstre m = new Monstre(4,0);
	//methode à tester pour que le monstre se décale à gauche
	m.evoluer();
	// vérification des données
	assertEquals("Verification de X qui doit reduire de 1",3,m.getX());
	//methode à tester pour que le monstre parcourt l'arène vers la bas pour changer de sens une fois en bas
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	m.evoluer();
	// vérification des données
	assertEquals("Verification de X qui doit encore reduire de 1",2,m.getX());
}

public void test_avoirTraverse_MonstreALaFin(){
	// preparation des données
	Monstre m = new Monstre(1,0);
	//methode à tester pour voir quand le monstre arrive a la fin
	m.evoluer();
	// vérification des données
	assertEquals("Le monstre est arrivé à la limite",true,m.avoirTraverse());
}

public void test_avoirTraverse_MonstreDansArene(){
	// preparation des données
	Monstre m = new Monstre(4,0);
	//methode à tester quand le monstre n'arrive pas la fin
	m.evoluer();
	// vérification des données
	assertEquals("Le monstre est toujours dans l'arène",false,m.avoirTraverse());
}

public void test_avoirCollision_MonstreTouche(){
	// preparation des données
	Monstre m = new Monstre(4,6);
	Tir t = new Tir(4,6);
	//methode à tester pour voir s'il y a collision ou non
	boolean test = m.avoirCollision(t);
	// vérification des données
	assertEquals("Le monstre doit mourir",true,m.getEtreMort());
	assertEquals("La collision doit etre presente",true,test);
}

public void test_avoirCollision_MonstreSauve(){
	// preparation des données
	Monstre m = new Monstre (5,5);
	Tir t = new Tir (5,8);
	//methode à tester pour voir s'il y a collision ou non
	boolean test = m.avoirCollision(t);
	// vérification des données
	assertEquals("Le monstre doit etre vivant",false,m.getEtreMort());
	assertEquals("La collision n'est pas présente",false,test);
}

public void test_toString(){
	// preparation des données
	Monstre m = new Monstre(4,6);
	// vérification des données
	assertEquals("La phrase n'est pas juste","Monstre(4,6)",m.toString());
}
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestMonstre(), args);
	}

}
