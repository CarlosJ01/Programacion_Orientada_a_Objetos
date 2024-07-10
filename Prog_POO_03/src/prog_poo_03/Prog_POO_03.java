//Parte 2 del programa 02
package prog_poo_03;
import java.util.Random;
import java.util.Scanner;
public class Prog_POO_03 {
    public static void main(String[] args) {
        Random r=new Random();
        Perro p1 = new Perro("Lala");
        p1=new Perro("lolo","blanco");// El apuntador señala a un nuevo p1 y el vijo lo recoge el recolector
        Perro perrera[]=new Perro[10];//Arreglo de objetos
        int perros,i;
        for (i=0;i<r.nextInt(9)+1;i++)//ingresar los perros
            perrera[i]=ingresar();
        System.out.println("Perror capturados son: ");
        for (i=i-1;i>=0;i--)
        perrera[i].mostrar_edo();
    }
    public static Perro ingresar(){
        Scanner leer = new Scanner(System.in);
        Perro p1;
        String nom,col;
        System.out.print("Nombre del perro: ");
        nom=leer.nextLine();
        System.out.print("Color del perro: ");
        col=leer.nextLine();
        System.out.println("");
        p1=new Perro(nom,col);//crear los perros para regresarlos al arreglo
        return p1;
    }
}
class Perro{
    private String nombre,color,raza; // private para que los atributos no se puedan cambiar desde main
    private float tamaño,peso;
    private int felicidad;
    char vacunas[]=new char[5];//nuevo areglo para todos los objetos de la clase
    String nonvac[]={"Rabia","parvovirus","sarna","pulgas","moquillo"};
    Perro(String n,String c,String r,float t, float p, int f){
        nombre=n;
        raza=r;
        tamaño=t;
        peso=p;
        felicidad=f;
    }
    Perro(String n,String c){//Otro constructor con otro parametros y se el objeto se va con quien lo satisface
        nombre=n;
        color=c;
        raza="Callejero";
        felicidad=3;
    }
    Perro(String n){//Otro constructor con otro parametros y se el objeto se va con quien lo satisface
        nombre=n;
        color="Negro";
        raza="Callejero";
        felicidad=3;
    }
    public void ladrar(){
        System.out.println(nombre+": Guau Guau");
        felicidad=0;//cambiar el valor del atributo del objeto especifico que llamo al metodo
    }
    public void saltar(){
        System.out.println(nombre+": Jump");
        felicidad=3;//cambiar el atributo del objeto especifico que llamo al metodo
    }
    public void mostrar_edo(){
        if (felicidad == 0)
            System.out.println(nombre+" No esta feliz");
        else
            System.out.println(nombre+" Si esta feliz");
    }
}