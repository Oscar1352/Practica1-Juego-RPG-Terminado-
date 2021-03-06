package com.company;

import java.util.Scanner;
import java.lang.String;

public class JUEGOEJECUTABLE {

    //Clase Principal
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

        //Llamo mi clase Usuario
        Usuario usuario = new Usuario();

        //Llamo mi clase de Carros
        Carros carros = new Carros();

        //Aceptar términos y condiciones de juegos
        TerminosDelJuego terminosDelJuego = new TerminosDelJuego();
        terminosDelJuego.Termino();

            do {
            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
            Scanner Termino = new Scanner(System.in);
            terms = Termino.nextInt();
        } while ( terms < 1 || terms > 2 );
            switch (terms) {
                case 1:
                        //Solicito la información básica del usuario

                    usuario.DatosUsuario();
                        //Doy la lista de vehiculos para el corredor
                        System.out.print("\n\t\t\t\t"+ANSI_BLANCO_NEGRITA+"Los autos Disponibles son:"+ANSI_RESET+" ");

                    //Imprimo mis autos
                    System.out.print("\n1.  ");carros.Ferrari();
                    System.out.print("2.  ");carros.Honda();
                    System.out.print("3.  ");carros.BMW();
                        System.out.println("\n4)SALIR");
                    do {
                        System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su opción:"+ANSI_RESET+" ");
                        Scanner Carro = new Scanner(System.in);
                        carro = Carro.nextInt();
                    } while ( carro < 1 || carro > 4 );
                        //Establezco la condicion y limites del menú de los vehiculos
                        //Establezco el switch para escoger el vehiculo
                        switch (carro) {
                            case 1:
                                //El usuario escogió el Ferrari
                                System.out.print("\nSu auto escogido es el: ");
                                carros.Ferrari();
                                //Establezco un valor para mi clase vehiculo del usuario
                                usuario.setvehiculo("Ferrari");
                                System.out.println("\n"+ANSI_GREEN+"¡¡¡Felicidades ya tiene nuevo Vehiculo!!!"+ANSI_RESET);
                                System.out.println("\n"+ANSI_YELLOW+"¡¡¡Se te fueron otorgadas 30 gemas y 50 monedas de Oro!!!"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 2:
                                //El usuario escogió el Honda

                                System.out.print("\nSu auto escogido es el: ");
                                carros.Honda();
                                //Establezco un valor para mi clase vehiculo del usuario
                                usuario.setvehiculo("Honda");
                                System.out.println("\n\t\t\t"+ANSI_GREEN+"¡¡¡Felicidades ya tiene nuevo Vehiculo!!!"+ANSI_RESET);
                                System.out.println("\n"+ANSI_YELLOW+"¡¡¡Se te fueron otorgadas 30 gemas y 50 monedas de Oro!!!"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 3:
                                //El usuario escogió el BMW
                                System.out.print("\nSu auto escogido es el: ");
                                carros.BMW();
                                //Establezco un valor para mi clase vehiculo del usuario
                                usuario.setvehiculo("BMW");
                                System.out.println("\n"+ANSI_GREEN+"¡¡¡Felicidades ya tiene nuevo Vehiculo!!!"+ANSI_RESET);
                                System.out.println("\n"+ANSI_YELLOW+"¡¡¡Se te fueron otorgadas 30 gemas y 50 monedas de Oro!!!"+ANSI_RESET);
                                usuario.setgemas(+30);
                                usuario.setoro(+50);
                                break;
                            case 4:
                                //No Escogió ningun auto
                                System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                                System.exit(0);
                                break;
                        }

                        //Establezco los premios de inicio
                    gemas=gemas+30;
                    oro=oro+50;
                    //Establezco un if para que me dé el menú solamente si se escoge un vehiculo dado
                    if (carro<=3 && carro>=0){
                        menu();
                    }
                    //Vinculo mi if a mi menú para no crear conflictos
                    else if (carro==4){
                        //El usuario escogió salir del menu de autos
                        System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                        System.exit(0);
                    }
                    else{
                        //El usuario no ingresó un valor permitido
                        System.out.println(ANSI_RED+ "Opcion invalida"+ANSI_RESET);
                    }

                    break;
                case 2:
                    //EL usuario no aceptó los términos ni condiciones del juego
                    System.out.println("\n\t\t\t"+ANSI_RED +"Lo Sentimos no puede ingresar al Videojuego, Hasta Luego :D"+ANSI_RESET);
                    System.exit(0);
                    break;
            }
    }

    //Clase de Menú
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

        //Llamo mis clases
        Competicion competicion = new Competicion();
        Ruleta myClase = new Ruleta();
        Garage garage = new Garage();
        Pistas pistas = new Pistas();
        EstadisticasYReportes estadisticasYReportes = new EstadisticasYReportes();

        //Empieza mi programa
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
                competicion.Competicion();
                break;
            case 2:

                //Menú del modo de Ruleta
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"RULETA:"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                myClase.Ruleta();
                break;
            case 3:

                //Menú del modo de Garaje
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"GARAJE"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                garage.Garage();
                break;
            case 4:

                //Menú del modo de Pistas
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"PISTAS"+ANSI_RESET+"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();System.out.println("");
                pistas.pistaTierra();
                pistas.pistaArena();
                pistas.pistaConcreto();
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
                        //Regreso al menú
                        menu();
                        break;
                }
                break;
            case 5:

                //Menú del modo de ESTADISTICAS Y REPORTES
                Usuario.Nickname();System.out.print("\t\t\t"+ANSI_BLANCO_NEGRITA+"ESTADISTICAS Y REPORTES:"+ANSI_RESET +"\t\t\tOro=");Usuario.Oro();System.out.print(" Gemas=");
                Usuario.Gemas();
                estadisticasYReportes.Estadistica();

                break;
            case 6:
                //Menú de Salir
                System.out.println("\n\t\t\t"+ANSI_RED+ "Espero hayas disfrutado del juego, nos vemos :D"+ANSI_RESET);
                System.exit(0);
                break;
        }

    }
}