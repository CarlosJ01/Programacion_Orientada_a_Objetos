package archivos_alumnos;
import java.io.*;
public class Archivos_Alumnos {
    public static void main(String[] args) {
        Alumno alumnos[];
        String materias[][];
        String report;
        int i;
        File alum =  new File ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Alumnos.txt");
        File calif =  new File ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Calificaciones.txt");
        File mate =  new File ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Materias.txt");
        if (alum.exists() && calif.exists() && mate.exists()) {
            alumnos=Alumno.crearAlumnos();
            materias=nomMate();
            for (i=0;i<alumnos.length;i++) {
                if (alumnos[i]!=null){
                    alumnos[i].anotarCalif();
                    if(alumnos[i].existe==true){
                        alumnos[i].nomMat(materias);
                    }
                }
            }
            File obj = new File("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Objetos.txt");
            if (obj.exists()) {
                escribirAlumnos(alumnos);
                alumnos=leerAlumnos();
                File inf = new File ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Informe.txt");
                if (inf.exists()) {
                    report=crearInforme(alumnos);
                    escribirInforme(report);
                    leerInforme();
                } else {
                    System.out.println("ERROR:<EL ARCHIVO INFORME NO EXISTE>");
                }
            }
        } else {
            System.out.println("ERROR:<ALGUN ARCHIVO (ALUMNOS,CALIFIFCACIONES O MATERIAS) NO EXISTE>");
        }
    }
    public static String[][] nomMate(){
        String arr[][]=null;
        BufferedReader lector=null;
        String cad,clave,nom;
        int cont=0,esp=0,i,may;
        boolean ind;
        try {
            lector=new BufferedReader(new FileReader("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Materias.txt"));
            do {
                cad=lector.readLine();
                if (cad!=null && !cad.equalsIgnoreCase(""))
                    cont++;
            } while (cad!=null);
            arr=new String[cont][2];
            lector.close();
            lector=new BufferedReader(new FileReader("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Materias.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO MATERIAS>");
        }
        i=0;
        try {
            do {
                cad=lector.readLine();
                if (cad!=null && !cad.equalsIgnoreCase("")){
                    for (cont=0,esp=0,ind=true;ind && cont<cad.length();cont++)
                        if (cad.charAt(cont)==' '){
                            esp=cont;
                            ind=false;
                        }
                    clave=cad.substring(0,esp).trim();
                    nom=cad.substring(esp,cad.length()).trim();
                    arr[i][0]=clave;
                    arr[i][1]=nom;
                    i++;
                }
            } while (cad!=null);
            lector.close();
        } catch (IOException error) {
            System.out.println("TERMINO DEL CONTENIDO DEL ARCHIVO ALUMNOS");
        }
        
        for (i=0,may=0;i<arr.length;i++)
            if (arr[i][1].length()>=may)
                may=arr[i][1].length();
        for (i=0;i<arr.length;i++)
            if (arr[i][1].length()<may)
                while(arr[i][1].length()<may)
                    arr[i][1]+=" ";         
        return arr;
    }
    public static void escribirAlumnos(Alumno arr[]){
        ObjectOutputStream escritor=null;
        int i;
        try {
            escritor=new ObjectOutputStream(new FileOutputStream ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Objetos.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OBJETOS>");
        }
        for (i=0;i<arr.length;i++) {
            try {
                if (arr[i]!=null)
                    escritor.writeObject(arr[i]);
            } catch (IOException error) {
                System.out.println("ERROR:<AL ESCRIBIR EL OBJETO NUMERO "+(i+1)+" >");
            }
        }
    }
    public static Alumno[] leerAlumnos(){
        Alumno arr[]=null;
        ObjectInputStream lector = null;
        int cont;
        try {
            lector=new ObjectInputStream(new FileInputStream("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Objetos.txt"));
        } catch (IOException error) {  
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OBJETOS>");
        }
        cont=0;
        try {
            while (true) {                
                lector.readObject();
                cont++;
            }
        } catch (EOFException fin){
            arr=new Alumno[cont];
            try {
                lector.close();
            } catch (IOException e) {
                System.out.println("ERROR:<AL CERRAR EL ARCHIVO OBJETOS>");
            }
        }catch (IOException error) {
            System.out.println("ERROR:<NO SE PUEDE LEER EL OBJETO "+cont+">");
        }catch (ClassNotFoundException error) {
        }
        try {
            lector=new ObjectInputStream(new FileInputStream("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Objetos.txt"));
        } catch (IOException error) {  
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO OBJETOS>");
        }
        cont=0;
        try {
            while (true) {                
                arr[cont]=(Alumno)lector.readObject();
                cont++;
            }
        } catch (EOFException fin){
            try {
                lector.close();
            } catch (IOException e) {
                System.out.println("ERROR:<AL CERRAR EL ARCHIVO OBJETOS>");
            }
        }catch (IOException error) {
            System.out.println("ERROR:<NO SE PUEDE LEER EL OBJETO "+cont+">");
        }catch (ClassNotFoundException error) {
        }
        return arr;
    }
    public static String crearInforme(Alumno arr[]){
        String info="";
        int i;
        for (i=0;i<arr.length;i++) {
            if (arr[i].existe==true)
                info+=arr[i].toString();
        }
        if (info.equals(""))
            System.out.println("\t\t\tNO EXISTE EL INFORME\t\t\t");
        return info;
    }
    public static void escribirInforme(String cad){
        DataOutputStream escritor=null;
        try {
            escritor=new DataOutputStream(new FileOutputStream("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Informe.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO INFORME>");
        }
        try {
            escritor.writeUTF(cad);
        } catch (IOException e) {
            System.out.println("ERROR:<AL ESCRIBIR EL INFORME>");
        }
        try {
            escritor.close();
        } catch (IOException error) {
            System.out.println("ERROR:<AL CERRAR EL ARCHIVO INFORME>");
        }
    }
    public static void leerInforme(){
        DataInputStream lector=null;
        String info="ERROR:<NO EXISTE EL INFORME>";
        try {
            lector=new DataInputStream(new FileInputStream ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Informe.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO INFORME>");
        }
        try {
            info=lector.readUTF();
        } catch (IOException error) {
            System.out.println("ERROR:<AL LEER EL INFORME>");
        }
        try {
            lector.close();
        } catch (IOException error) {
            System.out.println("ERROR:<AL CERRAR EL INFORME>");
        }
        System.out.println(info);
    }
}
class Alumno implements Serializable{
    String boleta[][];
    String nombre;
    double promedio;
    int numeroControl;
    boolean existe;
    Alumno (String nom,int noCont){
        nombre=nom;
        numeroControl=noCont;
        promedio=0;
        existe=true;
        boleta=null;
    }
    public static Alumno[] crearAlumnos(){
        Alumno arr[]=null;
        BufferedReader lector=null;
        String cad,nom;
        int cont=0,noCont;
        try {
            lector=new BufferedReader(new FileReader ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Alumnos.txt"));
            do {
                cad=lector.readLine();
                if (cad!=null) {
                    cont++;
                }
            } while (cad!=null);
            arr=new Alumno[cont];
            lector.close();
            lector=new BufferedReader(new FileReader ("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Alumnos.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO ALUMNOS> O\n");
            System.out.println("ERROR:<TERMINO DEL CONTENIDO DEL ARCHIVO ALUMNOS>");
        }
        cont=0;
        cad=null;
        do {
            try {
                cad=lector.readLine();
                if (cad!=null && !cad.equalsIgnoreCase("")) {
                    noCont=Integer.parseInt(cad.substring(0,8).trim());
                    nom=cad.substring(8,cad.length()).trim();
                    if (nom.equalsIgnoreCase(""))
                        nom="No tiene nombre";
                    arr[cont]=new Alumno(nom,noCont);
                    cont++;
                }    
            } catch (IOException error) {
                System.out.println("TERMINO DEL CONTENIDO DEL ARCHIVO ALUMNOS");
            }catch (StringIndexOutOfBoundsException error) {
                System.out.println("ERROR:<LA MATRICULA "+(cont+1)+" NO ESTA COMPLETA (ARCHIVO:ALUMNOS)>");
                System.out.println("-----------------------------------------------------------------------------");
            }catch (NumberFormatException error){
                System.out.println("ERROR:<LA MATRICULA "+(cont+1)+" NO TIENE FORMATO DE MATRICULA (ARCHIVO:ALUMNOS)>");
                System.out.println("-----------------------------------------------------------------------------");
            }
        } while (cad!=null);
        try {
            lector.close();
        } catch (IOException error) {
            System.out.println("ERROR:<AL CERRAR EL ARCHIVO ALUMNOS>");
        }
        return arr;
    }
    public void anotarCalif(){
        BufferedReader lector=null;
        String cad,mate="",calif="";
        int noCont,i,j;
        boolean iden,fin;
        try {
            lector=new BufferedReader(new FileReader("C:\\Users\\Carlos Jahir\\Documents\\NetBeansProjects\\Archivos_Alumnos\\Archivos\\Calificaciones.txt"));
        } catch (IOException error) {
            System.out.println("ERROR:<AL ABRIR EL ARCHIVO CALIFICACIONES>");
        }
        fin=true;
        do {
            try {
                cad=lector.readLine();
                if (cad!=null) {
                    if (!cad.equalsIgnoreCase("")) {
                        noCont=Integer.parseInt(cad.substring(0,8).trim());
                        if (noCont==this.numeroControl && cad.charAt(8)==' ') {
                            cad=cad.substring(8,cad.length()).trim();
                            if (!cad.equalsIgnoreCase("")) {
                                this.contarMat(cad);
                                for (i=0,j=0,iden=true;i<cad.length();i++) {
                                    switch (cad.charAt(i)) {
                                        case ' ':
                                                boleta[j][0]=mate.trim();
                                                boleta[j][2]=calif.trim();
                                                mate="";
                                                calif="";
                                                iden=true;
                                                j++;
                                            break;
                                        case '-':
                                            iden=false;
                                            break;
                                        default:
                                            if (iden==true)
                                                mate+=cad.charAt(i);
                                            else
                                                calif+=cad.charAt(i);
                                    }
                                }
                                boleta[j][0]=mate.trim();
                                boleta[j][2]=calif.trim();
                            }
                            fin=false;
                        }
                    }  
                }
                else
                    throw new notFoundAlumException(nombre,numeroControl);
            } catch (IOException error) {
            }catch (StringIndexOutOfBoundsException error) {
            }catch (NumberFormatException error){
            }catch (notFoundAlumException noExiste){
                System.out.println(noExiste);
                existe=false;
                fin=false;
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        } while (fin);
        try {
            lector.close();
        } catch (IOException error) {
            System.out.println("ERROR:<AL CERRAR EL ARCHIVO ALUMNOS>");
        }
    }
    public void contarMat(String cad){
        int i,cont;
        for (i=0,cont=1;i<cad.length();i++)
            if (cad.charAt(i)==' ')
                cont++;
        boleta=new String[cont][3];
    }
    public void nomMat(String arr[][]){
        int i,j;
        boolean ind;
        if (boleta!=null) {
            for (i=0;i<boleta.length;i++) {
            try {
                for (j=0,ind=true;ind;j++) {
                    if (boleta[i][0].equals(arr[j][0])) {
                        boleta[i][1]=arr[j][1];
                        ind=false;
                    }
                }
            } catch ( ArrayIndexOutOfBoundsException noEsta) {
                try {
                    throw new notFoundMateException(boleta[i][0],nombre);
                } catch (notFoundMateException error) {
                    System.out.println(error);
                }
            }
            }
        }
    }
    @Override
    public String toString(){
        String cad;
        int i,mat=0,j;
        promedio=0;
        cad="Numero de Control: "+numeroControl+"\t\t\tNombre: "+nombre+"\r\n\n";
        cad+="\t\t\tCALIFICACIONES\r\n\n";
        if (boleta!=null) {
            cad+="Clave\t\t\tNombre de Materia\t\tCalificacion\r\n\n";
            for (i=0;i<boleta.length;i++) {
                if (boleta[i][0]!=null && boleta[i][1]!=null && boleta[i][2]!=null) {
                    try {
                            promedio+=Double.parseDouble(boleta[i][2]);
                            cad+=boleta[i][0]+"\t\t"+boleta[i][1]+"\t\t"+boleta[i][2]+"\r\n";
                            mat++;
                    } catch (NumberFormatException error) {
                        System.out.println("ERROR:<CONVERSION DE CALIFICACION ERRONEA EN LA CALIFICACION DE: "+boleta[i][1]+" >");
                    }
                }
                else
                    cad+="\t\t\t NO EXISTE UNA MATERIA \r\n";
            }
            if (mat==0)
                mat=1;
            promedio=promedio/mat;
        } else {
            cad+="\t\t   No Existen Calificaciones\r\n";
        }
        for (i=0,j=0;i<String.valueOf(promedio).length();i++)
            if (String.valueOf(promedio).charAt(i)=='.')
                j=i;
        promedio=Double.parseDouble(String.valueOf(promedio).substring(0,j+2));
        cad+="\r\nPromedio: "+promedio;
        cad+="\r\n\n---------------------------------------------------------------------------\r\n\n";
        return cad;
    }
}
class notFoundAlumException extends Exception{
    String nom;
    int noCont;
    notFoundAlumException(String nom,int noCont){
        this.nom=nom;
        this.noCont=noCont;
    }
    @Override
    public String toString(){
        String cad;
        cad="ERROR:<EL ALUMNO CON NUMERO DE CONTROL: "+noCont+" Y NOMBRE: "+nom+" NO EXISTE>";
        return cad;
    }
}
class notFoundMateException extends Exception{
    String clave,nom;
    notFoundMateException(String clave,String nom){
        this.clave=clave;
        this.nom=nom;
    }
    @Override
    public String toString(){
        String cad;
        cad="ERROR:<LA MATERIA CON CLAVE: "+clave+"DEL ALUMNO: "+nom+" NO EXISTE>";
        return cad;
    }
}