package main.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    public final PrestamoService prestamoService;

    public BiblioController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/api/prestamos/prestar")
    public Material prestarMaterial(@RequestParam String codigo){
        return prestamoService.prestar(codigo);
    }
    @PostMapping("/api/prestamos/devolver")
    public double devolverMaterial(
        @RequestParam String codigo,
        @RequestParam int diasRetraso,
        @RequestParam String tipoSocio,
        @RequestParam String tipoMulta){

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
