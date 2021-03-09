package Ejercicio4.controllers;

import Ejercicio4.Utilidades.Inputs;
import Ejercicio4.models.Product;
import Ejercicio4.repository.ProductsRepo;

import java.io.IOException;

public class ProductsController {
    private ProductsRepo listproducts;

    public ProductsController() throws IOException {
        this.listproducts = new ProductsRepo();
    }

    public boolean addProduct(){
        Product newProduct = new Product();
        Inputs<String> inputStr = new Inputs<String>();
        Inputs<Integer> inputItg = new Inputs<Integer>();
        Inputs<Float> inputflt = new Inputs<Float>();
        newProduct.setName(inputStr.input("Nombre: " , String.class));
        newProduct.setMarca(inputStr.input("Marca: " , String.class));
        newProduct.setPrecio(inputflt.input("Precio: " , Float.class));
        newProduct.setStock(inputItg.input("Stock: " , Integer.class));
        this.listproducts.add(newProduct);
        return true;

    }

    public String get(){
        Inputs<String> inputStr = new Inputs<String>();
        Product search = this.listproducts.get(inputStr.input("Ingrese Cod: ", String.class));
        return search.toString();
    }

    public boolean remove(){
        Inputs<String> inputStr = new Inputs<String>();
       return  this.listproducts.remove(inputStr.input("Ingrese Cod: ", String.class));
    }

    public void viewProducts(){
        this.listproducts.viewProducts();
    }
}
