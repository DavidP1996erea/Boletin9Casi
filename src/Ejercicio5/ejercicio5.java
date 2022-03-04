package Ejercicio5;

import static Ejercicio5.Confeccion.*;

public class ejercicio5 {
    public static void main(String[] args) {



        for(Confeccion x : crearArrayVestidos(2) ){

            System.out.println(x.getCodVestido());
            System.out.println(x.getPrecio());
        }


    }
}
