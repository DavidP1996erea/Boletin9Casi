package Ejercicio3;

import java.util.Scanner;

public class Discografica {


    public static void llenarArray(int [] [] array){

        int contador=1;

        for(int i = 0; i<100;i++) {

            array[i][0] = contador;
            contador++;

        }
    }


    public static void votacion(int[][] array, int numPersonas){

        while (numPersonas>0){

                System.out.println("Votación de la persona " + numPersonas);
                elegirCancion(array);

                numPersonas--;
        }
    }



    public static void elegirCancion(int[][] array){
        Scanner sc = new Scanner(System.in);

        int cancionVotada;
        int contador=0;

        while (contador<5){
            System.out.println("Introduzca la canción que desea votar");
            cancionVotada=sc.nextInt();

            for(int i = 0; i<100;i++){

                    if (array[i][0] == cancionVotada) {

                        array[i][1]=array[i][1]+1;
                        contador++;
                }
            }
        }

        ordenar(array);
    }



    public static void ordenar(int[][] array) {
        int aux;
        int aux2;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i][1] < array[j][1]) {
                    aux = array[i][1];
                    array[i][1] = array[j][1];
                    array[j][1] = aux;
                    aux2 = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = aux2;
                }
            }
        }
    }

    public static int [][] mostrarDatos(int [][]array ){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < 2; j++){
                if(array[i][1] != 0) {
                    System.out.print(array[i][j] +"  ");
                }
            }
            if(array[i][1] != 0) {
                System.out.println("");
            }
        }

        return array;
    }






}
