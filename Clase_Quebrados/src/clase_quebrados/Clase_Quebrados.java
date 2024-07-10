package clase_quebrados;
public class Clase_Quebrados {
    public static void main(String[] args) {
        Quebrado q1 = new Quebrado("+ 1 1/2");
        Quebrado q2 = new Quebrado("- 0 1/3");
        Quebrado q3 = new Quebrado("- 0 5/2");
        Quebrado q4 = new Quebrado("+ 0 1/3");
        Quebrado q5 = new Quebrado("+ 0 10/3");
        Quebrado q6 = new Quebrado("+ 0 9/6");
        Quebrado q7 = new Quebrado("- 0 10/2");
        Quebrado q8 = new Quebrado("- 0 1/3");
        Quebrado q9 = new Quebrado("- 1 1/2");
        q1.multiplicar(q2).mostrar();
        q3.dividir(q4).mostrar();
        q5.sumar(q6).mostrar();
        q7.dividir(q8).mostrar();
        q9.multiplicar(q8).mostrar();
    }
}
class Quebrado{
    private int ent,num,den;
    private char sig;
    Quebrado(int ent,int num,int den,char sig){
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
    Quebrado (String cad){
        String num1="",num2="",num3="";
        int i;
        boolean ind1=true,ind2=false,ind3=false;
        cad=cad.trim();
        sig=cad.charAt(0);
        for (i=1;i<cad.length();i++) {
            if (ind1 == true) {
                if (num1.equalsIgnoreCase("")==false && cad.charAt(i)==' ') {
                    ind1=false;
                    ind2=true;
                } 
                else {
                    if (cad.charAt(i)!=' ')
                        num1+=cad.charAt(i);
                }
            }
            if (ind2==true) {
                if (num2.equalsIgnoreCase("")==false && cad.charAt(i)=='/') {
                    ind2=false;
                    ind3=true;
                    i++;
                } 
                else {
                    if (cad.charAt(i)!=' ')
                        num2+=cad.charAt(i);
                }
            }
            if (ind3==true) {
                if (cad.charAt(i)!=' ')
                    num3+=cad.charAt(i);
            }
        }
        ent=Integer.parseInt(num1);
        num=Integer.parseInt(num2);
        den=Integer.parseInt(num3);
    }
    public Quebrado sumar(Quebrado q){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(q.ent*q.den)+q.num;
        if (this.sig=='-')
            num1*=-1;
        if (q.sig=='-')
            num2*=-1;
        qRes.num=(num1*q.den)+(this.den*num2);
        qRes.den=this.den*q.den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado restar(Quebrado q){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(q.ent*q.den)+q.num;
        if (this.sig=='-')
            num1*=-1;
        if (q.sig=='-')
            num2*=-1;
        qRes.num=(num1*q.den)-(this.den*num2);
        qRes.den=this.den*q.den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado multiplicar(Quebrado q){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(q.ent*q.den)+q.num;
        if (this.sig=='-')
            num1*=-1;
        if (q.sig=='-')
            num2*=-1;
        qRes.num=num1*num2;
        qRes.den=this.den*q.den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado dividir(Quebrado q){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(q.ent*q.den)+q.num;
        if (this.sig=='-')
            num1*=-1;
        if (q.sig=='-')
            num2*=-1;
        qRes.num=num1*q.den;
        qRes.den=this.den*num2;
        if (qRes.num<0)
                qRes.num*=-1;
        if (qRes.den<0)
            qRes.den*=-1;
        if (this.sig==q.sig)
            qRes.sig='+';
        else
            qRes.sig='-'; 
        qRes.simplificar();
        return qRes;
    }
    public Quebrado sumar(int ent,int num,int den,char sig){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(ent*den)+num;
        if (this.sig=='-')
            num1*=-1;
        if (sig=='-')
            num2*=-1;
        qRes.num=(num1*den)+(this.den*num2);
        qRes.den=this.den*den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado restar(int ent,int num,int den,char sig){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(ent*den)+num;
        if (this.sig=='-')
            num1*=-1;
        if (sig=='-')
            num2*=-1;
        qRes.num=(num1*den)-(this.den*num2);
        qRes.den=this.den*den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado multiplicar(int ent,int num,int den,char sig){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(ent*den)+num;
        if (this.sig=='-')
            num1*=-1;
        if (sig=='-')
            num2*=-1;
        qRes.num=num1*num2;
        qRes.den=this.den*den;
        if(qRes.num<0){
            qRes.num*=-1;
            qRes.sig='-';
        }
        else{
            if (qRes.num>0)
                qRes.sig='+';
            else
                qRes.sig=' ';
        }
        qRes.simplificar();
        return qRes;
    }
    public Quebrado dividir(int ent,int num,int den,char sig){
        Quebrado qRes=new Quebrado(0,0,0,'+');
        int num1,num2;
        num1=(this.ent*this.den)+this.num;
        num2=(ent*den)+num;
        if (this.sig=='-')
            num1*=-1;
        if (sig=='-')
            num2*=-1;
        qRes.num=num1*den;
        qRes.den=this.den*num2;
        if (qRes.num<0)
                qRes.num*=-1;
        if (qRes.den<0)
            qRes.den*=-1;
        if (this.sig==sig)
            qRes.sig='+';
        else
            qRes.sig='-'; 
        qRes.simplificar();
        return qRes;
    }
    public void simplificar(){
        int i,MCD=1;
        ent=num/den;
        num=num%den;
        for (i=1;i<Math.max(num,den);i++)
            if (num%i==0 && den%i==0)
                MCD=i;
        num=num/MCD;
        den=den/MCD;
    }
    public void mostrar(){
        if (num==0 && ent==0)
            System.out.print("0");
        else{
            System.out.print(sig);
            if (ent!=0)
                System.out.print(" "+ent);
            if (num!=0)
                System.out.print(" "+num+"/"+den);
        }
        System.out.println("");
    }
}