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

    public void addProduct(){
        Product newProduct = new Product();
        Inputs<String> inputStr = new Inputs<String>();
        Inputs<Integer> inputItg = new Inputs<Integer>();
        Inputs<Float> inputflt = new Inputs<Float>();
        newProduct.setName(inputStr.input("Nombre: " , String.class));
        newProduct.setMarca(inputStr.input("Marca: " , String.class));
        newProduct.setPrecio(inputflt.input("Precio: " , Float.class));
        newProduct.setStock(inputItg.input("Stock: " , Integer.class));
        this.listproducts.add(newProduct);

    }

    public String get(String cod){
        Product search = this.listproducts.get(cod);
        return search.toString();
    }

    public void remove(String cod){
        this.listproducts.remove(cod);
    }

    public void viewProducts(){
        this.listproducts.viewProducts();
    }
}
