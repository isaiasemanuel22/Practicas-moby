package Ejercicio4.repository;

import Ejercicio4.Utilidades.Archivos;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientesRepo {
    private ArrayList<Cliente> listCliente;
    private Archivos<Cliente> file;
    private static ClientesRepo instance;

    private ClientesRepo() throws IOException {
        this.listCliente = new ArrayList<Cliente>();
        this.file = new Archivos<Cliente>("Clientes.json");
        this.listCliente = file.read(new Cliente());
    }

    public static ClientesRepo getInstance() throws IOException {
        if(instance == null){
            instance = new ClientesRepo();
        }
        return instance;
    }

    public boolean add (Cliente newCliente){
        this.listCliente.add(newCliente);
        this.file.save(this.listCliente);
        return true;
    }

    public ArrayList<Cliente> get(String name , String lastname){

        Stream<Cliente> list =  listCliente.stream().filter(cliente -> cliente.getName().equals(name)).filter(cliente -> cliente.getLastname().equals(lastname));

        ArrayList<Cliente> listSearch = (ArrayList<Cliente>) list.collect(Collectors.toList());

        return listSearch;
    }

    public ArrayList<Cliente> getAll() {
        return listCliente;
    }

    public Cliente getByDNI(ArrayList<Cliente> list , String dni){

        Cliente client = list.stream().filter(cliente -> cliente.getDNI().equals(dni)).findFirst().get();

        if(client.getName() == null){
            System.out.println("El cliente no existe");
        }
        return client;
    }


    public boolean remove(String name , String lastname) {

        if(this.searchByName(name , lastname) > -1){
            this.listCliente.remove(searchByName(name , lastname));
            file.save(this.listCliente);
            return true;
        }
        return false;
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
