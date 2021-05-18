package datos.renovacionpasaporte;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;
import modelo.base.RenovacionPasaporte;

import static controlador.archivos.ManejarArchivo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la interfaz RanovaconPAsaporteDAO
 * @see RenovacionPasaporteDAO
 * @author abnerhl
 */
public class RenovacionPasaporteDAOImpl implements RenovacionPasaporteDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_RENOVACIONPASAPORTE = HOME_USUARIO + "/datos/renovacionpasaporte/";
    private final String EXTENSION_RENOVACIONPASAPORTE = ".rpt";
    ManejarArchivoBinario<RenovacionPasaporte> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(RenovacionPasaporte renovacionPasaporte) {
        crearDirectorio(PATH_RENOVACIONPASAPORTE);
        String noPasaporte = String.valueOf(renovacionPasaporte.getNO_Pasaporte());
        manejarArchivoBinario.crearArchivoBinario(PATH_RENOVACIONPASAPORTE + noPasaporte + EXTENSION_RENOVACIONPASAPORTE,
                renovacionPasaporte);
    }

    @Override
    public RenovacionPasaporte obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_RENOVACIONPASAPORTE)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_RENOVACIONPASAPORTE + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_RENOVACIONPASAPORTE + id + EXTENSION_RENOVACIONPASAPORTE);
        }
    }

    @Override
    public void actualizar(RenovacionPasaporte renovacionPasaporte) {
        String noPasaporte = String.valueOf(renovacionPasaporte.getNO_Pasaporte());
        borrar(noPasaporte);
        manejarArchivoBinario.crearArchivoBinario(PATH_RENOVACIONPASAPORTE + noPasaporte + EXTENSION_RENOVACIONPASAPORTE,
                renovacionPasaporte);
    }

    @Override
    public void borrar(String id) {
        borrarArchivo(PATH_RENOVACIONPASAPORTE + id + EXTENSION_RENOVACIONPASAPORTE);
    }

    @Override
    public List<RenovacionPasaporte> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_RENOVACIONPASAPORTE);
        List<RenovacionPasaporte> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_RENOVACIONPASAPORTE + id + EXTENSION_RENOVACIONPASAPORTE);
    }
}
