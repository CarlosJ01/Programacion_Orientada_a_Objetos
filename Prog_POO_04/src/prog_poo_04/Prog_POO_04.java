package prog_poo_04;
public class Prog_POO_04 {
     public static void main(String[] args) {
        Quebrado q1 = new Quebrado(0,1,2,'+');
        Quebrado q2 = new Quebrado(0,1,2,'+');
        Quebrado x;
        x=q1.sumar(q2);
        x.mostrar();
    }
}
class Quebrado{
    private int ent,num,den;
    private char sig;
    Quebrado(int ent,int num,int den,char sig){ // sobrecargar para recibir cadena y construir objeto Quebrado(String quebrado)  
        this.ent=ent;
        this.num=num;
        this.den=den;
        this.sig=sig;
    }
    Quebrado (Quebrado q){
        this.ent=q.ent;
        this.num=q.num;
        this.den=q.den;
        this.sig=q.sig;
    }
    public Quebrado sumar(Quebrado q){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int n,m;
        n=(this.ent*this.den)+this.num;
        m=(q.ent*q.den)+q.num;
        if (this.sig=='-')
            n=n*(-1);
        if (q.sig=='-')
            m=m*(-1);
//        qRes.ent=this.ent+q.ent;
        qRes.num=(n*q.den)+(this.den*m);
        qRes.den=this.den*q.den;
        if (n>m)
            qRes.sig=this.sig;
        else {
            if (n<m)
                qRes.sig=q.sig;
            else
                qRes.sig=this.sig;
        }
        qRes.simplificar();
        return qRes;
    }
    public void mostrar(){
        System.out.print(sig+" ");
        if (ent!=0)
            System.out.print(ent+" ");
        if (num!=0)
            System.out.print(num+"/"+den);
        System.out.println("");
    }
    public void simplificar(){
        ent=num/den;
        num=num%den;
        // reducir en caso nesesario;
    }
}