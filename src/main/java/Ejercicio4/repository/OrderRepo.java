package Ejercicio4.repository;

import Ejercicio4.Utilidades.Archivos;
import Ejercicio4.models.Order;

import java.io.IOException;
import java.util.ArrayList;

public class OrderRepo {
    private  ArrayList<Order> listOrder;
    private Archivos<Order> file;
    private static OrderRepo instance;

    private OrderRepo() throws IOException {
        listOrder = new ArrayList<Order>();
        this.file = new Archivos<Order>("Order.json");
        this.listOrder = file.read(new Order());
    }

    public static OrderRepo getInstance() throws IOException {
        if(instance == null){
            instance = new OrderRepo();
        }
        return instance;
    }

    public void add(Order newOrder){
        listOrder.add(newOrder);
        this.file.save(this.listOrder);
    }

    public void viewOrder(){
        this.listOrder.stream().map(Order::toString)
                .forEach(System.out::println);
    }

    public void remove(Order order){
        this.listOrder.remove(order);
        this.file.save(this.listOrder);
    }

}
