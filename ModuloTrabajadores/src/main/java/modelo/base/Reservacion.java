package modelo.base;

import modelo.tablas.Arrayable;

import java.io.Serializable;

/**
 * Registra un pasajero en un Vuelo, el pasajero ya tiene un boleto comprado.
 * @see Vuelo
 * @see Pasaporte
 * @see Tarjeta
 * @author abnerhl
 */
public class Reservacion implements Serializable, Arrayable {
    private long NO_Pasaporte;
    private int codigoVuelo;
    private long NO_Tarjeta;
    private int NO_Asiento;

    /**
     * Construye una reservacion con los siguientes parametros.
     * @param NO_Pasaporte Es el numero del pasaporte del pasajero.
     * @param codigoVuelo Es el codigo del Vuelo al que se hará la reservacion.
     * @param NO_Tarjeta Es el numero de la tarjeta del pasajero.
     * @param NO_Asiento Es el numero de asiento que ocupara el pasajero.
     */
    public Reservacion(long NO_Pasaporte, int codigoVuelo, long NO_Tarjeta, int NO_Asiento) {
        this.NO_Pasaporte = NO_Pasaporte;
        this.codigoVuelo = codigoVuelo;
        this.NO_Tarjeta = NO_Tarjeta;
        this.NO_Asiento = NO_Asiento;
    }

    public long getNO_Pasaporte() {
        return NO_Pasaporte;
    }

    public void setNO_Pasaporte(long NO_Pasaporte) {
        this.NO_Pasaporte = NO_Pasaporte;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public long getNO_Tarjeta() {
        return NO_Tarjeta;
    }

    public void setNO_Tarjeta(long NO_Tarjeta) {
        this.NO_Tarjeta = NO_Tarjeta;
    }

    public int getNO_Asiento() {
        return NO_Asiento;
    }

    public void setNO_Asiento(int NO_Asiento) {
        this.NO_Asiento = NO_Asiento;
    }

    @Override
    public String[] toArray() {
        return new String[] {String.valueOf(NO_Pasaporte), String.valueOf(codigoVuelo), String.valueOf(NO_Tarjeta),
                String.valueOf(NO_Asiento)};
    }
}
