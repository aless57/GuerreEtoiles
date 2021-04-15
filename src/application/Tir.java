package application;

//Initalisation de la classe TIR
public class Tir{

//ATTRIBUT de la classe TIR
  private int x;
  private int y;

//CONSTRUCTEURS et METHODES de la classe Tir

//CONSTRUCTEUR TIR avec deux paramètres
  public Tir(int px, int py){
    if (px<0){
      px=0;
    }
    if(px>10){
      px=10;
    }
    if (py<0){
      py=0;
    }
    if(py>10){
      py=10;
    }
    this.x=px;
    this.y=py;
    }

//METHODE getX
    public int getX(){
      return this.x;
    }

//METHODE getY
    public int getY(){
      return this.y;
    }

//METHODE evoluer qui renvoit un BOOLEAN
    public boolean evoluer(){
      this.x=this.x+1;
      return (this.x>10);
    }

//METHODE toString qui renvoit un STRING
    public String toString(){
      return ("T"+"("+this.x+","+this.y+")");
    }
}
