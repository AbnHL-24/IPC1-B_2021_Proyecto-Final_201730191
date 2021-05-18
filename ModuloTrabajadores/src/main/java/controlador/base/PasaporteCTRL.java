package controlador.base;

import datos.pasaporte.PasaporteDAOImpl;
import modelo.base.Pasaporte;
import modelo.base.soporte.EstadoCivil;
import modelo.base.soporte.Sexo;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.pasaporte.PasaporteGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static controlador.validaciones.ValidacionPasaporte.validarPasaporte;

public class PasaporteCTRL implements ActionListener {
    private PasaporteGUI pasaporteGUI;
    private PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
    private final String[] TITULOS = {"noPasaporte", "contraseña", "fechaDeNacimiento", "nacionalidad",
            "estadoCivil", "nombre", "apellidos", "sexo", "fechaDeVencimiento",
            "fechaEmision", "paisActual", "millasRecorridas"};
    private GeneradorTabla<Pasaporte> generadorTabla;

    public PasaporteCTRL(PasaporteGUI pasaporteGUI) {
        this.pasaporteGUI = pasaporteGUI;

        this.pasaporteGUI.getBtnAgregar().addActionListener(this);
        this.pasaporteGUI.getBtnActualizar().addActionListener(this);
        this.pasaporteGUI.getBtnBorrar().addActionListener(this);

        this.generadorTabla = new GeneradorTabla<>(this.pasaporteGUI.getjTable1(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pasaporteGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == pasaporteGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == pasaporteGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        pasaporteGUI.setSize(parent.getSize());
        pasaporteGUI.setVisible(true);
        parent.add(pasaporteGUI);
        parent.validate();
        pasaporteGUI.limpiarCampos();
        generadorTabla.generar(pasaporteDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosPasaporte();
        String erroresPasaporte = validarPasaporte(parametros);
        if ("".equals(erroresPasaporte)) {
            Pasaporte pasaporte = new Pasaporte(parametros[0], parametros[1],
                    LocalDate.parse(parametros[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), parametros[3],
                    EstadoCivil.valueOf(parametros[4].toUpperCase()), parametros[5], parametros[6], Sexo.valueOf(parametros[7].toUpperCase()),
                    LocalDate.parse(parametros[8], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalDate.parse(parametros[9], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    parametros[10], Integer.parseInt(parametros[11]));
            PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
            pasaporteDAO.crear(pasaporte);
            generadorTabla.generar(pasaporteDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(pasaporteGUI, erroresPasaporte, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        generadorTabla.generar(pasaporteDAO.obtenerList());
    }

    private void borrar() {
        generadorTabla.generar(pasaporteDAO.obtenerList());
    }


    private String[] obtenerParametrosPasaporte() {
        String[] parametros = new String[12];
        parametros[0] = pasaporteGUI.getTflNoPasaporte().getText();
        parametros[1] = pasaporteGUI.getTflContrasenya().getText();
        parametros[2] = pasaporteGUI.getTflFechaNacimiento().getText();
        parametros[3] = pasaporteGUI.getTflNacionalidad().getText();
        parametros[4] = pasaporteGUI.getTflEstadoCivil().getText();
        parametros[5] = pasaporteGUI.getTflNombre().getText();
        parametros[6] = pasaporteGUI.getTflApellidos().getText();
        parametros[7] = pasaporteGUI.getTflSexo().getText();
        parametros[8] = pasaporteGUI.getTflFechaVencimiento().getText();
        parametros[9] = pasaporteGUI.getTflFechaEmision().getText();
        parametros[10] = pasaporteGUI.getTflPaisActual().getText();
        parametros[11] = pasaporteGUI.getTflMillasRecorridas().getText();
        return parametros;
    }
}
