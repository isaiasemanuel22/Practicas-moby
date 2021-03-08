package Ejercicio4.repository;

import Ejercicio4.models.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductsRepo {
    LinkedList<Product> listProducts;

    public ProductsRepo(){
        listProducts =  new LinkedList<Product>();
    }

    public void add (Product newProduct){
        listProducts.add(newProduct);
    }

    public Product get(String cod){
      return listProducts.get(this.searchByCod(cod));
    }

    public boolean remove(String cod) {
        return this.listProducts.remove(this.searchByCod(cod)).equals(Product.class);
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
