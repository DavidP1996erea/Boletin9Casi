package Ejercicio5;

import java.util.Scanner;

public class Confeccion {

    private int codVestido;
    private double precio;
    private double precioTotal;
    private int cantidad;
    private int cantidadTotal;


    public Confeccion(int codVestido){

        this.codVestido=codVestido;
        this.precio=0;
        this.precioTotal=0;
        this.cantidad=0;
        this.cantidadTotal=0;
    }

    public static int comprobarNumero(int codigo){

        Scanner sc = new Scanner(System.in);

        String codigoV;
        int codigoValido=0;
        boolean valido=false;
        codigoV= String.valueOf(codigo);

        while (valido==false)

        if(codigoV.length()==3){
            codigoValido=Integer.valueOf(codigoV);
            valido=true;
        }else {

            System.out.println("Código incorrecto, introduzca un número de 3 dígitos");
            codigoV=String.valueOf(sc.nextInt());
        }

        return codigoValido;
    }


    public static Confeccion [] crearArrayVestidos(int numeroVestidos){
        Scanner sc = new Scanner(System.in);
        Confeccion [] vestidos=new Confeccion[numeroVestidos];

        for(int i = 0; i<vestidos.length; i++){

            System.out.println("Introduzca el código de vestido " + i);

            vestidos[i]=new Confeccion(comprobarNumero(sc.nextInt()));

            System.out.println("Introduzca su precio");
            vestidos[i].precio=sc.nextDouble();

        }

        return vestidos;

    }





    public int getCodVestido() {
        return codVestido;
    }

    public void setCodVestido(int codVestido) {
        this.codVestido = codVestido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
