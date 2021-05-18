package modelo.trabajadores;

public class Operador extends Usuario{
    String aeropuerto;

    public Operador(String nombreUsuario, String contrasenya, String aeropuerto) {
        super(nombreUsuario, contrasenya);
        this.aeropuerto = aeropuerto;
    }

    @Override
    public String[] toArray() {
        return new String[] {nombreUsuario, aeropuerto};
    }
}
