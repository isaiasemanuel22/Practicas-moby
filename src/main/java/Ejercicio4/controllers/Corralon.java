package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;

import java.util.Scanner;

public class Corralon {

    private static Corralon intance;
    private ClientesController clientes;

    public Corralon(){
        this.clientes = new ClientesController();
    }

    public static Corralon start(){
        if(intance == null){
            intance = new Corralon();

        }
       return intance;
    }

    public void run(){
        boolean exit = false;
       do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Clientes");
            System.out.println("2_ Productos");
            System.out.println("3_ Pedidos");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

           switch (entada) {
               case 0 -> exit = true;
               case 1 -> menuCliente();
               case 2 -> menuProductos();
               case 3 -> menuPedidos();
           }
        }while (!exit);

    }

    private void menuCliente(){
        boolean exit = false;
        do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Agregar Cliente");
            System.out.println("2_ Mostrar Clientes");
            System.out.println("3_ Mostrar Un Cliente");
            System.out.println("4_ Eliminar Un Cliente");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> this.clientes.addCliente();
                case 2 -> this.clientes.viewClientes();
                case 3 -> System.out.println(this.clientes.getCliente());
                case 4 -> this.clientes.remove();
            }
        }while (!exit);
    }

    private void menuProductos(){
        boolean exit = false;
        do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Agregar Cliente");
            System.out.println("2_ Mostrar Clientes");
            System.out.println("3_ Mostrar Un Cliente");
            System.out.println("4_ Eliminar Un Cliente");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> this.clientes.addCliente();
                case 2 -> this.clientes.viewClientes();
                case 3 -> this.clientes.getCliente();
                case 4 -> this.clientes.remove();
            }
        }while (!exit);
    }
    private void menuPedidos(){
        boolean exit = false;
        do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Agregar Cliente");
            System.out.println("2_ Mostrar Clientes");
            System.out.println("3_ Mostrar Un Cliente");
            System.out.println("4_ Eliminar Un Cliente");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> this.clientes.addCliente();
                case 2 -> this.clientes.viewClientes();
                case 3 -> this.clientes.getCliente();
                case 4 -> this.clientes.remove();
            }
        }while (!exit);
    }




}
