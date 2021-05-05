package modelo.base;

/**
 * Crea una aerolinea, que contiene aviones y puede generar vuelos
 * @see Avion
 * @see Vuelo
 * @author abnerhl
 */
public class Aerolinea {
    private String nombreAeropuerto;
    private String nombreAerolinea;

    /**
     * Constructor de la clase Aerolinea.
     * @param nombreAeropuerto es el nombre del aeropuerto.
     * @param nombreAerolinea es el nombre de la aerlinea.
     */
    public Aerolinea(String nombreAeropuerto, String nombreAerolinea) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.nombreAerolinea = nombreAerolinea;
    }

    /**
     * Captador del nombre del aeropuerto.
     * @return retorna el nombre del aeropuerto.
     */
    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    /**
     * Definidor del nombre del aeropuerto.
     * @param nombreAeropuerto nombre a  definir del aeropuerto.
     */
    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    /**
     * Captador del nombre de la aerolinea.
     * @return retorna el nombre de la aerolinea.
     */
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    /**
     * Definidor del nombre de la aerolinea.
     * @param nombreAerolinea nombre a definir de la aerolinea.
     */
    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }
}
