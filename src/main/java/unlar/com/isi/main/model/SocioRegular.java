package unlar.com.isi.main.model;

public class SocioRegular extends Socio{

    public SocioRegular(int id, String nombre){
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto){
        return monto;
    }

}
