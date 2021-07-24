import controlador.archivos.CargarDatosDesdeArchivo;
import controlador.interfaz.BienvenidaCTRL;
import datos.usuario.UsuarioDAOImpl;
import modelo.trabajadores.Administrador;
import vista.informes.administrador.aerolinea.AerolineaMasUsadaRGUI;
import vista.inicio.BienvenidaGUI;


import java.io.File;

import static controlador.archivos.ManejarArchivo.borrarArchivo;
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
        borrarArchivo("src/main/resources/resultadoCargaObjetos.txt");


        String path = "src/main/resources/cargaObjetos.txt";
        CargarDatosDesdeArchivo cargarDatosDesdeArchivo = new CargarDatosDesdeArchivo();
        cargarDatosDesdeArchivo.cargarDatos(path);

        AerolineaMasUsadaRGUI aerolineaMasUsadaRGUI = new AerolineaMasUsadaRGUI();
        String feha = aerolineaMasUsadaRGUI.getDtcFechaInicio().getDate().toString();
        System.out.println(feha);

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
