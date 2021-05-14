package datos.vuelo;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Vuelo;
import modelo.base.soporte.EstadoVuelo;

import static controlador.archivos.ManejarArchivo.*;

import java.util.List;

/**
 * Implementa la interfaz VUeloDAO.
 * @see VueloDAO
 * @author abnerhl
 */
public class VueloDAOImpl implements VueloDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_VUELO = HOME_USUARIO + "/datos/vuelos/";
    private final String EXTENSION_VUELO = ".aep";
    ManejarArchivoBinario<Vuelo> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Vuelo vuelo) {
        crearDirectorio(PATH_VUELO);
        String codigoVuelo = String.valueOf(vuelo.getCodigoVuelo());
        manejarArchivoBinario.crearArchivoBinario(PATH_VUELO + codigoVuelo + EXTENSION_VUELO, vuelo);

    }

    @Override
    public Vuelo obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_VUELO)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_VUELO + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_VUELO + id + EXTENSION_VUELO);
        }
    }

    @Override
    public void actualizar(Vuelo vuelo) {

    }

    @Override
    public void borrar(String id) {

    }

    @Override
    public List<Vuelo> obtenerList() {
        return null;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_VUELO + id + EXTENSION_VUELO);
    }
}
