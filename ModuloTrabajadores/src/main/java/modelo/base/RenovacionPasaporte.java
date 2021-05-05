package modelo.base;

/**
 * Asigna una nueva fecha de vencimineto para el pasaporte inddicado.
 * @see Pasaporte
 * @author abnerhl
 */
public class RenovacionPasaporte {
    long NO_Pasaporte;
    String fechaNuevoVencimiento; //cambiar para clase LocalDate

    /**
     * Constructor que pide un numero de pasarpote y la fecha nueva.
     * @param NO_Pasaporte Numero unico del pasaporte.
     * @param fechaNuevoVencimiento Fecha nueva para el documento.
     */
    public RenovacionPasaporte(long NO_Pasaporte, String fechaNuevoVencimiento) {
        this.NO_Pasaporte = NO_Pasaporte;
        this.fechaNuevoVencimiento = fechaNuevoVencimiento;
    }

    public long getNO_Pasaporte() {
        return NO_Pasaporte;
    }

    public void setNO_Pasaporte(long NO_Pasaporte) {
        this.NO_Pasaporte = NO_Pasaporte;
    }

    public String getFechaNuevoVencimiento() {
        return fechaNuevoVencimiento;
    }

    public void setFechaNuevoVencimiento(String fechaNuevoVencimiento) {
        this.fechaNuevoVencimiento = fechaNuevoVencimiento;
    }
}
