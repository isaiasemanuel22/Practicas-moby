package Ejercicio4.repository;

import Ejercicio4.models.Cliente;
import Ejercicio4.models.Product;

import java.util.ArrayList;
import java.util.LinkedList;

public class ClientesRepo {
    ArrayList<Cliente> listCliente;

    public ClientesRepo(){
        this.listCliente = new ArrayList<Cliente>();
    }

    public void add (Cliente newCliente){
        this.listCliente.add(newCliente);
    }

    public Cliente get(String name , String lastname){
        return this.listCliente.get(this.searchByName(name , lastname));
    }

    public boolean remove(String name , String lastname) {
        return this.listCliente.remove(this.searchByName(name , lastname)).equals(Product.class);
    }

    public void viewClientes(){

        this.listCliente.stream().map(Cliente::toString)
                .forEach(System.out::println);

    }

    private int searchByName(String name , String lastname){
        int pos=-1;
        for (int i =0 ; i< this.listCliente.size() ; i++){
            if(listCliente.get(i).getName().equals(name) && listCliente.get(i).getLastname().equals(lastname) ){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
