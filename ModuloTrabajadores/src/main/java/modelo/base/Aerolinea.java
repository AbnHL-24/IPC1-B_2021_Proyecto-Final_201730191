package modelo.base;

import lombok.*;
import modelo.tablas.Arrayable;

import java.io.Serializable;

/**
 * Crea una aerolinea, que contiene aviones y puede generar vuelos
 * @see Avion
 * @see Vuelo
 * @author abnerhl
 */
@Getter
@Setter
@NoArgsConstructor
//@Builder
public class Aerolinea implements Serializable, Arrayable {
    private String nombreAeropuerto;
    private String nombreAerolinea;
    private String identificadorAerolinea;

    /**
     * Constructor de la clase Aerolinea.
     * @param nombreAeropuerto es el nombre del aeropuerto.
     * @param nombreAerolinea es el nombre de la aerlinea.
     */
    public Aerolinea(String nombreAeropuerto, String nombreAerolinea) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.nombreAerolinea = nombreAerolinea;
        this.identificadorAerolinea = nombreAerolinea + "-" + nombreAeropuerto;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreAeropuerto, nombreAerolinea};
    }
}
