package Ejercicio4.models;

public class ClienteEmpresa extends Cliente implements  JsonWrite{
    private String cuit;
    private String condicionIVA;

    public ClienteEmpresa(){
        super();
    }
    public ClienteEmpresa(String name , String lastname , String birth , String phonenumber ,String DNI ){
        super.setName(name);
        super.setLastname(lastname);
        super.setBirth(birth);
        super.setPhoneNumber(phonenumber);
        super.setDNI(DNI);
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
        return "Cliente{ \n" +
                "name: "+ super.getName() + '\n' +
                "lastname: " + super.getLastname() + '\n' +
                "birth: " + super.getBirth() + '\n' +
                "phoneNumber: " + super.getPhoneNumber() + '\n' +
                "DNI: " + super.getDNI() + '\n' +
                "CUIT: " + this.cuit + '\n'+
                "IVA: " + this.condicionIVA + '\n' +
                "}\n";
    }

    @Override
    public String writeJson(){
        return "\n{\n" +
                "name: "+ super.getName() + '\n' +
                "lastname: " + super.getLastname() + '\n' +
                "birth: " + super.getBirth() + '\n' +
                "phoneNumber: " + super.getPhoneNumber() + '\n' +
                "DNI: " + super.getDNI() + '\n' +
                "CUIT: " + this.cuit + '\n'+
                "IVA: " + this.condicionIVA + '\n' +
                "}\n";
    }
}
