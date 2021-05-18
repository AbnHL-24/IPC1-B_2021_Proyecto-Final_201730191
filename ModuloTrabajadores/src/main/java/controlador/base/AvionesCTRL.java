package controlador.base;

import datos.avion.AvionDAOImpl;
import modelo.base.Avion;
import vista.vistas.datos.avion.AvionGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionAvion.validarAvion;

public class AvionesCTRL implements ActionListener {
    private AvionGUI avionGUI;
    private AvionDAOImpl avionDAO = new AvionDAOImpl();

    public AvionesCTRL(AvionGUI avionGUI) {
        this.avionGUI = avionGUI;

        this.avionGUI.getBtnAgregar().addActionListener(this);
        this.avionGUI.getBtnActualizar().addActionListener(this);
        this.avionGUI.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        avionGUI.setSize(parent.getSize());
        avionGUI.setVisible(true);
        parent.add(avionGUI);
        parent.validate();
        avionGUI.limpiarCampos();
    }

    private void agregar() {
        String[] parametros = obtenerParametrosAvion();
        String erroresAvion = validarAvion(parametros);
        if ("".equals(erroresAvion)) {
            Avion avion = new Avion(parametros[0], parametros[1], parametros[2], Integer.parseInt(parametros[3]),
                    Integer.parseInt(parametros[4]), Integer.parseInt(parametros[5]));
            AvionDAOImpl avionDAO = new AvionDAOImpl();
            avionDAO.crear(avion);
        } else {
            JOptionPane.showMessageDialog(avionGUI, erroresAvion, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    private void actualizar() {

    }

    private void borrar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == avionGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == avionGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == avionGUI.getBtnBorrar()) {
            borrar();
        }
    }

    private String[] obtenerParametrosAvion() {
        String[] parametros = new String[6];
        parametros[0] = avionGUI.getTflNombreAerolinea().getText();
        parametros[1] = avionGUI.getTflNombreAeropuertoActual().getText();
        parametros[2] = avionGUI.getTflCodigoAvion().getText();
        parametros[3] = avionGUI.getTflCapacidadPasajeros().getText();
        parametros[4] = avionGUI.getTflCapacidadGasolina().getText();;
        parametros[5] = avionGUI.getTflConsumoPorMilla().getText();
        return parametros;
    }
}
