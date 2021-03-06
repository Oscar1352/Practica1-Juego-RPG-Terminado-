package com.company;
import java.util.Scanner;

public class Ruleta {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLANCO_SUBRAYADO = "\033[1;47;30m";

    public void Ruleta(){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLANCO_NEGRITA = "\033[2;47;30m";

        //Defino mis variable general
        Usuario usuario=new Usuario();
        int gemas=usuario.getgemas();
        double oro= usuario.getgoro();
        int ruleta,Ciclo;

        //Inicio
        System.out.println("\n\n\t\t\t\t\t\t"+ANSI_BLANCO_NEGRITA+"Bienvenido al videojuego de la ruleta"+ANSI_RESET);
        System.out.print("Cantidad de oro Actual= "+usuario.getgoro());
        System.out.println("\t\tCantidad de gemas= "+usuario.getgemas());
        System.out.println("Costo de juego 5 gemas, gemas actuales : "+usuario.getgemas());
        System.out.println("¿Te sientes con suerte?");
        System.out.println("1)Si");
        System.out.println("2)No");
        System.out.print(ANSI_BLANCO_SUBRAYADO + "Ingrese su elección:" + ANSI_RESET + " ");
        do {
            System.out.print(ANSI_BLANCO_SUBRAYADO+"Ingrese su opción:"+ANSI_RESET+" ");
            Scanner Ruleta = new Scanner(System.in);
            ruleta = Ruleta.nextInt();
            }while ( ruleta < 1 || ruleta > 2 );
            switch(ruleta){
                case 1:
                    if (usuario.getgemas()>=5){
                    System.out.println("\n\t\t\t\t\t\tVamos a jugar, Gemas actuales "+usuario.getgemas());
                    usuario.setgemas(gemas-5);
                    System.out.println("Gemas restantes= "+usuario.getgemas());
                        System.out.println("Oro actual= "+usuario.getgoro());
                    double random = Math.random();// generamos un numero al azar entre 0 y 1

                        //Establezco las propabilidades tomando en base a 1 como uno 100%
                    if (random < 0.1){// el 10% de las veces
                        System.out.println(ANSI_GREEN+  "\nTe ganaste 40 gemas"+ ANSI_RESET);
                        usuario.setgemas(gemas+40);
                    System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                    System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                }
                    else if(random <0.15){// el 15% de las veces
                        System.out.println(ANSI_YELLOW+"\nTe ganaste 75 de oro"+ANSI_RESET);
                        usuario.setoro((int) (oro+75));
                        System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                        System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                }
                    else if(random <0.05){// el 5% de las veces
                    System.out.println(ANSI_GREEN+"\nTe ganaste 1000  gemas"+ANSI_RESET);
                        usuario.setgemas(gemas+1000);
                        System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                        System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                    }
                    else if(random <0.05){// el 5% de las veces
                        System.out.println(ANSI_YELLOW+"\nTe ganaste 2000 de oro"+ANSI_RESET);
                        usuario.setoro((int) (oro+2000));
                        System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                        System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                    }
                    else if(random <0.3){// el 30% de las veces
                        System.out.println(ANSI_GREEN+"\nTe ganaste 5 gemas"+ANSI_RESET);
                        usuario.setgemas(gemas+5);
                        System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                        System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                    }
                    else{// el 10% restante
                        System.out.println(ANSI_YELLOW+"\nTe ganaste 10 de oro"+ANSI_RESET);
                        usuario.setoro((int) (oro+10));
                        System.out.println("\nTus totales son: "+usuario.getgemas()+" gemas");
                        System.out.println("Tus totales son: "+usuario.getgoro()+" monedas oro");
                    }
                    }
                    else{
                        System.out.println("No posee la cantidad de gemas necesarias para jugar");
                    }
                    System.out.println("\n¿Regresar al juego?");
                    System.out.println("1)Si");
                    System.out.println("2)No, Regresar al menú");
                    do{
                    System.out.println("\nIngrese su opcion: ");
                    Scanner Ruleta = new Scanner(System.in);
                    Ciclo = Ruleta.nextInt();
                    }while(Ciclo < 1 || Ciclo > 2);
                    switch (Ciclo){
                        case 1:
                            if(gemas>=5)
                                Ruleta();
                            else
                                //Si el usuario no tiene las gemas necesarias para lanzar la ruleta es regresasdo al menu principal
                                System.out.println("No posee la cantidad de gemas necesarias para jugar");
                            System.out.println(ANSI_RED+ "\n\t\t\t\t\t\tRegresaremos al menú" + ANSI_RESET);
                            System.out.println("\t\t\tJUEGO FINALIZADO \t\t\tOro="+usuario.getgoro()+" Gemas="+usuario.getgemas());
                            JUEGOEJECUTABLE Menu= new JUEGOEJECUTABLE();
                                Menu.menu();
                            break;
                        case 2:
                            //El usuario dicide ser regresasdo al menu principal
                            System.out.println(ANSI_RED+ "\n\t\t\t\t\t\tRegresaremos al menú" + ANSI_RESET);
                            System.out.println("\t\t\tJUEGO FINALIZADO \t\t\tOro="+usuario.getgoro()+" Gemas="+usuario.getgemas());
                            JUEGOEJECUTABLE Menu1= new JUEGOEJECUTABLE();
                            Menu1.menu();

                            break;
                    }
                    break;
                case 2:
                    //El usuario no decide jugar y es enviado al menú
                    System.out.println(ANSI_RED+ "\n\t\t\t\t\t\tRegresaremos al menú" + ANSI_RESET);
                    System.out.println("\t\t\tJUEGO FINALIZADO \t\t\tOro="+usuario.getgoro()+" Gemas="+usuario.getgemas());
                    JUEGOEJECUTABLE Menu= new JUEGOEJECUTABLE();
                    Menu.menu();
                    break;
        }
    }

}