package Ejercicio4.models;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Order implements JsonWrite {
    private String day;
    private String nameClient;
    private String lastnameClient;
    private ArrayList<Product> listProducts;
    private boolean paid;
    private String dniClient;

    public Order(String day , String nameClient ,String lastnameClient, String dni ,ArrayList<Product> listProducts){
        this.day = day;
        this.nameClient = nameClient;
        this.lastnameClient = lastnameClient;
        this.dniClient = dni;
        this.listProducts = listProducts;
        this.paid = false;
    }

    public Order( ) {
    }

    public float calcularTotalBruto (){
        float bruto = 0;
        for (Product product : listProducts ) {
            bruto = bruto + product.getPrecio();
        }
        return bruto;
    }


    public float descuento(float porcentaje){
        float bruto = calcularTotalBruto();
        return bruto - (bruto * porcentaje)/100;
    }
    public void charge(){
       this.paid = true;
    }

    public String getNameClient(){
        return this.nameClient;
    }

    public String getLastnameClient(){
        return this.lastnameClient;
    }

    public String getDni(){
        return dniClient;
    }

    public boolean getPaid(){
        return this.paid;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "day='" + this.day + '\'' +
                ", nameCliente='" + this.nameClient + '\'' +
                '}';
    }
    @Override
    public String writeJson(){
        return "\n{\n" +
                "day: " + this.day + '\n' +
                "nameCliente: " + this.nameClient + '\n' +
                "}\n";
    }
}
