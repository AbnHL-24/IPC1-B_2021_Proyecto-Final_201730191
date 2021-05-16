package modelo.base;

/**
 * Esta clase permite realizar la compra de vuelos. Se asocia a un pasajero.
 * @see Pasaporte
 * @author abnerhl
 */
public class Tarjeta {
    private long no_Tarjeta;
    private long no_Pasaporte;
    private int dineroActual;
    private int codigoCV;

    /**
     * Permite crear una tarjeta.
     * @param no_Tarjeta Numero unico de la tarjeta.
     * @param no_Pasaporte Numero de pasaporte del cliente al cual esta asociada la tarjeta.
     * @param dineroActual Es la cantidad de dinero que posee acrualmente el pasajero.
     * @param codigoCV Codigo seguro de Verificacion compuesto de 3 digitos.
     */
    public Tarjeta(long no_Tarjeta, long no_Pasaporte, int dineroActual, int codigoCV) {
        this.no_Tarjeta = no_Tarjeta;
        this.no_Pasaporte = no_Pasaporte;
        this.dineroActual = dineroActual;
        this.codigoCV = codigoCV;
    }

    public long getNo_Tarjeta() {
        return no_Tarjeta;
    }

    public void setNo_Tarjeta(long no_Tarjeta) {
        this.no_Tarjeta = no_Tarjeta;
    }

    public long getNo_Pasaporte() {
        return no_Pasaporte;
    }

    public void setNo_Pasaporte(long no_Pasaporte) {
        this.no_Pasaporte = no_Pasaporte;
    }

    public int getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(int dineroActual) {
        this.dineroActual = dineroActual;
    }

    public int getCodigoCV() {
        return codigoCV;
    }

    public void setCodigoCV(int codigoCV) {
        this.codigoCV = codigoCV;
    }
}
