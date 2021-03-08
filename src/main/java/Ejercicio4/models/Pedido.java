package Ejercicio4.models;

public class Pedido {
    private String day;
    private String nameCliente;

    public Pedido (String day , String nameCliente){
        this.day = day;
        this.nameCliente = nameCliente;

    }

    @Override
    public String toString() {
        return "Pedido{" +
                "day='" + day + '\'' +
                ", nameCliente='" + nameCliente + '\'' +
                '}';
    }
}
