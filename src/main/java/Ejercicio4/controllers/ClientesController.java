package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.ClienteEmpresa;
import Ejercicio4.repository.ClientesRepo;



public class ClientesController {
    private ClientesRepo listClientes;

    public ClientesController(){
        listClientes = new ClientesRepo();
    }

    public void addCliente(){
        Cliente newCliente = new Cliente();
        Inputs<String> inputStr = new Inputs<String>();
        Inputs<Integer> inputItg = new Inputs<Integer>();
        newCliente.setName(inputStr.input("Nombre: " , String.class));
        newCliente.setLastname(inputStr.input("apellido: " , String.class));
        newCliente.setBirth(inputStr.input("cumpleaños: " , String.class));
        newCliente.setPhoneNumber(inputStr.input("numero telefonico: " , String.class));
        newCliente.setDNI(inputStr.input("DNI: " , String.class));
        this.listClientes.add(empresa(newCliente));

    }

    private Cliente empresa(Cliente cliente){
        Inputs<String> inputStr = new Inputs<String>();
        Inputs<Integer> inputItg = new Inputs<Integer>();
        System.out.println("Representa a una empresa? \n 1_SI - 2_NO" );
        if(inputItg.input(" " , Integer.class) == 1 ){
           ClienteEmpresa newClienteEmpre = new ClienteEmpresa(cliente.getName() ,cliente.getLastname() , cliente.getBirth() , cliente.getPhoneNumber() , cliente.getDNI());
            newClienteEmpre.setCuit(inputStr.input("CUIT: " , String.class));
            newClienteEmpre.setCondicionIVA(inputStr.input("IVA: " , String.class));

            cliente = newClienteEmpre;
        }
        return cliente;
    }


    public String getCliente(){
        Inputs<String> inputStr = new Inputs<String>();
        Cliente search = this.listClientes.get(inputStr.input("Ingrese nombre: " , String.class) , inputStr.input("Ingrese apellido: " , String.class));
        return search.toString();
    }

    public void remove(){
        Inputs<String> inputStr = new Inputs<String>();
        this.listClientes.remove(inputStr.input("Ingrese nombre: " , String.class) , inputStr.input("Ingrese apellido: " , String.class));
    }

    public void viewClientes(){
        this.listClientes.viewClientes();
    }


}
