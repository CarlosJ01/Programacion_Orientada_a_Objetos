package menu_metodos;
import java.util.Scanner;
public class Menu_Metodos_01 {
    public static void main(String[] args) {
        int arr[]=new int [6];
        Menu(arr);
    }
    public static void Menu (int arr[]){
        Scanner leer = new Scanner(System.in);
        int cont=0,opc;
        boolean sal=false;
        do {
            System.out.println("\tMenu");
            System.out.println("1) Ingresar");
            System.out.println("2) Mostrar");
            System.out.println("3) Eliminar");
            System.out.println("4) Salir");
            System.out.print("  Ingresa una Opcion: ");
            opc=leer.nextInt();
            System.out.println("____________________________________________________");
                switch (opc) {
                    case 1: cont=Ingre(arr,cont);
                        break;
                    case 2: Most(arr,cont);
                        break;
                    case 3: cont=Elim(cont);
                        break;
                    case 4: sal=true;
                            System.out.println("FIN DEL PROGRAMA");
                        break;
                    default:
                        System.out.println("<OPCION NO VALIDA>");
                }
            System.out.println("____________________________________________________\n"); 
        } while (sal==false);
    }
    public static int Ingre(int arr[],int cont){
        Scanner leer = new Scanner(System.in);
        System.out.println("\tOpcion Ingresar");
        if (cont<arr.length) {
           System.out.print("Ingresa un dato: ");
           arr[cont]=leer.nextInt(); 
           return cont+1;
        }
        else {
            System.out.println("<ARREGLO LLENADO>");
            return cont;
        }       
    }
    public static void Most(int arr[],int cont){
        int i;
        System.out.println("\tOpcion Mostrar");
        if (cont==0)
            System.out.println("<NO HAY ELEMENTOS EN EL ARREGLO>");
        else {
            for (i=0;i<cont;i++)
                System.out.print(arr[i]+"\t");
            System.out.println("");
        }
        
    }
    public static int Elim(int cont){
        System.out.println("\tOpcion Eliminar");
        if (cont>0) {
            System.out.println("Ultimo dato eliminado");
            return cont-1;
        }
        else {
            System.out.println("<NO HAY ELEMENTOS A ELIMINAR>");
            return 0;
        }
    }
}