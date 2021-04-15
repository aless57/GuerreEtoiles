package application;

//INITIALISATION de la classe Vaisseau
public class Vaisseau{

// ATTRIBUT de la classe Vaisseau
  private int x;
  private int y;
  private Tir tirCourant;

// CONSTRUCTEURS ET METHODES de la classe Vaisseau

//CONSTRUCTEUR Vaisseau sans paramètre
  public Vaisseau(){
    this.x=5;
    this.y=5;
    this.tirCourant=null;
  }

//CONSTRUCTEUR Vaisseau avec deux paramètres
  public Vaisseau(int px, int py){
    if (px<0 || px>10 || py<0 || py>10){
      this.x=5;
      this.y=5;
      this.tirCourant=null;
    }
    else {
      this.x=px;
      this.y=py;
      this.tirCourant=null;
    }
  }

//METHODE getTirCourant
  public Tir getTirCourant(){
    return(this.tirCourant);
  }

//METHODE getX
  public int getX(){
    return(this.x);
  }

//METHODE getY
  public int getY(){
    return(this.y);
  }

//METHODE deplacer avec deux paramètres
  private void deplacer(int dx, int dy){
    if (this.x+dx<=10 && this.x+dx>=0){
      this.x=this.x+dx;
    }
    if (this.y+dy<=10 && this.y+dy>=0){
      this.y=this.y+dy;
    }
  }

//METHODE tirer
  public void tirer(){
    if (this.tirCourant==null){
      this.tirCourant=new Tir(this.x,this.y);
    }
  }

//METHODE faireAction qui fait le lien avec les autres méthodes(déplacer et tirer)
  public void faireAction(int commande){
    switch (commande){
      case 0:
        break;
      case 4:
        this.deplacer(-1,0);
        break;
      case 6:
        this.deplacer(1,0);
        break;
      case 8:
        this.deplacer(0,-1);
        break;
      case 2:
        this.deplacer(0,1);
        break;
      case 5:
        this.tirer();
        break;
    }
  }

//METHODE detruireTir
  public void detruireTir(){
      this.tirCourant=null;
  }

//METHODE evoluerTir qui fait le lien avec la METHODE detruireTir et la METHODE evoluer de la classe TIR
  public void evoluerTir(){
    if (this.tirCourant!=null){
      if(this.tirCourant.evoluer()){;
        this.detruireTir();
      }
    }
  }

//METHODE toString qui renvoit un STRING et qui fait reférence à la méthode toString de la classe TIR
  public String toString(){
    if (this.tirCourant==null){
      return ("Vaisseau("+this.x+","+this.y+")");
    }
    else {
      return ("Vaisseau("+this.x+","+this.y+")-"+this.tirCourant.toString());
    }
  }
}
