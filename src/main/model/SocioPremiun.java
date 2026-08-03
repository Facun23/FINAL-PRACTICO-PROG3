package main.model;

public class SocioPremiun extends Socio {
    public SocioPremiun(int id, String nombre){
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto){
        return monto * 0.5;
    }

}
