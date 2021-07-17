package controlador.base;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Aeropuerto;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.aerolinea.AerolineaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controlador.validaciones.ValidacionAerolinea.validarAerolinea;

public class AerolineaCTRL extends MouseAdapter implements ActionListener {
    private AerolineaGUI aerolineaGUI;
    private AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();
    private final String[] TITULOS = {"nombreAeropuerto", "nombreAerolinea"};
    private GeneradorTabla<Aerolinea> generadorTabla;

    public AerolineaCTRL(AerolineaGUI aerolineaGUI) {
        this.aerolineaGUI = aerolineaGUI;
        aerolineaGUI.getBtnAgregar().addActionListener(this);
        aerolineaGUI.getBtnActualizar().addActionListener(this);
        aerolineaGUI.getBtnBorrar().addActionListener(this);
        aerolineaGUI.getTblDatosAerolineas().addMouseListener(this);

        this.generadorTabla = new GeneradorTabla(this.aerolineaGUI.getTblDatosAerolineas(), TITULOS);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        aerolineaGUI.setSize(parent.getSize());
        aerolineaGUI.setVisible(true);
        parent.add(aerolineaGUI);
        parent.validate();
        aerolineaGUI.limpiarCampos();
        generadorTabla.generar(aerolineaDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosAerolinea();
        String erroresAerolinea = validarAerolinea(parametros);
        if ("".equals(erroresAerolinea)) {
            Aerolinea aerolinea = new Aerolinea(parametros[0], parametros[1]);
            aerolineaDAO.crear(aerolinea);
            generadorTabla.generar(aerolineaDAO.obtenerList());
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
        generadorTabla.generar(aerolineaDAO.obtenerList());
    }

    private void borrar() {
        String id = aerolineaGUI.getTflNombreAerolinea().getText() + "-" + aerolineaGUI.getTflNombreAeropuerto().getText();
        aerolineaDAO.borrar(id);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = aerolineaGUI.getTblDatosAerolineas().getSelectedRow();
        String aerolinea = aerolineaGUI.getTblDatosAerolineas().getValueAt(fila, 1).toString();
        aerolineaGUI.getTflNombreAerolinea().setText(aerolinea);
        String aeropuerto = aerolineaGUI.getTblDatosAerolineas().getValueAt(fila, 0).toString();
        aerolineaGUI.getTflNombreAeropuerto().setText(aeropuerto);
    }
}