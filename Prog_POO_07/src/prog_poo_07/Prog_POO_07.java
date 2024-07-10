package prog_poo_07;
import java.util.Scanner;
public class Prog_POO_07 {
    public static void main(String[] args) {
        animales anims[]=new animales[4];
        for (int i=0;i<anims.length;i++){
            anims[i]= crear_animal();
        }
        /* HARA LO ESPECIFICO DE ACUERO AL TIPO DE ANIMAL */
        for (int i=0;i<anims.length;i++){
            System.out.println("===================== Animal: "+(i+1)+" ==================");
           if(anims[i]!=null){
              anims[i].asustar();
              anims[i].comer();
              if (anims[i].getClass().getSimpleName().compareToIgnoreCase("pajaro")==0){
                 pajaro x=(pajaro)anims[i];
                 x.picotear();
              }
              if (anims[i].getClass().getSimpleName().compareToIgnoreCase("perro")==0){
                 perro x=(perro)anims[i];
                 x.ladrar();
              }
             if (anims[i].getClass().getSimpleName().compareToIgnoreCase("serpiente")==0){
               serpiente x=(serpiente)anims[i];
               x.asfixiar();

             }
           }
           else{
               System.out.println("Casilla vacia");
           }
           System.out.println("");
        }   
    }
    public static animales crear_animal(){
    String tipo,nom,raz;
    animales a;
    Scanner l=new Scanner(System.in);
    System.out.print("Qué tipo de animal quieres: ");
    tipo=l.next();
    System.out.print("cual sera su nombre: ");
    nom=l.next();
    System.out.print("cual sera su raza: ");
    raz=l.next();
    if(tipo.compareTo("pajaro")==0){
        System.out.println("Has creado un pajaro");    
        a=new pajaro(nom,raz);
    }
    else if(tipo.compareTo("perro")==0){
        System.out.println("Has creado un perro");    
        a=new perro(nom,raz);
    }
    else if(tipo.compareTo("serpiente")==0){
        System.out.println("Has creado un serpiente");    
        a=new serpiente(nom,raz);
    }
    else {
        System.out.println("No existe ese animal");
        a=null;
    }
    System.out.println("");
   return a; 
}
}

abstract class animales{
    String nombre;
    animales(String nombre){
        this.nombre=nombre;
    }
    public abstract void asustar();
    public abstract void comer();
}

////////////////////////////////////////////

class perro extends animales{
    String raza;
    perro(String n,String raza){
        super(n);
        this.raza=raza;
    }
    @Override
    public void asustar(){
        System.out.println("UUUUUUUUyyyy  DEL PERRO");   
    }
    @Override
    public void comer(){
        System.out.println("Perro Come");
    }
    public void ladrar(){
        System.out.println("GUAU  GUAU");   
    }
}

///////////////////////////////////////////////

class pajaro extends animales{
    String raza;
    pajaro(String n,String raza){
        super(n);
        this.raza=raza;
    }
    @Override
    public void asustar(){
    System.out.println("UUUUUUUUyyyy  DEL PAJARO");     
    }
    @Override
    public void comer(){
        System.out.println("Pajaro Come");
    }
    public void picotear(){
        System.out.println("Piki  Piki");   
    }
}

/////////////////////////////////////////

class serpiente extends animales{
    String raza;
    serpiente(String n,String raza){
        super(n);
        this.raza=raza;
    }
    @Override
    public void asustar(){
        System.out.println("UUUUUUUUyyyy  DE LA SERPIENTE");   
    }
    @Override
    public void comer(){
        System.out.println("Serpiente Come");
    }
    public void asfixiar(){
        System.out.println("AAAAAAAGGGGGGGHHHHHH");   
    }    
}