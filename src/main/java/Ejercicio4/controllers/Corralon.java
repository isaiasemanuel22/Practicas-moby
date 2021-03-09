package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;

import java.io.IOException;

public class Corralon {

    private static Corralon intance;
    private ClientesController clientes;

    public Corralon() throws IOException {
        this.clientes = new ClientesController();
    }

    public static Corralon start() throws IOException {
        if(intance == null){
            intance = new Corralon();

        }
       return intance;
    }

    public void run() throws IOException, InterruptedException {
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

    private void menuCliente() throws IOException, InterruptedException {
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
                case 1 -> {if(this.clientes.addCliente()){
                    System.out.println("Creado exitosamente");
                }else {
                    System.out.println("Fallo la creacion de cuenta");
                }
                }

                case 2 -> {this.clientes.viewClientes();
                            input.input(" " , String.class);
                            break;
                }
                case 3 -> {System.out.println(this.clientes.getCliente());
                input.input(" " , String.class);
                break;}

                case 4 -> {if(this.clientes.remove()){
                    System.out.println("Eliminado Correctamente");
                }else{
                    System.out.println("Fallo la eliminacion de cuenta");
                }
                }
                default -> throw new IllegalStateException("Unexpected value: " + entada);
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
