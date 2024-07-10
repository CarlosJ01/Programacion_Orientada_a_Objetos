package archivo_fracciones;
import java.io.*;
import java.util.Scanner;
public class Archivo_Fracciones {
    public static void main(String[] args) {
        Quebrado[][] elementos=null;
        double[] resultados=null;
        char operaciones[]=null;
        int i;
        File ope=new File("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Operaciones.txt");
        if (ope.exists()) {
            elementos=sacarElementos();
            operaciones=sacarOperaciones();
            resultados=hacerOperaciones(elementos,operaciones);
            escribir(resultados);
            buscar();
        } else {
            System.out.println("El Archivo Operaciones no existe");
        }
    }
    public static Quebrado[][] sacarElementos(){
        BufferedReader lector=null;
        Quebrado [][] arr = null;
        String cad="",quebrado;
        int ope,quebra,i,j,ind;
        try {
            lector=new BufferedReader (new FileReader("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Operaciones.txt"));
        } catch (IOException e) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OPERACIONES>");
        }
        ope=0;
        try {
            do {
                cad=lector.readLine();
                if (cad!=null){
                    ope++;
                }
            } while (cad!=null);
            arr=new Quebrado[ope][2];
        } catch (IOException error) {
            System.out.println("ERROR:<DE LECTURA>");
        }
        try {
            lector.close();
            lector=new BufferedReader (new FileReader("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Operaciones.txt"));
        } catch (IOException e) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OPERACIONES>");
        }
        ope=0;
        try {
            do {
                cad=lector.readLine();
                if (cad!=null){
                    for (i=0,ind=0,j=0;i<cad.length();i++) {
                        switch (cad.charAt(i)) {
                            case '+':
                            case '-':
                            case '*':
                            case '%':
                                quebrado=cad.substring(ind,i);
                                arr[ope][j]=Quebrado.crearQuebrado(quebrado);
                                j++;
                                ind=i;
                                break;
                            default:
                            }
                    }
                    quebrado=cad.substring(ind+1,i);
                    arr[ope][j]=Quebrado.crearQuebrado(quebrado);
                    ope++;
                }    
            } while (cad!=null);
        } catch (IOException error) {
            System.out.println("ERROR:<DE LECTURA>");
        }
        return arr;
    }
    public static char[] sacarOperaciones(){
        char arr[]=null;
        BufferedReader lector=null;
        String cad;
        int i,cont=0;
        try {
            lector=new BufferedReader (new FileReader("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Operaciones.txt"));
        } catch (IOException e) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OPERACIONES>");
        }
        try {
            do {
                cad=lector.readLine();
                if (cad!=null){
                     for (i=0;i<cad.length();i++) {
                        switch (cad.charAt(i)) {
                            case '+':
                            case '-':
                            case '*':
                            case '%':
                                cont++;
                                break;
                            default:
                        }
                    }
                }
            } while (cad!=null);
            arr=new char[cont];
        } catch (IOException error) {
            System.out.println("ERROR:<DE LECTURA>");
        }
        try {
            lector.close();
            lector=new BufferedReader (new FileReader("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Operaciones.txt"));
        } catch (IOException e) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OPERACIONES>");
        }
        cont=0;
         try {
            do {
                cad=lector.readLine();
                if (cad!=null){
                     for (i=0;i<cad.length();i++) {
                        switch (cad.charAt(i)) {
                            case '+':
                            case '-':
                            case '*':
                            case '%':
                                arr[cont]=cad.charAt(i);
                                break;
                            default:
                        }
                    }
                    cont++;
                }
            } while (cad!=null);
        } catch (IOException error) {
            System.out.println("ERROR:<DE LECTURA>");
        }
        return arr;
    }
    public static double[] hacerOperaciones(Quebrado[][] elem,char[] ope){
        double arr[]=new double [ope.length];
        for (int i = 0; i <ope.length; i++) {
            switch (ope[i]) {
                case '+':
                        arr[i]=elem[i][0].suma(elem[i][1]);
                    break;
                case '-':
                        arr[i]=elem[i][0].resta(elem[i][1]);
                    break;
                case '*':
                        arr[i]=elem[i][0].multiplicacion(elem[i][1]);
                    break;
                case '%':
                        arr[i]=elem[i][0].division(elem[i][1]);
                    break;
            }
        }
        return arr;
    }
    public static void escribir(double[] arr){
        DataOutputStream esc=null;
        try {
            esc=new DataOutputStream(new FileOutputStream("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Resultados - Acceso directo"));
        } catch (IOException e) {
            System.out.println("error al abrir resultados");
        }
        try {
            for (int i = 0; i <arr.length; i++) {
                esc.writeDouble(arr[i]);
            }
            esc.close();
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }
    public static void buscar(){
        RandomAccessFile lec=null;
        Scanner leer = new Scanner(System.in);
        int ind;
        try {
            lec=new RandomAccessFile("C:\\Users\\Lab3 mq 08\\Documents\\NetBeansProjects\\Archivo_Quebrados\\Archivos\\Resultados - Acceso directo","rw");
        } catch (IOException e) {
            System.out.println("error al abrir resultados");
        }
        System.out.println("Para salir escribe una letra:");
        try {
            do {
                System.out.print("Que Resultado quieres ver: ");
                ind=leer.nextInt();
                if (ind==1) {
                    ind=0;
                } else {
                    ind--;
                    ind=ind*8;
                }
                try {
                    lec.seek(ind);
                    System.out.println(lec.readDouble());
                } catch (IOException e) {
                    System.out.println("Resultado no esncontrado");
                }
                System.out.println("");
            } while (true);  
        } catch (Exception e) {
            System.out.println("Saliste");
        }
    }
}
class Quebrado{
    int num,den;
    Quebrado(int num,int den){
        this.num=num;
        this.den=den;
    }
    public static Quebrado crearQuebrado(String cad){
        Quebrado obj=null;
        int i,j;
        String num="",den="";
        int numNum,denNum;
        for (i=0,j=0;i<cad.length();i++) {
            if (cad.charAt(i)=='/') {
               j=i; 
            }
        }
        try {
            num=cad.substring(0,j).trim();
            den=cad.substring(j+1,cad.length()).trim();
            if (!num.equals("")&&!den.equals("")) {
                try {
                    numNum=Integer.parseInt(num);
                    denNum=Integer.parseInt(den);
                    obj=new Quebrado(numNum,denNum);
                } catch (Exception e) {
                    System.out.println("ERROR:<ALGUN ELEMENTO DE LA FRACCION NO ES NUMERO (NUMERADOR/DENOMINADOR)>");
                }
            }
            else
                System.out.println("ERROR:<UNA FRACCION LE FALTAN ELEMENTOS>");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("ERROR:<UNA FRACCION NO EXISTE>");
        }
        return obj;
    }
    public double suma(Quebrado obj){
        double res;
        int numerador,denominador;
        numerador=(this.num*obj.den)+(this.den*obj.num);
        denominador=this.den*obj.den;
        res=numerador/denominador;
        return res;
    }
    public double resta(Quebrado obj){
        double res;
        int numerador,denominador;
        numerador=(this.num*obj.den)+(this.den*obj.num);
        denominador=this.den*obj.den;
        res=numerador/denominador;
        return res;
    }
    public double multiplicacion(Quebrado obj){
        double res;
        int numerador,denominador;
        numerador=(this.num*obj.num);
        denominador=this.den*obj.den;
        res=numerador/denominador;
        return res;
    }
    public double division(Quebrado obj){
        double res;
        int numerador,denominador;
        numerador=(this.num*obj.den);
        denominador=this.den*obj.num;
        res=numerador/denominador;
        return res;
    }
}