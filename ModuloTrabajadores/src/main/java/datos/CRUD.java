package datos;

import java.util.List;

/**
 * Iterfaz GRUD que sirve par abstraer aquello que se hara con los objetos que se manejen en archivos.
 * @param <T> Tipo de objeto, especificado de fomrma genera.
 * @author abnerhl
 */
public interface CRUD<T> {
    void crear(T t);
    T obtenerObjecto(String id);
    void actualizar(T t);
    void borrar(String id);
    List<T> obtenerList();
    boolean existe(String id);
}
