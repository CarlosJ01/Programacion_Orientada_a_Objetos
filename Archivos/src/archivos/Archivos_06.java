package archivos;
import java.io.*;
public class Archivos_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        String cad;
        FileWriter arch=null;  // Objeto para escribir en archivo    
        try{
          arch= new FileWriter("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt");
      }
      catch(IOException ex){
          System.out.println("Error al abrir el archivo");
      }
      try{
          System.out.println("ingresa cadenas");
          do{
              cad=b.readLine(); //  Se lee linea DEL TECLADO
              if(cad.compareToIgnoreCase("alto")!=0){
                  cad+="\r";
                  arch.write(cad);  // Se escribe linea al archivo
                  System.out.println("Se escribio "+cad);
              }
           }while(cad.compareToIgnoreCase("alto")!=0);
      }
      catch(IOException ex){
          System.out.println("Error al esccirbir en archivo");
      }
    arch.close();
    }
}
