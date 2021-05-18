package modelo.base;

import modelo.tablas.Arrayable;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Asigna una nueva fecha de vencimineto para el pasaporte inddicado.
 * @see Pasaporte
 * @author abnerhl
 */
public class RenovacionPasaporte implements Serializable, Arrayable {
    long NO_Pasaporte;
    LocalDate fechaNuevoVencimiento;

    /**
     * Constructor que pide un numero de pasarpote y la fecha nueva.
     * @param NO_Pasaporte Numero unico del pasaporte.
     * @param fechaNuevoVencimiento Fecha nueva para el documento.
     */
    public RenovacionPasaporte(long NO_Pasaporte, LocalDate fechaNuevoVencimiento) {
        this.NO_Pasaporte = NO_Pasaporte;
        this.fechaNuevoVencimiento = fechaNuevoVencimiento;
    }

    public long getNO_Pasaporte() {
        return NO_Pasaporte;
    }

    public void setNO_Pasaporte(long NO_Pasaporte) {
        this.NO_Pasaporte = NO_Pasaporte;
    }

    public LocalDate getFechaNuevoVencimiento() {
        return fechaNuevoVencimiento;
    }

    public void setFechaNuevoVencimiento(LocalDate fechaNuevoVencimiento) {
        this.fechaNuevoVencimiento = fechaNuevoVencimiento;
    }

    @Override
    public String[] toArray() {
        return new String[] {String.valueOf(NO_Pasaporte), String.valueOf(fechaNuevoVencimiento)};
    }
}
