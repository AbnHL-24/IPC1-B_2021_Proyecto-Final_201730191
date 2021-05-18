import controlador.archivos.CargarDatosDesdeArchivo;
import controlador.interfaz.AdministradorCTRL;
import modelo.trabajadores.Administrador;
import vista.ventanas.administrador.AdministradorGUI;
import vista.vistas.datos.avion.AvionGUI;

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
        CargarDatosDesdeArchivo cargarDatosDesdeArchivo = new CargarDatosDesdeArchivo();
        cargarDatosDesdeArchivo.cargarDatos(path);
        /* pruebas
        for (int i = 0; i < cargarDatosDesdeArchivo.obtenerResultados().size(); i++) {
            System.out.println(cargarDatosDesdeArchivo.obtenerResultados().get(i));
        }*/
        AdministradorGUI administradorGUI = new AdministradorGUI();
        AdministradorCTRL administradorCTRL = new AdministradorCTRL(administradorGUI);
        administradorCTRL.iniciar();

    }
}
