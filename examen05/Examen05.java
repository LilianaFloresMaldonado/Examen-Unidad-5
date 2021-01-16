
package examen05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Examen05 {
     public static void main(String[] args) {
        try {
            FileReader fr;
            BufferedReader bf;
            String numeros;
            String Arreglo[];
            fr = new FileReader("‪C:\\Users\\Graciela\\Desktop\\Mi_Archivo.txt");
            bf = new BufferedReader(fr);
            
            numeros = bf.readLine();
            Arreglo = numeros.split(" ");
            System.out.println("Numeros encontrados en el archivo: "+"\n"+ Arrays.toString(Arreglo));
            bf.close();
            fr.close();
            int M[] = new int[Arreglo.length];

            for (int i = 0; i < Arreglo.length; i++) {
                M[i] = Integer.parseInt(Arreglo[i]);
            }
            Quick(M, 0, M.length - 1);
            System.out.println("Arreglo ordenado\n" + Arrays.toString(M));

        } catch (IOException ex) {
            System.out.println("Error");
        }
     }

     
     public static void Quick(int M[], int primer, int ultima) {
        int i, j, aux, pivote;
        i = primer;
        j = ultima;
        pivote = M[(i + j) / 2];
        do {
            while (M[i] < pivote) {
                i++;
            }
            while (M[j] > pivote) {
                j--;
            }
            if (i <= j) {
                aux = M[i];
                M[i] = M[j];
                M[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        
        if (j > primer) {
            Quick(M, primer, j);
        }
        if (i < ultima) {
            Quick(M, i, ultima);
        }
    }

}
