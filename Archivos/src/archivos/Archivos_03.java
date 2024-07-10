package archivos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Archivos_03 {
    public static void main(String[] args) throws IOException{
    FileOutputStream arch=null;
    int i;
    try{
        arch=new FileOutputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
    }
    catch(FileNotFoundException ex){
        System.out.println("Archivo no encontrado");   
    }
    System.out.println("Comienza tu propia composición\nIngresa '#' para terminar");
    do{
    i=System.in.read();
    if (i!='#')
        arch.write(i);
    }while(i!='#');
    arch.close();
    }
}
