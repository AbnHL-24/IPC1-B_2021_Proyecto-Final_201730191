package controlador.reportes;

import modelo.reportes.administrador.pasajero.PasajeroR;
import modelo.reportes.administrador.pasajero.ReportePasajero;
import modelo.tablas.GeneradorTabla;
import vista.informes.administrador.pasajero.PasajeroRGUI;

import javax.swing.*;

public class PasajeroRCTRL {
    private PasajeroRGUI pasajeroRGUI;
    ReportePasajero reportePasajero = new ReportePasajero();
    private final String[] TITULOS = {"Tipo de pasajero que mas viaja", "Cantidad"};
    private GeneradorTabla<PasajeroR> generadorTabla;

    public PasajeroRCTRL(PasajeroRGUI pasajeroRGUI) {
        this.pasajeroRGUI = pasajeroRGUI;

        this.generadorTabla = new GeneradorTabla<>(this.pasajeroRGUI.getTblDatos(), TITULOS);
    }
    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        pasajeroRGUI.setSize(parent.getSize());
        pasajeroRGUI.setVisible(true);
        parent.add(pasajeroRGUI);
        parent.validate();
        generadorTabla.generar(reportePasajero.obtenerPasajerosReporte());
    }
}