package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.Order;
import Ejercicio4.repository.OrderRepo;

import java.io.IOException;

public class Corralon {

    private static Corralon intance;
    private ClientesController clientes;
    private ProductsController productos;
    private OrderController orders;

    public Corralon() throws IOException {
        this.clientes = new ClientesController();
        this.productos = new ProductsController();
        this.orders = new OrderController();
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
                }
                case 3 -> {
                    Cliente cliente = this.clientes.getCliente();
                    if( ! (cliente.getName() == null) ){
                        System.out.println(cliente.toString());
                        input.input(" " , String.class);
                    }

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

    private void menuProductos() {
        boolean exit = false;
        do {
            Inputs<Integer> input = new Inputs<Integer>();
            System.out.println("1_ Agregar Producto");
            System.out.println("2_ Mostrar Productos");
            System.out.println("3_ Mostrar Un Producto");
            System.out.println("4_ Eliminar Un Producto");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: ", Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> {
                    if (this.productos.addProduct()) {
                        System.out.println("El producto de cargo exitosamente");
                    } else {
                        System.out.println("Ocurrio un error al cargar el producto");
                    }
                }
                case 2 -> {
                    this.productos.viewProducts();
                    input.input(" ", String.class);
                }
                case 3 -> {
                    System.out.println(this.productos.get().toString());
                    input.input(" ", String.class);
                }
                case 4 -> {
                    if (this.productos.remove()) {
                        System.out.println("Se ha eliminado exitosamente");
                    } else {
                        System.out.println("Ha ocurrido un error al intentar eliminar");
                    }
                }
            }

        } while (!exit) ;
    }
    private void menuPedidos(){
        boolean exit = false;
        do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Agregar Pedido");
            System.out.println("2_ Mostrar Pedidos");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> { Order order  = this.orders.addOrder();
                            if(order.getNameClient()!=null){
                                submenuOrder(order);
                            }
                            }
                case 2 -> this.orders.viewOrders();
            }
        }while (!exit);
    }

    private void submenuOrder(Order order){
        boolean exit = false;
        do {
            Inputs<Integer> input= new Inputs<Integer>();
            System.out.println("1_ Calcular total Bruto");
            System.out.println("2_ Asignar Pago");
            System.out.println("3_ Calcular total Neto");
            System.out.println("4_ Cobrar");
            System.out.println("0_ Salir");
            int entada = input.input("Ingrese una opcion: " , Integer.class);

            switch (entada) {
                case 0 -> exit = true;
                case 1 -> System.out.println(order.calcularTotalBruto());
                case 2 -> System.out.println(this.orders.assignPayment(order));
                case 3 -> System.out.println(this.orders.calcularNeto(order));
                case 4 -> System.out.println(this.orders.charge(order));
            }
        }while (!exit);
    }




}
