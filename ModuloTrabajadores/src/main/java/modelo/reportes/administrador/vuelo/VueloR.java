package modelo.reportes.administrador.vuelo;

import lombok.Getter;
import lombok.Setter;
import modelo.tablas.Arrayable;

@Getter
@Setter
public class VueloR implements Arrayable {
    private String pasajero;

    public VueloR(String pasajero) {
        this.pasajero = pasajero;
    }

    @Override
    public String[] toArray() {
        return new String[] {pasajero};
    }
}
