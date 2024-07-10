package clase_generica;
import java.util.Random;
public class Clase_Generica {
    public static void main(String[] args) {
        Generica <Pan> panes=new Generica<Pan>(5);
        Generica <Yogur> yogures=new Generica<Yogur>(3);
        ///////////////////////////////////////////////Inventario Vacio
        System.out.println("---------------------------- Inventario Vacio ---------------------------------");
        Generica.verInventario(panes,yogures);
        //////////////////////////////////////////////Lleno Inventario
        System.out.println("\n---------------------------- Lleno Inventario ---------------------------------");
        panes.surtir(new Pan("Bimbo","Blanco"));
        panes.surtir(new Pan("Bombo","Dulce"));
        panes.surtir(new Pan("Bumbo","Muerto"));
        panes.surtir(new Pan("Bambo","Integral"));
        panes.surtir(new Pan("Bembo","Sal"));
        yogures.surtir(new Yogur("Lala","Fresa"));
        yogures.surtir(new Yogur("Lala","Piña"));
        yogures.surtir(new Yogur("Lele","Durazno"));
        yogures.surtir(new Yogur("Lile","Guayaba"));//ignora este
        Generica.verInventario(panes,yogures);
        //////////////////////////////////////////////Vendo 2 de cada 1
        System.out.println("\n---------------------------- Vendo 2 de cada 1 ---------------------------------");
        System.out.println("\tPanes");
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("\tYogur");
        System.out.println("Se vendio -> "+yogures.vender());
        System.out.println("Se vendio -> "+yogures.vender());
        System.out.println("");
        Generica.verInventario(panes,yogures);
        /////////////////////////////////////////////Surto 1 de cada 1
        System.out.println("\n---------------------------- Surto 1 de cada 1 ---------------------------------");
        panes.surtir(new Pan("Tiendita","Generico"));
        yogures.surtir(new Yogur("Envace","Fresa con trocitos"));
        Generica.verInventario(panes,yogures);
        /////////////////////////////////////////////Vacio Inventario
        System.out.println("\n---------------------------- Vacio Inventario ---------------------------------");
        System.out.println("\tPanes");
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("Se vendio -> "+panes.vender());
        System.out.println("Se vendio -> "+panes.vender());//No existe
        System.out.println("\tYogur");
        System.out.println("Se vendio -> "+yogures.vender());
        System.out.println("Se vendio -> "+yogures.vender());
        System.out.println("Se vendio -> "+yogures.vender());//No existe
        
        Generica.verInventario(panes,yogures);
        /////////////////////////////////////////////Surto 3 de cada 1
        System.out.println("\n---------------------------- Surto 3 de cada 1 ---------------------------------");
        panes.surtir(new Pan("Pan Generico","Blanco"));
        panes.surtir(new Pan("Pan Generico","Integral"));
        panes.surtir(new Pan("Pan Generico","Concha"));
        yogures.surtir(new Yogur("Yogur Generico","Fresa con trosos"));
        yogures.surtir(new Yogur("Yogur Generico","Piña con trosos"));
        yogures.surtir(new Yogur("Yogur Generico","Durazno con trosos"));

        Generica.verInventario(panes,yogures);
        
    }
}
class Generica <T>{
    T inv[];
    int cont;
    Generica(int n){
        int i;
        inv=(T[])new Object[n];
        for (i=0;i<inv.length;i++)
            inv[i]=null;
        cont=0;
    }
    public void surtir(T elem){
        int i;
        boolean salir=false;
        if (cont<inv.length){
            for (i=0;i<inv.length && salir==false;i++)
                if (inv[i]==null){
                    inv[i]=elem;
                    salir=true;
                }
            cont++;
        }
        
    }
    public T vender(){
        T elem=null;
        int i,men,iMen=0;
        Pan pan;
        Yogur yor;
        if (vacia()){
            for (i=0,men=30;i<inv.length;i++) {
                if (inv[i]!=null){
                    if(inv[i].getClass().getSimpleName().equalsIgnoreCase("Pan")) {     
                        pan=(Pan)inv[i];
                        if (pan.cad<=men) {
                            men=pan.cad;
                            iMen=i;
                        }
                    } 
                    else {
                        yor=(Yogur)inv[i];
                        if (yor.cad<=men) {
                            men=yor.cad;
                            iMen=i;
                        }
                    } 
                } 
            }
        }
        elem=inv[iMen];
        inv[iMen]=null;
        cont--;
        return elem;
    }
    public boolean vacia(){
        boolean resp=true;
        if (cont==0)
            resp=false;
        return resp;
    }
    public static void verInventario(Generica obj1,Generica obj2){
        System.out.println("\t\t\t\tInventario");
        System.out.println("________________________________________________________________________________________________________");
        System.out.println("\tPanes");
        System.out.println(obj1);
        System.out.println("\tYogures");
        System.out.println(obj2);
    }
    @Override
    public String toString(){
        String cad="";
        Pan pan;
        Yogur yor;
        int i,j;
        for (i=0,j=1;i<inv.length;i++){
            if (inv[i]!=null){
                if (inv[i].getClass().getSimpleName().equalsIgnoreCase("Pan")) {
                    pan=(Pan)inv[i];
                    cad+="\t\t"+j+"° Marca: "+pan.marca+" Tipo: "+pan.tipo+" Caducidad: "+pan.cad+"\n";
                    j++;
                }
                else{
                    yor=(Yogur)inv[i];
                    cad+="\t\t"+j+"° Marca: "+yor.marca+" Sabor: "+yor.sabor+" Caducidad: "+yor.cad+"\n";
                    j++;
                }
            }
        }
        if (cad.equalsIgnoreCase(""))
            cad="\t\tInventario Vacio";
        return cad;
    }
}
class Pan{
    Random ram = new Random();
    String marca,tipo;
    int cad;
    Pan(String marca, String tipo){
        this.marca=marca;
        this.tipo=tipo;
        cad=ram.nextInt(30)+1;
    }
    @Override
    public String toString(){
        String cad;
        cad="Marca: "+marca+" Tipo: "+tipo+" Caducidad: "+this.cad;
        return cad;
    }
}
class Yogur{
    Random ram = new Random();
    String marca,sabor;
    int cad;
    Yogur(String marca, String sabor){
        this.marca=marca;
        this.sabor=sabor;
        cad=ram.nextInt(30)+1;
    }
    @Override
    public String toString(){
        String cad;
        cad="Marca: "+marca+" Tipo: "+sabor+" Caducidad: "+this.cad;
        return cad;
    }
}