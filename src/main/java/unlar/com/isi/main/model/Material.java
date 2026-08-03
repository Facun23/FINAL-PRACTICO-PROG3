package unlar.com.isi.main.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Material {
    private String codigo;
    private String titulo;
    private boolean disponible;

}
