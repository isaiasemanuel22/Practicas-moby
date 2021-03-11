package Ejercicio4.repository;

import Ejercicio4.Utilidades.Archivos;
import Ejercicio4.models.Cliente;
import Ejercicio4.models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsRepo {
    ArrayList<Product> listProducts;
    private Archivos<Product> file;
    private static ProductsRepo instance;

    private ProductsRepo() throws IOException {
        listProducts = new ArrayList<Product>();
        this.file = new Archivos<Product>("Productos.json");
        this.listProducts = file.read(new Product());
    }

    public static ProductsRepo getInstance() throws IOException {
        if(instance == null){
            instance = new ProductsRepo();
        }
        return instance;
    }
    public void add (Product newProduct){
        this.listProducts.add(newProduct);
        this.file.save(listProducts);
    }

    public Product get(String cod){

        Stream<Product> product = this.listProducts.stream().filter(product1 -> product1.getCod().equals(cod));

        ArrayList<Product> search = (ArrayList<Product>) product.collect(Collectors.toList());

        if(search.size() < 1){
            System.out.println("no Existe");
            return new Product();
        }


        return search.get(0);
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
