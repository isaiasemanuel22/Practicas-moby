package Ejercicio4.models;

public class Cliente {
    private String name;
    private String lastname;
    private String birth;
    private String phoneNumber;
    private String DNI;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirth() {
        return birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth='" + birth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
