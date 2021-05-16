/**
 * Paquete donde se encuentra amacenadas las clases base para el modulo de administracion.
 */
package modelo.base;

import java.io.Serializable;

/**
 * Crea un aeropuerto que contiene aviones, aerolineas, distancias entre un aeropuerto y otros, desde el se generan vuelos.
 * @see Aerolinea
 * @see Avion
 * @see Distancia
 * @see Vuelo
 * @author abnerhl
 */
public class Aeropuerto implements Serializable {
    private String nombreAeropuerto;
    private String ciudad;
    private String pais;

    /**
     * Constructor que solicita el nombre, la ciudad y el pais del aeropuerto.
     * @param nombreAeropuerto es el nombre que tendra el aeropuerto.
     * @param ciudad ciudad del aeropuerto.
     * @param pais pais del aeropuerto.
     */
    public Aeropuerto(String nombreAeropuerto, String ciudad, String pais) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.ciudad = ciudad;
        this.pais = pais;
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
     * @param nombreAeropuerto cadena que establecerá el nombre del aeropuerto.
     */
    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    /**
     * Captador de la ciudad del aeropuerto.
     * @return retorna la ciudad del aeropuerto.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Definidor de la ciudad del aeropuerto.
     * @param ciudad ciudad del aeropuerto.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Captador del pais del aeropuerto.
     * @return retorna el pais del aeropuerto.
     */
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
