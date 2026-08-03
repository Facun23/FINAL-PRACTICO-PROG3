package main.model.multa;

public class MultaFinDeSemana implements MultaStrategy {

    @Override
    public double calcular(int diasAtraso){
        return (diasAtraso * 100.0) + 200.0;
    }

}
