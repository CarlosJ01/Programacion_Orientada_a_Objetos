package prog_poo_02;
public class Prog_POO_02 {
    public static void main(String[] args) {
        Perro per1=new Perro("zuzu","negro","boxer",1.05f,20.8f,0/*Da los datos del constructor*/); // crear un objeto
        Perro per2=new Perro("popeye","blanco","chihuha",0.40f,2.5f,0);
        per1.ladrar();//ejecutar metodos
        per2.saltar();
    }  
}
//______________________________________________________________________________
class Perro{
    //Atributos
    String nombre,color,raza;
    float tamaño,peso;
    int felicidad;
   // metodos
    Perro(String n,String c,String r,float t, float p, int f){//metodo constructor, inicializa los atributos se llama igual a la clase
        nombre=n;//reasignas variables
        color=c;
        raza=r;
        tamaño=t;
        peso=p;
        felicidad=f;
    }
    public/*Ya no es necesario static ya que esta en una clase*/ void ladrar(){
        System.out.println(nombre+": Guau Guau");
    }
    public void saltar(){
        System.out.println(nombre+": Jump");
    }
}
//Abstraccion: Es concentrarnos en los detalles importantes y dejar de lado lo mas importante 
// Modularidad: Dividir en metodos
//Encapsulamiento: Guardar los elementos en unidades.Ejem: El periodo de vida de las variables

//clases no tienen atributos los objetos si
//Instancia ejemplo particular de una clase/subclase