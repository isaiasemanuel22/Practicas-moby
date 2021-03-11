package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.ClienteEmpresa;
import Ejercicio4.models.Order;
import Ejercicio4.models.Product;
import Ejercicio4.repository.ClientesRepo;
import Ejercicio4.repository.OrderRepo;
import Ejercicio4.repository.ProductsRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class OrderController {
    private OrderRepo listOrder;
    private ClientesRepo listClient;
    private ProductsRepo listProduct;

    public OrderController() throws IOException{
        this.listOrder = OrderRepo.getInstance();
        this.listClient = ClientesRepo.getInstance();
        this.listProduct = ProductsRepo.getInstance();
    }

    public Order addOrder(){
        Inputs<String> inputSrt =  new Inputs<String>();
        String nombre = inputSrt.input("Nombre: " , String.class);
        String apellido = inputSrt.input("Apellido: " , String.class);

        ArrayList<Cliente> orderClient = this.listClient.get(nombre , apellido);
        Cliente cliente = new Cliente();
        if (orderClient.size() == 1) {
            cliente = orderClient.get(0);
        } else if (orderClient.size() > 1) {
            cliente = this.listClient.getByDNI(orderClient , inputSrt.input("DNI: ", String.class));
        } else{
            System.out.println("El cliente ingresado no existe");
        }

        if(cliente.getName() != null){
            Calendar day = Calendar.getInstance();

            String dia = Integer.toString(day.get(Calendar.DATE));
             dia = dia + "/" + Integer.toString(day.get(Calendar.MONTH));
             dia = dia + "/" + Integer.toString(day.get(Calendar.YEAR));

            Order newOrder = new Order(dia , cliente.getName() , cliente.getLastname() , cliente.getDNI() ,addListProduct());
            this.listOrder.add(newOrder);

            return newOrder;
        }
        return new Order();
    }

    private ArrayList<Product> addListProduct(){
        boolean exit = false;
        Inputs<String> inputsStr = new Inputs<String>();
        Inputs<Integer> inputInt = new Inputs<Integer>();
        ArrayList<Product> listProductOrder = new ArrayList<Product>();
       do {
           this.listProduct.viewProducts();
           listProductOrder.add(listProduct.get(inputsStr.input("COD" , String.class)));

           if(inputInt.input("Salir = 0" , Integer.class) == 0 ){
               exit = true;
           }
        }while (exit == false);

       return listProductOrder;
    }

    public void viewOrders(){
        this.listOrder.viewOrder();
    }

    public String charge(Order order){
        this.listOrder.remove(order);
        order.charge();
        this.listOrder.add(order);
        return order.toString() + " \n Total a Cobrar: " + this.calcularNeto(order);
    }

    public float calcularNeto(Order order){
        Cliente client = this.listClient.getByDNI(listClient.getAll() , order.getDni());
        if(client instanceof ClienteEmpresa){
            return order.descuento(10);
        }
        return order.descuento(15);
    }

    public float calcularTotalBruto (Order order){
      return  order.calcularTotalBruto();
    }

    public String assignPayment(Order order){
        Cliente client = listClient.getByDNI(listClient.getAll(), order.getDni());
        if(order.getPaid()){
            return " ";
        } else{
            if(client instanceof ClienteEmpresa){
                return "Pago con targeta de credito";
            }
            return "Pago en efectivo";
        }

    }





}
