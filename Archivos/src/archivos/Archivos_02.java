package archivos;
import java.io.*;
public class Archivos_02 {
    public static void main(String[] args) throws IOException{
        FileInputStream arch=null;
    int i;
    try{
        arch=new FileInputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
    }
    catch(FileNotFoundException ex){
        System.out.println("Archivo no encontrado");   
    }
    do{
    i=arch.read();
    if (i!=-1)
            System.out.print((char)i+" ");
    }while(i!=-1);
    arch.close();
    }    
}