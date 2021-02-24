package com.company;

import java.util.Scanner;
public class Usuario {

    //Colores de las variables
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\033[2;41;30m";
    String ANSI_CYAN = "\033[2;46;30m";
    String ANSI_WHITE = "\033[2;47;30m";

    //Atributos
    String Nombre;
    private static String Nickname;
    int Edad;
    private static int gemas;
    private static double oro;
    private static String vehiculo;


    public Usuario(String Nombre, String Nickname, int Edad){
        this.Nombre = Nombre;
        this.Nickname = Nickname;
        this.Edad = Edad;

    }


    //Declaro gets y sets
    //Gemas
    public int getgemas()
    {
        return this.gemas;
    }
    public void setgemas(int gemas)
    {
        this.gemas=gemas;
    }

    //Oro
    public double getgoro()
    {
        return this.oro;
    }
    public void setoro(int oro)
    {
        this.oro=oro;
    }

    //Vehiculo
    public String getvehiculo()
    {
        return this.vehiculo;
    }
    public void setvehiculo(String vehiculo)
    {
        this.vehiculo=vehiculo;
    }



    //Usuario
    public Usuario() {

    }
    public void informacionGeneral(){
        System.out.println("\nSu nomnre es: " + this.Nombre);
        System.out.println("Su Nickname es: " + this.Nickname);
        System.out.println("Su edad es: " + this.Edad+" años");

    }
    public void info(){

    }
    public void DatosUsuario(){
        System.out.println("\n\t\t\t"+ANSI_RED+"Bienvenido"+
                ANSI_WHITE+" al"+ANSI_CYAN +" mejor" +ANSI_RED+" juego" +ANSI_WHITE +
                        ANSI_CYAN+" RPG"+ANSI_RED +" de"+ANSI_WHITE + " la"+ANSI_CYAN + " región"+ANSI_RESET);
        System.out.print("\nPor favor, ingrese su nombre : ");
        Scanner Menu = new Scanner(System.in);
        Nombre = Menu.nextLine();
        System.out.print("Ingrese su Nickname: ");
        Scanner nom  = new Scanner(System.in);
        Nickname = Menu.nextLine();
        System.out.print("Por Favor ingrese su edad: ");
        Scanner ed  = new Scanner(System.in);
        Edad = Menu.nextInt();
    }
    public static void Nickname(){
        System.out.print("\nSu Nickname es: " +Nickname);
    }
    public static int Gemas(){
        System.out.print(" " +gemas);
        return 0;
    }
    public static int Oro(){
        System.out.print(" " +oro);
        return 0;
    }
    public static void Vehiculo(){
        System.out.print(" " +vehiculo);
    }
}

