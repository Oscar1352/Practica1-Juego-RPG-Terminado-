package com.company;

public class ArregloCarrosActuales {

    public static void Arreglo  (String[] args){
            // declara un array de enteros.
            int[] arr;
        int[] miArrreglo;


        // asignando memoria para 5 enteros.
            arr = new int[5];
        miArrreglo = new int[5];
            // inicializa el primer elemento del array
            arr[1] = 10;

            // inicializa el segundo elemento del array
            arr[2]= 20;
        // inicializa el segundo elemento del array
        arr[3]= 40;
        // inicializa el segundo elemento del array
        arr[4]= 40;

            // y así...
        miArrreglo= new int[]{1, 5, 7, 9, 4, 5, 100};
        arr[1] = 10;
        arr[2]= 20;
        arr[3] = 30;
        arr[4]= 40;

            // accediendo a los elementos del array
            for (int i = 0; i <arr.length; i++)
                System.out.println("Elemento en el índice " + i +
                        " : "+ miArrreglo);
        }
}
