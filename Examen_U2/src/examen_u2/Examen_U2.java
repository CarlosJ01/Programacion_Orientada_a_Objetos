//Clase Serpientes y Escaleras
package examen_u2;
import java.util.Scanner;
import java.util.Random;
public class Examen_U2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        SerpyEsc[] jugadores = new SerpyEsc[3];
        String nom;
        int i,j,gan=0;
        boolean ganaste;
        System.out.print("Con cuantos dados van a jugar los jugadores ?: ");
        SerpyEsc.numDad=leer.nextInt();
        System.out.println("");
        leer.nextLine();
        for (i=0;i<jugadores.length;i++) {
            System.out.print("Nombre del "+(i+1)+"° Jugador: ");
            nom=leer.nextLine();
            jugadores[i]=new SerpyEsc(nom);
        }
        System.out.println("");
        for (i=1;SerpyEsc.ganador==false;i++) {
            System.out.println("========================= Ronda "+i+" ===========================");
            for (j=0;j<jugadores.length && SerpyEsc.ganador==false;j++) {
                ganaste=jugadores[j].jugar();
                if (ganaste==true)
                    gan=j;
                jugadores[j].mostrar_edo();
            }
        }
        SerpyEsc.mostrar_ganador(gan,jugadores);
    }
}
class SerpyEsc{
    String nom,nomCasAnt;
    static boolean ganador=false;
    static int numCas=60,esc1=5,esc2=30,serp1=45,serp2=20,numDad;
    int casAct,casAnt,puntos;
    SerpyEsc(String nom){
        this.nom=nom;
        casAct=0;
        casAnt=0;
        nomCasAnt="Casilla Normal";
        puntos=0;
    }
    public boolean jugar(){
        int retroceder;
        this.lanzar(numDad);
        casAnt=casAct;
        this.casAct+=puntos;
        if (casAct>numCas) {
            retroceder=casAct-numCas;
            casAct=numCas;
            casAct-=retroceder;
        }
        this.seguir_Reglas();
        if (casAct==60){
            ganador=true;
            return true;
        }
        return false;
    }
    public void lanzar(int numDad){
        Random ram = new Random();
        int i;
        puntos=0;
        for (i=1;i<=numDad;i++)
            this.puntos+=ram.nextInt(6)+1;
    }
    public void seguir_Reglas(){
        if (casAct==esc1 || casAct==esc2) {
            if (casAct==esc1){
                casAct=25;
                nomCasAnt="Casilla Escalera 1 (casilla 5)";
            } 
            else {
                casAct=60;
                nomCasAnt="Casilla Escalera 2 (casilla 30)";
            }
        } 
        else {
            if (casAct==serp1 || casAct==serp2) {
                if (casAct==serp1) {
                    casAct=20;
                    nomCasAnt="Casilla Serpiente 1 (casilla 45)";
                } 
                else {
                    casAct=8;
                    nomCasAnt="Casilla Serpiente 2 (casilla 20)";
                }   
            }
            else
                nomCasAnt="Casilla Normal";
        }
    }
    public void mostrar_edo(){
        System.out.println("Nombre: "+nom);
        System.out.println("Casilla anterior: "+casAnt);
        System.out.println("Puntos Obtenidos: "+puntos);
        if (!(nomCasAnt.equalsIgnoreCase("Casilla Normal")))
            System.out.println("Se cayo en la "+nomCasAnt);
        System.out.println("Casilla Actual: "+casAct);
        if (ganador==true)
            System.out.println("-----Juego Terminado-----");
        System.out.println("");
    }
    static public void mostrar_ganador(int g,SerpyEsc[] jugadores){
        int i;
        System.out.println("=============== FELIZIDADES GANASTES "+jugadores[g].nom.toUpperCase()+" ===============");
        System.out.println("-GANADOR");
        jugadores[g].mostrar_edo();
        System.out.println("\n-OTROS JUGADORES");
        for (i=0;i<jugadores.length;i++)
            if (i!=g)
                jugadores[i].mostrar_edo(); 
    }
}