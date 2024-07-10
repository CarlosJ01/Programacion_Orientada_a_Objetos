package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archivos_04 {
    public static void main(String[] args) throws IOException {
    FileOutputStream archcopia=null;
    FileInputStream arch=null;
    File a,c;
    int i;
    try{
        arch=new FileInputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
    }
    catch(FileNotFoundException ex){
        System.out.println("Archivo Origen no encontrado");   
    }
    try{
        archcopia=new FileOutputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo - copia.txt");
    }
    catch(FileNotFoundException ex){
        System.out.println("No se pudo crear Archivo copia");   
    }
    System.out.println("Un momento... creando copia de archivo cancion.txt\nLISTO");
    try{
        do{
        i=arch.read();
        if (i!=-1)
            archcopia.write(i);
    }while(i!=-1);
    }
    catch(IOException ex){
        System.out.println("Error al accesar archivo");
    }
    arch.close();
    archcopia.close();
    }
}