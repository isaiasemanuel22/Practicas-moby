package Ejercicio1y2.main;



import Ejercicio1y2.models.MyCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Ejercicio 1;
        /*
        Se te pide que calcules la potencia de un número implementando una calculadora.
        Crea la clase MyCalculator la cual consiste en un único método
        long power(int a,int b).
        Este método recibe dos parámetros y eleve el primero por el segundo (a
        elevado a la b). Si cualquiera de los dos números que se reciben es negativo,
        entonces el método deberá lanzar una excepción que diga “Ninguno de los
        números ingresados debe ser negativo”. También, si éstos tienen valor cero, el
        método deberá lanzar una excepción que diga “Ninguno de los números
        ingresados puede valer cero”.*/


        long  rta =0 ;

        Supplier<MyCalculator> calculator = MyCalculator::new; // utilizacion de programacion funcional

        System.out.println("Ingrese 2 valores numeros positivos y no nulos");
        while (rta == 0){
            try{

                System.out.println("Num 1: ");
                int num1 = scan.nextInt();

                scan.nextLine();


                System.out.println("Num 2: ");
                int num2 = scan.nextInt();

                rta = calculator.get().power(num1 , num2);

            }catch (RuntimeException e ){
                System.out.println(e.getMessage());

                scan.nextLine();
            }
        }
        System.out.println("resultado: " + rta);

        //Ejercicio 2

        /*Dados dos números enteros x e y como inputs deberás realizar la operación x/y. Si
        x e y no son números enteros o si y vale cero, se producirá una excepción y deberás
        informarla. Las excepciones son java.util.InputMismatchException y
        java.lang.ArithmeticException.*/

        System.out.println("Division");
        System.out.println("Ingrese 2 valores numerios , positivos , no nulos");
        float rta2 = 0;
       do {
            try{

                System.out.println("Num 1: ");
                int num1 = scan.nextInt();

                scan.nextLine();


                System.out.println("Num 2: ");
                int num2 = scan.nextInt();

                rta2 = (float) num1 / (float) num2;

            }
            catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numerico");
                scan.nextLine();
            }
            catch (ArithmeticException e ){

                System.out.println("El denominador debe ser positivo mayor a 0");

                scan.nextLine();
            }
        }while (rta2 == 0);

       System.out.println("Resultado= " + rta);

    }


}
