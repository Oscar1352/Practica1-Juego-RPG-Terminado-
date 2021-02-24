package com.company;
import sun.usagetracker.UsageTrackerClient;

import java.util.Scanner;
import java.lang.String;

public class Practica1 {
    public static void main(String[] args) {
        int gemas=0, oro=0;
        //Declaro Variables de colores
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
        String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";

        //Declaro Variables locales
        String nom, nick="", veh="";
        int edad, terms, carro, menu,reto,pis,riv,orden=0;
        //Aceptar términos y condiciones de juegos
        TerminosDelJuego myClass = new TerminosDelJuego();
        myClass.Termino();
            do {
            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
            Scanner Termino = new Scanner(System.in);
            terms = Termino.nextInt();
        } while ( terms < 1 || terms > 2 );
            switch (terms) {
                case 1:
                        //Solicito la información básica del usuario
                    Usuario prueba = new Usuario();
                    prueba.DatosUsuario();
                        //Doy la lista de vehiculos para el corredor
                        System.out.print("\n\t\t\t\t"+ANSI_BLANCO_NEGRITA+"Los autos Disponibles son:"+ANSI_RESET+" ");
                    Carros miClass = new Carros();
                    System.out.print("\n1.  ");miClass.Ferrari();
                    System.out.print("2.  ");miClass.Honda();
                    System.out.print("3.  ");miClass.BMW();
                        System.out.println("\n4)SALIR");
                    do {
                        System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su opción:"+ANSI_RESET+" ");
                        Scanner Carro = new Scanner(System.in);
                        carro = Carro.nextInt();
                    } while ( carro < 1 || carro > 4 );
                        //Establezco la condicion y limites del menú de los vehiculos
                        //Establezco el switch para escoger el vehiculo
                    Usuario usuario=new Usuario();
                        switch (carro) {
                            case 1:
                                System.out.print("\nSu auto escogido es el: ");
                                miClass.Ferrari();
                                usuario.setvehiculo("Ferrari");
                                System.out.println("\n"+ANSI_YELLOW+"Se te fueron otorgadas 30 gemas y 50 monedas de Oro"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 2:
                                System.out.print("\nSu auto escogido es el: ");
                                miClass.Honda();
                                usuario.setvehiculo("Honda");
                                System.out.println("\n"+ANSI_YELLOW+"Se te fueron otorgadas 30 gemas y 50 monedas de Oro"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 3:
                                System.out.print("\nSu auto escogido es el: ");
                                miClass.BMW();
                                usuario.setvehiculo("BMW");
                                System.out.println("\n"+ANSI_YELLOW+"Se te fueron otorgadas 30 gemas y 50 monedas de Oro"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 4:
                                System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                                System.exit(0);
                                break;
                        }
                            //Establezco un if para que me dé el menú solamente si se escoge un vehiculo dado
                    gemas=gemas+30;
                    oro=oro+50;
                    if (carro<=3 && carro>=0){
                        menu();
                    }
                    //Vinculo mi if a mi menú para no crear conflictos
                    else if (carro==4){
                        System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                        System.exit(0);
                    }
                    else{
                        System.out.println(ANSI_RED+ "Opcion invalida"+ANSI_RESET);
                    }

                    break;
                case 2:
                    System.out.println("\n\t\t\t"+ANSI_RED +"Lo Sentimos no puede ingresar al Videojuego, Hasta Luego :D"+ANSI_RESET);
                    System.exit(0);
                    break;
            }
    }
    public static void menu(){

        //Colores
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
        String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";
        //Variables
        int gemas=0, oro=0, menu, pis;
        Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"Menú general del juego"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
        Usuario.Gemas();
        System.out.println("\n1) COMPETIR");
        System.out.println("2) RULETA");
        System.out.println("3) GARAGE");
        System.out.println("4) PISTAS");
        System.out.println("5) ESTADISTICAS Y REPORTES");
        System.out.println("6) SALIR");
        do {
            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
            Scanner Menu = new Scanner(System.in);
            menu = Menu.nextInt();
        }while ( menu < 1 || menu > 6 );
        //Establezco el menú principal del juego
        switch (menu){
            case 1:
                //Menú del modo de Competición
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"COMPETITCIÓN:"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                System.out.println("\nEn qué pista desea competir:");
                Pistas mipista = new Pistas();
                mipista.pistaTierra();
                mipista.pistaArena();
                mipista.pistaConcreto();
                System.out.println("4) Regresar");
                do {
                    System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                    Scanner Pis = new Scanner(System.in);
                    pis = Pis.nextInt();
                }while ( pis < 1 || pis > 4 );
                //Declaro el switch de las pistas
                //Declaro mi variable y numero aleatorio
                switch (pis){
                    case 1:
                        Usuario.Nickname();System.out.println("\t\t\tBienvenido a la pista de Arena:  \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                        Usuario.Gemas();
                        //Genero Los numeros aleartorios para los turnos
                        //Creo sistema para que no se repitan los competidores
                        Rivales myclass = new Rivales();
                        myclass.ordenRiv();
                        System.out.println("\t\t\tSuerte en tu Carrera.");
                        break;
                    case 2:
                        Usuario.Nickname();System.out.println("\t\t\tBienvenido a la pista de Tierra: \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                        Usuario.Gemas();
                        //Genero Los numeros aleartorios para los turnos
                        //Creo sistema para que no se repitan los competidores
                        Rivales myclass1 = new Rivales();
                        myclass1.ordenRiv();
                        System.out.println("\t\t\tSuerte en tu Carrera.");
                        break;
                    case 3:
                        Usuario.Nickname();System.out.println("\t\t\tBienvenido a la de Concreto: \t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                        Usuario.Gemas();
                        //Genero Los numeros aleartorios para los turnos
                        //Creo sistema para que no se repitan los competidores
                        Rivales myclass2 = new Rivales();
                        myclass2.ordenRiv();
                        System.out.println("\t\t\tSuerte en tu Carrera.");
                        break;
                    case 4:
                        menu();
                        System.out.println("Gracias por Jugar, nos vemos pronto");
                        break;
                }
                break;
            case 2:
                //Menú del modo de Ruleta

                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"RULETA:"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                Ruleta myClase = new Ruleta();
                myClase.Ruleta();
                break;
            case 3:
                //Menú del modo de Garaje
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"GARAJE"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                Garage garage = new Garage();
                garage.Garage();
                break;
            case 4:
                //Menú del modo de Pistas

                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"PISTAS"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();System.out.println("");
                Pistas mispistas = new Pistas();
                mispistas.pistaTierra();
                mispistas.pistaArena();
                mispistas.pistaConcreto();
                System.out.println("¿Regresar al menú?");
                System.out.println("1. Si");
                int pista;
                do {
                    System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                    Scanner Pista = new Scanner(System.in);
                    pista = Pista.nextInt();
                }while ( pista !=1 );
                switch (pista){
                    case 1:
                        menu();
                        break;
                }
                break;
            case 5:
                //Menú del modo de ESTADISTICAS Y REPORTES

                Usuario.Nickname();System.out.println("\t\t\t"+ANSI_BLANCO_NEGRITA+"ESTADISTICAS Y REPORTES:"+ANSI_RESET +"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                break;
            case 6:
                //Menú de Salir
                System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                System.exit(0);
                break;
        }

    }
}