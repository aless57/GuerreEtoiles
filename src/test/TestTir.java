package test;

//IMPORTATION des packages
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

//INITIALISATION de la classe TestTir
public class TestTir {

	/**
	 * test initial pour verifier le bon appel des methodes
	 */
	public void test_initial() {
		Tir t = new Tir(5, 6);
		assertEquals("test X", 5, t.getX());
		assertEquals("test Y", 6, t.getY());
		t.evoluer();
	}

//METHODE test Tir qui sort de l'arène
	public void test_Tir_SortirdeLArene() {
		//preparation des données
		Tir t = new Tir (-2, 12);
		//verification des modifications des valeurs de X et Y
		assertEquals("Test de X",0,t.getX());
		assertEquals("Test de Y",10,t.getY());
	}

	/**
	 * evoluer et le tir reste dans l'arene
	 */
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Tir t = new Tir(6, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour false
		assertEquals("tir devrait rester dans arene", false, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 7, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	 * evoluer et le tir sort de l'arene
	 */
	public void test_Evoluer_SortirArene() {
		// preparation des donnees
		Tir t = new Tir(10, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour true car sortie de l arene
		assertEquals("tir devrait rester dans arene", true, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 11, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	// ... autres tests
//METHODE test pour la chaîne avec les coordonnées du Tir
	public void test_toString(){
		//preparation des données
		Tir t = new Tir (5,5);
		//verification des coordonnées du tir
		assertEquals("La phrase nest pas bonne","T(5,5)",t.toString());
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestTir(), args);
	}

}
