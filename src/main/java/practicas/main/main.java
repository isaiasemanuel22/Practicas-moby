package practicas.main;

import practicas.main.models.MyCalculator;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long rta = 0;
        System.out.println("Ingrese 2 valores numeros positivos y no nulos");
        while (rta == 0){
            try{
                System.out.println("Num 1: ");
                int num1 = scan.nextInt();
                scan.nextLine();
                System.out.println("Num 2: ");
                int num2 = scan.nextInt();

                rta = new MyCalculator().power(num1 , num2);

            }catch (RuntimeException e ){
                System.out.println(e.getMessage());

                scan.nextLine();
            }
        }

        System.out.println("resultado: " + rta);

    }
}
