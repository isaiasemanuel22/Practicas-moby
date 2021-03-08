package Ejercicio4.Utilidades;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Inputs <T>  {


     public Inputs(){

     }

     public T input(String mensaje, Object obj) throws InputMismatchException{

         Scanner scan = new Scanner(System.in);

         T entrada = null;
         while (entrada == null){
             System.out.println(mensaje);
             if (obj.equals(String.class)) {
                 String input = scan.nextLine();
                 entrada = (T) input;
             }else
                 if(obj.equals(Integer.class)){
                 Integer  input = null;
                 try {
                     input = scan.nextInt();
                 }
                 catch (InputMismatchException ex){
                     System.out.println("Ingrese una entrada valida");
                     scan.nextLine();
                 }

                 entrada = (T) input;
             }else{
                     Float  input = null;
                     try {
                         input = scan.nextFloat();
                     }
                     catch (InputMismatchException ex){
                         System.out.println("Ingrese una entrada valida");
                         scan.nextLine();
                     }

                     entrada = (T) input;
                 }
         }

         return entrada;
     }
}
