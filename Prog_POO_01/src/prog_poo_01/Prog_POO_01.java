package prog_poo_01;
import java.util.*;
public class Prog_POO_01 {
    public static void main(String[] args) {
        int arr[]=new int [6];
        int a=8,b=64,i;
        System.out.println("a= "+a+" b= "+b);
        System.out.println(intercambio(a,b)); //llamado de metodo
        System.out.println("a= "+a+" b= "+b);
        System.out.println("____________________________________________________");
        System.out.print(a+" + "+b+" = ");
        System.out.println(suma(a,b));
        a=-34;
        b=75;
        System.out.print(a+" + "+b+" = ");
        System.out.println(suma(a,b));
        System.out.println("____________________________________________________");
        a=8;
        b=7;
        System.out.println(modulo(/*Argumentos (*/a,b/*)*/));
        System.out.println("____________________________________________________");
        System.out.println(terCar("Morelia"));
        System.out.println(terCar("Hola"));
        System.out.println(terCar("Tec"));
        System.out.println(terCar("Hi"));
        System.out.println("____________________________________________________");
        System.out.println(reversa("Morelia"));
        System.out.println("____________________________________________________");
        llenar(arr);
        for (i=0;i<arr.length;i++) {
            System.out.println("La celda "+i+" Tiene: "+arr[i]);
        }
    }
    
    public static/*Todo metodo debe ser estatico si no tiene objetos*/ int intercambio(/*Parametros (*/int x, int y/*)*/){ //Las variables se copean
        int aux=x;
        x=y;
        y=aux;
        System.out.println("El intercambio x= "+x+" y="+y);
        return x;
    }
    
    public static int suma(int a, int b){
        return a+b/*Puede regresar resultados sin almacenarlos*/;
    }
    
    public static float modulo (int a,int b){
        return ((float)a/b)-((int)a/b);
    }
    
    public static char terCar(String cad){
        if (cad.length()>=3)
            return cad.charAt(2);
        else
            return '0';
    }
    
    public static String reversa (String cad){
        StringBuilder rev = new StringBuilder(cad);
        return rev.reverse().toString();
    }
    
    public static void llenar(int arr[]){ // los objetos que se mandan si son modificados
        int i;
        Scanner leer = new Scanner (System.in);
        for (i=0;i<arr.length;i++) {
            System.out.print("Ingresa el valor en la celda "+i+": ");
            arr[i]=leer.nextInt();
        }
        System.out.println("");
    } 
}