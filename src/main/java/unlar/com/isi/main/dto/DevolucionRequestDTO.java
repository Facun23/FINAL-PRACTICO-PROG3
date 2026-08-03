package unlar.com.isi.main.dto;

import lombok.Data;

@Data
public class DevolucionRequestDTO {
    private String codigo;
    private int diasAtraso;
    private String tipoSocio;
    private String tipoMulta;
}