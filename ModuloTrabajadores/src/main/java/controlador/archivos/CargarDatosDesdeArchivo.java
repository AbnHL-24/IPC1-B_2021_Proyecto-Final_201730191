package controlador.archivos;

import java.util.ArrayList;

import static controlador.archivos.GenerarObjetos.*;

/**
 * Clase que se encarga de leer el archivo de datos del sistema anterior.
 * @author abnerhl
 */
public class CargarDatosDesdeArchivo {
    //static String path = "src/main/resources/cargaObjetos.txt";

    public static void obtenerDatos(String path) {
        ArrayList<String> datos = ManejarArchivo.leerArchivo(path);
        generarObjetos(datos);
    }

    private static void generarObjetos(ArrayList<String> datos) {
        for (int i = 0; i < datos.size(); i++) {
            int indice = i + 1;
            String[] parametros = obtenerParametros(datos.get(i));

            if (datos.get(i).startsWith("AEROPUERTO")) {
                generarAeropuerto(parametros, indice);
            } else if (datos.get(i).startsWith("AEROLINEA")) {
                generarAerolinea(parametros, indice);
            } else if (datos.get(i).startsWith("AVION")) {
                generarAvion(parametros, indice);
            } else if (datos.get(i).startsWith("DISTANCIA")) {
                generarDistancia(parametros, indice);
            } else if (datos.get(i).startsWith("VUELO")) {
                generarVuelo(parametros, indice);
            } else if (datos.get(i).startsWith("PASAPORTE")) {
                generarPasaporte(parametros, indice);
            } else if (datos.get(i).startsWith("TARJETA")) {
                generarTarjeta(parametros, indice);
            } else if (datos.get(i).startsWith("RENOVACION_PASAPORTE")) {
                generarRenovacionPasaporte(parametros, indice);
            } else if (datos.get(i).startsWith("RESERVACION")) {
                generarReservacion(parametros, indice);
            } else {
                errorCoincidenciaNula(indice);
            }
        }
    }



    /**
     * Este metodo obtiene la cadena 'dato' para separarla en los parametros del objeto a crear.
     * La cadena 'dato' es obtenida de la lectura de archivos.
     * Los parametros seran usados para crear el objeto en cuestion correspondiente.
     * @param dato Cadena que contiene los parametros en una sola linea de texto.
     * @return Retorna los parametros en forma de arreglo de tipo String, lista para usar en la creacion de un objeto.
     */
    private static String[] obtenerParametros(String dato) {
        // A indiceAbrirParentesis le sumamos uno porque el metodo substring incluye al primer indice.
        int indiceAbrirParentesis = dato.indexOf("(") +1;
        // A indiceAbrirParentesis no le sumamos uno porque el metodo substring excluye al segundo indice.
        int indiceCerrarParentesis = dato.indexOf(")");
        String datos = dato.substring(indiceAbrirParentesis, indiceCerrarParentesis);
        String[] parametros = datos.split(",");
        return parametros;
    }
}
