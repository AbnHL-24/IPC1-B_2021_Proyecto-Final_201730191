package datos.reservacion;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;
import modelo.base.Reservacion;

import java.util.List;

import static controlador.archivos.ManejarArchivo.crearDirectorio;
import static controlador.archivos.ManejarArchivo.verificarArchivo;

public class ReservacionDAOImpl implements ReservacionDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_RESERVACION = HOME_USUARIO + "/datos/reservaciones/";
    private final String EXTENSION_RESERVACION = ".rsc";
    ManejarArchivoBinario<Reservacion> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Reservacion reservacion) {
        crearDirectorio(PATH_RESERVACION);
        String id = String.valueOf(reservacion.getCodigoVuelo() + " + " +reservacion.getNO_Asiento());
        manejarArchivoBinario.crearArchivoBinario(PATH_RESERVACION + id + EXTENSION_RESERVACION, reservacion);
    }

    @Override
    public Reservacion obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_RESERVACION)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_RESERVACION + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_RESERVACION + id + EXTENSION_RESERVACION);
        }
    }

    @Override
    public void actualizar(Reservacion reservacion) {

    }

    @Override
    public void borrar(String id) {

    }

    @Override
    public List<Reservacion> obtenerList() {
        return null;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_RESERVACION + id + EXTENSION_RESERVACION);
    }
}
