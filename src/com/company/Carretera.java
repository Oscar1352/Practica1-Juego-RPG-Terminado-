package com.company;

public class Carretera {
    //Llamo mi clase
    Pistas pistas = new Pistas();

    //Establezco mis variables
    int ancho;
    int anchopista=pistas.getlargo();
    int alto;
    Calle Calle[][];

    public Carretera(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        int anchopista=pistas.getlargo();
        Calle = new Calle[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int x = 0; x < ancho; x++) {
                Calle[i][x] = new Calle(obtenerCaracter(x, i), 1);
            }
        }
    }

    //Establezco el tamaño de mi caretera
    public void pintarCarretera() {
        for (int i = 0; i < alto; i++) {
            for (int x = 0; x < ancho; x++) {
                Calle[i][x].imprimirCasilla2(0);
            }
            System.out.println();
        }
    }

    //Me coloca los guiones mostrando el avance que tiene el vehiculo
    public void pintarAvance() {
        for (int i = 0; i < alto; i++) {
            for (int x = 0; x < ancho; x++) {
                Calle[i][x].imprimirCasilla2(0);
            }
            System.out.print("");
        }
    }

    //EStablezco la cadena de "-" En mi "carretera"
    public char obtenerCaracter(int columna, int fila) {
        if (fila % 2 != 0)
            columna = columna;

        return '_';
    }
}