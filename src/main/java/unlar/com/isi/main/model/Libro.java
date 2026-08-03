package unlar.com.isi.main.model;

import lombok.*;

@Data
@NoArgsConstructor

public class Libro extends Material {

    private String autor;

    public Libro(String autor, String codigo, String titulo, boolean disponible) {
        super(codigo, titulo, disponible);
        this.autor = autor;
    }

}
   

