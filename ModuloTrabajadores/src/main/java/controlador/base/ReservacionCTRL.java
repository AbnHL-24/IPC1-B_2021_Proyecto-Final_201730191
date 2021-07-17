package controlador.base;

import datos.reservacion.ReservacionDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Reservacion;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.reservacion.ReservacionGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionReservacion.validarReservacion;

public class ReservacionCTRL implements ActionListener {
    private ReservacionGUI reservacionGUI;
    private ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();
    private final String[] TITULOS = {"NO_Pasaporte", "codigoVuelo", "NO_Tarjeta",
            "NO_Asiento"};
    private GeneradorTabla<Reservacion> generadorTabla;

    public ReservacionCTRL(ReservacionGUI reservacionGUI) {
        this.reservacionGUI = reservacionGUI;

        this.reservacionGUI.getBtnAgregar().addActionListener(this);
        this.reservacionGUI.getBtnActualizar().addActionListener(this);
        this.reservacionGUI.getBtnBorrar().addActionListener(this);

        this.generadorTabla = new GeneradorTabla<>(this.reservacionGUI.getjTable1(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reservacionGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == reservacionGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == reservacionGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        reservacionGUI.setSize(parent.getSize());
        reservacionGUI.setVisible(true);
        parent.add(reservacionGUI);
        parent.validate();
        reservacionGUI.limpiarCampos();
        generadorTabla.generar(reservacionDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosReservacion();
        String erroresReservacion= validarReservacion(parametros);
        if ("".equals(erroresReservacion)) {
            Reservacion reservacion = new Reservacion(parametros[0], parametros[1],
                    Long.parseLong(parametros[2]), Integer.parseInt(parametros[3]));
            ReservacionDAOImpl reservacionDAO= new ReservacionDAOImpl();
            reservacionDAO.crear(reservacion);
            generadorTabla.generar(reservacionDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(reservacionGUI, erroresReservacion, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        generadorTabla.generar(reservacionDAO.obtenerList());
    }

    private void borrar() {
        String id = reservacionGUI.getTflCodigoVuelo().getText() + "-" + reservacionGUI.getTflNoAsiento().getText();
        reservacionDAO.borrar(id);
    }


    private String[] obtenerParametrosReservacion() {
        String[] parametros = new String[4];
        parametros[0] = reservacionGUI.getTflNoPasaporte().getText();
        parametros[1] = reservacionGUI.getTflCodigoVuelo().getText();
        parametros[2] = reservacionGUI.getTflNoTarjeta().getText();
        parametros[3] = reservacionGUI.getTflNoAsiento().getText();
        return parametros;
    }
}
