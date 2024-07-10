package excepcion_cadena_a_flotante;
import java.util.Scanner;
public class Excepcion_Cadena_a_Flotante {
    public static void main(String[] args) {
        String num;
        Scanner leer = new Scanner (System.in);
        System.out.print("Ingresa una cadena: ");
        num=leer.nextLine();
        Decimal numero=new Decimal(num);
        numero.Conversion();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        System.out.println("============================== NUMEROS POSITIVOS ====================================");
//        numero=new Decimal("1");
//        System.out.println("Numero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("1.5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal(".5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        System.out.println("============================== NUMEROS NEGATIVOS ====================================");
//        numero=new Decimal("-1");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("-1.5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("-0.5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        System.out.println("======================================= ERRORES ====================================");
//        numero=new Decimal("HOLA");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("1f.h5g");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("1..5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("--1.5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("1-.5");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
//        numero=new Decimal("");
//        System.out.println("\nNumero: "+numero.num);
//        numero.Conversion();
    }    
}
class Decimal{
    String num,ent,dec;
    int i,indPunt;
    boolean punt,guion;
    Decimal(String cad){
        num=cad;
    }
    public void Conversion(){
        try {
            Float.parseFloat(num);
            for (i=0,indPunt=num.length();i<num.length();i++)
                if (num.charAt(i)=='.')
                    indPunt=i;
            ent=num.substring(0,indPunt);
            dec=num.substring(indPunt,num.length());
            if (ent.equalsIgnoreCase(""))
                ent="No tiene";
            if (dec.equalsIgnoreCase(""))
                dec="No tiene";
            System.out.println("Parte Entera: "+ent+"\nParte Decimal: "+dec);
            System.out.println("____________________________________________________________________________________________\n");
        } 
        catch (NumberFormatException noFlotante) {
            try {
                if (num.equalsIgnoreCase("")) {
                     throw new noFloatException(4);
                }
                for (i=0,punt=false,guion=false;i<num.length();i++){
                    switch (num.charAt(i)) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            break;
                        case '-':
                                if (i!=0 && guion==false)
                                    throw new noFloatException(num,i,3);
                                if (guion==true)
                                    throw new noFloatException(num,i,2);
                                guion=true;
                            break;
                        case '.':
                                if (punt==true)
                                    throw new noFloatException(num,i,1);
                                punt=true;
                            break;
                        default:
                            throw new noFloatException(num,i,0);
                    }
                }
            } 
            catch (noFloatException error) {
                System.out.println(error);
            }
        } 
    }
}
class noFloatException extends Exception{
    static String errores[]={"No es un numero o algun caracter es diferente de -,.,0-9","Mas de un punto","Mas de un guion","El guion no esta en su lugar","Cadena Vacia"};
    String error,causa;
    noFloatException (String cad,int ind,int indError){
        causa="El caracter "+cad.charAt(ind)+" esta en la pocion "+ind+" de la cadena";
        error=errores[indError];
    }
    noFloatException (int indError){
        causa="No ingresaste nada";       
        error=errores[indError];
    }
    @Override
    public String toString(){
        String cad="";
        cad+="Ocurrio el Error: "+error+"\nPor que: "+causa+"\n_____________________________________________________________________________________\n";
        return cad;
    }
}