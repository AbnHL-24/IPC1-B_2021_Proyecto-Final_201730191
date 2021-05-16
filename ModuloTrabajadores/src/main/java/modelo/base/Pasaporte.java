package modelo.base;

/**
 * Paquete donde estan algunos complementos necesarios para algunas clases del paquete modelo.base
 */
import modelo.base.soporte.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Crea un pasaporte para un cliente.
 * Contiene un numero unci, una contraseña, fechas de nacimiento, emmision y caducidad del documento, y demas datos personales del cliente.
 * @author abnerhl
 */
public class Pasaporte implements Serializable {
    private String noPasaporte;
    private String contrasenya;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private EstadoCivil estadoCivil;
    private String nombre;
    private String apellidos;
    private Sexo sexo;
    private LocalDate fechaDeVencimiento;
    private LocalDate fechaEmision;
    private String paisActual;
    private int millasRecorridas;

    /**
     * Constructor para un pasaporte con los datos para la carga de archivos.
     * @param noPasaporte Numero unico del pasaporte, tiene 8 digitos.
     * @param contrasenya Texto plano, permite el login de los pasajeros.
     * @param fechaDeNacimiento Fecha de nacimineto del pasajero.
     * @param nacionalidad Nacionalidad del pasajero.
     * @param estadoCivil Estado civil del pasajero.
     * @param nombre Nombre del pasajero.
     * @param apellidos Apellidos del pasajero.
     * @param sexo Sexo del pasajero.
     * @param fechaDeVencimiento Fecha de vencimiento del documento.
     * @param fechaEmision Fecha en la que se emitio el documento.
     * @param paisActual Pais en el que se encuentra actualmente ell pasajero.
     * @param millasRecorridas Millas que ha recorrido el pasajero.
     */
    public Pasaporte(String noPasaporte, String contrasenya, LocalDate fechaDeNacimiento, String nacionalidad,
                     EstadoCivil estadoCivil, String nombre, String apellidos, Sexo sexo, LocalDate fechaDeVencimiento,
                     LocalDate fechaEmision, String paisActual, int millasRecorridas) {
        this.noPasaporte = noPasaporte;
        this.contrasenya = contrasenya;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.fechaEmision = fechaEmision;
        this.paisActual = paisActual;
        this.millasRecorridas = millasRecorridas;
    }

    /*Definidores y captadores respectivos
    */

    public String getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(String noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getPaisActual() {
        return paisActual;
    }

    public void setPaisActual(String paisActual) {
        this.paisActual = paisActual;
    }

    public int getMillasRecorridas() {
        return millasRecorridas;
    }

    public void setMillasRecorridas(int millasRecorridas) {
        this.millasRecorridas = millasRecorridas;
    }
}
