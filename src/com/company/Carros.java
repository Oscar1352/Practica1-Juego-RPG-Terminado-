package com.company;

public class Carros {
    //Atributos

    private static String marca;
    private static String color;
    private static String motor;
    private static int potencia;
    private static String llantas;
    //cuanta gasolina tiene
    private static int gas;

    //General
    private static String vehiculo;




    //Vehiculo
    public String getvehiculo()
    {
        return this.vehiculo;
    }
    public void setvehiculo(String gevehiculomas)
    {
        this.vehiculo=vehiculo;
    }
    public Carros(String marca, String color, String motor,int potencia, String llantas, int gas) {
        this.color = color;
        this.marca = marca;
        this.motor = motor;
        this.potencia = potencia;
        this.llantas = llantas;
        this.gas = gas;
    }
    public Carros() {

    }
    public void consumirGasolina(int gasolinaConsumida) {
        this.gas = this.gas - gasolinaConsumida;
        if (this.gas < 0) {
            this.gas = 0;
            System.out.println("No fue suficiente gasolina, se quedó en el camino.\n\n");
        } else
            System.out.println("Le queda " + this.gas + " de gasolina\n\n");
    }
    public void mostrarRestanteGasolina() {
        if (this.gas == 0)
            System.out.println("El tanque esta vacio\n\n");
        else
            System.out.println("Tiene " + this.gas + " de gasolina \n\n");

    }




    public void informacionGeneral(){
        System.out.println("\nLa marca del carro es: " + this.marca);
        System.out.println("El color del carro es: " + this.color);
        System.out.println("El  carro tiene un motor: " + this.motor);
        System.out.println("El  carro tiene una potencia de: " + this.potencia);
        System.out.println("Las llantas del carro son: " + this.llantas);
        System.out.println("La gasolina del carro del coche1 es: " + this.gas+" litros \n");
    }
    public void imprimirMarca(){
         System.out.println("Marca: "+this.marca);
     }
     public void imprimirGasolina(){
             System.out.println("Gasolina: "+this.gas+ " galones");
     }



    public static void Carro(){
        Carros Ferrari= new Carros("1) Ferrari", "Rojo", "básico", 4, "Perfil bajo",50);
        Carros Honda= new Carros("2) Honda", "Azul", "básico", 4, "Perfil Medio",50);
        Carros BMW= new Carros("3)BMW", "Verde",  "básico",4, "Perfil Medio",50);
        Ferrari.informacionGeneral();
        Honda.informacionGeneral();
        BMW.informacionGeneral();
    }
    public void Carro1(){
        Carros Ferrari= new Carros("Ferrari", this.color, this.motor,this.potencia, this.llantas,this.gas);
        Ferrari.informacionGeneral();
    }
    public void Carro2(){
        Carros Honda= new Carros("Honda", this.color, this.motor,this.potencia, this.llantas,this.gas);
        Honda.informacionGeneral();

    }
    public void Carro3(){
        Carros BMW= new Carros("BMW", this.color,   this.motor,this.potencia, this.llantas,this.gas);
        BMW.informacionGeneral();

    }
    public void Ferrari(){
        Carros Ferrari= new Carros("Ferrari", "Rojo", "genérico",2, "genérico",100);
        Ferrari.informacionGeneral();
    }
    public void Honda(){
        Carros Honda= new Carros("Honda", "Azul", "genérico",2, "genérico",100);
        Honda.informacionGeneral();

    }
    public void BMW(){
        Carros BMW= new Carros("BMW", "Verde",  "genérico",2, "genérico",100);
        BMW.informacionGeneral();

    }

//Caracteristicas
    //Vehiculo
    public int getpotencia()
    {
        return this.potencia;
    }
    public void setpotencia(int potencia)
    {
        this.potencia=potencia;
    }

    //Motor
    public String getmotor()
    {
        return this.motor;
    }
    public void setmotor(String motor)
    {
        this.motor=motor;
    }

    //Gasolina
    public int getgasolina()
    {
        return this.gas;
    }
    public void setgasolina(int gas)
    {
        this.gas=gas;
    }

    //Llantas
    public String getLlantas()
    {
        return this.llantas;
    }
    public void setLlantas(String llantas)
    {
        this.llantas=llantas;
    }

    //Color
    public String getcolor()
    {
        return this.color;
    }
    public void setcolor(String color)
    {
        this.color=color;
    }

}