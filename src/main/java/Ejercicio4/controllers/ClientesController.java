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
        System.out.println("AGREGAR UN NUEVO CLIENTE: ");
        newCliente.setName(new Inputs<String>().input("Nombre: " , String.class));
        newCliente.setLastname(new Inputs<String>().input("apellido: " , String.class));
        newCliente.setBirth(new Inputs<String>().input("cumpleaños: " , String.class));
        newCliente.setPhoneNumber(new Inputs<String>().input("numero telefonico: " , String.class));
        newCliente.setDNI(new Inputs<String>().input("DNI: " , String.class));

        this.listClientes.add(empresa(newCliente));

    }

    private Cliente empresa(Cliente cliente){
        System.out.println("Representa a una empresa? \n S/N" );
        if(new Inputs<String>().input(" " , String.class).equals("S")){
            ClienteEmpresa newClienteEmpre = (ClienteEmpresa) cliente;
            newClienteEmpre.setCuit(new Inputs<String>().input("CUIT: " , String.class));
            newClienteEmpre.setCondicionIVA(new Inputs<String>().input("IVA: " , String.class));

            cliente = newClienteEmpre;
        }
        return cliente;
    }



}
