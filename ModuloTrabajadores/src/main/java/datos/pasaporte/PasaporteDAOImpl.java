package datos.pasaporte;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;
import modelo.base.Pasaporte;

import static controlador.archivos.ManejarArchivo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la interfaz PasaporteDAO
 * @see PasaporteDAO
 * @author abnerhl
 */
public class PasaporteDAOImpl implements PasaporteDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_PASAPORTE = HOME_USUARIO + "/datos/pasaportes/";
    private final String EXTENSION_PASAPORTE = ".pst";
    ManejarArchivoBinario<Pasaporte> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Pasaporte pasaporte) {
        crearDirectorio(PATH_PASAPORTE);
        String noPasaporte = String.valueOf(pasaporte.getNoPasaporte());
        manejarArchivoBinario.crearArchivoBinario(PATH_PASAPORTE + noPasaporte + EXTENSION_PASAPORTE, pasaporte);
    }

    @Override
    public Pasaporte obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_PASAPORTE)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_PASAPORTE + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_PASAPORTE + id + EXTENSION_PASAPORTE);
        }
    }

    @Override
    public void actualizar(Pasaporte pasaporte) {
        String noPasaporte = String.valueOf(pasaporte.getNoPasaporte());
        borrar(noPasaporte);
        manejarArchivoBinario.crearArchivoBinario(PATH_PASAPORTE + noPasaporte + EXTENSION_PASAPORTE, pasaporte);
    }

    @Override
    public void borrar(String id) {
        borrarArchivo(PATH_PASAPORTE + id + EXTENSION_PASAPORTE);
    }

    @Override
    public List<Pasaporte> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_PASAPORTE);
        List<Pasaporte> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_PASAPORTE + id + EXTENSION_PASAPORTE);
    }
}
