package Ejercicio4.repository;

import Ejercicio4.Utilidades.Archivos;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProductsRepo {
    ArrayList<Product> listProducts;
    private Archivos<Product> file;

    public ProductsRepo() throws IOException {
        listProducts = new ArrayList<Product>();
        this.file = new Archivos<Product>("Productos.json");
        this.listProducts = file.read(new Product());
    }

    public void add (Product newProduct){
        this.listProducts.add(newProduct);
        this.file.save(listProducts);
    }

    public Product get(String cod){
        if(searchByCod(cod) > -1){
            return listProducts.get(this.searchByCod(cod));
        }
        return null;
    }

    public boolean remove(String cod) {
        if (this.searchByCod(cod) > -1){
            this.listProducts.remove(this.searchByCod(cod));
            file.save(listProducts);
            return true;
        }
        return false;
    }

    public void viewProducts(){

        this.listProducts.stream().map(Product::toString)
                .forEach(System.out::println);

    }

    private int searchByCod(String cod){
        int pos=-1;
        for (int i =0 ; i< this.listProducts.size() ; i++){
            if(listProducts.get(i).getCod().equals(cod)){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
