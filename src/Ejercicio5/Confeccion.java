package Ejercicio5;

import java.util.Locale;
import java.util.Scanner;

public class Confeccion {

    private int codVestido;
    private double precio;
    private double precioTotal;
    private int cantidad;
    private int cantidadTotal;


    public Confeccion(int codVestido) {

        this.codVestido = codVestido;
        this.precio = 0;
        this.precioTotal = 0;
        this.cantidad = 0;
        this.cantidadTotal = 0;
    }

    public static int comprobarNumero(int codigo) {

        Scanner sc = new Scanner(System.in);

        String codigoV;
        int codigoValido = 0;
        boolean valido = false;
        codigoV = String.valueOf(codigo);

        while (valido == false)

            if (codigoV.length() == 3) {
                codigoValido = Integer.valueOf(codigoV);
                valido = true;
            } else {

                System.out.println("Código incorrecto, introduzca un número de 3 dígitos");
                codigoV = String.valueOf(sc.nextInt());
            }

        return codigoValido;
    }


    public static Confeccion[] crearArrayVestidos(int numeroVestidos) {
        Scanner sc = new Scanner(System.in);
        Confeccion[] vestidos = new Confeccion[numeroVestidos];

        for (int i = 0; i < vestidos.length; i++) {

            System.out.println("Introduzca el código de vestido " + i);

            vestidos[i] = new Confeccion(comprobarNumero(sc.nextInt()));

            System.out.println("Introduzca su precio");
            vestidos[i].precio = sc.nextDouble();

        }

        return metodoBurbuja(vestidos);

    }


    public static void ordenVenta(Confeccion[] vestidos) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduzca el código del vestido a comprar");
        int compra = comprobarNumero(sc.nextInt());
        for (int i = 0; i < vestidos.length; i++) {

            if (vestidos[i].getCodVestido() == compra) {
                System.out.println("Introduzca la cantidad de vestidos que desea comprar");
                vestidos[i].setCantidad(sc.nextInt());
                vestidos[i].precioTotal = vestidos[i].precio * vestidos[i].cantidad;
                vestidos[i].cantidadTotal = vestidos[i].cantidadTotal + vestidos[i].cantidad;
                System.out.println("El precio de la compra del vestido " + vestidos[i].getCodVestido() + " es: " + vestidos[i].precioTotal + "€");
            }
        }
    }

    public static void comprarVestidos(Confeccion[] vestidos) {
        Scanner sc = new Scanner(System.in);

        String respuesta;


        for (Confeccion x : vestidos) {

            System.out.println("El vestido con el código " + x.getCodVestido() + " cuesta " + x.getPrecio() + "€");
            System.out.println();
        }

        System.out.println("¿Desea comprar algún vestido?");
        respuesta = sc.nextLine();

        while (respuesta.equals("NO") == false) {

            ordenVenta(vestidos);

            System.out.println("¿Tiene más fichas?");
            respuesta = sc.nextLine().toUpperCase(Locale.ROOT);

        }

        for (Confeccion x : vestidos) {
            System.out.println("El vestido " + x.getCodVestido() + " con un precio de  " + x.getPrecio()
                    + " fue comprado " + x.getCantidadTotal() +
                    " con un total de " + x.getPrecioTotal() + "€");
        }
    }

    public static Confeccion[] metodoBurbuja(Confeccion[] burbuja) {

        Confeccion aux;

        for (int i = 0; i < burbuja.length; i++) {
            for (int j = i; j < burbuja.length; j++) {

                if (burbuja[i].getCodVestido() > burbuja[j].getCodVestido()) {

                    aux = burbuja[i];

                    burbuja[i] = burbuja[j];
                    burbuja[j] = aux;
                }
            }
        }

        return burbuja;


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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
}
