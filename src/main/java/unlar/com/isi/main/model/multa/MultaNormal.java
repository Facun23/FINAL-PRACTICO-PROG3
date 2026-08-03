package unlar.com.isi.main.model.multa;

public class MultaNormal implements MultaStrategy{

    @Override
    public double calcular(int diasAtraso){
        return diasAtraso * 100.0;
    }

}
