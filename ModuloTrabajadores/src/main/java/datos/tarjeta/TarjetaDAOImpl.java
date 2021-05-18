package datos.tarjeta;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;
import modelo.base.Tarjeta;

import static controlador.archivos.ManejarArchivo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la interfaz TarjetaDAO
 * @see TarjetaDAO
 * @author abnerhl
 */
public class TarjetaDAOImpl implements TarjetaDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_TARJETA = HOME_USUARIO + "/datos/tarjetas/";
    private final String EXTENSION_TARJETA = ".tjt";
    ManejarArchivoBinario<Tarjeta> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Tarjeta tarjeta) {
        crearDirectorio(PATH_TARJETA);
        String noTarjeta = String.valueOf(tarjeta.getNo_Tarjeta());
        manejarArchivoBinario.crearArchivoBinario(PATH_TARJETA + noTarjeta + EXTENSION_TARJETA, tarjeta);
    }

    @Override
    public Tarjeta obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_TARJETA)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_TARJETA + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_TARJETA + id + EXTENSION_TARJETA);
        }
    }

    @Override
    public void actualizar(Tarjeta tarjeta) {
        String noTarjeta = String.valueOf(tarjeta.getNo_Tarjeta());
        borrar(noTarjeta);
        manejarArchivoBinario.crearArchivoBinario(PATH_TARJETA + noTarjeta + EXTENSION_TARJETA, tarjeta);
    }

    @Override
    public void borrar(String id) {
        borrarArchivo(PATH_TARJETA + id + EXTENSION_TARJETA);
    }

    @Override
    public List<Tarjeta> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_TARJETA);
        List<Tarjeta> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_TARJETA + id + EXTENSION_TARJETA);
    }
}
