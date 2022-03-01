package principal;

public class Array {

    // Métodos de ordenación

    /**
     * Método burbuja
     * @param burbuja
     */

    public static void metodoBurbuja(int [] burbuja){

        int aux;

        for(int i = 0; i< burbuja.length;i++){
            for(int j=i; j<burbuja.length;j++){

                if(burbuja[i] > burbuja [j]){

                    aux=burbuja[i];

                    burbuja[i]= burbuja[j];
                    burbuja[j]=aux;
                }
            }
        }


        for (int x : burbuja){

            System.out.print(x + "  ");
        }

    }

    /**
     * Método selección directa
     * @param seleccion
     */

    public static void seleccionDirecta(int [] seleccion){

        int minimo;
        int aux;
        int i;

        for(i =0; i < seleccion.length;i++){
            minimo=i;

            for(int j = i+1; j < seleccion.length; j++){

                if(seleccion[minimo]>seleccion[j]){

                    minimo=j;

                }
            }

            aux=seleccion[i];
            seleccion[i]=seleccion[minimo];
            seleccion[minimo]=aux;

        }
        for (int x : seleccion){

            System.out.print(x + "  ");
        }

    }

    /**
     * Método quicksort
     * @param quick
     * @param izq
     * @param der
     * @return
     */

    public static int [] quicksort(int [] quick, int izq, int der ){

        int pivote=quick[izq];
        int i=izq;
        int j=der;
        int aux;

        while(i < j){

            while(quick[i] <= pivote && i < j)
                i++;

            while(quick[j] > pivote)
                j--;
            if (i < j) {
                aux= quick[i];
                quick[i]=quick[j];
                quick[j]=aux;
            }
        }

        quick[izq]=quick[j];
        quick[j]=pivote;

        if(izq < j-1)
            quicksort(quick,izq,j-1);
        if(j+1 < der)
            quicksort(quick,j+1,der);

        return  quick;

    }

    /**
     * Búsqueda secuencial
     * @param busqueda
     * @param numero
     */

    public static void busquedaSecuencial(int [] busqueda, int numero){


        for(int i = 0; i<busqueda.length;i++){

            if(busqueda[i]==numero){

                System.out.println("Se encontró el número " + busqueda [i] + " en la posición " + i);

            }
        }
    }

    /**
     * Insertar
     * @param miarray
     * @param dato
     * @param posVal
     * @return
     */


        public static int insertOrden(int[] miarray, int dato, int posVal) {
            int nuevaLong = -1;
            int indice = 0;
            if (dato > miarray[posVal]) {
                miarray[posVal+1] = dato;
            } else {
                if (dato < miarray[0]) {
                    for (int i = posVal; i >= 0; i--) {
                        miarray[i+1] = miarray[i];
                    }
                    miarray[0] = dato;
                } else {
                    while (miarray[indice] <= dato) {
                        indice++;
                    }
                    for (int i = posVal; i >= indice; i--) {
                        miarray[i+1] = miarray[i];
                    }
                    miarray[indice] = dato;
                }
            }

            return ( posVal+1 );

    }



    public static boolean busquedaBinaria(int [] array, int dato){

            int inicio=0;
            int fin =array.length-1;
            int mitad=(inicio+fin)/2;
            boolean encontrado=false;

            while(inicio<=fin && encontrado==false){


                if(array[mitad] == dato){

                    encontrado=true;

                }else {

                    if(array[mitad]>dato){
                        fin=mitad-1;
                    }else {
                        inicio=mitad+1;
                    }
                    mitad=(inicio+fin)/2;
                }
            }

            return encontrado;


    }



}
