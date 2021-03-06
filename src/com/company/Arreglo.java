package com.company;

import java.util.Scanner;

public class Arreglo {
    public static void Arreglo(){
        Usuario usuario=new Usuario();
        String array[];
        array = new String[5];
        array[0]=""+usuario.getvehiculo();


        for (int x=0;x<array.length;x++)
            System.out.println("Auto "+x+" "+array[x]);

    }

}
