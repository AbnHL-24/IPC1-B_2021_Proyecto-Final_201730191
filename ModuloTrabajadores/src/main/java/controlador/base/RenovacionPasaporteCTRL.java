package controlador.base;

import datos.renovacionpasaporte.RenovacionPasaporteDAOImpl;
import modelo.base.RenovacionPasaporte;
import vista.vistas.datos.renovacionpasaporte.RenovacionPasaporteGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static controlador.validaciones.ValidacionRanovacionPasaporte.validarRenovacionPasaporte;

public class RenovacionPasaporteCTRL implements ActionListener {
    private RenovacionPasaporteGUI renovacionPasaporteGUI;
    private RenovacionPasaporteDAOImpl renovacionPasaporteDAO = new RenovacionPasaporteDAOImpl();

    public RenovacionPasaporteCTRL(RenovacionPasaporteGUI renovacionPasaporteGUI) {
        this.renovacionPasaporteGUI = renovacionPasaporteGUI;

        this.renovacionPasaporteGUI.getBtnAgregar().addActionListener(this);
        this.renovacionPasaporteGUI.getBtnActualizar().addActionListener(this);
        this.renovacionPasaporteGUI.getBtnBorrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == renovacionPasaporteGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == renovacionPasaporteGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == renovacionPasaporteGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        renovacionPasaporteGUI.setSize(parent.getSize());
        renovacionPasaporteGUI.setVisible(true);
        parent.add(renovacionPasaporteGUI);
        parent.validate();
        renovacionPasaporteGUI.limpiarCampos();
    }

    private void agregar() {
        String[] parametros = obtenerParametrosRenovacionPasaporte();
        String erroresRenovacionPasaporte = validarRenovacionPasaporte(parametros);
        if ("".equals(erroresRenovacionPasaporte)) {
            RenovacionPasaporte renovacionPasaporte = new RenovacionPasaporte(Long.parseLong(parametros[0]),
                    LocalDate.parse(parametros[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            RenovacionPasaporteDAOImpl renovacionPasaporteDAO =  new RenovacionPasaporteDAOImpl();
            renovacionPasaporteDAO.crear(renovacionPasaporte);
        } else {
            JOptionPane.showMessageDialog(renovacionPasaporteGUI, erroresRenovacionPasaporte,
                    "Error en los datos ingresados", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {

    }

    private void borrar() {

    }

    private String[] obtenerParametrosRenovacionPasaporte() {
        String[] parametros = new String[2];
        parametros[0] = renovacionPasaporteGUI.getTflNoPasaporte().getText();
        parametros[1] = renovacionPasaporteGUI.getTflNuevaFechaVendimiento().getText();
        return parametros;
    }
}
