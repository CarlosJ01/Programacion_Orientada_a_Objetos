package metodo_generico;
public class Metodo_Generico { // Clase Principal
    public static void main(String[] args) {
        System.out.println(M_Generico.aCadena(40, 60));
        M_Generico.imprimir("Hola", 45.6);
    }
}
///////////////////////////////////////////////////////////////
class M_Generico { //Clase genérica
    static String x;
    ///////Metodo Generico
    public static <T> String aCadena(T a, T b) {
        x=a.toString()+" "+b.toString();
        return x;
    }
    public static <T> void imprimir(T a, T b){
        System.out.println("Los datos son "+a+" y "+b);
    }
}