package controlador.reportes.administrador;

import datos.reservacion.ReservacionDAOImpl;
import datos.vuelo.VueloDAO;
import datos.vuelo.VueloDAOImpl;
import modelo.base.Vuelo;
import modelo.reportes.administrador.vuelo.ReporteVuelo;
import modelo.reportes.administrador.vuelo.VueloR;
import modelo.tablas.GeneradorTabla;
import vista.informes.administrador.vuelo.VueloRGUI;
import vista.vistas.datos.vuelo.VueloGUI;

import javax.swing.*;
import java.util.List;

/**
 * Controlador para los reportes por vuelo para un administrador.
 * @author abnerhl
 */
public class VueloRCTRL {
    private VueloRGUI vueloRGUI;
    private VueloDAOImpl vueloDAO = new VueloDAOImpl();
    private ReporteVuelo reporteVuelo = new ReporteVuelo();
    private final String[] TITULOS = {"Pasajeros"};
    private GeneradorTabla<VueloR> generadorTabla;

    public VueloRCTRL(VueloRGUI vueloRGUI) {
        this.vueloRGUI = vueloRGUI;

        this.generadorTabla = new GeneradorTabla<>(this.vueloRGUI.getTblDatos(), TITULOS);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        vueloRGUI.setSize(parent.getSize());
        vueloRGUI.setVisible(true);
        parent.add(vueloRGUI);
        parent.validate();
        List<Vuelo> vuelos = vueloDAO.obtenerList();
        //vuelos.sort(null);
        for (Vuelo v : vuelos) {
            vueloRGUI.getCmbSeleccionarVuelo().addItem(v.getCodigoVuelo());
        }
    }

}
