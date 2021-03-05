package practicas.main.models;

public class MyCalculator {

    public long power(int a , int b)
    {
        long resultado;
        if( a < 0  || b < 0 ) {
            throw new RuntimeException("Los valores deben ser positivos");
        }
        else if( a == 0 || b == 0){
            throw new RuntimeException("Los valores no pueden valer 0");
        }
        return (long) pow(a , b);
    }

    private int pow(int a , int b){
        int resultado = a;
        if(b > 1 ){
           resultado = resultado * pow( a , b-1);
        }
        return resultado;
    }

}


