package controlador.reportes.administrador;

import modelo.reportes.administrador.aerolinea.AerolineaRA;
import modelo.reportes.administrador.aerolinea.AerolineaRP;
import modelo.reportes.administrador.aerolinea.ReporteAerolinea;
import modelo.tablas.GeneradorTabla;
import vista.informes.administrador.aerolinea.AerolineaRGUI;

import javax.swing.*;

public class AerolineaRCTRLRuta {
    private AerolineaRGUI aerolineaRGUI;
    private ReporteAerolinea reporteAerolinea = new ReporteAerolinea();
    private final String[] TITULO_AVION = {"Aviones"};
    private final String[] TITULO_PASAJERO = {"Pasajeros"};
    private GeneradorTabla<AerolineaRA> generadorTablaA;
    private GeneradorTabla<AerolineaRP> generadorTablaP;

    public AerolineaRCTRLRuta(AerolineaRGUI aerolineaRGUI) {
        this.aerolineaRGUI = aerolineaRGUI;

        this.generadorTablaA = new GeneradorTabla<>(this.aerolineaRGUI.getTblDatosAviones(), TITULO_AVION );
        this.generadorTablaP = new GeneradorTabla<>(this.aerolineaRGUI.getTblDatosPasajeros(), TITULO_PASAJERO);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        aerolineaRGUI.setSize(parent.getSize());
        aerolineaRGUI.setVisible(true);
        parent.add(aerolineaRGUI);
        parent.validate();

        aerolineaRGUI.getLblRutaMasConcurrida().setText(reporteAerolinea.obtenerRuta());
        String canPasajers = String.valueOf(reporteAerolinea.obtenerCantidadPasajerosRuta());
        aerolineaRGUI.getLblCantidadPasajeros().setText(canPasajers);
        generadorTablaA.generar(reporteAerolinea.generarAerolineaRA());
        generadorTablaP.generar(reporteAerolinea.generarAerolineaRP());
    }

}
