package excepciones;
public class Excepciones {
    public static void main(String[] args) {
        int arr[] = new int [3];
        int valor=8,ubic=7;
        try {
            ubicar(arr,valor,ubic);
        }
        catch (ArrayIndexOutOfBoundsException fueraLimites){
            System.out.println("No existe la celda "+ubic+", celda maxima es "+(arr.length));
        }
        System.out.println("Fin del programa");
    }
    public static void ubicar(int a[],int x, int u){
        a[u]=x;
    }
}