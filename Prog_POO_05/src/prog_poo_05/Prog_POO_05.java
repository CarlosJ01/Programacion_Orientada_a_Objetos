package prog_poo_05;
import java.util.Scanner;
public class Prog_POO_05 {
    public static void main(String[] args) {
        SerpyEsc serpientes[]=new SerpyEsc[3];
        Oca ocas[]=new Oca[3];
        int i;
        for (i=0;i<serpientes.length;i++)
            serpientes[i]=SerpyEsc.invitar();
        for (i=0;i<ocas.length;i++)
            ocas[i]=Oca.invitar();
        System.out.println("---------------------------------------Jugadores------------------------------------");
        for (i=0;i<serpientes.length;i++)
            serpientes[i].mostrar_edo();
        for (i=0;i<ocas.length;i++)
            ocas[i].mostrar_edo();
    }
}
//--------------------------------Clase Juego-----------------------------------
class Juego{
    int num_cas;
    String nom_jug;
    int cas_act;
    Juego(String nom){
        nom_jug=nom;
    }
    public int lanzar(){
        int pts=0;
        //codigo
        return pts;
    }
    public void jugar(){
        //codigo;
    }
}
//------------------------------Clase Serpientes y Escaleras--------------------
class SerpyEsc extends Juego{
    int cas_ant;
    static int esc1=5,esc2=30,serp1=45,serp2=20;
    SerpyEsc(String nom) {
        super(nom);
        num_cas=60;
    }
    public static SerpyEsc invitar(){
        String nom;
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        nom=leer.nextLine();
        SerpyEsc obj=new SerpyEsc(nom);
        return obj;
    }
    public void mostrar_edo(){
        System.out.println("Serpientes y Escaleras");
        System.out.println("Nombre: "+nom_jug+" Casilla actual: "+cas_act);
    }
}
//-------------------------------Clase Oca--------------------------------------
class Oca extends Juego{
    static int carcel=56,posada=19,puente1=6,puente2=84,pozo=60;
    public Oca(String nom) {
        super(nom);
        num_cas=99;
    }
    public static Oca invitar(){
        String nom;
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        nom=leer.nextLine();
        Oca obj=new Oca(nom);
        return obj;
    }
    public void mostrar_edo(){
        System.out.println("Oca");
        System.out.println("Nombre: "+nom_jug+" Casilla actual: "+cas_act);
    }
}