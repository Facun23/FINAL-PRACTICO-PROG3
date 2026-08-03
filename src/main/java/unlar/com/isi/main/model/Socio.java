package unlar.com.isi.main.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Socio {

    private int id;
    private String nombre;

    public abstract double aplicarBeneficio(double monto);

}
