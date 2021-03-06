package datos.aerolinea;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aerolinea;
import modelo.base.Aeropuerto;

import java.util.ArrayList;
import java.util.List;

import static controlador.archivos.ManejarArchivo.*;

/**
 * Implementa la interfaz AerolineaDAO
 * @see AerolineaDAO
 * @author abnerhl
 */
public class AerolineaDAOImpl implements AerolineaDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_AEROLINEAS = HOME_USUARIO + "/datos/aerolineas/";
    private final String EXTENSION_AEROLINEA = ".ael";
    ManejarArchivoBinario<Aerolinea> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Aerolinea aerolinea) {
        crearDirectorio(PATH_AEROLINEAS);
        manejarArchivoBinario.crearArchivoBinario(PATH_AEROLINEAS + aerolinea.getIdentificadorAerolinea() + EXTENSION_AEROLINEA, aerolinea);
    }

    @Override
    public Aerolinea obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_AEROLINEA)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AEROLINEAS + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_AEROLINEAS + id + EXTENSION_AEROLINEA);
        }
    }

    @Override
    public void actualizar(Aerolinea aerolinea) {
        borrar(aerolinea.getIdentificadorAerolinea());
        manejarArchivoBinario.crearArchivoBinario(PATH_AEROLINEAS + aerolinea.getIdentificadorAerolinea() + EXTENSION_AEROLINEA, aerolinea);
    }

    @Override
    public void borrar(String id) {
        borrarArchivo(PATH_AEROLINEAS + id + EXTENSION_AEROLINEA);
    }

    @Override
    public List<Aerolinea> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_AEROLINEAS);
        List<Aerolinea> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_AEROLINEAS + id + EXTENSION_AEROLINEA);
    }
}
