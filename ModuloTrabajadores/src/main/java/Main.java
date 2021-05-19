import controlador.archivos.CargarDatosDesdeArchivo;
import controlador.interfaz.AdministradorCTRL;
import controlador.interfaz.BienvenidaCTRL;
import datos.usuario.UsuarioDAOImpl;
import modelo.trabajadores.Administrador;
import vista.inicio.BienvenidaGUI;
import vista.ventanas.administrador.AdministradorGUI;
import vista.vistas.datos.avion.AvionGUI;

import java.io.File;

import static controlador.archivos.ManejarArchivo.borrarDirectorio;

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
        borrarDirectorio(new File("/home/abnerhl/datos/"));
        String path = "src/main/resources/cargaObjetos.txt";
        CargarDatosDesdeArchivo cargarDatosDesdeArchivo = new CargarDatosDesdeArchivo();
        cargarDatosDesdeArchivo.cargarDatos(path);
        /* pruebas
        for (int i = 0; i < cargarDatosDesdeArchivo.obtenerResultados().size(); i++) {
            System.out.println(cargarDatosDesdeArchivo.obtenerResultados().get(i));
        }
        AdministradorGUI administradorGUI = new AdministradorGUI();
        AdministradorCTRL administradorCTRL = new AdministradorCTRL(administradorGUI);
        administradorCTRL.iniciar();

        */

        Administrador admin = new Administrador("admin", "admin");
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        usuarioDAO.crear(admin);
        BienvenidaGUI bienvenidaGUI = new BienvenidaGUI();
        BienvenidaCTRL bienvenidaCTRL = new BienvenidaCTRL(bienvenidaGUI);
        bienvenidaCTRL.iniciar();
    }
}
