package modelo.base;

import modelo.tablas.Arrayable;

import java.io.Serializable;

/**
 * Clase que establece la distancia entre un aeropuerto origen y uno destino.
 * No se pueden realizar vuelos donde no halla una distancia entre el aeropuerto origen y el destino.
 * @see Aeropuerto
 * @see Vuelo
 * @author abnerhl
 */
public class Distancia implements Serializable, Arrayable {
    private String nombreAeropuertoOrigen;
    private String nombreAeropuertoDestino;
    private int cantidadMillas;
    private String identificadorDistancia;

    /**
     * Constructor de la clase distancia.
     * @param nombreAeropuertoOrigen nombre del aeropuerto origen.
     * @param nombreAeropuertoDestino nombre del aeropuerto destino.
     * @param cantidadMillas cantidad de millas entre el aeropuerto origen y el aeropuerto destino.
     */
    public Distancia(String nombreAeropuertoOrigen, String nombreAeropuertoDestino, int cantidadMillas) {
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
        this.cantidadMillas = cantidadMillas;
        this.identificadorDistancia = nombreAeropuertoOrigen + "-" + nombreAeropuertoDestino;
    }

    /**
     * Captador del nombre del aeropuerto origen.
     * @return nombre del aeropuerto origen.
     */
    public String getNombreAeropuertoOrigen() {
        return nombreAeropuertoOrigen;
    }

    /**
     * Definidor del nombre del aeropuerto origen.
     * @param nombreAeropuertoOrigen define el nombre del aeropuerto origen.
     */
    public void setNombreAeropuertoOrigen(String nombreAeropuertoOrigen) {
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
    }

    /**
     * Captador del nombre del aeropuerto destino.
     * @return nombre del aeropuerto destino.
     */
    public String getNombreAeropuertoDestino() {
        return nombreAeropuertoDestino;
    }

    /**
     * Definidor del nombre del aeropuerto destino.
     * @param nombreAeropuertoDestino nombre del aeropuerto destino.
     */
    public void setNombreAeropuertoDestino(String nombreAeropuertoDestino) {
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
    }

    /**
     * Captador de las millas entre el aeropuerto origen y el aeropuerto destino.
     * @return Millas entre el aeropuerto origen y el aeropuerto destino.
     */
    public int getCantidadMillas() {
        return cantidadMillas;
    }

    /**
     * Definidor de la cantidad de millas entre el aeropuerto origen y el aeropuerto destino.
     * @param cantidadMillas cantidad de millas entre el aeropuerto origen y el aeropuerto destino.
     */
    public void setCantidadMillas(int cantidadMillas) {
        this.cantidadMillas = cantidadMillas;
    }

    public String getIdentificadorDistancia() {
        return identificadorDistancia;
    }

    public void setIdentificadorDistancia(String identificadorDistancia) {
        this.identificadorDistancia = identificadorDistancia;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreAeropuertoOrigen, nombreAeropuertoDestino, String.valueOf(cantidadMillas)};
    }
}
