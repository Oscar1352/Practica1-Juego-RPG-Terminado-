package com.company;
import java.util.Scanner;
import java.lang.String;
import java.util.Scanner;

public class TerminosDelJuego {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLANCO_SUBRAYADO = "\033[2;47;30m";

    int terms;

    public void Termino() {
        //Establezco mis variables
        int edad, terms, carro, menu, reto, pis, riv, orden = 0;
        String nom, nick, veh = "";

        //Se le pide al usuario aceptar o no los terminos para continuar en el juego
        System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"Por favor, declare que acepta los términos y condiciones del juego"+ANSI_RESET);
        System.out.println("1) Si Acepto");
        System.out.println("2) No Acepto");
    }
}

