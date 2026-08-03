package main.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BiblioController {

    private final PrestamoService prestamoService;

    public BiblioController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/prestamos/prestar")
    public Material prestarMaterial(@RequestParam String codigo) {
        return prestamoService.prestar(codigo);
    }

    @PostMapping("/prestamos/devolver")
    public double devolverMaterial(@RequestBody DevolucionRequestDTO request) {
        
        Socio socio = request.getTipoSocio().equalsIgnoreCase("premium") 
                ? new SocioPremium(1, "Socio Premium") 
                : new SocioRegular(2, "Socio Regular");

        MultaStrategy estrategia;
        switch (request.getTipoMulta().toLowerCase()) {
            case "campania":
                estrategia = new MultaCampania();
                break;
            case "findesemana":
                estrategia = new MultaFinDeSemana();
                break;
            default:
                estrategia = new MultaNormal();
                break;
        }

        return prestamoService.devolver(request.getCodigo(), socio, request.getDiasAtraso(), estrategia);
    }

    @GetMapping("/materiales/disponibles")
    public List<Material> obtenerMaterialesDisponibles() {
        return prestamoService.listarDisponibles();
    }

    @PostMapping("/socios/depurar-duplicados")
    public List<String> depurarDnis(@RequestBody List<String> dnis) {
        return prestamoService.depurarDnis(dnis);
    }
}