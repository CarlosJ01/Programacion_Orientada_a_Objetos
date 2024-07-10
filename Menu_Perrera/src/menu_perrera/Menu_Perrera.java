package menu_perrera;
import java.util.Random;
import java.util.Scanner;
public class Menu_Perrera {
    public static void main(String[] args) {
        Perro perrera[]=new Perro[10];
        Perro adoptados[]=new Perro[10];
        empiezo(perrera,adoptados);
        menu(perrera,adoptados);
    }
    public static void empiezo (Perro perrera[],Perro adoptados[]){
        int i,x;
        Random ram = new Random();
        for (i=0;i<perrera.length;i++)
            perrera[i]=null;
        for (i=0;i<adoptados.length;i++)
            adoptados[i]=null;
        System.out.println("\t\tPrimeros Perros");
        x=ram.nextInt(perrera.length)+1;
        for (i=0;i<x;i++) {
            perrera[i]=new Perro("","");
            perrera[i].ingresar(perrera);
        }
    }
    public static void menu(Perro perrera[],Perro adoptados[]){
        Scanner leer = new Scanner (System.in);
        String opc,nom;
        int i,adop=0;
        boolean sal=false,ind;
        do {
            System.out.println("\n________________________________________________\n");
            System.out.println("\tMenu\t");
            System.out.println("1) Ingresar");
            System.out.println("2) Dar en Adopcion");
            System.out.println("3) Mostrar jaulas");
            System.out.println("4) vacunar");
            System.out.println("5) Mostrar Adoptados");
            System.out.println("6) Salir");
            System.out.print("\n  Elige una opcion: ");
            opc=leer.nextLine();
            System.out.println("\n________________________________________________\n");
            switch (opc) {
                case "1":
                        System.out.println("\t\tOpcion Ingresar");
                        for (i=0;i<perrera.length && perrera[i]!=null;i++) {}
                            if (i==perrera.length)
                                System.out.println("\t\t<PERRERA LLENA>");
                            else {
                                perrera[i]=new Perro("","");
                                perrera[i].ingresar(perrera);
                        } 
                    break;
                case "2":
                        System.out.println("\t\tOpcion Dar En Adopcion\n");
                        ind=mostrar(perrera);
                        if (ind==false){
                            System.out.println("_________________________________________________");
                            System.out.print("Que perro quieres adoptar ?: ");
                            nom=leer.nextLine();
                            for (i=0,ind=false;i<perrera.length && ind==false;i++)
                                if (perrera[i]!=null)
                                    if (nom.equalsIgnoreCase(perrera[i].nombre))
                                        ind=true;
                            i--;
                            if(ind==false)
                                System.out.println("\n\t\t<El PERRO NO EXISTENTE>");
                            else
                                adop=perrera[i].adoptar(perrera,adoptados,i,adop);
                        }  
                    break;
                case "3":   
                        System.out.println("\t\tOpcion Mostrar Jaulas\n");
                        mostrar(perrera);
                    break;
                case "4":
                        System.out.println("\t\tOpcion Vacunar\n");
                        mostrar(perrera);
                        System.out.print("Que perro quieres vacunar: ");
                        nom=leer.nextLine();
                        for (i=0,ind=false;i<perrera.length && ind==false;i++)
                                if (perrera[i]!=null)
                                    if (nom.equalsIgnoreCase(perrera[i].nombre))
                                        ind=true;
                            i--;
                            if(ind==false)
                                System.out.println("\n\t\t<EL PERRO NO EXISTENTE>");
                            else
                                perrera[i].vacunar(perrera,i);
                    break;
                    case "5":
                        System.out.println("\t\tOpcion Mostrar Adoptados\n");
                        mostrar(adoptados);
                        break;
                case "6":   System.out.println("\t\t<FIN DEL PROGRAMA>");
                            System.out.println("_________________________________________________\n");
                            sal=true;
                    break;
                default:
                    System.out.println("\t<OPCION NO VALIDA>");
            }
        } while (sal==false);
    }
    public static boolean mostrar(Perro perrera[]){
        int i;
        boolean lleno=false;
        for (i=0;i<perrera.length;i++)
            if (perrera[i]!=null){
                perrera[i].mostrar(perrera,i);
                perrera[i].mostVacSi(perrera,i);
                System.out.println("\n");
                lleno=true;
            }
        if(lleno==false) {
            System.out.println("\t\t<PERRERA VACIA>");
            return true;
        }
        else
            return false;
    }
}
class Perro{
    String nombre,color;
    private final int vacunas[]=new int [5];
    String nomvac[]={"Rabia","Parvovirus","Sarna","Pulgas","Moquillo"};
    
    Perro(String nom,String col){
        Random ram = new Random();
        nombre=nom;
        color=col;
        for (int i=0;i<vacunas.length;i++)
            vacunas[i]=ram.nextInt(2);
    }
    public void ingresar(Perro perrera[]){
        Scanner leer = new Scanner (System.in);
        System.out.println("\nIngresa un perro");
        System.out.print("  Nombre del perro: ");
        nombre=leer.nextLine();
        System.out.print("  Color del perro: ");
        color=leer.nextLine();
    }
    public void mostrar(Perro perrera[],int i){
        System.out.println("Nombre: "+perrera[i].nombre);
        System.out.println("Color: "+perrera[i].color);
    }
    public void mostVacSi(Perro perrera[],int i){
        int j,cont;
        System.out.print("Vacunas que tiene:");
        for (j=0,cont=0;j<perrera[i].vacunas.length;j++)
            if (perrera[i].vacunas[j]==1) {
                System.out.print(" ✓ "+perrera[i].nomvac[j]);
                cont++;
            }
        if (cont==0)
            System.out.print(" 0");
    }
    public int mostVacNo(Perro perrera[],int i){
        int j,cont=0;
        System.out.print("Vacunas que no tiene:");
        for (j=0;j<perrera[i].vacunas.length;j++)
            if (perrera[i].vacunas[j]==0){
                cont++;
                System.out.print(" >< "+perrera[i].nomvac[j]);
            }
        if (cont==0)
            System.out.print(" 0");
        return cont;
    }
    public int adoptar(Perro perrera[],Perro adoptados[],int i,int adop){
        int j,vac;
        for (j=0,vac=0;j<perrera[i].vacunas.length;j++)
            if (perrera[i].vacunas[j]==1)
                vac++;
        if (vac>=5) {
            if(i<10){
                adoptados[adop]=perrera[i];
                perrera[i]=null;
                System.out.println("Perro: "+adoptados[adop].nombre+" a sido adoptado :)");
                adop++;
            }
            else
                System.out.println("\t\t<ARREGLO ADOPTADOS LLENO>");
            
        }
        else
            System.out.println("El perro: "+perrera[i].nombre+" no puede ser adoptado porque le faltan vacunas");
        return adop;
    }
    public void vacunar(Perro perrera[],int i){
        Scanner leer = new Scanner (System.in);
        String vac,opc;
        int j;
        boolean ind;
        do {
            System.out.println("_________________________________________________");
            System.out.println("El Perro: "+perrera[i].nombre+"\n");
            perrera[i].mostVacSi(perrera, i);
            System.out.println("\n");
            j=perrera[i].mostVacNo(perrera, i);
            System.out.println("\n_________________________________________________");
            if (j<=0)
                System.out.println("\t\t<YA NO HAY VACUANAS A DAR>");
            else {
                System.out.print("Que vacuna quieres dar: ");
                vac=leer.nextLine();
                for (j=0,ind=false;j<perrera[i].nomvac.length && ind==false; j++)
                    if (perrera[i].nomvac[j].equalsIgnoreCase(vac)==true)
                        ind=true;
                j--;
                if (ind==false) {
                    System.out.println("\t\t<VACUNA NO EXISTE>");
                }
                else {
                    if (perrera[i].vacunas[j]==1)
                        System.out.println("\t\t<YA TIENE ESA VACUNA>");
                    else{
                        perrera[i].vacunas[j]=1;
                        System.out.println("El perro: "+perrera[i].nombre+" a sido vacunado");
                    }   
                }
            }
            System.out.print("  Quieres segir vacunando(S/N): ");
            opc=leer.nextLine();
        } while (opc.equalsIgnoreCase("S")==true);
    }
}