package clase_juego;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
public class Clase_Juego {
    ////////////////////////////////////Menu////////////////////////////////////
    public static void main(String[] args) throws IOException{
        Scanner leer = new Scanner(System.in);
        SerpyEsc[] jugadoresSeryEsc = new SerpyEsc[3];
        Oca[] jugadoresOca = new Oca[3];
        int [] indSeryEsc={1,0};
        int [] indOca={1,0};
        int opc;
        boolean invitar1=true,invitar2=true;
        do {
            System.out.println("1) Jugar Serpientes y Escaleras");
            System.out.println("2) Jugar Oca");
            System.out.println("3) Terminar");
            System.out.print("  Que quieres hacer: ");
            opc=leer.nextInt();
            System.out.println("");
            switch (opc) {
                case 1:
                        if (invitar1==true) {
                            invitar(jugadoresSeryEsc);
                            invitar1=false;
                        }
                        indSeryEsc=rondas(indSeryEsc,jugadoresSeryEsc);
                    break;
                case 2:
                        if (invitar2==true) {
                            invitar(jugadoresOca);
                            invitar2=false;
                        }
//                        jugadoresOca[0].puntos=95;
//                        jugadoresOca[1].puntos=11;
//                        jugadoresOca[2].puntos=25;
                        indOca=rondas(indOca,jugadoresOca);
                    break;
                case 3:
                    System.out.println("=============================== Fin del Juego ===============================");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opc!=3);
    }
    /////////////////////////Rondas/////////////////////////////////////////////
    public static int[] rondas(int[] ind,SerpyEsc[] jugadores) throws IOException{
        int j;
        char pausar;
        boolean pausa,ganaste;
        for (pausa=false;SerpyEsc.ganador==false && pausa==false;ind[0]++) {
            System.out.println("=============================== Ronda "+ind[0]+" =================================");
            for (j=0;j<jugadores.length && SerpyEsc.ganador==false;j++) {
                ganaste=jugadores[j].jugar().SeguirReglas().ganar();
                jugadores[j].mostrar_edo();
                if (ganaste==true)
                    ind[1]=j;
            }
            if (ind[0]%3==0){
                System.out.print("  DESEAS PONER PAUSA ?(S/N): ");
                pausar=(char)System.in.read();
                System.in.read();
                if(pausar=='S' || pausar=='s'){
                    pausa=true;
                    System.out.println("===========================================================================\n");
                }   
            }
        }
        if (pausa==false)
            SerpyEsc.mostrar_ganador(ind[1],jugadores);
        return ind;
    }
    public static int[] rondas(int[] ind, Oca[] jugadores) throws IOException{
        int j;
        char pausar;
        boolean pausa,ganaste;
        for (pausa=false;Oca.ganador==false && pausa==false;ind[0]++) {
            System.out.println("=============================== Ronda "+ind[0]+" ===============================");
            for (j=0;j<jugadores.length && Oca.ganador==false;j++) {
                ganaste=jugadores[j].jugar(/*ind[0],j*/).seguirReglas(jugadores,j).ganar();
                jugadores[j].mostrar_edo();
                if (ganaste==true)
                    ind[1]=j;
            }
            if (ind[0]%3==0){
                System.out.print("  DESEAS PONER PAUSA ?(S/N): ");
                pausar=(char)System.in.read();
                System.in.read();
                if(pausar=='S' || pausar=='s'){
                    pausa=true;
                    System.out.println("===========================================================================\n");
                }   
            }
        }
        if (pausa==false)
            Oca.mostrar_ganador(ind[1],jugadores);
        return ind;
    }
    ////////////////////////Invitar a Jugar/////////////////////////////////////
    public static void invitar(SerpyEsc[] jugadores){
        int i;
        for (i=0;i<jugadores.length;i++) {
            System.out.println(i+1+"° jugador");
            jugadores[i]=SerpyEsc.invitar();
            System.out.println("");
        }
        System.out.println("");
    }
    public static void invitar(Oca[] jugadores){
        int i;
        for (i=0;i<jugadores.length;i++) {
            System.out.println(i+1+"° jugador");
            jugadores[i]=Oca.invitar();
            System.out.println("");
        }
        System.out.println("");
    }
}
///////////////////////////////Clase Juego//////////////////////////////////////
class Juego{
    String nomJug,nomCas;
    int casAct,casAnt,puntos,numDad,numCas;
    Juego(String nom){
        nomJug=nom;
    }
    ////////////////////////////Lanzar Dados////////////////////////////////////
    public void lanzar(int numDad){
        Random ram = new Random();
        int i;
        puntos=0;
        for (i=1;i<=numDad;i++)
            this.puntos+=ram.nextInt(6)+1;
    }
}
/////////////////////////////Clase SerpyEsc/////////////////////////////////////
class SerpyEsc extends Juego{
    static int esc1=5,esc2=30,serp1=45,serp2=20;
    static boolean ganador=false;
    SerpyEsc(String nom) {
        super(nom);
        numCas=60;
        casAct=0;
        casAnt=0;
        puntos=0;
        numDad=1;
        nomCas="Casilla Normal";
    }
    ////////////////////////////Invitar al Jugador//////////////////////////////
    public static SerpyEsc invitar(){
        String nom;
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        nom=leer.nextLine();
        SerpyEsc obj=new SerpyEsc(nom);
        return obj;
    }
    ////////////////////////////Jugar///////////////////////////////////////////
    public SerpyEsc jugar(){
        int retroceder;
        this.lanzar(numDad);
        casAnt=casAct;
        this.casAct+=puntos;
        if (casAct>numCas) { //Retroceso
            retroceder=casAct-numCas;
            casAct=numCas;
            casAct-=retroceder;
        }
        return this;
    }
    //////////////////////////////Seguir Reglas/////////////////////////////////
    public SerpyEsc SeguirReglas(){
        if (casAct==esc1 || casAct==esc2) {//Escaleras
            if (casAct==esc1){
                casAct=25;
                nomCas="Casilla Escalera 1 (casilla 5)";
            } 
            else {
                casAct=60;
                nomCas="Casilla Escalera 2 (casilla 30)";
            }
        } 
        else {//Serpientes
            if (casAct==serp1 || casAct==serp2) {
                if (casAct==serp1) {
                    casAct=20;
                    nomCas="Casilla Serpiente 1 (casilla 45)";
                } 
                else {
                    casAct=8;
                    nomCas="Casilla Serpiente 2 (casilla 20)";
                }   
            }
            else//Casilla Normal
                nomCas="Casilla Normal";
        }
        return this;
    }
    /////////////////////////////El Jugador Gano////////////////////////////////
    public boolean ganar(){
        if (casAct==numCas){
            ganador=true;
            return true;
        }
        return false;
    }
    /////////////////////////////Mostrar el estado del Jugador//////////////////
    public void mostrar_edo(){
        System.out.println("Nombre: "+nomJug);
        System.out.println("Casilla anterior: "+casAnt);
        System.out.println("Puntos Obtenidos: "+puntos);
        System.out.println("Se cayo en la "+nomCas);
        System.out.println("Casilla Actual: "+casAct);
        if (ganador==true)
            System.out.println("-----Juego Terminado-----");
        System.out.println("");
    }
    /////////////////////////Mostrar al Ganador/////////////////////////////////
    public static void mostrar_ganador(int g,SerpyEsc[] jugadores){
        int i;
        System.out.println("=============================== FELIZIDADES GANASTES "+jugadores[g].nomJug.toUpperCase()+" ===============================");
        System.out.println("-GANADOR");
        jugadores[g].mostrar_edo();
        System.out.println("\n-OTROS JUGADORES");
        for (i=0;i<jugadores.length;i++)
            if (i!=g)
                jugadores[i].mostrar_edo();
        System.out.println("==============================================================\n");
    } 
}
///////////////////////////////Clase Oca////////////////////////////////////////
class Oca extends Juego{
    static int posada=19,puente1=6,puente2=84,pozo=60,carcel=56,calavera=95;
    static boolean ganador=false;
    int contPosada,contPozo;
    boolean indPosada,indPozo,indCarcel;
    Oca(String nom) {
        super(nom);
        numCas=99;
        numDad=2;
        casAct=0;
        casAnt=0;
        puntos=0;
        nomCas="Casilla Normal";
        indPosada=false;
        indPozo=false;
        indCarcel=false;
        contPozo=0;
        contPosada=0;
    }
    ////////////////////////////Invitar al Jugador//////////////////////////////
    public static Oca invitar(){
        String nom;
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        nom=leer.nextLine();
        Oca obj=new Oca(nom);
        return obj;
    }
    ////////////////////////////Jugar///////////////////////////////////////////
    public Oca jugar(/*int i,int j*/){
        int retroceder;
        if (indPosada==true) { //Saltar posada
            nomCas="Casilla Posada y Perderas este turno";
            indPosada=false;
            contPosada++;
        } 
        else {
            if (indPozo==true) {// Saltar Pozo
                nomCas="Casilla Pozo y Perderas este turno";
                contPozo++;
                if (contPozo==2)
                    indPozo=false;
            } 
            else { 
                if (indCarcel==true) { //Saltar carcel
                    nomCas="Sigues en la Carcel";
                } 
                else {//Jugar
                    casAnt=casAct;
//                    if (i>1)
                    this.lanzar(numDad);
                    this.casAct+=puntos;
                    if (casAct>numCas) {
                        retroceder=casAct-numCas;
                        casAct=numCas;
                        casAct-=retroceder;
                    }
                    nomCas="Casilla Normal";
                    if (casAct==numCas)
                        nomCas="la ultima casilla";
                    contPosada=0;
                    contPozo=0;
//                    if (i==3 && j==2)
//                        this.casAct=56;
                }
            }
        }
        return this;
    }
    ////////////////////////////Sacar de la Carcel//////////////////////////////
    public void sacarCarcel(Oca[] jugadores,int j){
        int i;
        for (i=0;i<jugadores.length;i++) {
            if (i!=j)
                jugadores[i].indCarcel=false;
        }
    }
    ////////////////////////////Seguir Regalas//////////////////////////////////
    public Oca seguirReglas(Oca[] jugadores,int j){
        int i,cont;
        if (casAct%9==0 && casAct!=99 && casAct!=0) { //Si es Oca
            if (casAct==9){// si fue la primera oca
                nomCas="La 1° Oca y saltaste ala ultima casilla";
                casAct=99;
            }
            else{//Las demas
                casAct+=puntos;
                nomCas="Casilla de Oca y voliste a avanzar "+puntos;
            }
        }
        if (casAct==posada && contPosada==0){//Cayo en Posada
            indPosada=true;
            nomCas="Casilla Posada y perderas un turno";
        }
        if (casAct==puente1) {//Cayo en el puente 1
            casAct=puente2;
            nomCas="Casilla Puente 1 e iras al Puente 2 casilla 84";
        } else { // Callo en el puente 2
            if (casAct==puente2){
                casAct=puente1;
                nomCas="Casilla Puente 2 e iras al Puente 1 casilla 6";
            }   
        }
        if (casAct==pozo && contPozo==0) { //Cayo en el pozo
            indPozo=true;
            nomCas="Casilla Pozo y perderas 2 turnos";
        }
        if (casAct==carcel) { //Cayo en la carcer
            indCarcel=true;
            nomCas="Casilla Carcel estaras aqui hasta que alguien te saque";
            for (i=0,cont=0;i<jugadores.length;i++) { //Hay alguien mas en la carcel
                if (i!=j && jugadores[i].indCarcel==true)
                    cont++;
            }
            if  (cont>0)
                this.sacarCarcel(jugadores, j);
        }
        if (casAct==calavera) { //Cayo en la calavera
            casAct=1;
            nomCas="Casilla Calavera regresaras a la casilla 1";
        }
        return this;
    }
    /////////////////////////////El Jugador Gano////////////////////////////////
    public boolean ganar(){
        if (casAct==numCas){
            ganador=true;
            return true;
        }
        return false;
    }
    /////////////////////////////Mostrar el estado del Jugador//////////////////
    public void mostrar_edo(){
        System.out.println("Nombre: "+nomJug);
        System.out.println("Casilla Anterior: "+casAnt);
        System.out.println("Puntos Obtenidos: "+puntos);
        System.out.println("Caistes en una "+nomCas);
        System.out.println("Casilla Actual: "+casAct);
        if (ganador==true)
            System.out.println("-----Juego Terminado-----");
        System.out.println("");
    }
    /////////////////////////Mostrar al Ganador/////////////////////////////////
    public static void mostrar_ganador(int g,Oca[] jugadores){
        int i;
        System.out.println("=============================== FELIZIDADES GANASTES "+jugadores[g].nomJug.toUpperCase()+" ===============================");
        System.out.println("-GANADOR");
        jugadores[g].mostrar_edo();
        System.out.println("\n-OTROS JUGADORES");
        for (i=0;i<jugadores.length;i++)
            if (i!=g)
                jugadores[i].mostrar_edo(); 
        System.out.println("==============================================================\n");
    }
}