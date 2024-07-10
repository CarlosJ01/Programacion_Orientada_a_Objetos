package archivos;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/////////////////////////////
class Objetos implements Serializable{
    String cta,nombre;
    float saldo;
    
    Objetos(String c, String n, float s){
        cta=c;
        nombre=n;
        saldo=s;
    }
}
/////////////////////////////////
class Escribe_Archivo{
        ObjectOutputStream salida;            
    void agregar(){
        Objetos a=new Objetos("123-111","Servando",456);
        Objetos b=new Objetos("123-999","Mateo",3456);
        Objetos c=new Objetos("523-141","Alfredo",76);
        try{
            salida= new ObjectOutputStream(new FileOutputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt"));
        }
        catch(IOException ex){
            System.out.println("Error de archivo");
        }
        try{
            salida.writeObject(a);
            salida.writeObject(b);
            salida.writeObject(c);
            salida.close();
        }
        catch(IOException ex){
          System.out.println("no se pudo escribir objeto");
        }
    }
}
/////////////////////////////////777
    class Lee_Archivo{
        private ObjectInputStream lectura;
        void abrirarchivo(){
            try{
                lectura= new ObjectInputStream(new FileInputStream("C:\\Users\\Carlos Jahir\\Desktop\\Programacion Orientada a Objetos\\Archivo.txt"));
            }
            catch(IOException ex){
                System.out.println("Error de archivo");
            }
        }     
  void leer(){
      Objetos o;
      try{
          while(true){
            o=(Objetos)lectura.readObject();
            System.out.println("Cuenta: "+o.cta+" nombre "+o.nombre+" saldo "+o.saldo);
        }
      }
    catch(EOFException ex){
          System.out.println("Fin de Archivo");
          try{
          lectura.close();}
          catch(IOException e){
              System.out.println("Error al cerrar archivo");
          }
        }
      catch(IOException ex){
          System.out.println("no se pudo escribir objeto");
        }
      catch(ClassNotFoundException ex){
          
      }
        }
    }
public class Archivos_09 {
    public static void main(String[] args) throws IOException {
    Escribe_Archivo x=new Escribe_Archivo();
    x.agregar();
    Lee_Archivo y=new Lee_Archivo();
    y.abrirarchivo();
    y.leer();
    }      
}   