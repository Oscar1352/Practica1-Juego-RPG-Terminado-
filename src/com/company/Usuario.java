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
    private static int Edad;
    private static int gemas;
    private static double oro;
    private static double orogastado;
    private static String vehiculo;
    private static int CanRivales;
    private static int gasgastado;
    private static int gascomprado;

    //Llamo mis clases
    Carros carros= new Carros();
    Pistas pistas= new Pistas();

    //Establezco mi constructor
    public Usuario(String Nombre, String Nickname, int Edad){
        this.Nombre = Nombre;
        this.Nickname = Nickname;
        this.Edad = Edad;

    }


    //Establezco mis getters y setters de mis atributos para acceder a ellos y editarlos
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
    public void setoro(double oro)
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

    //Rivales
    public int getrivales()
    {
        return this.CanRivales;
    }
    public void setrivales(int CanRivales)
    {
        this.CanRivales=CanRivales;
    }

    //Nickname
    public String getnickname()
    {
        return this.Nickname;
    }
    public void setnickname(String Nickname)
    {
        this.Nickname=Nickname;
    }

    //Nickname
    public double getorogastado()
    {
        return this.orogastado;
    }
    public void setorogastado(double orogastado)
    {
        this.orogastado=orogastado;
    }

    //GasolinaGastada
    public int getgasolinagastada()
    {
        return this.gasgastado;
    }
    public void setgasolinagastada(int gasgastado)
    {
        this.gasgastado=gasgastado;
    }

    //GasolinaComprado
    public int getgasolinacomprada()
    {
        return this.gascomprado;
    }
    public void setgasolinacomprada(int gascomprado)
    {
        this.gascomprado=gascomprado;
    }


    //Establezco los atributos principales del Usuario
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
        setnickname(Nickname);
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

    //Establezco el movimiento del usuario en la competencia
    public int MovimientoUsuario (){
        int n1 = (int)(Math.random()*10)+1;
        int n2 = (int)(Math.random()*5)+1;
        int x = carros.getpotencia();
        int y= carros.getcoellantas();
        int a= pistas.getcoeficiente();
        int z;
        z=(x*n1) + a +(y*n2);
        return z;
    }
}

