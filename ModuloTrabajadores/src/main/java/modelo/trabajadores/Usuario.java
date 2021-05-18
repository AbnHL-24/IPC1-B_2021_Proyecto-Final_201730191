package modelo.trabajadores;

import modelo.tablas.Arrayable;

import java.io.Serializable;

public class Usuario implements Serializable, Arrayable {
    protected String nombreUsuario;
    protected String contrasenya;

    public Usuario(String nombreUsuario, String contrasenya) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreUsuario};
    }
}
