package com.company;

public class Carros {

    //Atributos
    private static String marca;
    private static String color;
    private static String motor;
    private static int potencia;
    private static String llantas;
    private static int coellantas;

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
    public Carros(String marca, String color, String motor,int potencia, String llantas,int coellantas, int gas) {
        this.color = color;
        this.marca = marca;
        this.motor = motor;
        this.potencia = potencia;
        this.llantas = llantas;
        this.coellantas = coellantas;
        this.gas = gas;
    }
    public Carros() {

    }

    //Imprimo la información establecida de mi vehiculo
    public void informacionGeneral(){
        System.out.println("\nLa marca del carro es: " + this.marca);
        System.out.println("El color del carro es: " + this.color);
        System.out.println("El  carro tiene un motor: " + this.motor);
        System.out.println("El  carro tiene una potencia de: " + this.potencia);
        System.out.println("Las llantas del carro son: " + this.llantas);
        System.out.println("La gasolina del carro del coche1 es: " + this.gas+" Galones \n");
    }



    //Muestra mis autos, e imprime mi informacion General
    public static void Carro(){
        Carros Ferrari= new Carros("1) Ferrari", "Rojo", "genérico", 2, "Calidad bajo",1,100);
        Carros Honda= new Carros("2) Honda", "Azul", "genérico", 2, "Calidad Medio",1,100);
        Carros BMW= new Carros("3)BMW", "Verde",  "genérico",2, "Calidad Medio",1,100);
        Carros Mercedez= new Carros("4) Mercedez", "Blanco", "genérico", 2, "Calidad Medio",1,100);
        Carros Tesla= new Carros("5)Tesla", "Azul",  "genérico",2, "Calidad Medio",1,100);
        Ferrari.informacionGeneral();
        Honda.informacionGeneral();
        BMW.informacionGeneral();
        Mercedez.informacionGeneral();
        Tesla.informacionGeneral();
    }

    //Establezco mis autos predefinidos
    public void Ferrari(){
        Carros Ferrari= new Carros("Ferrari", "Rojo", "genérico",2, "genérico",1,100);
        Ferrari.informacionGeneral();
    }
    public void Honda(){
        Carros Honda= new Carros("Honda", "Azul", "genérico",2, "genérico",1,100);
        Honda.informacionGeneral();

    }
    public void BMW(){
        Carros BMW= new Carros("BMW", "Verde",  "genérico",2, "genérico",1,100);
        BMW.informacionGeneral();

    }
    public void Mercedez(){
        Carros Mercedez= new Carros("Mercedez", "Blanco",  "genérico",2, "genérico",1,100);
        Mercedez.informacionGeneral();

    }
    public void Tesla(){
        Carros Tesla= new Carros("Tesla", "Azul",  "genérico",2, "genérico",1,100);
        Tesla.informacionGeneral();

    }

    //EStablezco mis autos de manera editable, es decir puedo cambiar sus características
    public void Carro1(){
        Carros Ferrari= new Carros("Ferrari", this.color, this.motor,this.potencia, this.llantas,this.coellantas,this.gas);
        Ferrari.informacionGeneral();
    }
    public void Carro2(){
        Carros Honda= new Carros("Honda", this.color, this.motor,this.potencia, this.llantas,this.coellantas,this.gas);
        Honda.informacionGeneral();

    }
    public void Carro3(){
        Carros BMW= new Carros("BMW", this.color,   this.motor,this.potencia, this.llantas,this.coellantas,this.gas);
        BMW.informacionGeneral();

    }
    public void Carro4(){
        Carros Mercedez= new Carros("Mercedez", this.color, this.motor,this.potencia, this.llantas,this.coellantas,this.gas);
        Mercedez.informacionGeneral();

    }
    public void Carro5(){
        Carros Tesla= new Carros("Tesla", this.color,   this.motor,this.potencia, this.llantas,this.coellantas,this.gas);
        Tesla.informacionGeneral();

    }

    //Imprimo el autoElegido por el usuario
    public void AutoUsuario(){
        Usuario carros=new Usuario();
        String x=carros.getvehiculo();
        if(x=="Ferrari"){
            Carro1();
        }
        else if(x=="Honda"){
            Carro2();
        }
        else if(x=="BMW"){
            Carro3();
        }
        else if(x=="Mercedez"){
            Carro4();
        }
        else if(x=="Tesla"){
            Carro5();
        }
    }


    //Establezco mis getters y setters de mis atributos para acceder a ellos y editarlos
    //Potencia
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

    //CoeficienteLlantas
    public int getcoellantas()
    {
        return this.coellantas;
    }
    public void setcoellantas(int coellantas)
    {
        this.coellantas=coellantas;
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
    Pistas coeficiente=new Pistas();


    public void CarrosEnPosesion (){

    }
}