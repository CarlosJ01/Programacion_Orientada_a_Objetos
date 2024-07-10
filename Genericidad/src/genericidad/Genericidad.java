package genericidad;
/////////////////////// CLASE TERNA GENERICA /////////////////
class Terna_Generica <T>{
    private T elem1,elem2,elem3;
    public Terna_Generica(){
        elem1=elem2=elem3=null;
    }
    public Terna_Generica(T v1,T v2,T v3){ //constructor
        elem1=v1;
        elem2=v2;
        elem3=v3;
    }
    public T get(int i){ //devuelve el elemento i
        if (i==1)
            return elem1;
        else if (i==2)
            return elem2;
        else
            return elem3;
    }
    // SE CAMBIA EL VALOR AL ELEMENTO i
    public void set(T valor,int i){
        if (i==1)
            elem1=valor;
        else if (i==2)
            elem2=valor;
        else
            elem3=valor;
    }
    @Override
    public String toString(){
        return "Terna conformada por "+elem1+", "+elem2+", "+ elem3;
    }
}
/////////////// CLASE PRINCIPAL //////////////////////////////////
class Genericidad {
    public static void main(String[] args) {
        Terna_Generica <Integer>ti=new Terna_Generica <Integer>(45,90,135);
        System.out.println(ti);
        ti.set(65, 1);
        ti.set(75, 2);
        ti.set(85, 3);
        System.out.println(ti);
        Terna_Generica <String> ts;
        ts=new Terna_Generica <String> ("tere","beto","chucho");
        System.out.println(ts);
        ts.set("Sandra", 1);
        ts.set("Joaquin", 2);
        ts.set("Kevin", 3);
        System.out.println(ts);
        /* Elemento 2 de cada objeto */
        System.out.println(ti.get(2));
        System.out.println(ts.get(2));
    }
}