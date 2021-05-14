package controlador.archivos;

import controlador.base.aeropuerto.ValidarDatosAeropuerto;
import modelo.base.Aeropuerto;

import java.util.ArrayList;

/**
 * Clase que se encarga de leer el archivo de datos del sistema anterior.
 * @author abnerhl
 */
public class CargarDatosDesdeArchivo {
    static String path = "src/main/resources/cargaObjetos.txt";

    public static void obtenerDatos() {
        ArrayList<String> datos = ManejarArchivo.leerArchivo(path);
        generarObjetos(datos);
    }

    private static void generarObjetos(ArrayList<String> datos) {
        for(String dato: datos) {
            String[] parametros = obtenerParametros(dato);
            if (dato.startsWith("AEROPUERTO")) {
                generarAeropuerto(parametros);
            } else if (dato.startsWith("AEROLINEA")) {
                generarAerolinea(parametros);
            } else if (dato.startsWith("AVION")) {
                generarAvion(parametros);
            } else if (dato.startsWith("DISTANCIA")) {
                generarDistancia(parametros);
            } else if (dato.startsWith("VUELO")) {
                generarVuelo(parametros);
            } else if (dato.startsWith("PASAPORTE")) {
                generarPasaporte(parametros);
            } else if (dato.startsWith("TARJETA")) {
                generarTarjeta(parametros);
            } else if (dato.startsWith("RENOVACION_PASAPORTE")) {
                generarRenovacionPAsaporte(parametros);
            } else if (dato.startsWith("RESERVACION")) {
                generarReservacion(parametros);
            } else {
                System.out.println("Error, la linea no continene nunguna coincidencia.");
            }
        }
    }

    private static void generarReservacion(String[] parametros) {
        //crear validaciones y objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarRenovacionPAsaporte(String[] parametros) {
        //crear validaciones y objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarTarjeta(String[] parametros) {
        //crear validaciones y objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarPasaporte(String[] parametros) {
        //crear validaciones y objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarVuelo(String[] parametros) {
        //crear validaciones y objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarDistancia(String[] parametros) {
        //Crear objeto

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarAvion(String[] parametros) {
        //Crear objeto mandando los parametros.

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarAerolinea(String[] parametros) {
        if (ValidarDatosAeropuerto.validar(parametros)) {
            //CrearAeroppuerto
        } else {
            System.out.println("Los datos estan erroneos.");
        }

        //prueba
        for (int i = 0; i < parametros.length; i++) {
            System.out.println(parametros[i]);
        }
        System.out.println();
        // fin de prueba
    }

    private static void generarAeropuerto(String[] parametros) {

        if (parametros.length == 3) {
            Aeropuerto aeropuerto = new Aeropuerto(parametros[0], parametros[1], parametros[2]);
        } else {
            System.out.println("Error en la cantidad de parametros");
        }
        System.out.println();
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
