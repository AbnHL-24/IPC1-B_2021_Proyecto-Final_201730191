package modelo.base;

import modelo.base.soporte.EstadoVuelo;

import java.time.LocalDate;

/**
 * Crea un Vuelo de un avion desde un aeropuerto origen hacia un aeropuerto destino.
 * @see Avion
 * @see Aeropuerto
 * @author abnerhl
 */
public class Vuelo {
    private EstadoVuelo estadoVuelo = EstadoVuelo.EN_ESPERA;
    private int codigoVuelo;
    private int codigoAvion;
    private String nombreAeropuertoOrigen;
    private String nombreAeropuertoDestino;
    private int precioBoleto;
    private LocalDate fechaSalida; //cambiar cuando se sepa utilizar LocalDate

    /**
     * Constructor que genera el Vuelo de un avion entre dos aeropuertos.
     * @param codigoVuelo Codigo unico del Vuelo.
     * @param codigoAvion Codigo unico de un avion previamente creado.
     * @param nombreAeropuertoOrigen Nombre del aeropuerto del que parte el avion.
     * @param nombreAeropuertoDestino Nombre del aeropuerto al que llega el avion.
     * @param precioBoleto Precio del boleto del Vuelo.
     * @param fechaSalida fecha en que se realizo el Vuelo.
     */
    public Vuelo(int codigoVuelo, int codigoAvion, String nombreAeropuertoOrigen, String nombreAeropuertoDestino, int precioBoleto, LocalDate fechaSalida) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAvion = codigoAvion;
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
        this.precioBoleto = precioBoleto;
        this.fechaSalida = fechaSalida;
    }

    public EstadoVuelo getEstadoVuelo() {
        return estadoVuelo;
    }

    public void setEstadoVuelo(EstadoVuelo estadoVuelo) {
        this.estadoVuelo = estadoVuelo;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(int codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public String getNombreAeropuertoOrigen() {
        return nombreAeropuertoOrigen;
    }

    public void setNombreAeropuertoOrigen(String nombreAeropuertoOrigen) {
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
    }

    public String getNombreAeropuertoDestino() {
        return nombreAeropuertoDestino;
    }

    public void setNombreAeropuertoDestino(String nombreAeropuertoDestino) {
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
    }

    public int getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(int precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
