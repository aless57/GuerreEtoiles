package application;
public class Monstre{
  //ATTRIBUT de la classe Monstre
  private int x;
  private int y;
  private boolean deplacerHaut;
  private boolean etreMort;

  //CONSTRUCTEURS et METHODES de la classe Monstre

  //CONSTRUCTEUR Monstre avec deux paramètres
  public Monstre(int px,int py){
    if (px<0 || px>10 || py<0 || py>10){
      this.x=10;
      this.y=5;
      this.deplacerHaut=true;
      this.etreMort=false;
    }
    else {
      this.x=px;
      this.y=py;
      this.deplacerHaut=true;
      this.etreMort=false;
  }
  }
//METHODE getEtreMort
  public boolean getEtreMort(){
    return(this.etreMort);
  }

//METHODE getX
  public int getX(){
    return (this.x);
  }

//METHODE getY
  public int getY(){
    return (this.y);
  }

//METHODE evoluer
  public void evoluer(){
    if (this.deplacerHaut==true){
      if (this.etreMort==false){
        if (this.y>0){
          this.y=this.y-1;
        }else{
          this.x=this.x-1;
          this.deplacerHaut=false;
        }
      }
    }else{
      if (this.etreMort==false){
        if (this.y<10){
          this.y=this.y+1;
        }
        else{
          this.x=this.x-1;
          this.deplacerHaut=true;
        }
    }
   }
}

//METHODE avoirTraverse avec un BOOLEAN en retourt
  public boolean avoirTraverse(){
    if (this.x==0){
      return (true);
    }
    else{
      return (false);
    }
  }

//METHODE avoirCollision avec un objet de Type Tir en paramètre et retourne un BOOLEAN
  public boolean avoirCollision(Tir t){
    if (t!=null && this.x==t.getX() && this.y==t.getY()){
      this.etreMort=true;
      return(true);
    }
    else{
      return(false);
    }
  }

//METHODE toString avec un STRING en retour
  public String toString(){
    return ("Monstre("+this.x+","+this.y+")");
  }
}
