package com.company;

import java.util.Scanner;

public class EstadisticasYReportes {
    //Colores
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
    String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";

    //Clases Externas
    Carros carros = new Carros();
    Usuario usuario = new Usuario();
    Pistas pistas = new Pistas();
    Rivales rivales = new Rivales();
    Competicion competicion=new Competicion();
    JUEGOEJECUTABLE juegoejecutable = new JUEGOEJECUTABLE();

    //EStablezco metodo principal de la clase de Estadistica
    public void Estadistica(){
        EstadísticasDePartida();
        ReportePorVehiculo();
        Regresar();
    }

    //Metodo para ver Estadisticas de la carrera
    public void EstadísticasDePartida(){
        int n=usuario.getrivales();
        System.out.println("\n\n\t\t\tEstadisticas de Partida");
        System.out.println("\n\nCantidad de Rivales: ");
        System.out.println(""+usuario.getrivales());
        System.out.println("\nNombre de Rivales: ");
        rivales.Rivales();
        System.out.println("\nDistancia Recorrida:");
        System.out.println(""+usuario.getgasolinagastada()+" kilometros");
        System.out.println("\nPista Usada:");
        System.out.println(""+pistas.getpista());
        System.out.println("\nPodio: ");
        if (usuario.getrivales()==2){
            System.out.println("Los Lugares son: ");
            System.out.println("1."+competicion.getPrimero());
            System.out.println("2."+competicion.getSegundo());
            System.out.println(ANSI_CYAN+"EL USUARIO ES EL COMPETIDOR A"+ANSI_RESET);
        }
        else if (usuario.getrivales()==3){
            System.out.println("Los Lugares son: ");
            System.out.println("1."+competicion.getPrimero());
            System.out.println("2."+competicion.getSegundo());
            System.out.println("3."+competicion.getTercero());
            System.out.println(ANSI_CYAN+"EL USUARIO ES EL COMPETIDOR A"+ANSI_RESET);
        }
        else if (usuario.getrivales()==4){
            System.out.println("Los Lugares son: ");
            System.out.println("1."+competicion.getPrimero());
            System.out.println("2."+competicion.getSegundo());
            System.out.println("3."+competicion.getTercero());
            System.out.println("4."+competicion.getCuarto());
            System.out.println(ANSI_CYAN+"EL USUARIO ES EL COMPETIDOR A"+ANSI_RESET);
        }
        else if (usuario.getrivales()==5){
            System.out.println("Los Lugares son: ");
            System.out.println("1."+competicion.getPrimero());
            System.out.println("2."+competicion.getSegundo());
            System.out.println("3."+competicion.getTercero());
            System.out.println("3."+competicion.getCuarto());
            System.out.println("3."+competicion.getQuinto());
            System.out.println(ANSI_CYAN+"EL USUARIO ES EL COMPETIDOR A"+ANSI_RESET);
        }
        else if (usuario.getrivales()==6){
            System.out.println("Los Lugares son: ");
            System.out.println("1."+competicion.getPrimero());
            System.out.println("2."+competicion.getSegundo());
            System.out.println("3."+competicion.getTercero());
            System.out.println("4."+competicion.getCuarto());
            System.out.println("5."+competicion.getQuinto());
            System.out.println("6."+competicion.getSexto());
            System.out.println(ANSI_CYAN+"EL USUARIO ES EL COMPETIDOR A"+ANSI_RESET);
        }
    }

    //Metodo para ver el reporte que ha tenido el vehiculo durante el juego
    public void ReportePorVehiculo(){
        System.out.println("\n\n\t\t\tReporte Por Vehiculo");
        System.out.println("\n\nNombre del Vehículo: ");
        System.out.println(""+usuario.getvehiculo());
        System.out.println("\nOro Gastado: ");
        System.out.println(""+usuario.getorogastado());
        System.out.println("\nCantidad  de Galones de Gasolina Gastados en el Juego: ");
        System.out.println(""+usuario.getgasolinagastada());
        System.out.println("\nCantidad de Gasolina Comprados en el juego: ");
        System.out.println(""+usuario.getgasolinacomprada());
    }

    //Regresar al menu
    public void Regresar() {
        System.out.println("\n\n¿Regresar al menú Principal?");
        System.out.println("1. SI");
        int Opcion;
        do {
            System.out.print(ANSI_BLANCO_SUBRAYADO + "Ingrese su elección:" + ANSI_RESET + " ");
            Scanner opcion = new Scanner(System.in);
            Opcion = opcion.nextInt();
        } while (Opcion !=1);
        switch (Opcion) {
            case 1:

                juegoejecutable.menu();
                System.out.println(ANSI_RED + "\n\t\t\t\t\t\tRegresaremos al menú" + ANSI_RESET);
                System.out.println("\t\t\tACTIVIDAD FINALIZADA \t\t\tOro=" + usuario.getgoro() + " Gemas=" + usuario.getgemas());
                break;
        }
    }
}
