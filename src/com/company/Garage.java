package com.company;
import java.util.Scanner;

public class Garage {
    Usuario carro = new Usuario();
    Carros carros = new Carros();
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
    String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";
    public void Garage(){
        Menú();

    }
    public void Menú(){
        int Opcion;
        Usuario usuario = new Usuario();
            System.out.println("\n\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"BIENVENIDO AL GARAJE"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        System.out.println("\n1.Mejorar Potencia");
        System.out.println("2.Llenar tanque de Gasolina");
        System.out.println("3.Mejorar llantas");
        System.out.println("4.Cambiar color");
        System.out.println("5.Características del vehiculo");
        System.out.println("6.Comprar otro vehículo");
        System.out.println("7.Cambiar de vehiculo");
        System.out.println("8.Volver al menú principal");
        System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
        Scanner opcion = new Scanner(System.in);
        Opcion = opcion.nextInt();
        switch (Opcion){
            case 1:
                MejorarPotencia();
                break;
                case 2:
                    LLenarTanque();
                break;
                case 3:
                    MejorarLlantas();
                break;
                case 4:
                    CambiarColor();
                break;
                case 5:
                    Características();
                break;
                case 6:
                    ComprarVehiculo();
                break;
                case 7:
                    CambiarCarro();
                break;
                case 8:
                    Practica1 Menu1= new Practica1();
                    Menu1.menu();
                    System.out.println(ANSI_RED+ "\n\t\t\t\t\t\tRegresaremos al menú" + ANSI_RESET);
                    System.out.println("\t\t\tACTIVIDAD FINALIZADA \t\t\tOro="+usuario.getgoro()+" Gemas="+usuario.getgemas());
                break;
        }
    }



        //Funciones
    public void MejorarPotencia(){
        int gemas=carro.getgemas();
        double oro= carro.getgoro();
        int compra, motor;
        String x,y;
        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"MEJORA DE MOTOR"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        y= carro.getvehiculo();
        if(y=="Ferrari"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro1();
            do{
                System.out.println("\nDesea modificar su motor:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"MOTORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Motor básico, Potencia 4,  Costo= 5 GEMAS");
                        System.out.println("2. Motor medio, Potencia 5,  Costo= 20 GEMAS");
                        System.out.println("3. Motor alto rendimiento, Potencia 7, Costo= 35 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué motor deseas?"+ ANSI_RESET+" ");
                            String nmotor=carros.getmotor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=5){
                                        x="básico";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("básico");
                                            carros.setpotencia(4);
                                            carro.setgemas(gemas-5);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=20){
                                        x="medio";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("medio");
                                            carros.setpotencia(5);
                                            carro.setgemas(gemas-20);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("No tienes las gemas necesarias para comprar el vehiculo");
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=35){
                                        x="Alto Rendimiento";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("Alto Rendimiento");
                                            carros.setpotencia(7);
                                            carro.setgemas(gemas-35);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }
        else if (y== "Honda"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro2();
            do{
                System.out.println("\nDesea modificar su motor:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"COLORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Motor básico, Potencia 4,  Costo= 5 GEMAS");
                        System.out.println("2. Motor medio, Potencia 5,  Costo= 20 GEMAS");
                        System.out.println("3. Motor alto rendimiento, Potencia 7, Costo= 35 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"'¿Que motor deseas?'"+ ANSI_RESET+" ");
                            String nmotor=carros.getmotor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=5){
                                        x="básico";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("básico");
                                            carros.setpotencia(4);
                                            carro.setgemas(gemas-5);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=20){
                                        x="medio";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("medio");
                                            carros.setpotencia(5);
                                            carro.setgemas(gemas-20);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=35){
                                        x="Alto Rendimiento";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("Alto Rendimiento");
                                            carros.setpotencia(7);
                                            carro.setgemas(gemas-35);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }
        else if (y== "BMW"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro3();
            do{
                System.out.println("\nDesea modificar su motor:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"COLORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Motor básico, Potencia 4,  Costo= 5 GEMAS");
                        System.out.println("2. Motor medio, Potencia 5,  Costo= 20 GEMAS");
                        System.out.println("3. Motor alto rendimiento, Potencia 7, Costo= 35 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué motor desas?"+ ANSI_RESET+" ");
                            String nmotor=carros.getmotor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=5){
                                        x="básico";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("básico");
                                            carros.setpotencia(4);
                                            carro.setgemas(gemas-5);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTAULIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=20){
                                        x="medio";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("medio");
                                            carros.setpotencia(5);
                                            carro.setgemas(gemas-20);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTAULIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=35){
                                        x="Alto Rendimiento";
                                        if (nmotor==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar motores iguales"+ANSI_RESET);
                                            MejorarPotencia();
                                        }
                                        else {
                                            System.out.println("\nEscogiste el motor medio");
                                            carros.setmotor("Alto Rendimiento");
                                            carros.setpotencia(7);
                                            carro.setgemas(gemas-35);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTAULIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar el motor"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }

    }
    public void LLenarTanque(){
        int gemas=carro.getgemas();
        double oro= carro.getgoro();
        int gas,eleccion,compra,gasolina=100,cantidad;
        double precio;
        String x,y;
        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"GASOLINERA"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        y= carro.getvehiculo();
        if(y=="Ferrari"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro1();
            do{
                System.out.println("\nDesea echar gasolina");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                eleccion = opcion.nextInt();
                switch (eleccion){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"GASOLINA"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\nActualmente tiene: "+carros.getgasolina()+" galones");
                        cantidad=gasolina- carros.getgasolina();
                        precio=cantidad*2.5;
                        System.out.println("Usted debe echar: "+cantidad+" galones de gasolina a un total de "+
                                precio+" monedas de oro");
                        System.out.println("1.Llenar el tanque");
                        System.out.println("2.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            int cangas=carros.getgasolina();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=precio){
                                        if (cangas==100){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede echar más gasolina"+ANSI_RESET);
                                            LLenarTanque();
                                        }
                                        else {
                                            System.out.println("\nEscoogiste llenar el tanque");
                                            carros.setgasolina(100);
                                            carro.setoro((int) (oro-precio));
                                            System.out.println("Oro Restante= "+carro.getgoro());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro necesario para llenar el tanque"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    Garage();
                                    break;
                            }
                        }while( compra < 1 || compra > 2 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( eleccion < 1 || eleccion > 2 );
        }
        else if (y== "Honda"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro2();
            do{
                System.out.println("\nDesea echar gasolina");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                eleccion = opcion.nextInt();
                switch (eleccion){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"GASOLINA"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\nActualmente tiene: "+carros.getgasolina()+" galones");
                        cantidad=gasolina- carros.getgasolina();
                        precio=cantidad*2.5;
                        System.out.println("Usted debe echar: "+cantidad+" galones de gasolina a un total de "+
                                precio+" monedas de oro");
                        System.out.println("1.Llenar el tanque");
                        System.out.println("2.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            int cangas=carros.getgasolina();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=precio){
                                        if (cangas==100){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede echar más gasolina"+ANSI_RESET);
                                            LLenarTanque();
                                        }
                                        else {
                                            System.out.println("\nEscoogiste llenar el tanque");
                                            carros.setgasolina(100);
                                            carro.setoro((int) (oro-precio));
                                            System.out.println("Oro Restante= "+carro.getgoro());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro necesario para llenar el tanque"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    Garage();
                                    break;
                            }
                        }while( compra < 1 || compra > 2 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( eleccion < 1 || eleccion > 2 );
        }
        else if (y== "BMW"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro3();
            do{
                System.out.println("\nDesea echar gasolina");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                eleccion = opcion.nextInt();
                switch (eleccion){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"GASOLINA"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\nActualmente tiene: "+carros.getgasolina()+" galones");
                        cantidad=gasolina- carros.getgasolina();
                        precio=cantidad*2.5;
                        System.out.println("Usted debe echar: "+cantidad+" galones de gasolina a un total de "+
                                precio+" monedas de oro");
                        System.out.println("1.Llenar el tanque");
                        System.out.println("2.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            int cangas=carros.getgasolina();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=precio){
                                        if (cangas==100){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede echar más gasolina"+ANSI_RESET);
                                            LLenarTanque();
                                        }
                                        else {
                                            System.out.println("\nEscoogiste llenar el tanque");
                                            carros.setgasolina(100);
                                            carro.setoro((int) (oro-precio));
                                            System.out.println("Oro Restante= "+carro.getgoro());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro necesario para llenar el tanque"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    Garage();
                                    break;
                            }
                        }while( compra < 1 || compra > 2 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( eleccion < 1 || eleccion > 2 );
        }
    }
    public void MejorarLlantas(){
        int gemas=carro.getgemas();
        double oro= carro.getgoro();
        int compra, motor;
        String x,y;
        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"MEJORA DE LLANTAS"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        Usuario.Vehiculo();
        y= carro.getvehiculo();
        if(y=="Ferrari"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro1();
            do{
                System.out.println("\nDesea modificar sus Llantas:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"LLANTAS DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Calidad Baja, Coeficiente 2,  Costo= 25 GEMAS");
                        System.out.println("2. Calidad Media, Coeficiente 3,  Costo= 50 GEMAS");
                        System.out.println("3. Calidad Alta , Coeficiente 5, Costo= 75 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué llantas deseas?"+ ANSI_RESET+" ");
                            String nmotor=carros.getLlantas();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=25){
                                        x="Calidad Baja";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Baja");
                                            carros.setLlantas("Calidad Baja");
                                            carro.setgemas(gemas-25);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=50){
                                        x="Calidad Media";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Media");
                                            carros.setLlantas("Calidad Media");
                                            carro.setgemas(gemas-50);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=75){
                                        x="Calidad Alta";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Altaa");
                                            carros.setLlantas("Calidad Altaa");
                                            carro.setgemas(gemas-75);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }
        else if (y== "Honda"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro2();
            do{
                System.out.println("\nDesea modificar sus Llantas:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"LLANTAS DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Calidad Baja, Coeficiente 2,  Costo= 25 GEMAS");
                        System.out.println("2. Calidad Media, Coeficiente 3,  Costo= 50 GEMAS");
                        System.out.println("3. Calidad Alta , Coeficiente 5, Costo= 75 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué llantas deseas?"+ ANSI_RESET+" ");
                            String nmotor=carros.getLlantas();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=25){
                                        x="Calidad Baja";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Baja");
                                            carros.setLlantas("Calidad Baja");
                                            carro.setgemas(gemas-25);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=50){
                                        x="Calidad Media";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Media");
                                            carros.setLlantas("Calidad Media");
                                            carro.setgemas(gemas-50);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=75){
                                        x="Calidad Alta";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Altaa");
                                            carros.setLlantas("Calidad Altaa");
                                            carro.setgemas(gemas-75);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }
        else if (y== "BMW"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro3();
            do{
                System.out.println("\nDesea modificar sus Llantas:");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                motor = opcion.nextInt();
                switch (motor){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"LLANTAS DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("\n1. Calidad Baja, Coeficiente 2,  Costo= 25 GEMAS");
                        System.out.println("2. Calidad Media, Coeficiente 3,  Costo= 50 GEMAS");
                        System.out.println("3. Calidad Alta , Coeficiente 5, Costo= 75 GEMAS");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué llantas deseas?"+ ANSI_RESET+" ");
                            String nmotor=carros.getLlantas();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (gemas>=25){
                                        x="Calidad Baja";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Baja");
                                            carros.setLlantas("Calidad Baja");
                                            carro.setgemas(gemas-25);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (gemas>=50){
                                        x="Calidad Media";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Media");
                                            carros.setLlantas("Calidad Media");
                                            carro.setgemas(gemas-50);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (gemas>=75){
                                        x="Calidad Alta";
                                        if (nmotor==x){
                                            System.out.println("\n\t\t\t"+ANSI_RED+"No puede comprar llantas iguales"+ANSI_RESET);
                                            MejorarLlantas();
                                        }
                                        else {
                                            System.out.println("\nEscogiste las llantas de Calidad Altaa");
                                            carros.setLlantas("Calidad Altaa");
                                            carro.setgemas(gemas-75);
                                            System.out.println("Gemas Restantes= "+carro.getgemas());
                                            System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"ACTUALIZACION"+ANSI_RESET);
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\n\t\t\t"+ANSI_RED+"No tienes las gemas necesarias para comprar las llantas"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( motor < 1 || motor > 2 );
        }

    }
    public void CambiarColor(){
        int gemas=carro.getgemas();
        double oro= carro.getgoro();
        int compra, color;
        String x,y;
        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"CAMBIO DE COLOR"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        Usuario.Vehiculo();
        y= carro.getvehiculo();
        if(y=="Ferrari"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro1();
            do{
                System.out.println("\nCambiar de color");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                color = opcion.nextInt();
                switch (color){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"COLORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("1. Azul\t\tCosto=20 Monedas de Oro");
                        System.out.println("2. Rojo\t\tCosto=20 Monedas de Oro");
                        System.out.println("3. Verde\t\tCosto=20 Monedas de Oro");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"¿Qué color deseas?"+ ANSI_RESET+" ");
                            String colorN=carros.getcolor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=20){
                                        x="Azul";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Azul");
                                            carros.setcolor("Azul");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (oro>=20){
                                        x="Rojo";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Rojo");
                                            carros.setcolor("Rojo");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (oro>=20){
                                        x="Verde";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Verde");
                                            carros.setcolor("Verde");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro1();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( color < 1 || color > 2 );
        }
        else if (y== "Honda"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro2();
            do{
                System.out.println("\nCambiar de color");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                color = opcion.nextInt();
                switch (color){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"COLORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("1. Azul\t\tCosto=20 Monedas de Oro");
                        System.out.println("2. Rojo\t\tCosto=20 Monedas de Oro");
                        System.out.println("3. Verde\t\tCosto=20 Monedas de Oro");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.println("¿Qué color deseas?");
                            String colorN=carros.getcolor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=20){
                                        x="Azul";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Azul");
                                            carros.setcolor("Azul");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("No tienes las gemas necesarias para comprar el color");
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (oro>=20){
                                        x="Rojo";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Rojo");
                                            carros.setcolor("Rojo");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (oro>=20){
                                        x="Verde";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Verde");
                                            carros.setcolor("Verde");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro2();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( color < 1 || color > 2 );
        }
        else if (y== "BMW"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro3();
            do{
                System.out.println("\nCambiar de color");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner opcion = new Scanner(System.in);
                color = opcion.nextInt();
                switch (color){
                    case 1:
                        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"COLORES DISPONIBLES"+ANSI_RESET);
                        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
                        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
                        System.out.println("1. Azul\t\tCosto=20 Monedas de Oro");
                        System.out.println("2. Rojo\t\tCosto=20 Monedas de Oro");
                        System.out.println("3. Verde\t\tCosto=20 Monedas de Oro");
                        System.out.println("4.REGRESAR AL MENÚ");
                        do{
                            System.out.println("¿Qué color deseas?");
                            String colorN=carros.getcolor();
                            Scanner motorN = new Scanner(System.in);
                            compra = motorN.nextInt();
                            switch (compra){
                                case 1:
                                    if (oro>=20){
                                        x="Azul";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Azul");
                                            carros.setcolor("Azul");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 2:
                                    if (oro>=20){
                                        x="Rojo";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Rojo");
                                            carros.setcolor("Rojo");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 3:
                                    if (oro>=20){
                                        x="Verde";
                                        if (colorN==x){
                                            System.out.println("\t\t\t"+ANSI_RED+"No puede comprar colores iguales"+ANSI_RESET);
                                            CambiarColor();
                                        }
                                        else {
                                            System.out.println("Escogiste el color Verde");
                                            carros.setcolor("Verde");
                                            carro.setoro((int) (oro-20));
                                            System.out.println("Su Oro Restante= "+carro.getgoro());
                                            System.out.println("Sus nuevas características son: ");
                                            carros.Carro3();
                                            Menú();
                                        }
                                    }
                                    else{
                                        System.out.println("\t\t\t"+ANSI_RED+"No tienes el oro suficiente para comprar el color"+ANSI_RESET);
                                        Menú();
                                    }
                                    break;
                                case 4:
                                    Menú();
                                    break;
                            }
                        }while( compra < 1 || compra > 4 );
                        break;
                    case 2:
                        Menú();
                        break;
                }
            }while( color < 1 || color > 2 );
        }
    }
    public void Características(){
        String y;
        System.out.println("\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"CARACTERISTICAS"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+carro.getgoro());
        System.out.println("\t\tCantidad de gemas= "+carro.getgemas());
        y= carro.getvehiculo();
        if(y=="Ferrari"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro1();
            System.out.println("\n¿Regresar al menú?");
            System.out.println("1. Si");
            int regreso;
            do {
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Pista = new Scanner(System.in);
                regreso = Pista.nextInt();
            }while ( regreso !=1 );
            switch (regreso){
                case 1:
                    Garage();
                    break;
            }
        }
        else if (y== "Honda"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro2();
            System.out.println("\n¿Regresar al menú?");
            System.out.println("1. Si");
            int regreso;
            do {
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Pista = new Scanner(System.in);
                regreso = Pista.nextInt();
            }while ( regreso !=1 );
            switch (regreso){
                case 1:
                    Garage();
                    break;
            }
        }
        else if (y== "BMW"){
            System.out.println("\nSus caracteristicas actuales son:");
            carros.Carro3();
            System.out.println("\n¿Regresar al menú?");
            System.out.println("1. Si");
            int regreso;
            do {
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Pista = new Scanner(System.in);
                regreso = Pista.nextInt();
            }while ( regreso !=1 );
            switch (regreso){
                case 1:
                    Garage();
                    break;
            }
        }

    }
    public void ComprarVehiculo(){}
    public void CambiarCarro(){
        System.out.println("Su vehiculo actual es: "+carro.getvehiculo());
    }

}
