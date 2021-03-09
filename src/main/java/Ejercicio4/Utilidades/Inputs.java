package Ejercicio4.Utilidades;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Inputs <T>  {


     public Inputs(){

     }

     public T input(String mensaje, Object obj) throws InputMismatchException{

         Scanner scan = new Scanner(System.in);

         T entrada = null;
         do {
             System.out.println(mensaje);
             if (obj.equals(String.class)) {
                 try {
                     String input = scan.nextLine();
                     entrada = (T) input;
                 }catch (Exception e){
                     scan.nextLine();
                 }

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

         }while (entrada == null || entrada == "");

         return entrada;
     }
}
