package main.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MaterialRepository {
    private List<Material> materiales = new ArrayList<>();

    public MaterialRepository() {
        //DATOS DE PRUEBA
        materiales.add(new Libro("L001", "El Señor de los Anillos", true, "J.R.R. Tolkien"));
        materiales.add(new Revista("R001", "National Geographic", true, 202));
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