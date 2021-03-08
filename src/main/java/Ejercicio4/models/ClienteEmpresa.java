package Ejercicio4.models;

public class ClienteEmpresa extends Cliente{
    private String cuit;
    private String condicionIVA;
    public ClienteEmpresa(){
    }

    public String getCuit() {
        return cuit;
    }

    public String getCondicionIVA() {
        return condicionIVA;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setCondicionIVA(String condicionIVA) {
        this.condicionIVA = condicionIVA;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + super.getName() + '\'' +
                ", lastname='" + super.getLastname() + '\'' +
                ", birth='" + super.getBirth() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", DNI='" + super.getDNI() + '\'' +
                "cuit='" + this.cuit + '\'' +
                ", condicionIVA='" + this.condicionIVA + '\'' +
                '}';
    }
}
