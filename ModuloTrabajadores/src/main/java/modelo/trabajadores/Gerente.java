package modelo.trabajadores;

public class Gerente extends Usuario{
    String aerolinea;

    public Gerente(String nombreUsuario, String contrasenya, String aerolinea) {
        super(nombreUsuario, contrasenya);
        this.aerolinea = aerolinea;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreUsuario, aerolinea};
    }
}
