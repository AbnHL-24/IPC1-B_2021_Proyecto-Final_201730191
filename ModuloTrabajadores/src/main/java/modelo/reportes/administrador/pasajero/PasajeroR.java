package modelo.reportes.administrador.pasajero;

import modelo.tablas.Arrayable;

public class PasajeroR implements Arrayable {
    private String tipo;
    private String cantidad;

    public PasajeroR(String tipo, String cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String[] toArray() {
        return new String[] {tipo, cantidad};
    }
}
