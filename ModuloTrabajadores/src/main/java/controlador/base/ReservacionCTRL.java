package controlador.base;

import datos.reservacion.ReservacionDAOImpl;
import modelo.base.Reservacion;
import vista.vistas.datos.reservacion.ReservacionGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionReservacion.validarReservacion;

public class ReservacionCTRL implements ActionListener {
    private ReservacionGUI reservacionGUI;
    private ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();

    public ReservacionCTRL(ReservacionGUI reservacionGUI) {
        this.reservacionGUI = reservacionGUI;

        this.reservacionGUI.getBtnAgregar().addActionListener(this);
        this.reservacionGUI.getBtnActualizar().addActionListener(this);
        this.reservacionGUI.getBtnBorrar().addActionListener(this);
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
    }

    private void agregar() {
        String[] parametros = obtenerParametrosReservacion();
        String erroresReservacion= validarReservacion(parametros);
        if ("".equals(erroresReservacion)) {
            Reservacion reservacion = new Reservacion(Long.parseLong(parametros[0]), Integer.parseInt(parametros[1]),
                    Long.parseLong(parametros[2]), Integer.parseInt(parametros[3]));
            ReservacionDAOImpl reservacionDAO= new ReservacionDAOImpl();
            reservacionDAO.crear(reservacion);
        } else {
            JOptionPane.showMessageDialog(reservacionGUI, erroresReservacion, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {

    }

    private void borrar() {

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
