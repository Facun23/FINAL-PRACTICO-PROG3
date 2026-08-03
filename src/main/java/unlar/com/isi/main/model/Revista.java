package unlar.com.isi.main.model;
import lombok.*;

@Data
@NoArgsConstructor

public class Revista extends Material {


    private int numeroEdicion;

    public Revista(int numeroEdicion, String codigo, String titulo, boolean disponible) {
        super(codigo, titulo, disponible);
        this.numeroEdicion = numeroEdicion;
    }
}



