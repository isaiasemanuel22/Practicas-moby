package Ejercicio4.controllers;

public class Corralon {

    private static Corralon intance;

    private Corralon(){

    }

    public static Corralon run(){
        if(intance == null){
            intance = new Corralon();

        }
       return intance;
    }



}
