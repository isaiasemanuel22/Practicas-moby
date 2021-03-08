package Ejercicio3.main;


import Ejercicio3.models.*;

public class ejercicio3{

    public static void main(String args[]){

        Lily flowerLily = new AndhraPradesh().yourNationalFlower();
        System.out.println(flowerLily.whatsYourName());

        Jasmine flowerJasmine = new WestBegal().yourNationalFlower();
        System.out.println(flowerJasmine.whatsYourName());

        Flower flower = new Region().yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }

}