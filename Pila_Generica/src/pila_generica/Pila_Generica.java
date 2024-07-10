package pila_generica;
// CLASE PRINCIPAL
public class Pila_Generica {
    public static void main(String[] args) {
        Generica <String> exams=new Generica <String>(4);
        Generica <Character> carac=new Generica <Character>(3);
        Generica <pelota> pel=new Generica <pelota>(3);
        Generica <Float> flo=new Generica <>();
        System.out.println(flo.devolverClase(23.4f));
        System.out.println(exams.devolverClase("Morelia"));
        System.out.println(carac.devolverClase('R'));
        pel.agregar(new pelota("azul"));
        pel.agregar(new pelota("verde"));
        pel.agregar(new pelota("roja"));
        System.out.println(pel);
        pelota p=pel.eliminar();
        System.out.println("Eliminada: pelota "+ p.color);
        System.out.println(pel);
        carac.agregar('T');
        carac.agregar('E');
        carac.agregar('C');
        carac.agregar('Z'); //ya no lo agrega
        System.out.println(carac);
        System.out.println("Eliminado: "+carac.eliminar());
        exams.agregar("Chana");
        System.out.println("Examenes por revisar: "+exams);
        exams.agregar("Margarito");
        exams.agregar("Isabel");
        exams.agregar("Juan");
        System.out.println("Examens por revisar: "+exams);
        System.out.println("examen de "+ exams.eliminar()+" fue revisado");
        System.out.println("examen de "+ exams.eliminar()+" fue revisado");
        System.out.println("examen de "+ exams.eliminar()+" fue revisado");
        System.out.println("examen de "+ exams.eliminar()+" fue revisado");
        exams.agregar("Lorenzo");
        System.out.println("Examenes por revisar: "+exams);
    }
}
class Generica <T>{ //CLASE GENERICA DE UNA PILA, ULTIMAS ENTRADAS-PRIMERAS SALIDAS
    T arr[];
    int cont;
    public Generica(){
        arr = (T[]) new Object[5];
        cont=0; 
    }
    //************************************************
    public Generica(int tam){
        arr = (T[]) new Object[tam];
        cont=0; 
    }
    //************************************************
    public T eliminar(){
        T elem=null;
        if (!vacia()){
            cont--;
            elem=arr[cont];
        }
        return elem;
    }
    //***********************************************
    public boolean vacia(){
        boolean resp=false;
        if (cont==0)
            resp=true;
        return resp;
    }
    //***********************************************
    public void agregar(T elem){
        if (cont<arr.length){
            arr[cont]=elem;
            cont++;
        }
    }
    //***********************************************
    @Override
    public String toString(){
        int i=0;
        pelota p;
        String c="";
        for(i=0;i<cont;i++){
            if (arr[i].getClass().getSimpleName().equalsIgnoreCase("pelota")){
                p= (pelota)arr[i];
            c+=p.color+", ";
            }
            else
                c+=arr[i].toString()+", ";
        }
        return c; 
    }
    //************************************************
    public String devolverClase(T algo){
        String x="";
        if (algo.getClass().getName().equalsIgnoreCase("java.lang.Float")){
            x+="El dato "+algo.toString()+" es flotante";
        }
        else if (algo.getClass().getName().equalsIgnoreCase("java.lang.String")){
            String s=algo.toString();
            x+="El dato \""+algo.toString()+"\" es cadena";
        }
        return x;
    }
}
    //////////////////////////////////////////// Clase Pelota
class pelota{
    String color;
    pelota(String c){
        color=c;
    }
}