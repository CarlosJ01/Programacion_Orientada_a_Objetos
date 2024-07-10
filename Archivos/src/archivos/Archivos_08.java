package archivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Archivos_08 {
    public static void main(String[] args) throws IOException {
    float flotantes[]={3,23,900,123,450,700,567};
       float d;
       RandomAccessFile arch=null;
       try{
          arch= new RandomAccessFile("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt","rw");
          }
      catch(FileNotFoundException ex){
          System.out.println("Error al abrir el archivo");
      }
      for(int i=0;i<flotantes.length; i++){  //Se escriben valores al archivo
           try{
              arch.writeFloat(flotantes[i]); 
           }
           catch(IOException exc){
               System.out.println("Error de acceso a archivo");
           }
       }
       try{
       arch.seek(0); // Se localiza puntero en primer dato
       d=arch.readFloat();
       System.out.println("Primer valor doble es: "+d);
       arch.seek(8); // Se localiza puntero en 3r dato
       d=arch.readFloat();
       System.out.println("Tercer valor doble es: "+d);
       System.out.println("En orden inverso, Todos los valores del archivo son");
       for(int i=flotantes.length-1;i>=0;i--){
           arch.seek(i*4); 
           d=arch.readFloat();
           System.out.println(d+" "+i*4);
       }
       }
       catch(IOException ex){
           System.out.println("Error al seek o leer");
       }
       arch.seek(0);  //Puntero de archivo al inicio
       d=arch.readFloat();
       System.out.println(d+" esta al inicio del archivo ");
       arch.seek(0);
       arch.skipBytes(12); // Salto 3 datos, primeros 12 bytes
       d=arch.readFloat();
       System.out.println(d+" es el cuarto dato ");
       arch.seek(8);  // Puntero en el tercer dato
       arch.writeFloat(600);  // Se sobreescribe 3er dato
       arch.seek(0);
       System.out.println("Ahora los datos inversos son");
       for(int i=flotantes.length-1;i>=0; i--){
           arch.seek(i*4); 
           d=arch.readFloat();
       System.out.println(d+" "+i*4);
       }
       arch.close();
    } 
}