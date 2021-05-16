import controlador.archivos.CargarDatosDesdeArchivo;

/**
 * Clase principal desde donde se inicia la aplicacion.
 * @author abnerhl
 */
public class Main {

    /**
     * Metodo donde empeiza la ejecucion del programa.
     * @param args arreglo de argumentos de la consola.
     */
    public static void main(String[] args) {
        String path = "src/main/resources/cargaObjetos.txt";
        System.out.println("Hola mundo");
        CargarDatosDesdeArchivo.obtenerDatos(path);
    }
}
