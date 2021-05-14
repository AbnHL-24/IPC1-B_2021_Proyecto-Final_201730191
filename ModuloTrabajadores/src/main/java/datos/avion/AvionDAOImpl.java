package datos.avion;

import controlador.archivos.ManejarArchivoBinario;
import datos.aeropuerto.AeropuertoDAO;
import modelo.base.Aeropuerto;
import modelo.base.Avion;

import static controlador.archivos.ManejarArchivo.*;

import java.util.List;

/**
 * Implementa la interfaz AvionDAO.
 * @see AvionDAO
 * @author abnerhl
 */
public class AvionDAOImpl implements AvionDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_AVION = HOME_USUARIO + "/datos/aviones/";
    private final String EXTENSION_AVION = ".avn";
    ManejarArchivoBinario<Avion> manejarArchivoBinario = new ManejarArchivoBinario();


    @Override
    public void crear(Avion avion) {
        crearDirectorio(PATH_AVION);
        String codigoAvion = String.valueOf(avion.getCodigoAvion());
        manejarArchivoBinario.crearArchivoBinario(PATH_AVION + codigoAvion + EXTENSION_AVION, avion);
    }

    @Override
    public Avion obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_AVION)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AVION + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AVION + id + EXTENSION_AVION);
        }
    }

    @Override
    public void actualizar(Avion avion) {

    }

    @Override
    public void borrar(String id) {

    }

    @Override
    public List<Avion> obtenerList() {
        return null;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_AVION + id + EXTENSION_AVION);
    }
}
