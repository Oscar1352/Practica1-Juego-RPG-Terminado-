package com.company;

public class Calle{

    //EStablezco mis variables y carcaterísticas de mi cadena
    public int posicion;
    public char simbolo;
    public int ancho;
    public int alto = 3;

    public Calle(char simbolo, int ancho){
        this.posicion = 0;
        this.simbolo = simbolo;
        this.ancho = ancho;
    }

    public void imprimirCasilla2(int numLinea){
        if (numLinea < alto){
            for (int x = 0; x<ancho; x++){
                System.out.print(this.simbolo);
            }
        }
    }

    public void imprimirCasilla(){
        // imprimir 3 lineas
        for(int i = 0; i<alto;i++){

            // imprimir el ancho
            for (int x = 0; x<ancho; x++){
                System.out.print(this.simbolo);
            }
            System.out.print("\n");
        }
    }

}