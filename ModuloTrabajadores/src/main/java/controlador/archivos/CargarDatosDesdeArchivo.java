package controlador.archivos;

import java.util.ArrayList;

import static controlador.archivos.ManejarArchivo.*;

/**
 * Clase que se encarga de leer el archivo de datos del sistema anterior.
 * @author abnerhl
 */
public class CargarDatosDesdeArchivo {
    //static String path = "src/main/resources/cargaObjetos.txt";
    GenerarObjetos generarObjetos = new GenerarObjetos();

    /**
     * Carga los datos de un archivo .txt
     * @param path ruta del archivo del cualse vana a cargar los datos.
     */
    public void cargarDatos(String path) {
        ArrayList<String> datos = leerArchivo(path);

        for (int i = 0; i < datos.size(); i++) {
            int indice = i + 1;
            //Retorna un arreglo de argumentos
            String[] parametros = obtenerParametros(datos.get(i));

            if (datos.get(i).startsWith("AEROPUERTO")) {
                generarObjetos.generarAeropuerto(parametros, indice);
            } else if (datos.get(i).startsWith("AEROLINEA") | datos.get(i).startsWith("AEROLÍNEA")) {
                generarObjetos.generarAerolinea(parametros, indice);
            } else if (datos.get(i).startsWith("AVION")) {
                generarObjetos.generarAvion(parametros, indice);
            } else if (datos.get(i).startsWith("DISTANCIA")) {
                generarObjetos.generarDistancia(parametros, indice);
            } else if (datos.get(i).startsWith("VUELO")) {
                generarObjetos.generarVuelo(parametros, indice);
            } else if (datos.get(i).startsWith("PASAPORTE")) {
                generarObjetos.generarPasaporte(parametros, indice);
            } else if (datos.get(i).startsWith("TARJETA")) {
                generarObjetos.generarTarjeta(parametros, indice);
            } else if (datos.get(i).startsWith("RENOVACION_PASAPORTE")) {
                generarObjetos.generarRenovacionPasaporte(parametros, indice);
            } else if (datos.get(i).startsWith("RESERVACION")) {
                generarObjetos.generarReservacion(parametros, indice);
            } else {
                generarObjetos.errorCoincidenciaNula(indice);
            }
        agregarAUnArchivoTXT("src/main/resources/resultadoCargaObjetos.txt",generarObjetos.getResutadosDeCargaDeDatos().get(i));
        }

    }

    /**
     * Este metodo obtiene la cadena 'dato' para separarla en los parametros del objeto a crear.
     * La cadena 'dato' es obtenida de la lectura de archivos.
     * Rompe en un arreglo lo que esta dentro de parentesis y separado por comas.
     * Los parametros seran usados para crear el objeto en cuestion correspondiente.
     * @param dato Cadena que contiene los parametros en una sola linea de texto.
     * @return Retorna los parametros en forma de arreglo de tipo String, lista para usar en la creacion de un objeto.
     */
    private String[] obtenerParametros(String dato) {
        // A indiceAbrirParentesis le sumamos uno porque el metodo substring incluye al primer indice.
        int indiceAbrirParentesis = dato.indexOf("(") +1;
        // A indiceAbrirParentesis no le sumamos uno porque el metodo substring excluye al segundo indice.
        int indiceCerrarParentesis = dato.indexOf(")");
        String datos = dato.substring(indiceAbrirParentesis, indiceCerrarParentesis);
        String[] parametros = datos.split(",");
        return parametros;
    }

    public ArrayList<String> obtenerResultados() {
        return generarObjetos.getResutadosDeCargaDeDatos();
    }
}
