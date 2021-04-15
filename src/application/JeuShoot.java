package application;
import java.util.Scanner;
public class JeuShoot{
  //ATTRIBUT de la classe JeuShoot
  private Vaisseau joueur;
  private Monstre ennemi;
  private int score;
  private boolean perdu;

  //CONSTRUCTEURS et METHODES de la classe Monstre

  //CONSTRUCTEUR JeuShoot sans paramètre
  public JeuShoot(){
    this.joueur = new Vaisseau(0,5);
    this.ennemi = new Monstre(10,5);
    this.score = 0;
    this.perdu = false;
  }

  //METHODE getJoueur qui renvoit un objet de type Vaisseau
  public Vaisseau getJoueur(){
    return (this.joueur);
  }

  //METHODE getEnnemi qui renvoit un objet de type Monstre
  public Monstre getEnnemi(){
    return (this.ennemi);
  }

  //METHODE getPerdu qui renvoit un BOOLEAN
  public boolean getPerdu(){
    return (this.perdu);
  }

  //METHODE getScore qui renvoit un entier
  public int getScore(){
    return (this.score);
  }

  //METHODE setEnnemi
  public void setEnnemi(Monstre m){
    this.ennemi = m;
  }

  //METHODE setJoueur
  public void setJoueur(Vaisseau v){
    this.joueur = v;
  }

  //METHODE gererCollision
  public void gererCollision(){
    if(this.ennemi.avoirCollision(this.joueur.getTirCourant())){
      this.score=this.score+1;
      Monstre m = new Monstre(10,5);
      this.setEnnemi(m);
      this.joueur.detruireTir();
    }
  }

  //METHODE evoluer avec un entier en paramètre
  public void evoluer(int commande){
    this.joueur.faireAction(commande);
    this.joueur.evoluerTir();
    this.gererCollision();
    this.ennemi.evoluer();
    this.gererCollision();
    this.perdu=this.ennemi.avoirTraverse();
  }

  //METHODE demanderJoueur
  public int demanderJoueur(){
    Scanner sc = new Scanner(System.in);
    return(sc.nextInt());
    }

  //METHODE poursuivre
  public void poursuivre(){
      this.evoluer(this.demanderJoueur());
  }

  //METHODE toString
  public String toString(){
    return (this.joueur.toString()+"\n"+this.ennemi.toString()+"\n"+this.score);
  }

  //METHODE main
  public static void main(String[] args){
    JeuShoot j = new JeuShoot();
    while (j.perdu!=true){
      j.poursuivre();
    }
    }
  }
