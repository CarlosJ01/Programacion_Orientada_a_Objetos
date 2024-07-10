package menu_metodos_02;
import java.util.Scanner;
public class Menu_Metodos_02 {
    static int arr[]=new int [6];//Declarado como static para que existan fuera de main
    static int cont=0;//Declarado como static para que existan fuera de main
    public static void main(String[] args) {
        Menu();
    }
    public static void Menu (){
        Scanner leer = new Scanner(System.in);
        int opc;
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
                    case 1: cont=Ingre();
                        break;
                    case 2: Most();
                        break;
                    case 3: cont=Elim();
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
    public static int Ingre(){
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
    public static void Most(){
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
    public static int Elim(){
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