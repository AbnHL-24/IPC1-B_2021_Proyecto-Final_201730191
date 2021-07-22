package modelo.reportes.administrador.aerolinea;

import modelo.base.Pasaporte;
import modelo.tablas.Arrayable;

public class AerolineaRP implements Arrayable {
    String NoPasaporte;

    public AerolineaRP(Pasaporte pasaporte) {
        NoPasaporte = pasaporte.getNoPasaporte();
    }

    @Override
    public String[] toArray() {
        return new String[] {NoPasaporte};
    }
}
