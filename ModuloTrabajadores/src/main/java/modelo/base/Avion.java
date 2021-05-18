package modelo.base;

import modelo.tablas.Arrayable;

import java.io.Serializable;

/**
 * Crea un avion que pertenece a una aerolinea, tiene un codigo unico y se encuentran en un aeropuerto.
 * @see Aerolinea
 * @see Aeropuerto
 * @author abnerhl
 */
public class Avion implements Serializable, Arrayable {
    private String nombreAerolinea;
    private String nombreAeropuertoActual;
    private String codigoAvion;
    private int capacidadPAsajeros;
    private int capacidadGasolina;
    private int consumoMilla;

    /**
     * Constructor de un avion.
     * @param nombreAerolinea Es el nombre de la aerolinea del avion.
     * @param nombreAeropuertoActual Es el nombre del aeropuerto donde se encuantra actualmente el avion.
     * @param codigoAvion Es el codigo unico del avion.
     * @param capacidadPAsajeros Es la capacidad maxima de pasajeros del avion.
     * @param capacidadGasolina Es la capacidad del tanque de combustible del avion.
     * @param consumoMilla Es el consumo de gasolina del avion por milla recorrida.
     */
    public Avion(String nombreAerolinea, String nombreAeropuertoActual, String codigoAvion, int capacidadPAsajeros,
                 int capacidadGasolina, int consumoMilla) {
        this.nombreAerolinea = nombreAerolinea;
        this.nombreAeropuertoActual = nombreAeropuertoActual;
        this.codigoAvion = codigoAvion;
        this.capacidadPAsajeros = capacidadPAsajeros;
        this.capacidadGasolina = capacidadGasolina;
        this.consumoMilla = consumoMilla;
    }

    /**
     * Captador del nombre de la aerolinea a la que pertenece el avion.
     * @return retorna el nombre de la aerolinea.
     */
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    /**
     * Definidor del nombre de la aerolinea a la que pertenece el avion.
     * @param nombreAerolinea nombre a definir para la aerolinea.
     */
    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    /**
     * Captador del nombre del aeropuerto donde se ubica actualmente el avion.
     * @return retorna el nombre del aeropuerto donde se encuentra el avion actualmente.
     */
    public String getNombreAeropuertoActual() {
        return nombreAeropuertoActual;
    }

    /**
     * Definidor del nombre del aeropuerto donde se encuantra el avion actualmente.
     * @param nombreAeropuertoActual nombre para definir el nombre del aeropuerto  donde se ubicara el avion.
     */
    public void setNombreAeropuertoActual(String nombreAeropuertoActual) {
        this.nombreAeropuertoActual = nombreAeropuertoActual;
    }

    /**
     * Captador del codigo unico del avion.
     * @return retorna el codico unico del avion.
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }

    /**
     * Definidor del codigo unico del avion.
     * @param codigoAvion codigo unico del avion.
     */
    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    /**
     * Captador de la capacidad de pasajeros que tiene el avion.
     * @return la capacidad de pasajeros del avion.
     */
    public int getCapacidadPAsajeros() {
        return capacidadPAsajeros;
    }

    /**
     * Definidor de la capacidad de pasajeros del avion.
     * @param capacidadPAsajeros define la capacidad de pasajeros del avion.
     */
    public void setCapacidadPAsajeros(int capacidadPAsajeros) {
        this.capacidadPAsajeros = capacidadPAsajeros;
    }

    /**
     * Captador de la capacidad del tanque de gasolina del avion.
     * @return la capacidad de gasolina del avion.
     */
    public int getCapacidadGasolina() {
        return capacidadGasolina;
    }

    /**
     * Definidor de la capacidad del tanque de gasolina del avion.
     * @param capacidadGasolina define la capacidad del tanque de gasolina del avion.
     */
    public void setCapacidadGasolina(int capacidadGasolina) {
        this.capacidadGasolina = capacidadGasolina;
    }

    /**
     * Captador de la tasa de consumo de gasolina por milla del avion.
     * @return retorna la tasa del consumo de gaolina del avion
     */
    public int getConsumoMilla() {
        return consumoMilla;
    }

    /**
     * Definidor de la tasa de consumo de la casolina por milla del avion.
     * @param consumoMilla tasa de consumo de gaolina dela vion.
     */
    public void setConsumoMilla(int consumoMilla) {
        this.consumoMilla = consumoMilla;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreAerolinea, nombreAeropuertoActual, codigoAvion,  String.valueOf(capacidadPAsajeros),
        String.valueOf(capacidadGasolina), String.valueOf(consumoMilla)};
    }
}
