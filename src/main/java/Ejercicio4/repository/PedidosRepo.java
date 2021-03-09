package Ejercicio4.repository;

import Ejercicio4.models.Pedido;

import java.util.ArrayList;

public class PedidosRepo {
    ArrayList<Pedido> listPedidos;

    public PedidosRepo(){
        listPedidos = new ArrayList<Pedido>();
    }

    public void add(Pedido newPedido){
        listPedidos.add(newPedido);
    }

    public void viewPedidos(){
        this.listPedidos.stream().map(Pedido::toString)
                .forEach(System.out::println);
    }

}
