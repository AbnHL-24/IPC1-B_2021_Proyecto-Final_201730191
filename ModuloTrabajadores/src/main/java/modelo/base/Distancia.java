package modelo.base;

/**
 * Clase que establece la distancia entre un aeropuerto origen y uno destino.
 * No se pueden realizar vuelos donde no halla una distancia entre el aeropuerto origen y el destino.
 * @see Aeropuerto
 * @see Vuelo
 * @author abnerhl
 */
public class Distancia {
    private String nombreAeropuertoOrigen;
    private String nombreAeropuertoDestino;
    private int cantidadMillas;
    private String identificador;

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
        this.identificador = nombreAeropuertoOrigen + "-" + nombreAeropuertoDestino;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
