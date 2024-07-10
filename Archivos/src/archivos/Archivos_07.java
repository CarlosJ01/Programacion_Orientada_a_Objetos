package archivos;
import java.io.*;
public class Archivos_07 {
    public static void main(String[] args) throws IOException {
    BufferedReader b=null;
        String cad;
        int l=1;
      FileReader arch=null;      
        try{
        arch= new FileReader("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
        b=new BufferedReader(arch);
      }
      catch(IOException ex){
          System.out.println("Error al abrir el archivo");
      }
      try{
          System.out.println("<<Contenido del archivo, linea a linea>>");
          do{
              cad=b.readLine();
              if (cad!=null)
                System.out.println("linea "+l+": "+cad);
                l++;
           }while(cad!=null);
      }
      catch(IOException ex){
          System.out.println("Termino contenido del archivo");
      }
    arch.close();
    }    
}