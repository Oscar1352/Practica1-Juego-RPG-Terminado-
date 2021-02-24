package com.company;

public class Rivales {
    String Nombre;
    String Variable;


    public Rivales(String nombre, String variable){
        this.Nombre = nombre;
        this.Variable = variable;
    }

    public Rivales() {

    }

    // método 1
    public String getnombre()
    {
        return Nombre;
    }
    // método 2
    public String getnacionalidad()
    {
        return Variable;

    }

    public String toString()
    {
        return("\nHola soy "+this.Nombre+" \n Soy el competidor: "+this.Variable);
    }

    public void ordenRiv(){
        //Genero Los numeros aleartorios para los turnos
        //Creo sistema para que no se repitan los competidores
        int n = (int)(Math.random()*5)+2;
        if (n==2)
        {
            int n1 = (int)(Math.random()*6)+65;
            int n2 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            do{
                n1 = (int)(Math.random()*3)+65;
                n2 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
            }while (orden1==orden2);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2);
        }
        else if (n==3)
        {
            int n1 = (int)(Math.random()*6)+65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            do{
                n1 = (int)(Math.random()*3)+65;
                n2 = (int)(Math.random()*3)+65;
                n3 = (int)(Math.random()*3)+65;
                orden1 = (char) n1;
                orden2 = (char) n2;
                orden3 = (char) n3;
            }while (orden1==orden2 || orden2==orden3 ||orden1==orden3);
            System.out.println("\nLa cantidad de rivales son: "+n);
            System.out.println("Ronda 1\n->"+orden1+""+orden2+""+orden3);
        }
        else if (n==4)
        {
            int n1 = (int)(Math.random()*6)+65;
            int n2 = (int)(Math.random()*6)+65;
            int n3 = (int)(Math.random()*6)+65;
            int n4 = (int)(Math.random()*6)+65;
            char orden1 = (char) n1;
            char orden2 = (char) n2;
            char orden3 = (char) n3;
            char orden4 = (char) n4;
            do{
                n1 = (int)(Math.random()*3)+65;
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
        }
        else if (n==5)
        {
            int n1 = (int)(Math.random()*6)+65;
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
                n1 = (int)(Math.random()*3)+65;
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
        }
        else if (n==6)
        {
            int n1 = (int)(Math.random()*6)+65;
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
                n1 = (int)(Math.random()*6)+65;
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
        }
    }


    public static void main(String[] args){

        Rivales Rival1=new Rivales("Carlos","A");
        Rivales Rival2=new Rivales("Francisco","B");
        Rivales Rival3=new Rivales("Sebastian","C" );
        Rivales Rival4=new Rivales("Juan","D");
        Rivales Rival5=new Rivales("Alejandro","E" );
        System.out.println(Rival1.toString());
        System.out.println(Rival2.toString());
        System.out.println(Rival3.toString());
        System.out.println(Rival4.toString());
        System.out.println(Rival5.toString());

    }
}