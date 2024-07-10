package examen_diagnostico;
import java.util.Random;
public class Examen_Diagnostico {
    public static void main(String[] args) {
        Random ram = new Random();
        char mat[][];
        char voc[]={'A','E','I','O','U'};
        int car,fil,col;
        int cont[]=new int[5];
        fil=ram.nextInt(3)+5;
        col=ram.nextInt(3)+5;
        mat = new char[fil][col];
        for (fil=0;fil<mat.length;fil++) {
            for (col=0;col<mat[fil].length;col++) {
                car=ram.nextInt(5);
                switch (car) {
                    case 0: mat[fil][col]='A';
                        break;
                    case 1: mat[fil][col]='E';
                        break;
                    case 2: mat[fil][col]='I';
                        break;
                    case 3: mat[fil][col]='O';
                        break;
                    case 4: mat[fil][col]='U';
                        break;
                }
            }
        }
        for (fil=0;fil<mat.length;fil++)
            for (col=0;col<mat[fil].length;col++)
                switch (mat[fil][col]) {
                    case 'A':   if (fil==0)
                                    cont[0]++;
                        break;
                    case 'E':   if (fil==1)
                                    cont[1]++;
                        break;
                    case 'I':   if (fil==2)
                                    cont[2]++;
                        break;
                    case 'O':   if (fil==3)
                                    cont[3]++;
                        break;
                    case 'U':   if (fil==4)
                                    cont[4]++;
                        break;
                }
        for (fil=0;fil<mat.length;fil++) {
            for (col=0;col<mat[fil].length;col++)
                System.out.print(mat[fil][col]+"\t");
            if (fil<5)
                System.out.println("|\t"+voc[fil]+": "+cont[fil]+"\n");
            else
                System.out.println("\n");
        }
    }
}