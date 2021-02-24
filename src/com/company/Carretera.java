package com.company;

public class Carretera {

    int ancho;
    int alto;
    Calle Calle[][];

    public Carretera(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        Calle = new Calle[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int x = 0; x < ancho; x++) {
                Calle[i][x] = new Calle(obtenerCaracter(x, i), 1);
            }
        }
    }

    public void pintarCarretera() {
        for (int i = 0; i < alto; i++) {
            for (int x = 0; x < ancho; x++) {
                Calle[i][x].imprimirCasilla2(0);
            }
            System.out.println();
        }
    }

    public char obtenerCaracter(int columna, int fila) {
        if (fila % 2 != 0)
            columna = columna;

        return '_';
    }
}