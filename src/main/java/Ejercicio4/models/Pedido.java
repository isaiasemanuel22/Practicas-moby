package Ejercicio4.models;

public class Pedido implements JsonWrite {
    private String day;
    private String nameCliente;

    public Pedido (String day , String nameCliente){
        this.day = day;
        this.nameCliente = nameCliente;

    }

    @Override
    public String toString() {
        return "Pedido{" +
                "day='" + this.day + '\'' +
                ", nameCliente='" + this.nameCliente + '\'' +
                '}';
    }
    @Override
    public String writeJson(){
        return "\n{\n" +
                "day: " + this.day + '\n' +
                "nameCliente: " + this.nameCliente + '\n' +
                "}\n";
    }
}
