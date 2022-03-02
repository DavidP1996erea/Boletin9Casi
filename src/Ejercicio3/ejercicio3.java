package Ejercicio3;

import static Ejercicio3.Discografica.*;

public class ejercicio3 {
    public static void main(String[] args) {


        int [] [] discos = new int[100][2];


        llenarArray(discos);

        votacion(discos, 2);

        ordenar(mostrarDatos(discos));








    }
}
