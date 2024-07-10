package archivos;
import java.io.*;
public class Archivos_01 {
    public static void main(String[] args) throws IOException {
        File arch = null ;
        arch=new File ("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
        if(arch.exists()){
            System.out.println(arch.getName()+ " si existe y se encuentra en \n"+arch.getPath());
            if(arch.isDirectory()){
              System.out.println("Se trata de una carpeta y contiene: ");
              String d[]=arch.list();
              for(String cont:d){
                System.out.println(cont);}
            }
        else{
            System.out.println("Se trata de un archivo y tiene "+arch.length()+" caracteres");     
            }
        }
    }
}