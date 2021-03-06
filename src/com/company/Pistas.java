package com.company;
class Pistas {

    public int ancho=80;
    public int alto = 1;

    //COLORES
    //Colores de letra
    public static final String ANSI_BLACK = "\u001B[30m";
    //Colores de fondo
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_CAFE_BACKGROUND = "\u001b[48;5;94m";
    public static final String ANSI_GRIS_BACKGROUND = "\u001B[47m";
    //Reset
    public static final String ANSI_RESET = "\u001B[0m";


    //Declaro mis variables y atributos
    String material;
    private static int largo;
    private static int coeficiente;
    private static String pista;

    //cuanta gasolina se necesita
    int gas;

    public Pistas(String material, int largo, int coeficiente, int gas) {
        this.material = material;
        this.largo = largo;
        this.coeficiente= coeficiente;
        this.gas = gas;
    }

    public Pistas() {

    }

    //Imprimo mis pistas y su información General
    public void pista(){
        Pistas tierra= new Pistas("Tierra",80,4,50);
        Pistas arena= new Pistas("Arena",90,2,45);
        Pistas concreto= new Pistas("Concreto",100,6,35);
        tierra.informacionGeneral();
        arena.informacionGeneral();
        concreto.informacionGeneral();

    }

    public void informacionGeneral(){
        System.out.println("\nPista de: "+this.material+"\t Largo de la pista: "+this.largo+"mts "+"\tCoeficiente de pista: "+this.coeficiente+
                "\t Gasolina necesaria: "+this.gas+"lts");

    }

    //ESTABLEZCO GETTERS Y SETTERS
    //Coeficientes
    public int getcoeficiente()
    {
        return this.coeficiente;
    }
    public void setcoeficiente(int coeficiente)
    {
        this.coeficiente=coeficiente;
    }
    //Coeficientes
    public int getlargo()
    {
        return this.largo;
    }
    public void setlargo(int largo)
    {
        this.largo=largo;
    }


    //Defino mis pistas y sus características
    public void pistaTierra(){
        //Pista de Tierra
        System.out.print(ANSI_CAFE_BACKGROUND + ANSI_BLACK);
        Pistas tierra= new Pistas("Tierra",80,4,80);
        tierra.informacionGeneral();
        Carretera Tierra = new Carretera(80,3);
        Tierra.pintarCarretera();
        System.out.println(ANSI_RESET);

    }
    public void pistaArena(){
        //Pista de Arena
        System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLACK);
        Pistas arena= new Pistas("Arena",90,2,90);
        arena.informacionGeneral();
        Carretera Arena = new Carretera(90,3);
        Arena.pintarCarretera();
        System.out.println(ANSI_RESET);

    }
    public void pistaConcreto(){
        System.out.print(ANSI_GRIS_BACKGROUND + ANSI_BLACK);
        Pistas concreto= new Pistas("Concreto",100,6,100);
        Carretera Concreto = new Carretera(100,3);
        concreto.informacionGeneral();

        Concreto.pintarCarretera();
        System.out.println(ANSI_RESET);

        }

    //Pista
    public String getpista()
    {
        return this.pista;
    }
    public void setpista(String pista)
    {
        this.pista=pista;
    }
    }