package principal;

import static principal.Array.*;

public class Main {

    public static void main(String[] args) {
        // write your code here


        int[] arrayPrueba = {25, 4, 2, 8, 9, 7, 5, 21, 14, 3, 87, 41, 55, 25, 148};


        System.out.println(busquedaBinaria(quicksort(arrayPrueba, 0, arrayPrueba.length-1), 41));

        // metodoBurbuja(arrayPrueba);

        // seleccionDirecta(arrayPrueba);


     /*   for (int x :  quicksort(arrayPrueba, 0, arrayPrueba.length-1) ){

            System.out.print(x + "  ");
        }

      */

        //   busquedaSecuencial(arrayPrueba, 21);

/*
        int[] miArray = {1, 2, 29, 30,31,32,0,0,0};
        int longitud =insertOrden(miArray, 2, 6);
        if (longitud == -1) {
            System.out.println("no se ha posido insertar");
        } else {

            for (int elemento : miArray) {
                System.out.print(elemento + "  ");

            }

        }

    }

 */




    }
}
