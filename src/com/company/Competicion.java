package com.company;

import java.util.Scanner;

public class Competicion {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
    String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";

    //Establezco mis varibales
    int pis;

    //EStablezco a mis lugares del podio
    private static char Primero;
    private static char Ganador;
    private static char Segundo;
    private static char Tercero;
    private static char Cuarto;
    private static char Quinto;
    private static char Sexto;

    //Llamo mis clases
    JUEGOEJECUTABLE juegoejecutable= new JUEGOEJECUTABLE();
    Carros carros = new Carros ();
    Pistas pistas = new Pistas();

    //Estableco mi metodo de competicion
    public void Competicion(){
    System.out.println("\nEn qué pista desea competir:");

                System.out.println("1.");pistas.pistaTierra();
                System.out.println("2.");pistas.pistaArena();
                System.out.println("3.");pistas.pistaConcreto();
                System.out.println("4) Regresar");
                do {
        System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
        Scanner Pis = new Scanner(System.in);
        pis = Pis.nextInt();
    }while ( pis < 1 || pis > 4 );

    //Declaro el switch de las pistas
    int x= carros.getgasolina();
                switch (pis){
        case 1:
            if (x<80){
                System.out.println("\n\t\t\t"+ANSI_RED+ "No posees gasolina suficiente"+ANSI_RESET);
            }
            else{
                Usuario.Nickname();System.out.print("\t\t\tBienvenido a la pista de Tierra: \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                pistas.setlargo(80);
                pistas.setpista("Tierra");
                Usuario.Gemas();
            }
            break;
        case 2:
            if (x<90){
                System.out.println("\n\t\t\t"+ANSI_RED+ "No posees gasolina suficiente"+ANSI_RESET);
            }
            else {
                Usuario.Nickname();System.out.print("\t\t\tBienvenido a la pista de Arena:  \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                pistas.setlargo(90);
                pistas.setpista("Arena");
                Usuario.Gemas();
            }
            break;
        case 3:
            if (x<100){
                System.out.println("\n\t\t\t"+ANSI_RED+ "No posees gasolina suficiente"+ANSI_RESET);
            }
            else {
                Usuario.Nickname();System.out.print("\t\t\tBienvenido a la de Concreto: \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                pistas.setlargo(100);
                pistas.setpista("Concreto");
                Usuario.Gemas();
                break;
            }
        case 4:
            juegoejecutable.menu();
            System.out.println("Gracias por Jugar, nos vemos pronto");
            break;
    }
                System.out.println("\n\n"+ANSI_BLANCO_NEGRITA+"Escoge cuantos rivales deseas: "+ANSI_RESET);
                System.out.println("Puede escoger mínimo 2 rivales y como máximo 6 rivales");
    int riv;
                do {
        System.out.print("\n\n"+ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
        Scanner rivales = new Scanner(System.in);
        riv = rivales.nextInt();
    }while ( riv< 2 || riv > 6 );
    Usuario CanRiv= new Usuario();
    Rivales myclass2 = new Rivales();
                switch (riv){
        case 2:
            CanRiv.setrivales(2);
            myclass2.ordenRiv();
            break;
        case 3:
            CanRiv.setrivales(3);
            myclass2.ordenRiv();
            break;
        case 4:
            CanRiv.setrivales(4);
            myclass2.ordenRiv();
            break;
        case 5:
            CanRiv.setrivales(5);
            myclass2.ordenRiv();
            break;
        case 6:
            CanRiv.setrivales(6);
            myclass2.ordenRiv();
            break;
    }
    }

    //Getters y Setters
    //Podio de posiciones
    public char getGanador() {
        return this.Ganador;
    }
    public void setGanador(char Ganador){
        this.Ganador=Ganador;
    }

    //1
        public char getPrimero() {
            return this.Primero;
        }
        public void setPrimero(char Primero){
            this.Primero=Primero;
    }

    //2
    public char getSegundo() {
            return this.Segundo;
        }
        public void setSegundo(char Segundo){
            this.Segundo=Segundo;
    }

    //3
    public char getTercero() {
            return this.Tercero;
        }
        public void setTercero(char Tercero){
            this.Tercero=Tercero;
    }

    //4
    public char getCuarto() {
            return this.Cuarto;
        }
        public void setCuarto(char Cuarto){
            this.Cuarto=Cuarto;
    }

    //5
    public char getQuinto() {
            return this.Quinto;
        }
        public void setQuinto(char Quinto){
            this.Quinto=Quinto;
    }

    //6
    public char getSexto() {
            return this.Sexto;
        }
        public void setSexto(char Sexto){
            this.Sexto=Sexto;
    }
}
