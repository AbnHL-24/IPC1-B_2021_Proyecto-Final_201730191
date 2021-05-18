package datos.usuario;

import controlador.archivos.ManejarArchivoBinario;
import modelo.base.Tarjeta;
import modelo.trabajadores.Usuario;

import java.util.ArrayList;
import java.util.List;

import static controlador.archivos.ManejarArchivo.*;

public class UsuarioDAOImpl implements UsuarioDAO{
    private final String HOME_USUARIO = System.getProperty("user.home");
    private final String PATH_USUARIO = HOME_USUARIO + "/datos/usuarios/";
    private final String EXTENSION_USUARIO = ".usr";
    ManejarArchivoBinario<Usuario> manejarArchivoBinario = new ManejarArchivoBinario();

    @Override
    public void crear(Usuario usuario) {
        crearDirectorio(PATH_USUARIO);
        manejarArchivoBinario.crearArchivoBinario(PATH_USUARIO + usuario.getNombreUsuario() + EXTENSION_USUARIO,
                usuario);
    }

    @Override
    public Usuario obtenerObjecto(String id) {
        if (id.endsWith(EXTENSION_USUARIO)) {
            return manejarArchivoBinario.leerArchivoBinario(PATH_USUARIO + id);
        } else {
            return manejarArchivoBinario.leerArchivoBinario(PATH_USUARIO + id + EXTENSION_USUARIO);
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        borrar(usuario.getNombreUsuario());
        manejarArchivoBinario.crearArchivoBinario(PATH_USUARIO + usuario.getNombreUsuario() + EXTENSION_USUARIO,
                usuario);
    }

    @Override
    public void borrar(String id) {
        borrarArchivo(PATH_USUARIO + id + EXTENSION_USUARIO);
    }

    @Override
    public List<Usuario> obtenerList() {
        List<String> fileNames = obtenerNombresArchivos(PATH_USUARIO);
        List<Usuario> users = new ArrayList();

        fileNames.forEach(user -> users.add(obtenerObjecto(user)));

        return users;
    }

    @Override
    public boolean existe(String id) {
        return verificarArchivo(PATH_USUARIO + id + EXTENSION_USUARIO);
    }
}
