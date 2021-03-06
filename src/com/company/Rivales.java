package com.company;

import java.util.Scanner;

public class Rivales {
    String Nombre;
    String Variable;

    //Colores
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_BLANCO = "\u001B[37m";
    String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";
    String ANSI_BLANCO_SUBRAYADO = "\033[4;47;30m";

    //Llamo mis clases
    static Usuario usuario= new Usuario();
    Carros carros= new Carros();
    Pistas pistas= new Pistas();
    Competicion competicion = new Competicion();

    //Establezco mis varibles
    String nombre=usuario.getnickname();
    private static int potencia;
    int gemas = usuario.getgemas();
    String CarroUsuario=usuario.getvehiculo();
    int gas;
    int regreso;
    int full;
    int A=20;
    private static char OrdenRiv;

    //Establezco constructor para mis rivales
    public Rivales(String nombre, String variable){
        this.Nombre = nombre;
        this.Variable = variable;
    }

    public Rivales() {

    }

    // Getters y setters de mis varibales
    public String getnombre()
    {
        return Nombre;
    }

    public String getnacionalidad(){
        return Variable;

    }

    public int getpotencia()
    {
        return this.potencia;
    }
    public void setpotencia(int potencia)
    {
        this.potencia=potencia;
    }

    public String Presentación()
    {
        return("\nHola soy "+this.Nombre+" \n Soy el competidor: "+this.Variable);
    }


    //Establezco mi orden y mi competencia, del usuario con los rivales aleatorios
    public void ordenRiv(){
        //Genero Los numeros aleartorios para los turnos
        //Creo sistema para que no se repitan los competidores

        int n=usuario.getrivales();
        int gemas = usuario.getgemas();
        double oro = usuario.getgoro();

        //Establezco mis IF para comparar y operar según la cantidad de rivales elegidos
        if (n==2)
        {
            int n1 = 65;
            int n2 = (int)(Math.random()*6)+65;
            int ronda = (int)(Math.random()*5)+1;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            do{
                n1 = 65;
                n2 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
            }while (orden1==orden2);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2);
            System.out.println("Número de rondas= "+ronda);

            //Declaro el movimiento que tendrá cada rival
            int Avance1=usuario.MovimientoUsuario();
            int Avance2=MovimientoRival();

            //Establezco las casillas avanzadas por rival, RONDA 1
            Carretera avance1 = new Carretera(Avance1,1);
            Carretera avance11 = new Carretera(Avance2,1);
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 1"+ ANSI_RESET+" ");
            avance1.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+Avance1+" espacios");
            avance11.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+Avance2+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance11=usuario.MovimientoUsuario();
            int Avance22=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 2
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 2"+ ANSI_RESET+" ");
            Carretera avance2 = new Carretera((Avance1+Avance11),1);
            Carretera avance22 = new Carretera((Avance2+Avance22),1);
            avance2.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11)+" espacios en total");
            avance22.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22)+" espacios en total");

            //Declaro el movimiento que tendrá cada rival
            int Avance111=usuario.MovimientoUsuario();
            int Avance222=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 3
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 3"+ ANSI_RESET+" ");
            Carretera avance3 = new Carretera((Avance1+Avance11+Avance111),1);
            Carretera avance33 = new Carretera((Avance2+Avance22+Avance222),1);
            avance3.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11+Avance111)+" espacios en total");
            avance33.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22+Avance222)+" espacios en total");
            int x=(Avance1+Avance11+Avance111);
            int y=(Avance2+Avance22+Avance222);

            //Descuento de Gasolina
            usuario.setgasolinagastada(x);
            gas = carros.getgasolina()-x;
            carros.setgasolina(gas);

            //Ganador
            //Establezco los lugares de los competidores según su posiición

            if (x>y){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+usuario.getnickname());
                int G=Gemas();
                double O=Oro();
                String Ganador=usuario.getnickname();
                competicion.setPrimero(orden1);
                competicion.setSegundo(orden2);
                System.out.println(ANSI_GREEN+"\nGanó "+G+" Gemas"+ usuario.ANSI_RESET);
                System.out.printf(ANSI_YELLOW+"Ganó "+O+" Monedas de oro"+ usuario.ANSI_RESET);
                usuario.setoro(oro+O);
                usuario.setgemas(gemas+G);
                System.out.print("\nGemas Actuales= "+usuario.getgemas());
                System.out.println(" Oro Actual= "+usuario.getgoro());
            }
            else if(x==y){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Hubo un empate "+ANSI_RESET+usuario.getnickname());
            }
            else {
                competicion.setPrimero(orden2);
                competicion.setSegundo(orden1);
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden2);
            }
            System.out.print("\nCaracterísticas actuales de su vehículo:");
            carros.AutoUsuario();

            do{
            System.out.println("\n¿Desea la Revancha?");
            System.out.println("1. SI");
            System.out.println("2. NO");
            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
            Scanner Regreso = new Scanner(System.in);
            regreso = Regreso.nextInt();
            }while(regreso<1 ||regreso >2);
            int a =carros.getgasolina();
            int b =pistas.getlargo();

            //Creo un switch comparando si la cantidad de gasolina es sufgiciente para el ancho de la pista
            switch (regreso){
                case 1:
                    if(a<b){
                        System.out.println("Gasolina Actual: "+carros.getgasolina()+" Galones     Necesita "+pistas.getlargo()+" Galones");
                        System.out.println("\n\t\t\t\t"+ANSI_RED+"No posee la gasolina suficiente"+ANSI_RESET);

                        do{
                            //Establezco la opción para llenar el tanque en caso se desee, la revancha
                            System.out.println("\n¿Comprar más?");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            Scanner Full = new Scanner(System.in);
                            full = Full.nextInt();
                        }while(full<1 ||full >2);
                        switch(full){
                        case 1:
                            Garage gasolinera = new Garage();
                            gasolinera.LLenarTanque();
                            break;
                        case 2:
                            JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                            Menu1.menu();
                            break;
                            }

                    }
                    else{
                        ordenRiv();
                    }
                    break;
                case 2:
                    JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                    Menu1.menu();
                    break;
            }
        }
        else if (n==3)
        {
            int n1 = 65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            do{
                n1 = 65;
                n2 = (int)(Math.random()*3)+65;
                n3 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
                orden3 = (char) n3;
            }while (orden1==orden2 || orden2==orden3 ||orden1==orden3);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2+""+orden3);

            //Declaro el movimiento que tendrá cada rival
            int Avance1=usuario.MovimientoUsuario();
            int Avance2=MovimientoRival();
            int Avance3=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 1
            Carretera avance1 = new Carretera(Avance1,1);
            Carretera avance11 = new Carretera(Avance2,1);
            Carretera avance111 = new Carretera(Avance3,1);
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 1"+ ANSI_RESET+" ");
            avance1.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+Avance1+" espacios");
            avance11.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+Avance2+" espacios");
            avance111.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+Avance3+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance11=usuario.MovimientoUsuario();
            int Avance22=MovimientoRival();
            int Avance33=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 2
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 2"+ ANSI_RESET+" ");
            Carretera avance2 = new Carretera((Avance1+Avance11),1);
            Carretera avance22 = new Carretera((Avance2+Avance22),1);
            Carretera avance222 = new Carretera((Avance3+Avance33),1);
            avance2.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11)+" espacios en total");
            avance22.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22)+" espacios en total");
            avance222.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33)+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance111=usuario.MovimientoUsuario();
            int Avance222=MovimientoRival();
            int Avance333=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 3
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 3"+ ANSI_RESET+" ");
            Carretera avance3 = new Carretera((Avance1+Avance11+Avance111),1);
            Carretera avance33 = new Carretera((Avance2+Avance22+Avance222),1);
            Carretera avance333 = new Carretera((Avance3+Avance33+Avance333),1);
            avance3.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11+Avance111)+" espacios en total");
            avance33.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22+Avance222)+" espacios en total");
            avance333.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33+Avance333)+" espacios en total");
            int x=(Avance1+Avance11+Avance111);
            int y=(Avance2+Avance22+Avance222);
            int o3=(Avance3+Avance33+Avance333);

            //Descuento de Gasolina
            usuario.setgasolinagastada(x);
            gas = carros.getgasolina()-x;
            carros.setgasolina(gas);

            //Ganador
            //Establezco los lugares de los competidores según su posiición

            if (x>y && x>o3){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+usuario.getnickname());
                int G=Gemas();
                double O=Oro();
                competicion.setPrimero(orden1);
                if (y>o3){
                    competicion.setSegundo(orden2);
                    competicion.setTercero(orden3);
                }
                else {
                    competicion.setSegundo(orden3);
                    competicion.setTercero(orden2);
                }
                competicion.setTercero(orden3);
                System.out.println(ANSI_GREEN+"\nGanó "+G+" Gemas"+ usuario.ANSI_RESET);
                System.out.printf(ANSI_YELLOW+"Ganó "+O+" Monedas de oro"+ usuario.ANSI_RESET);
                usuario.setoro(oro+O);
                usuario.setgemas(gemas+G);
                System.out.print("\nGemas Actuales= "+usuario.getgemas());
                System.out.println(" Oro Actual= "+usuario.getgoro());
            }
            else if(y>x && y>o3){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden2);
                competicion.setPrimero(orden2);
                if (x>o3){
                    competicion.setSegundo(orden1);
                    competicion.setTercero(orden3);
                }
                else {
                    competicion.setSegundo(orden3);
                    competicion.setTercero(orden1);
                }
            }
            else {
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden3);
                competicion.setPrimero(orden3);
                if (y>x){
                    competicion.setSegundo(orden2);
                    competicion.setTercero(orden1);
                }
                else {
                    competicion.setSegundo(orden1);
                    competicion.setTercero(orden2);
                }
            }
            System.out.print("\nCaracterísticas actuales de su vehículo:");
            carros.AutoUsuario();

            do{
                System.out.println("\n¿Desea la Revancha?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Regreso = new Scanner(System.in);
                regreso = Regreso.nextInt();
            }while(regreso<1 ||regreso >2);
            int a =carros.getgasolina();
            int b =pistas.getlargo();

            //Creo un switch comparando si la cantidad de gasolina es sufgiciente para el ancho de la pista
            switch (regreso){
                case 1:
                    if(a<b){
                        System.out.println("Gasolina Actual: "+carros.getgasolina()+" Galones     Necesita "+pistas.getlargo()+" Galones");
                        System.out.println("No posee la gasolina suficiente");

                        do{
                            System.out.println("\n¿Comprar más?");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            Scanner Full = new Scanner(System.in);
                            full = Full.nextInt();
                        }while(full<1 ||full >2);

                        //Si el usuario desea la revancha se lleva al usuario a la gasolinera
                        switch(full){
                            case 1:
                                Garage gasolinera = new Garage();
                                gasolinera.LLenarTanque();
                                break;
                            case 2:
                                JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                                Menu1.menu();
                                break;
                        }

                    }
                    else{
                        ordenRiv();
                    }
                    break;
                case 2:
                    JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                    Menu1.menu();
                    break;
            }
        }
        else if (n==4)
        {
            int n1 = 65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            int n4 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            char orden4 = (char) n4;
            do{
                n1 = 65;
                n2 = (int)(Math.random()*3)+65;
                n3 = (int)(Math.random()*3)+65;
                n4 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
                orden3 = (char) n3;
                orden4 = (char) n4;
            }while (orden1==orden2 || orden2==orden3 ||orden1==orden3 || orden1==orden4||orden2==orden4||orden3==orden4);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2+""+orden3+""+orden4);

            //Declaro el movimiento que tendrá cada rival
            int Avance1=usuario.MovimientoUsuario();
            int Avance2=MovimientoRival();
            int Avance3=MovimientoRival();
            int Avance4=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 1
            Carretera avance1 = new Carretera(Avance1,1);
            Carretera avance11 = new Carretera(Avance2,1);
            Carretera avance111 = new Carretera(Avance3,1);
            Carretera avance1111 = new Carretera(Avance4,1);
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 1"+ ANSI_RESET+" ");
            avance1.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+Avance1+" espacios");
            avance11.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+Avance2+" espacios");
            avance111.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+Avance3+" espacios");
            avance1.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+Avance4+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance11=usuario.MovimientoUsuario();
            int Avance22=MovimientoRival();
            int Avance33=MovimientoRival();
            int Avance44=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 2
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 2"+ ANSI_RESET+" ");
            Carretera avance2 = new Carretera((Avance1+Avance11),1);
            Carretera avance22 = new Carretera((Avance2+Avance22),1);
            Carretera avance222 = new Carretera((Avance3+Avance33),1);
            Carretera avance2222 = new Carretera((Avance4+Avance44),1);
            avance2.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11)+" espacios en total");
            avance22.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22)+" espacios en total");
            avance222.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33)+" espacios");
            avance2222.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44)+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance111=usuario.MovimientoUsuario();
            int Avance222=MovimientoRival();
            int Avance333=MovimientoRival();
            int Avance444=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 3
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 3"+ ANSI_RESET+" ");
            Carretera avance3 = new Carretera((Avance1+Avance11+Avance111),1);
            Carretera avance33 = new Carretera((Avance2+Avance22+Avance222),1);
            Carretera avance333 = new Carretera((Avance3+Avance33+Avance333),1);
            Carretera avance3333 = new Carretera((Avance4+Avance44+Avance444),1);
            avance3.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11+Avance111)+" espacios en total");
            avance33.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22+Avance222)+" espacios en total");
            avance333.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33+Avance333)+" espacios en total");
            avance3333.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44+Avance444)+" espacios en total");
            int x=(Avance1+Avance11+Avance111);
            int y=(Avance2+Avance22+Avance222);
            int o3=(Avance3+Avance33+Avance333);
            int o4=(Avance4+Avance44+Avance444);

            //Descuento de Gasolina
            usuario.setgasolinagastada(x);
            gas = carros.getgasolina()-x;
            carros.setgasolina(gas);

            //Ganador
            //Establezco los lugares de los competidores según su posiición
            if (x>y && x>o3 && x>o4){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+usuario.getnickname());
                int G=Gemas();
                double O=Oro();
                competicion.setPrimero(orden1);
                if (y>o3 && y>o4){
                    competicion.setSegundo(orden2);
                    if(o3>o4){
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden3);
                    }
                }
                else if (o3>y && o3>o4){
                    competicion.setSegundo(orden3);
                    if(y>o4){
                        competicion.setTercero(orden2);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden2);
                    }
                }
                else if (o4>y && o4>o3){
                    competicion.setSegundo(orden4);
                    if(y>o3){
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden3);
                    }
                }
                System.out.println(ANSI_GREEN+"\nGanó "+G+" Gemas"+ usuario.ANSI_RESET);
                System.out.printf(ANSI_YELLOW+"Ganó "+O+" Monedas de oro"+ usuario.ANSI_RESET);
                usuario.setoro(oro+O);
                usuario.setgemas(gemas+G);
                System.out.print("\nGemas Actuales= "+usuario.getgemas());
                System.out.println(" Oro Actual= "+usuario.getgoro());
            }
            else if(y>x && y>o3 && y>o4){
                competicion.setPrimero(orden2);
                if (x>o3 && x>o4){
                    competicion.setSegundo(orden1);
                    if(o3>o4){
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden3);
                    }
                }
                else if (o3>x && o3>o4){
                    competicion.setSegundo(orden3);
                    if(x>o4){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden1);
                    }
                }
                else if (o4>x && o4>o3){
                    competicion.setSegundo(orden4);
                    if(x>o3){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden3);
                    }
                    else{
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden1);
                    }
                }
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden2);
            }
            else if(o3>x && o3>y && o3>o4){
                competicion.setPrimero(orden3);
                if (x>y && x>o4){
                    competicion.setSegundo(orden1);
                    if(y>o4){
                        competicion.setTercero(orden2);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden2);
                    }
                }
                else if (y>x && y>o4){
                    competicion.setSegundo(orden2);
                    if(x>o4){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden4);
                    }
                    else{
                        competicion.setTercero(orden4);
                        competicion.setCuarto(orden1);
                    }
                }
                else if (o4>x && o4>y){
                    competicion.setSegundo(orden4);
                    if(x>y){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden2);
                    }
                    else{
                        competicion.setTercero(orden2);
                        competicion.setCuarto(orden1);
                    }
                }
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden3);
            }
            else {
                competicion.setPrimero(orden4);
                if (x>y && x>o3){
                    competicion.setSegundo(orden1);
                    if(y>o3){
                        competicion.setTercero(orden2);
                        competicion.setCuarto(orden3);
                    }
                    else{
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden2);
                    }
                }
                else if (y>x && y>o3){
                    competicion.setSegundo(orden2);
                    if(x>o3){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden3);
                    }
                    else{
                        competicion.setTercero(orden3);
                        competicion.setCuarto(orden1);
                    }
                }
                else if (o3>x && o3>y){
                    competicion.setSegundo(orden3);
                    if(x>y){
                        competicion.setTercero(orden1);
                        competicion.setCuarto(orden2);
                    }
                    else{
                        competicion.setTercero(orden2);
                        competicion.setCuarto(orden1);
                    }
                }
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden4);
            }
            System.out.print("\nCaracterísticas actuales de su vehículo:");
            carros.AutoUsuario();

            do{
                System.out.println("\n¿Desea la Revancha?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Regreso = new Scanner(System.in);
                regreso = Regreso.nextInt();
            }while(regreso<1 ||regreso >2);
            int a =carros.getgasolina();
            System.out.println(carros.getgasolina());
            int b =pistas.getlargo();
            //Se crea el comparador para evaluar si el usuario tiene la gasolina necesaria para la revancha

            switch (regreso){
                case 1:
                    if(a<b){
                        System.out.println("Gasolina Actual: "+carros.getgasolina()+" Galones     Necesita "+pistas.getlargo()+" Galones");
                        System.out.println("No posee la gasolina suficiente");

                        do{
                            System.out.println("\n¿Comprar más?");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            Scanner Full = new Scanner(System.in);
                            full = Full.nextInt();
                        }while(full<1 ||full >2);
                        //Se manda al usuario a la gasolinera si así lo desea
                        switch(full){
                            case 1:
                                Garage gasolinera = new Garage();
                                gasolinera.LLenarTanque();
                                break;
                            case 2:
                                JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                                Menu1.menu();
                                break;
                        }

                    }
                    else{
                        ordenRiv();
                    }
                    break;
                case 2:
                    JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                    Menu1.menu();
                    break;
            }
        }
        else if (n==5)
        {
            int n1 =65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            int n4 = (int)(Math.random()*6)+65;
            int n5 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            char orden4 = (char) n4;
            char orden5 = (char) n5;
            do{
                n1 =65;
                n2 = (int)(Math.random()*3)+65;
                n3 = (int)(Math.random()*3)+65;
                n4 = (int)(Math.random()*3)+65;
                n5 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
                orden3 = (char) n3;
                orden4 = (char) n4;
                orden5 = (char) n5;
            }while (orden1==orden2 || orden2==orden3 ||orden1==orden3 || orden1==orden4||orden2==orden4||orden3==orden4||orden5==orden1||orden5==orden2||orden5==orden3||orden5==orden4);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2+""+orden3+""+orden4+""+orden5);

            //Declaro el movimiento que tendrá cada rival
            int Avance1=usuario.MovimientoUsuario();
            int Avance2=MovimientoRival();
            int Avance3=MovimientoRival();
            int Avance4=MovimientoRival();
            int Avance5=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 1
            Carretera avance1 = new Carretera(Avance1,1);
            Carretera avance11 = new Carretera(Avance2,1);
            Carretera avance111 = new Carretera(Avance3,1);
            Carretera avance1111 = new Carretera(Avance4,1);
            Carretera avance11111 = new Carretera(Avance5,1);
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 1"+ ANSI_RESET+" ");
            avance1.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+Avance1+" espacios");
            avance11.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+Avance2+" espacios");
            avance111.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+Avance3+" espacios");
            avance1111.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+Avance4+" espacios");
            avance11111.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+Avance5+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance11=usuario.MovimientoUsuario();
            int Avance22=MovimientoRival();
            int Avance33=MovimientoRival();
            int Avance44=MovimientoRival();
            int Avance55=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 2
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 2"+ ANSI_RESET+" ");
            Carretera avance2 = new Carretera((Avance1+Avance11),1);
            Carretera avance22 = new Carretera((Avance2+Avance22),1);
            Carretera avance222 = new Carretera((Avance3+Avance33),1);
            Carretera avance2222 = new Carretera((Avance4+Avance44),1);
            Carretera avance22222= new Carretera((Avance4+Avance55),1);
            avance2.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11)+" espacios en total");
            avance22.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22)+" espacios en total");
            avance222.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33)+" espacios");
            avance2222.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44)+" espacios");
            avance22222.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+(Avance5+Avance55)+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance111=usuario.MovimientoUsuario();
            int Avance222=MovimientoRival();
            int Avance333=MovimientoRival();
            int Avance444=MovimientoRival();
            int Avance555=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 3
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 3"+ ANSI_RESET+" ");
            Carretera avance3 = new Carretera((Avance1+Avance11+Avance111),1);
            Carretera avance33 = new Carretera((Avance2+Avance22+Avance222),1);
            Carretera avance333 = new Carretera((Avance3+Avance33+Avance333),1);
            Carretera avance444 = new Carretera((Avance4+Avance44+Avance444),1);
            Carretera avance555 = new Carretera((Avance5+Avance55+Avance555),1);
            avance3.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11+Avance111)+" espacios en total");
            avance33.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22+Avance222)+" espacios en total");
            avance333.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33+Avance333)+" espacios en total");
            avance444.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44+Avance444)+" espacios en total");
            avance555.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+(Avance5+Avance55+Avance555)+" espacios en total");
            int x=(Avance1+Avance11+Avance111);
            int y=(Avance2+Avance22+Avance222);
            int o3=(Avance3+Avance33+Avance333);
            int o4=(Avance4+Avance44+Avance444);
            int o5=(Avance5+Avance55+Avance555);

            //Descuento de Gasolina
            usuario.setgasolinagastada(x);
            gas = carros.getgasolina()-x;
            carros.setgasolina(gas);

            //Ganador
            //Establezco los lugares de los competidores según su posiición

            if (x>y && x>o3 && x>o4 && x>o5){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+usuario.getnickname());
                int G=Gemas();
                double O=Oro();
                System.out.println(ANSI_GREEN+"\nGanó "+G+" Gemas"+ usuario.ANSI_RESET);
                System.out.printf(ANSI_YELLOW+"Ganó "+O+" Monedas de oro"+ usuario.ANSI_RESET);
                usuario.setoro(oro+O);
                usuario.setgemas(gemas+G);
                System.out.print("\nGemas Actuales= "+usuario.getgemas());
                System.out.println(" Oro Actual= "+usuario.getgoro());
            }
            else if(y>x && y>o3 && y>o4 && y>o5){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden2);
            }
            else if(o3>x && o3>y && o3>o4 && o3>o5){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden3);
            }
            else if(o4>x && o4>y && o4>o3 && o4>o5){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden4);
            }
            else {
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden5);
            }
            System.out.print("\nCaracterísticas actuales de su vehículo:");
            carros.AutoUsuario();

            do{
                System.out.println("\n¿Desea la Revancha?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Regreso = new Scanner(System.in);
                regreso = Regreso.nextInt();
            }while(regreso<1 ||regreso >2);
            int a =carros.getgasolina();
            System.out.println(carros.getgasolina());
            int b =pistas.getlargo();
            //Se crea el comparador para evaluar si el usuario tiene la gasolina necesaria para la revancha
            switch (regreso){
                case 1:
                    if(a<b){
                        System.out.println("Gasolina Actual: "+carros.getgasolina()+" Galones     Necesita "+pistas.getlargo()+" Galones");
                        System.out.println("No posee la gasolina suficiente");

                        do{
                            System.out.println("\n¿Comprar más?");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            Scanner Full = new Scanner(System.in);
                            full = Full.nextInt();
                        }while(full<1 ||full >2);
                        //Se manda al usuario a la gasolinera si así lo desea
                        switch(full){
                            case 1:
                                Garage gasolinera = new Garage();
                                gasolinera.LLenarTanque();
                                break;
                            case 2:
                                JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                                Menu1.menu();
                                break;
                        }

                    }
                    else{
                        ordenRiv();
                    }
                    break;
                case 2:
                    JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                    Menu1.menu();
                    break;
            }
        }
        else if (n==6)
        {
            int n1 = 65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            int n4 = (int)(Math.random()*6)+65;
            int n5 = (int)(Math.random()*6)+65;
            int n6 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            char orden4 = (char) n4;
            char orden5 = (char) n5;
            char orden6 = (char) n6;
            do{
                n1 = 65;
                n2 = (int)(Math.random()*6)+65;
                n3 = (int)(Math.random()*6)+65;
                n4 = (int)(Math.random()*6)+65;
                n5 = (int)(Math.random()*6)+65;
                n6 = (int)(Math.random()*6)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
                orden3 = (char) n3;
                orden4 = (char) n4;
                orden5 = (char) n5;
                orden6 = (char) n6;
            }while (orden1==orden2 || orden1==orden3  || orden1==orden4 || orden1==orden5 || orden1==orden6 || orden2==orden3  || orden2==orden4 || orden2==orden5 || orden2==orden6 || orden3==orden4 || orden3==orden5|| orden3==orden6  || orden4==orden5  || orden4==orden6 ||orden5==orden6);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("El orden de competición es: ");
            System.out.println("Ronda 1\n->"+orden1+""+orden2+""+orden3+""+orden4+""+orden5+""+orden6);

            //Declaro el movimiento que tendrá cada rival
            int Avance1=usuario.MovimientoUsuario();
            int Avance2=MovimientoRival();
            int Avance3=MovimientoRival();
            int Avance4=MovimientoRival();
            int Avance5=MovimientoRival();
            int Avance6=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 1
            Carretera avance1 = new Carretera(Avance1,1);
            Carretera avance11 = new Carretera(Avance2,1);
            Carretera avance111 = new Carretera(Avance3,1);
            Carretera avance1111 = new Carretera(Avance4,1);
            Carretera avance11111 = new Carretera(Avance5,1);
            Carretera avance111111 = new Carretera(Avance6,1);
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 1"+ ANSI_RESET+" ");
            avance1.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+Avance1+" espacios");
            avance11.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+Avance2+" espacios");
            avance111.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+Avance3+" espacios");
            avance1111.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+Avance4+" espacios");
            avance11111.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+Avance5+" espacios");
            avance111111.pintarAvance(); System.out.println(ANSI_BLANCO+"8-8-  "+orden6+ANSI_RESET);
            System.out.println("Se movió: "+Avance6+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance11=usuario.MovimientoUsuario();
            int Avance22=MovimientoRival();
            int Avance33=MovimientoRival();
            int Avance44=MovimientoRival();
            int Avance55=MovimientoRival();
            int Avance66=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 2
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 2"+ ANSI_RESET+" ");
            Carretera avance2 = new Carretera((Avance1+Avance11),1);
            Carretera avance22 = new Carretera((Avance2+Avance22),1);
            Carretera avance222 = new Carretera((Avance3+Avance33),1);
            Carretera avance2222 = new Carretera((Avance4+Avance44),1);
            Carretera avance22222= new Carretera((Avance4+Avance55),1);
            Carretera avance222222= new Carretera((Avance4+Avance66),1);
            avance2.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11)+" espacios en total");
            avance22.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22)+" espacios en total");
            avance222.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33)+" espacios");
            avance2222.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44)+" espacios");
            avance22222.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+(Avance5+Avance55)+" espacios");
            avance222222.pintarAvance(); System.out.println(ANSI_BLANCO+"8-8-  "+orden6+ANSI_RESET);
            System.out.println("Se movió: "+(Avance6+Avance66)+" espacios");

            //Declaro el movimiento que tendrá cada rival
            int Avance111=usuario.MovimientoUsuario();
            int Avance222=MovimientoRival();
            int Avance333=MovimientoRival();
            int Avance444=MovimientoRival();
            int Avance555=MovimientoRival();
            int Avance666=MovimientoRival();
            //Establezco las casillas avanzadas por rival, RONDA 3
            System.out.println("\n"+ANSI_BLANCO_SUBRAYADO+"RONDA 3"+ ANSI_RESET+" ");
            Carretera avance3 = new Carretera((Avance1+Avance11+Avance111+A),1);
            Carretera avance33 = new Carretera((Avance2+Avance22+Avance222),1);
            Carretera avance333 = new Carretera((Avance3+Avance33+Avance333),1);
            Carretera avance444 = new Carretera((Avance4+Avance44+Avance444),1);
            Carretera avance555 = new Carretera((Avance5+Avance55+Avance555),1);
            Carretera avance666 = new Carretera((Avance6+Avance66+Avance666),1);
            avance3.pintarAvance(); System.out.println(ANSI_BLUE+"8-8-  "+usuario.getnickname()+ANSI_RESET);
            System.out.println("Se movió: "+(Avance1+Avance11+Avance111+A)+" espacios en total");
            avance33.pintarAvance(); System.out.println(ANSI_RED+"8-8-  "+orden2+ANSI_RESET);
            System.out.println("Se movió: "+(Avance2+Avance22+Avance222)+" espacios en total");
            avance333.pintarAvance(); System.out.println(ANSI_GREEN+"8-8-  "+orden3+ANSI_RESET);
            System.out.println("Se movió: "+(Avance3+Avance33+Avance333)+" espacios en total");
            avance444.pintarAvance(); System.out.println(ANSI_PURPLE+"8-8-  "+orden4+ANSI_RESET);
            System.out.println("Se movió: "+(Avance4+Avance44+Avance444)+" espacios en total");
            avance555.pintarAvance(); System.out.println(ANSI_CYAN+"8-8-  "+orden5+ANSI_RESET);
            System.out.println("Se movió: "+(Avance5+Avance55+Avance555)+" espacios en total");
            avance666.pintarAvance(); System.out.println(ANSI_BLANCO+"8-8-  "+orden6+ANSI_RESET);
            System.out.println("Se movió: "+(Avance6+Avance6+Avance666)+" espacios en total");
            int x=(Avance1+Avance11+Avance111+A);
            int y=(Avance2+Avance22+Avance222);
            int o3=(Avance3+Avance33+Avance333);
            int o4=(Avance4+Avance44+Avance444);
            int o5=(Avance5+Avance55+Avance555);
            int o6=(Avance6+Avance66+Avance666);

            //Descuento de Gasolina
            usuario.setgasolinagastada(x);
            gas = carros.getgasolina()-x;
            carros.setgasolina(gas);

            //Ganador
            //Establezco los lugares de los competidores según su posiición

            if (x>y && x>o3 && x>o4 && x>o5 && x>o6){
                System.out.print("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+usuario.getnickname());
                int G=Gemas();
                double O=Oro();
                competicion.setPrimero(orden1);
                //Segundo Lugar
                //El competidor y segundo lugar
                if(y>o3 && y>o4 && y>o5 && y>o6) {
                    competicion.setSegundo(orden2);
                    if (o3>o4 && o3>o5 && o3>o6){
                        competicion.setTercero(orden3);
                        if(o4>o5 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>o4 && o5>o6){
                            competicion.setCuarto(orden5);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o6>o4 && o6>o5){
                            competicion.setCuarto(orden6);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                    }
                    else if (o4>o3 && o4>o5 && o4>o6){
                        competicion.setTercero(orden4);
                        if(o3>o5 && o3>o6){
                            competicion.setCuarto(orden3);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>o4 && o5>o6){
                            competicion.setCuarto(orden5);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o6>o4 && o6>o5){
                            competicion.setCuarto(orden6);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                    }
                    else if (o5>o3 && o5>o4 && o5>o6){
                        competicion.setTercero(orden5);
                        if(o3>o4 && o3>o4){
                            competicion.setCuarto(orden3);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>o3 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o6>o4 && o6>o3){
                            competicion.setCuarto(orden6);
                            if (o4>o3){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                            else{
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                        }
                    }
                    else if (o6>o3 && o6>o4 && o6>o5) {
                        competicion.setTercero(orden6);
                        if(o3>o4 && o3>o5){
                            competicion.setCuarto(orden3);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>o3 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o5>o4 && o5>o3){
                            competicion.setCuarto(orden5);
                            if (o3>o4){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                }
                //El competidor o3 segundo lugar
                else if (o3>y && o3>o4 && o3>o5 && o3>o6){
                    competicion.setSegundo(orden3);
                    if (o4>y && o4>o5 && o4>o6){
                        competicion.setTercero(orden4);
                        if(y>o5 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>y && o5>o6){
                            competicion.setCuarto(orden5);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>y && o6>o5){
                            competicion.setCuarto(orden6);
                            if (y>o5){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                    else if (y>o4 && y>o5 && y>o6){
                        competicion.setTercero(orden2);
                        if(o4>o5 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>o4 && o5>o6){
                            competicion.setCuarto(orden5);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o6>o4 && o6>o5){
                            competicion.setCuarto(orden6);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                    }
                    else if (o5>y && o5>o4 && o5>o6){
                        competicion.setTercero(orden5);
                        if(y>o4 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>o3 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o6>o4 && o6>o3){
                            competicion.setCuarto(orden6);
                            if (o4>o3){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                            else{
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                        }
                    }
                    else if (o6>o3 && o6>o4 && o6>o5) {
                        competicion.setTercero(orden6);
                        if(y>o4 && y>o5){
                            competicion.setCuarto(orden2);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>y && o4>o6){
                            competicion.setCuarto(orden4);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o5>o4 && o5>y){
                            competicion.setCuarto(orden5);
                            if (y>o4){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                }
                //El competidor o4 se lleva el segundo lugar
                else if (o4>y && o4>o3 && o4>o5 && o4>o6){
                    competicion.setSegundo(orden4);
                    if (o3>y && o3>o5 && o3>o6){
                        competicion.setTercero(orden3);
                        if(y>o5 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>y && o5>o6){
                            competicion.setCuarto(orden5);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>y && o6>o5){
                            competicion.setCuarto(orden6);
                            if (y>o5){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                    else if (y>o3 && y>o5 && y>o6){
                        competicion.setTercero(orden2);
                        if(o3>o5 && o3>o6){
                            competicion.setCuarto(orden3);
                            if (o5>o6){
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden5);
                            }
                        }
                        else if (o5>o3 && o5>o6){
                            competicion.setCuarto(orden5);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o6>o3 && o6>o5){
                            competicion.setCuarto(orden6);
                            if (o3>o5){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o5>y && o5>o3 && o5>o6){
                        competicion.setTercero(orden5);
                        if(y>o3 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o3>y && o3>o6){
                            competicion.setCuarto(orden3);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>o3 && o6>y){
                            competicion.setCuarto(orden6);
                            if (o3>y){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden2);
                            }
                            else{
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o6>o3 && o6>o4 && o6>o5) {
                        competicion.setTercero(orden6);
                        if(y>o4 && y>o5){
                            competicion.setCuarto(orden2);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>y && o4>o6){
                            competicion.setCuarto(orden4);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o5>o4 && o5>y){
                            competicion.setCuarto(orden5);
                            if (y>o4){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                }
                //El competidor o5 se lleva el segundo lugar
                else if (o5>y && o5>o3 && o5>o4 && o5>o6){
                    competicion.setSegundo(orden5);
                    if (o3>y && o3>o4 && o3>o6){
                        competicion.setTercero(orden3);
                        if(y>o4 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>y && o4>o6){
                            competicion.setCuarto(orden4);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>y && o6>o4){
                            competicion.setCuarto(orden6);
                            if (y>o4){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                    else if (y>o3 && y>o4 && y>o6){
                        competicion.setTercero(orden2);
                        if(o3>o4 && o3>o6){
                            competicion.setCuarto(orden3);
                            if (o4>o6){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>o3 && o4>o6){
                            competicion.setCuarto(orden4);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o6>o3 && o6>o4){
                            competicion.setCuarto(orden6);
                            if (o3>o4){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o4>y && o4>o3 && o4>o6){
                        competicion.setTercero(orden4);
                        if(y>o3 && y>o6){
                            competicion.setCuarto(orden2);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o3>y && o3>o6){
                            competicion.setCuarto(orden3);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>y && o6>o4){
                            competicion.setCuarto(orden6);
                            if (o3>y){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden2);
                            }
                            else{
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o6>o3 && o6>o4 && o6>o5) {
                        competicion.setTercero(orden6);
                        if(y>o4 && y>o5){
                            competicion.setCuarto(orden2);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>y && o4>o6){
                            competicion.setCuarto(orden4);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden6);
                            }
                            else{
                                competicion.setQuinto(orden6);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o5>o4 && o5>y){
                            competicion.setCuarto(orden5);
                            if (y>o4){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                }
                //El competidor o6 se lleva el segundo lugar
                else if (o6>y && o6>o3 && o6>o4 && o6>o5){
                    competicion.setSegundo(orden6);
                     if (y>o3 && y>o4 && y>o5){
                        competicion.setTercero(orden2);
                        if(o3>o4 && o3>o5){
                            competicion.setCuarto(orden3);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>o3 && o4>o5){
                            competicion.setCuarto(orden4);
                            if (o3>o6){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o5>o3 && o5>o4){
                            competicion.setCuarto(orden5);
                            if (o3>o4){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o3>y && o3>o4 && o3>o5){
                        competicion.setTercero(orden3);
                        if(y>o4 && y>o5){
                            competicion.setCuarto(orden2);
                            if (o4>o5){
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden4);
                            }
                        }
                        else if (o4>y && o4>o5){
                            competicion.setCuarto(orden4);
                            if (y>o5){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o5>y && o5>o4){
                            competicion.setCuarto(orden5);
                            if (y>o4){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden2);
                            }
                        }
                    }
                    else if (o4>y && o4>o3 && o4>o5){
                        competicion.setTercero(orden4);
                        if(y>o3 && y>o5){
                            competicion.setCuarto(orden2);
                            if (o3>o5){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o3>y && o3>o5){
                            competicion.setCuarto(orden3);
                            if (y>o6){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden5);
                            }
                            else{
                                competicion.setQuinto(orden5);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (o6>y && o6>o4){
                            competicion.setCuarto(orden6);
                            if (o3>y){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden2);
                            }
                            else{
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                    else if (o5>o3 && o5>o4 && o5>y) {
                        competicion.setTercero(orden5);
                        if(y>o4 && y>o3){
                            competicion.setCuarto(orden2);
                            if (o3>o4){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                        }
                        else if (o4>y && o4>o3){
                            competicion.setCuarto(orden4);
                            if (y>o3){
                                competicion.setQuinto(orden2);
                                competicion.setSexto(orden3);
                            }
                            else{
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden2);
                            }
                        }
                        else if (y>o4 && y>o3){
                            competicion.setCuarto(orden2);
                            if (o3>o4){
                                competicion.setQuinto(orden3);
                                competicion.setSexto(orden4);
                            }
                            else{
                                competicion.setQuinto(orden4);
                                competicion.setSexto(orden3);
                            }
                        }
                    }
                }

                System.out.println(ANSI_GREEN+"\nGanó "+G+" Gemas"+ usuario.ANSI_RESET);
                System.out.printf(ANSI_YELLOW+"Ganó "+O+" Monedas de oro"+ usuario.ANSI_RESET);
                usuario.setoro(oro+O);
                usuario.setgemas(gemas+G);
                System.out.print("\nGemas Actuales= "+usuario.getgemas());
                System.out.println(" Oro Actual= "+usuario.getgoro());
            }
            else if(y>x && y>o3 && y>o4 && y>o5 && y>o6){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden2);
            }
            else if(o3>x && o3>y && o3>o4 && o3>o5 && o3>o6){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden3);
            }
            else if(o4>x && o4>y && o4>o3 && o4>o5 && o4>o6){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden4);
            }
            else if(o5>x && o5>y && o5>o3 && o5>o4 && o5>o6){
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden5);
            }
            else {
                System.out.println("\n\t\t\t\t"+ANSI_GREEN+"Ganó el competidor "+ANSI_RESET+orden6);
            }
            System.out.print("\nCaracterísticas actuales de su vehículo:");
            carros.AutoUsuario();

            do{
                System.out.println("\n¿Desea la Revancha?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                Scanner Regreso = new Scanner(System.in);
                regreso = Regreso.nextInt();
            }while(regreso<1 ||regreso >2);
            int a =carros.getgasolina();
            System.out.println(carros.getgasolina());
            int b =pistas.getlargo();

            //Creo el comparador para evaluar si el usuairo tiene la gasolina necesaria para la revancha
            switch (regreso){
                case 1:
                    if(a<b){
                        System.out.println("Gasolina actual: "+carros.getgasolina()+" Galones    Necesita "+pistas.getlargo()+" Galones");
                        System.out.println("No posee la gasolina suficiente");

                        do{
                            System.out.println("\n¿Comprar más?");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su elección:"+ ANSI_RESET+" ");
                            Scanner Full = new Scanner(System.in);
                            full = Full.nextInt();
                        }while(full<1 ||full >2);
                        //Se manda al usuario a la gasolinera si así lo desea
                        switch(full){
                            case 1:
                                Garage gasolinera = new Garage();
                                gasolinera.LLenarTanque();
                                ordenRiv();
                                break;
                            case 2:
                                JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                                Menu1.menu();
                                break;
                        }
                    }
                    else{
                        ordenRiv();
                    }
                    break;
                case 2:
                    JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                    Menu1.menu();
                    break;
            }
        }
    }

    //Establezco el movimiento que tendrá el rival
    public int MovimientoRival (){
        int n1 = (int)(Math.random()*10)+1;
        int n2 = (int)(Math.random()*5)+1;

        int a= pistas.getcoeficiente();
        int z;
        z=(2*n1) + a +(1*n2);
        return z;
    }
    public void AutoRival(){
        Carros veh=new Carros();
        int n1 = (int)(Math.random()*5)+1;
        if(n1==1){
            veh.Ferrari();
        }
        else if(n1==2){
            veh.Honda();
        }
        else if(n1==3){
            veh.BMW();
        }
        else if(n1==4){
            veh.Mercedez();
        }
        else if(n1==5){
            veh.Tesla();
        }
    }

    //Establezco la cantidad de los premios en mi competencia
    public int Oro (){

        int n1 = (int)(Math.random()*10)+1;
        int potriv = getpotencia();
        int coepi= pistas.getcoeficiente();
        int ResOro;
        ResOro=(potriv+n1+coepi);
        return ResOro;
    }
    public int Gemas (){
        int n1 = (int)(Math.random()*10)+1;
        int potriv = getpotencia();
        int coepi= pistas.getcoeficiente();
        int ResGemas;
        ResGemas=(potriv*n1)+coepi;
        return ResGemas;
    }

    //Obtengo el orden de competición de los rivales
    public char getOrdenRiv()
    {
        return this.OrdenRiv;
    }
    public void setOrdenRiv(char OrdenRiv)
    {
        this.OrdenRiv=OrdenRiv;
    }

    //Establezco el nombre de mis rivales e imprimo su información
    public static void Rivales(){

        Rivales Rival1=new Rivales(""+usuario.getnickname(),"A");
        Rivales Rival2=new Rivales("Francisco","B");
        Rivales Rival3=new Rivales("Sebastian","C" );
        Rivales Rival4=new Rivales("Juan","D");
        Rivales Rival5=new Rivales("Alejandro","E" );
        System.out.println(Rival1.Presentación());
        System.out.println(Rival2.Presentación());
        System.out.println(Rival3.Presentación());
        System.out.println(Rival4.Presentación());
        System.out.println(Rival5.Presentación());

    }
}