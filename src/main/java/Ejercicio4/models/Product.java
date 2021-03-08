package Ejercicio4.models;

import java.util.Random;

public class Product {
    private String cod;
    private String name;
    private String marca;
    private float precio;
    private  int stock;

    public Product(){
        this.cod = this.creatCod();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", stock=" + stock + '\n';
    }

    private String creatCod(){
        Random aleatorio = new Random();

        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";

        String cadena="";

        int numero=(int)(aleatorio.nextDouble() * 99+100);

        int forma = (int)(aleatorio.nextDouble() * alfa.length()-1+0);

        return cadena+alfa.charAt(forma)+numero;

    }
}
