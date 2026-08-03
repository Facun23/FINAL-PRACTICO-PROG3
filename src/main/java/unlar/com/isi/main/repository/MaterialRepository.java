package unlar.com.isi.main.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import unlar.com.isi.main.model.*;


@Repository
public class MaterialRepository {
    private List<Material> materiales = new ArrayList<>();

    public MaterialRepository() {
        //DATOS DE PRUEBA
        materiales.add(new Libro("L001", "El Señor de los Anillos", "J.R.R. Tolkien", true));
        materiales.add(new Revista(202, "R001", "National Geographic", true));
    }

    public Material buscarPorCodigo(String codigo) {
        return materiales.stream()
            .filter(m -> m.getCodigo().equals(codigo))
            .findFirst()
            .orElse(null);
    }

    public List<Material> obtenerDisponibles() {
        return materiales.stream()
            .filter(Material::isDisponible)
            .collect(Collectors.toList());
    }
}