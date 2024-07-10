package archivos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.Scanner;
public class Archivos_05 {
    public static void main(String[] args) throws IOException{
    DataOutputStream salida=null;
      DataInputStream entrada=null;      
      int edad;
      float estatura;
      boolean soltero;
      Scanner leer=new Scanner(System.in);
      //////////////      SE ESCRIBE AL ARCHIVO /////////////////////////////77
    try{
          salida=new DataOutputStream(new FileOutputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt"));
      }
      catch(IOException ex){
          System.out.println("Error al abrir el archivo");
      }
      try{
          
          do{
             
              System.out.print("Ingresa edad: ");
              edad=leer.nextInt();
              if(edad!=0){
              System.out.print("Ingresa estatura: ");
              estatura=leer.nextFloat();
              System.out.print("Soltero?  ");
              soltero=leer.nextBoolean(); 
                 salida.writeInt(edad);
                 salida.writeFloat(estatura);
                 salida.writeBoolean(soltero);}
          }while(edad!=0);
      }
      catch(IOException ex){
          System.out.println("Error al esccirbir en archivo");
      }
    salida.close();
    //////////////      SE LEE  DEL ARCHIVO /////////////////////////////77
    try{
          entrada=new DataInputStream(new FileInputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt"));
      }
      catch(IOException ex){
          System.out.println("Error al abrir el archivo");
      }
      try{
          do{
             edad=entrada.readInt();
             estatura=entrada.readFloat();
             soltero=entrada.readBoolean();
              System.out.print(" Edad: "+edad+" Estatura: "+estatura+" y ");
              if(soltero==true)
                  System.out.println(" es soltero");
              else
                  System.out.println(" NO es soltero");
          }while(true);
      }
      catch(IOException ex){
          System.out.println("Se llegó al final del archivo");
      }
    entrada.close();
    }      
}