package prog_poo_06;
import java.util.Scanner;
public class Prog_POO_06 {
    public static void main(String[] args) {
        Animal anim = new Serpiente("1","Baba");//Padre ´puntancdo a un  hijo
        anim.asustar();
        System.out.println("ES: "+anim.getClass().getName());//Sacar el tipo del objeto de la referencia
        System.out.println("ES: "+anim.getClass().getSimpleName());//Sacar el tipo del objeto de la referencia
        System.out.println("");
        anim = new Perro("2","coquer");//Padre ´puntancdo a otro  hijo
        anim.asustar();
        System.out.println("ES: "+anim.getClass().getName());//Sacar el tipo del objeto de la referencia
        System.out.println("ES: "+anim.getClass().getSimpleName());//Sacar el tipo del objeto de la referencia
        System.out.println("");
        anim = new Pajaro("3","Canario");//Padre ´puntancdo a otro  hijo
        anim.asustar();
        System.out.println("ES: "+anim.getClass().getName());//Sacar el tipo del objeto de la referencia
        System.out.println("ES: "+anim.getClass().getSimpleName());//Sacar el tipo del objeto de la referencia
        System.out.println("");
        //compara el tipo del obje y ejecuta sus propio metodos de cada clase
        if (anim.getClass().getSimpleName().equalsIgnoreCase("Pajaro")) {
            Pajaro x = (Pajaro)anim;
            x.picotear();
        }
        if (anim.getClass().getSimpleName().equalsIgnoreCase("Perro")) {
            Perro x = (Perro)anim;
            x.ladrar();
        }
        if (anim.getClass().getSimpleName().equalsIgnoreCase("Serpiente")) {
            Serpiente x=(Serpiente)anim;
            x.asfixiar();
        }
        System.out.println("");
        System.out.println("1"+anim.toString());
        System.out.println("");
        //Arreglo de la clase padre
        Animal anims[]=new Animal[3];
        //Llenar el objeto
        for (int i=0;i<anims.length;i++) {
            anims[i]=crearAnimal(i);
        }
        for (int i=0;i<anims.length;i++) {
            if (anims[i]!=null) {
                anims[i].asustar();
                if (anims[i].getClass().getSimpleName().equalsIgnoreCase("Pajaro")) {
                    Pajaro x = (Pajaro)anims[i];
                    x.picotear();
                }
                if (anims[i].getClass().getSimpleName().equalsIgnoreCase("Perro")) {
                    Perro x = (Perro)anims[i];
                    x.ladrar();
                }
                if (anims[i].getClass().getSimpleName().equalsIgnoreCase("Serpiente")) {
                    Serpiente x=(Serpiente)anims[i];
                    x.asfixiar();
                }         
            }
            else
                System.out.println("Vacio");
        }
    }
    //Crear Objeto
    public static Animal crearAnimal(int i){
    String tipo,nom,raz;
    Animal obj=null;
    Scanner leer = new Scanner(System.in);
    System.out.println("Animal "+(i+1));
    System.out.print("Que animal quieres crear: ");
    tipo=leer.nextLine();
    System.out.print("Cual es su nombre : ");
    nom=leer.nextLine();
    System.out.print("Cual es su raza : ");
    raz=leer.nextLine();
        if (tipo.equalsIgnoreCase("Pajaro")) {
            System.out.println("Crear un pajaro");
            obj=new Pajaro(nom,raz);
        }
        if (tipo.equalsIgnoreCase("Perro")) {
            System.out.println("Crear un perro");
            obj=new Perro(nom,raz);
        }
        if (tipo.equalsIgnoreCase("Serpiente")) {
            System.out.println("Crear un pajaro");
            obj=new Serpiente(nom,raz);
        }
        System.out.println("");
        return obj;
    }
}
class Animal{
    String nom;
    Animal (String nom){
        this.nom=nom;
    }
    public void asustar(){
        System.out.println("Asustar animal");
    }
}
class Perro extends Animal{
    String Raza;
    public Perro(String nom,String raza) {
        super(nom);
        this.Raza=raza;
    }
    @Override
    public void asustar(){
        System.out.println("Asusta Perro: Corre");
    }
    public void ladrar(){
        System.out.println("Gua Gua");
    }
}
class Pajaro extends Animal{
    String Raza;
    public Pajaro(String nom,String raza) {
        super(nom);
        this.Raza=raza;
    }
    @Override
    public void asustar(){
        System.out.println("Asusta Pajaro: Vuela");
    }
    public void picotear(){
        System.out.println("picotea");
    }
}
class Serpiente extends Animal{
    String Raza;
    public Serpiente(String nom,String raza) {
        super(nom);
        this.Raza=raza;
    }
    @Override
    public void asustar(){
        System.out.println("Asusta Serpiente: Ataca");
    }
    public void asfixiar(){
        System.out.println("Aflixia");
    }
}