package datos.distancia;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Aeropuerto;
import modelo.base.Distancia;

import static controlador.archivos.ManejarArchivo.*;

import java.util.List;

public class DistanciaDAOImpl implements DistanciaDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_DISTANCIA = HOME_USUARIO + "/datos/distancias/";
    private final String EXTENSION_DISTANCIA = ".dtc";
    ManejarArchivoBinario<Distancia> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Distancia distancia) {
        crearDirectorio(PATH_DISTANCIA);
        manejarArchivoBinario.crearArchivoBinario(PATH_DISTANCIA + distancia.getIdentificador() + EXTENSION_DISTANCIA, distancia);
    }

    @Override
    public Distancia obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_DISTANCIA)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_DISTANCIA + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_DISTANCIA + id + EXTENSION_DISTANCIA);
        }
    }

    @Override
    public void actualizar(Distancia distancia) {

    }

    @Override
    public void borrar(String id) {

    }

    @Override
    public List<Distancia> obtenerList() {
        return null;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_DISTANCIA + id + EXTENSION_DISTANCIA);
    }
}
