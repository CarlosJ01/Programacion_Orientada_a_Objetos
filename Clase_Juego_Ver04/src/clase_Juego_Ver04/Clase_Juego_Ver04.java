package clase_Juego_Ver04;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
public class Clase_Juego_Ver04 {
    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        Juego [] jugadores;
        int [] indSeryEsc={1,0,0};
        int [] indOca={1,0,0};
        int opc,medio;
        boolean invitar1=true,invitar2=true;
        ////////////////////////////Empiezo del Juego///////////////////////////
        System.out.print("Cuantos Jugadores de Serpientes y Escaleras son: ");
        indSeryEsc[2]=leer.nextInt();
        System.out.print("Cuantos Jugadores de Oca son: ");
        indOca[2]=leer.nextInt();
        jugadores=new Juego[indSeryEsc[2]+indOca[2]];
        medio=indSeryEsc[2];
        System.out.println("\n===========================================================================\n");
        do {
            System.out.println("1) Jugar Serpientes y Escaleras");
            System.out.println("2) Jugar Oca");
            System.out.println("3) Terminar");
            System.out.print("  Que quieres hacer: ");
            opc=leer.nextInt();
            System.out.println("");
            switch (opc) {
                case 1:
                    if (indSeryEsc[2]==0) {
                        System.out.println("No hay jugadores\n");
                        System.out.println("===========================================================================\n");
                    } 
                    else {
                        if (invitar1==true) {
                            invitar(jugadores,0,medio,"SerpyEsc");
                            invitar1=false;
                        }
                        indSeryEsc=rondas(indSeryEsc,jugadores,0,medio,"SerpyEsc");
                    }
                    break;
                case 2:
                    if (indOca[2]==0) {
                        System.out.println("No hay jugadores\n");
                        System.out.println("===========================================================================\n");
                    } 
                    else {
                        if (invitar2==true) {
                            invitar(jugadores,medio,jugadores.length,"Oca");
                            invitar2=false;
                        }
                        indOca=rondas(indOca,jugadores,medio,jugadores.length,"Oca");
                    }
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
    public static int[] rondas(int[] ind,Juego jugadores[],int inicio,int fin,String juego) throws IOException{
        char pausar;
        boolean pausa,ganaste,ganador;
        int i;
        if (juego.equalsIgnoreCase("SerpyEsc"))
            ganador=SerpyEsc.ganador;
        else
            ganador=Oca.ganador;
        for (pausa=false;ganador==false && pausa==false;ind[0]++) {
            System.out.println("=============================== Ronda "+ind[0]+" =================================");
            for (i=inicio;i<fin && ganador==false;i++) {
                ganaste=jugadores[i].jugar().SeguirReglas(jugadores,i,inicio).ganar();//Poliformismo
                jugadores[i].mostrar_edo();//Poliformismo
                if (ganaste==true)
                    ind[1]=i;
                if (juego.equalsIgnoreCase("SerpyEsc"))
                    ganador=SerpyEsc.ganador;
                else
                    ganador=Oca.ganador;
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
            Juego.mostrar_ganador(ind[1],jugadores,inicio,fin);
        return ind;
    }
    ////////////////////////Invitar a Jugar/////////////////////////////////////
    public static void invitar(Juego[] jugadores,int prin,int fin,String juego){
        Scanner leer = new Scanner(System.in);
        int i=1;
        String nom;
        for (;prin<fin;prin++,i++) {
            System.out.println(i+"° jugador");
            System.out.print("Nombre del jugador: ");
            nom=leer.nextLine();
            if (juego.equalsIgnoreCase("SerpyEsc"))
                jugadores[prin]=new SerpyEsc(nom);
            else
                jugadores[prin]=new Oca(nom);
            System.out.println("");
        }
        System.out.println("");
    }
}


///////////////////////////////Clase Juego//////////////////////////////////////
class Juego implements Game{
    String nomJug,nomCas;
    int casAct,casAnt,puntos,numDad,numCas;
    Juego(String nom){
        nomJug=nom;
    }
    ////////////////////////////Lanzar Dados////////////////////////////////////
    @Override
    public void lanzar(int numDad){
        Random ram = new Random();
        int i;
        puntos=0;
        for (i=1;i<=numDad;i++)
            this.puntos+=ram.nextInt(6)+1;
    }
    /////////////////////////////Mostrar el estado del Jugador//////////////////
    @Override
    public void mostrar_edo(){
        System.out.println("Nombre: "+nomJug);
        System.out.println("Casilla anterior: "+casAnt);
        System.out.println("Puntos Obtenidos: "+puntos);
        System.out.println("Se cayo en la "+nomCas);
        System.out.println("Casilla Actual: "+casAct);
        System.out.println("");
    }
    /////////////////////////Mostrar al Ganador/////////////////////////////////
    public static void mostrar_ganador(int g,Juego[] jugadores,int inicio, int fin){
        System.out.println("=============================== FELIZIDADES GANASTES "+jugadores[g].nomJug.toUpperCase()+" ===============================");
        System.out.println("-GANADOR");
        jugadores[g].mostrar_edo();
        System.out.println("\n-OTROS JUGADORES");
        for (;inicio<fin;inicio++)
            if (inicio!=g)
                jugadores[inicio].mostrar_edo();
        System.out.println("==============================================================\n");
    }
    //Metodos solo para sobrescribir
    public Juego jugar(){
        return this;
    }
    public Juego SeguirReglas(Juego[] jugadores,int j,int inicio){
        return this;
    }
    @Override
    public boolean ganar(){
        return true;
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
    ////////////////////////////Jugar///////////////////////////////////////////
    @Override
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
    @Override
    public SerpyEsc SeguirReglas(Juego[] jugadores,int j,int inicio){
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
    @Override
    public boolean ganar(){
        if (casAct==numCas){
            ganador=true;
            return true;
        }
        return false;
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
    ////////////////////////////Jugar///////////////////////////////////////////
    @Override
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
                }
            }
        }
        return this;
    }
    ////////////////////////////Seguir Regalas//////////////////////////////////
    @Override
    public Oca SeguirReglas(Juego[] jugadores,int j,int inicio){
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
            this.sacarCarcel(jugadores, j,inicio);
        }
        if (casAct==calavera) { //Cayo en la calavera
            casAct=1;
            nomCas="Casilla Calavera regresaras a la casilla 1";
        }
        return this;
    }
    /////////////////////////////El Jugador Gano////////////////////////////////
    @Override
    public boolean ganar(){
        if (casAct==numCas){
            ganador=true;
            return true;
        }
        return false;
    }
    ////////////////////////////Sacar de la Carcel//////////////////////////////
    public void sacarCarcel(Juego[] copiar,int j,int inicio){
        int i,cont;
        Oca[] jugadores=new Oca[copiar.length];
        for (i=0;i<copiar.length;i++)
            jugadores[i]=(Oca)copiar[i];
        for (i=inicio,cont=0;inicio<jugadores.length;inicio++) { //Hay alguien mas en la carcel
                if (i!=j && jugadores[i].indCarcel==true)
                    cont++;
        }
        if  (cont>0){
            for (i=inicio;i<jugadores.length;i++) {
                if (i!=j)
                    jugadores[i].indCarcel=false;
            }
        }
        for (i=0;i<copiar.length;i++)
            copiar[i]=(Juego)jugadores[i];
    }
}