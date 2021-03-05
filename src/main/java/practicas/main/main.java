package practicas.main;

import practicas.main.models.MyCalculator;

public class main {

    public static void main(String[] args) {
        long resultado = new MyCalculator().power(1 , 3);
        System.out.println("resultado: " + resultado);

    }
}
