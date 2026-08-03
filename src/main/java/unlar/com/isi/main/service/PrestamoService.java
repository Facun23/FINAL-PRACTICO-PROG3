package unlar.com.isi.main.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import unlar.com.isi.main.model.*;
import unlar.com.isi.main.model.multa.MultaStrategy;
import unlar.com.isi.main.repository.MaterialRepository;


@Service
public class PrestamoService {
    
    private final MaterialRepository materialRepository;

    public PrestamoService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

        //SERVICE PRESTAR
    public Material prestar(String codigo) {
        Material material = materialRepository.buscarPorCodigo(codigo);
        if (material != null && material.isDisponible()) {
            material.setDisponible(false);
            return material;
        }
        throw new RuntimeException("El material no existe o ya está prestado.");
    }
 
    //SERVICE DEVOLVER
    public double devolver(String codigo, Socio socio, int diasAtraso, MultaStrategy estrategia) {
        Material material = materialRepository.buscarPorCodigo(codigo);
        if (material != null) {
            material.setDisponible(true);
        }

        //aca aplicamos la estrategia de multa y el beneficio del socio
        double multaBase = estrategia.calcular(diasAtraso);
        return socio.aplicarBeneficio(multaBase);
    }

    public List<Material> listarDisponibles() {
        return materialRepository.obtenerDisponibles();
    }
    //ACA DEVOLVEMOS LOS DNIS UNICOS DE LA LISTA, EN UNA SOLA PASADA 
    public List<String> depurarDnis(List<String> dnisConDuplicados) {
        Set<String> dnisUnicos = new HashSet<>(dnisConDuplicados);
        return new ArrayList<>(dnisUnicos);
    }
}