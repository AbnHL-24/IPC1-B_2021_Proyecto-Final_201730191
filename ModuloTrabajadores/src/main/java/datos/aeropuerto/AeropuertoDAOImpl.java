package datos.aeropuerto;
;
import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;

import static controlador.archivos.ManejarArchivo.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la interfaz AeorpuertoDAO.
 * @see AeropuertoDAO
 * @author abnerhl
 */
public class AeropuertoDAOImpl implements AeropuertoDAO {
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_AEROPUERTOS = HOME_USUARIO + "/datos/aeropuertos/";
    private final String EXTENSION_AEROPUERTO = ".aep";
    ManejarArchivoBinario<Aeropuerto> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Aeropuerto aeropuerto) {
        crearDirectorio(PATH_AEROPUERTOS);
        manejarArchivoBinario.crearArchivoBinario(PATH_AEROPUERTOS + aeropuerto.getNombreAeropuerto() + EXTENSION_AEROPUERTO, aeropuerto);
    }

    @Override
    public Aeropuerto obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_AEROPUERTO)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AEROPUERTOS + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AEROPUERTOS + id + EXTENSION_AEROPUERTO);
        }
    }

    @Override
    public void actualizar(Aeropuerto aeropuerto) {
        borrar(aeropuerto.getNombreAeropuerto());
        manejarArchivoBinario.crearArchivoBinario(PATH_AEROPUERTOS + aeropuerto.getNombreAeropuerto() + EXTENSION_AEROPUERTO, aeropuerto);
    }

    @Override
    public void borrar(String id) {
        //Queda pendiente si un archivo no fue borrado.
        borrarArchivo(PATH_AEROPUERTOS + id + EXTENSION_AEROPUERTO);
    }

    @Override
    public List<Aeropuerto> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_AEROPUERTOS);
        List<Aeropuerto> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_AEROPUERTOS + id + EXTENSION_AEROPUERTO);
    }
}
