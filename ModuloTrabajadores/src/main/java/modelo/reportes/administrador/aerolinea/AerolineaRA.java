package modelo.reportes.administrador.aerolinea;

import lombok.Getter;
import lombok.Setter;
import modelo.base.Avion;
import modelo.tablas.Arrayable;

@Getter
@Setter
public class AerolineaRA implements Arrayable {
    String codigoAvion;

    public AerolineaRA(Avion avion) {
        this.codigoAvion = avion.getCodigoAvion();
    }

    @Override
    public String[] toArray() {
        return new String[] {codigoAvion};
    }
}
