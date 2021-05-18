package controlador.base;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Aeropuerto;
import vista.vistas.datos.aerolinea.AerolineaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionAerolinea.validarAerolinea;

public class AerolineaCTRL implements ActionListener {
    private AerolineaGUI aerolineaGUI;
    private AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();

    public AerolineaCTRL(AerolineaGUI aerolineaGUI) {
        this.aerolineaGUI = aerolineaGUI;
        aerolineaGUI.getBtnAgregar().addActionListener(this);
        aerolineaGUI.getBtnActualizar().addActionListener(this);
        aerolineaGUI.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        aerolineaGUI.setSize(parent.getSize());
        aerolineaGUI.setVisible(true);
        parent.add(aerolineaGUI);
        parent.validate();
        aerolineaGUI.limpiarCampos();
    }

    private void agregar() {
        String[] parametros = obtenerParametrosAerolinea();
        String erroresAerolinea = validarAerolinea(parametros);
        if ("".equals(erroresAerolinea)) {
            Aerolinea aerolinea = new Aerolinea(parametros[0], parametros[1]);
            AerolineaDAOImpl aerolineaDOA = new AerolineaDAOImpl();
            aerolineaDOA.crear(aerolinea);
        }  else {
            JOptionPane.showMessageDialog(aerolineaGUI, erroresAerolinea, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private String[] obtenerParametrosAerolinea() {
        String[] parametros = new String[2];
        parametros[0] = aerolineaGUI.getTflNombreAeropuerto().getText();
        parametros[1] = aerolineaGUI.getTflNombreAerolinea().getText();
        return parametros;
    }

    private void actualizar() {

    }

    private void borrar() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aerolineaGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == aerolineaGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == aerolineaGUI.getBtnBorrar()) {
            borrar();
        }
    }
}
