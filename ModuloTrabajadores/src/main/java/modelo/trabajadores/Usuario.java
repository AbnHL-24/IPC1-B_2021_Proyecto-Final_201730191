package modelo.trabajadores;

public class Usuario {
    String nombreUsuario;
    String contrasenya;

    protected String getNombreUsuario() {
        return nombreUsuario;
    }

    protected void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    protected String getContrasenya() {
        return contrasenya;
    }

    protected void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
