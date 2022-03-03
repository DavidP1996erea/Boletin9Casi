package Ejercicio4;

import java.util.Locale;
import java.util.Scanner;

enum Equipos {
    BETIS, SEVILLA, MADRID, BARCELONA, RUBENTUS, ANGELETIC, FURBITO, RAIO, CADIZ, GRANADA, JAEN, ARSENAL, DIABLO,
    ELALEX, INTELLIJ, GENSHIN, FNATIC, VALORANT
}

public class Liga {

    private int golesFavor;
    private int golesContra;
    private int puntuacion;
    private int golesTotales;
    private int golesRecibidosTotales;
    private int puntosTotales;
    private int numeroDePartidos;
    private Equipos equipos;

    public Liga(Equipos equipos) {

        this.equipos = equipos;
        golesFavor = 0;
        golesContra = 0;
        puntuacion = 0;
        golesTotales = 0;
        golesRecibidosTotales = 0;
        puntosTotales = 0;
        numeroDePartidos = 0;

    }

    public static Liga[] crearObjetos(int numeroEquipos) {
        Scanner sc = new Scanner(System.in);
        Liga[] ligas = new Liga[numeroEquipos];

        for (int i = 0; i < numeroEquipos; i++) {
            System.out.println("Introduzca el nombre del equipo numero " + i);
            ligas[i] = new Liga(comprobarNombre(Equipos.valueOf(sc.next().toUpperCase(Locale.ROOT))));

        }


        return ligas;

    }


    public static void metodoBurbuja(Liga [] burbuja) {

        Liga aux;

        for (int i = 0; i < burbuja.length; i++) {
            for (int j = i; j < burbuja.length; j++) {

                if (burbuja[i].puntosTotales > burbuja[j].puntosTotales) {

                    aux = burbuja[i];

                    burbuja[i] = burbuja[j];
                    burbuja[j] = aux;
                }
            }
        }

        for(Liga x : burbuja){

            System.out.println(x.getEquipos()  +  " " + x.numeroDePartidos + " " + x.golesTotales + " "+ x.puntosTotales);

        }
    }


    public static Equipos comprobarNombre(Equipos equipo) {

        Equipos nombreCorrecto = null;

        for (Equipos x : Equipos.values()) {

            if (x.equals(equipo)) {

                nombreCorrecto = equipo;
            }
        }

        return nombreCorrecto;
    }


    public static Liga[] partido(Liga[] equipos) {

        Scanner sc = new Scanner(System.in);
        Equipos equipoLocal;
        Equipos equiposVisitante;

        int golesLocal;
        int golesVisitante;
        System.out.println("Introduzca que dos equipos van a jugar de la siguiente lista: ");

        for (Liga x : equipos) {
            System.out.println(x.getEquipos());
        }

        System.out.println("Introduzca el nombre del equipo local");
        equipoLocal = Equipos.valueOf(sc.next().toUpperCase(Locale.ROOT));

        System.out.println("Introduzca los goles marcados a favor del equipo local");
        golesLocal=sc.nextInt();

        System.out.println("Introduzca el nombre del equipo visitante");
        equiposVisitante = Equipos.valueOf(sc.next().toUpperCase(Locale.ROOT));

        System.out.println("Introduzca los goles marcados a favor del equipo visitante");
        golesVisitante=sc.nextInt();



        for (int i = 0; i < equipos.length; i++) {

            if (equipos[i].equipos.equals(equipoLocal)) {

                equipos[i].numeroDePartidos++;

                equipos[i].setGolesFavor(golesLocal);
                equipos[i].setGolesContra(golesVisitante);

                equipos[i].golesTotales=equipos[i].golesTotales+equipos[i].golesFavor;
                equipos[i].golesRecibidosTotales= equipos[i].golesRecibidosTotales+equipos[i].golesContra;

                if(golesLocal>golesVisitante){

                    equipos[i].puntuacion=equipos[i].puntuacion+3;

                }else if(golesLocal==golesVisitante){

                    equipos[i].puntuacion=equipos[i].puntuacion+1;
                }
                equipos[i].puntosTotales=equipos[i].puntuacion;

                System.out.println("El equipo " + equipos[i].getEquipos() + " metió estos goles " + equipos[i].golesFavor);
            }

            if (equipos[i].equipos.equals(equiposVisitante)) {
                equipos[i].numeroDePartidos++;

                equipos[i].setGolesFavor(golesVisitante);
                equipos[i].setGolesContra(golesLocal);

                equipos[i].golesTotales=equipos[i].golesTotales+equipos[i].golesFavor;
                equipos[i].golesRecibidosTotales= equipos[i].golesRecibidosTotales+equipos[i].golesContra;


                if(golesLocal<golesVisitante){

                    equipos[i].puntuacion=equipos[i].puntuacion+3;

                }else if(golesLocal==golesVisitante){

                    equipos[i].puntuacion=equipos[i].puntuacion+1;
                }

                equipos[i].puntosTotales=equipos[i].puntuacion;

                System.out.println("El equipo " + equipos[i].getEquipos() + " metió estos goles " + equipos[i].golesFavor);

            }
        }

        metodoBurbuja(equipos);

        return equipos;
    }


    public static void jornada(Liga [] ligas){

        int numeroPartidos=ligas.length/2;


        while (numeroPartidos>1){

            partido(ligas);

            numeroPartidos--;
        }

    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public int getGolesTotales() {
        return golesTotales;
    }

    public void setGolesTotales(int golesTotales) {
        this.golesTotales = golesTotales;
    }

    public int getGolesRecibidosTotales() {
        return golesRecibidosTotales;
    }

    public void setGolesRecibidosTotales(int golesRecibidosTotales) {
        this.golesRecibidosTotales = golesRecibidosTotales;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
