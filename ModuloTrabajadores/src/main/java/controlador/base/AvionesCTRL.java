package controlador.base;

import datos.avion.AvionDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Avion;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.avion.AvionGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controlador.validaciones.ValidacionAvion.validarAvion;

public class AvionesCTRL extends MouseAdapter implements ActionListener {
    private AvionGUI avionGUI;
    private AvionDAOImpl avionDAO = new AvionDAOImpl();
    private final String[] TITULOS = {"nombreAerolinea", "nombreAeropuertoActual", "codigoAvion",  "capacidadPAsajeros",
            "capacidadGasolina", "consumoMilla"};
    private GeneradorTabla<Avion> generadorTabla;

    public AvionesCTRL(AvionGUI avionGUI) {
        this.avionGUI = avionGUI;

        avionGUI.getBtnAgregar().addActionListener(this);
        avionGUI.getBtnActualizar().addActionListener(this);
        avionGUI.getBtnBorrar().addActionListener(this);
        avionGUI.getTblDatosAviones().addMouseListener(this);

        this.generadorTabla = new GeneradorTabla(this.avionGUI.getTblDatosAviones(), TITULOS);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        avionGUI.setSize(parent.getSize());
        avionGUI.setVisible(true);
        parent.add(avionGUI);
        parent.validate();
        avionGUI.limpiarCampos();
        generadorTabla.generar(avionDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosAvion();
        String erroresAvion = validarAvion(parametros);
        if ("".equals(erroresAvion)) {
            Avion avion = new Avion(parametros[0], parametros[1], parametros[2], Integer.parseInt(parametros[3]),
                    Integer.parseInt(parametros[4]), Integer.parseInt(parametros[5]));
            AvionDAOImpl avionDAO = new AvionDAOImpl();
            avionDAO.crear(avion);
            generadorTabla.generar(avionDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(avionGUI, erroresAvion, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    private void actualizar() {
        generadorTabla.generar(avionDAO.obtenerList());
    }

    private void borrar() {
        String id = avionGUI.getTflCodigoAvion().getText();
        avionDAO.borrar(id);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = avionGUI.getTblDatosAviones().getSelectedRow();
        String nombreAerolinea = avionGUI.getTblDatosAviones().getValueAt(fila, 0).toString();
        avionGUI.getTflNombreAerolinea().setText(nombreAerolinea);
        String nombreAeropuertoActual = avionGUI.getTblDatosAviones().getValueAt(fila, 1).toString();
        avionGUI.getTflNombreAeropuertoActual().setText(nombreAeropuertoActual);
        String codigoAvion = avionGUI.getTblDatosAviones().getValueAt(fila, 2).toString();
        avionGUI.getTflCodigoAvion().setText(codigoAvion);
        String capacidadDePasajeros = avionGUI.getTblDatosAviones().getValueAt(fila, 3).toString();
        avionGUI.getTflCapacidadPasajeros().setText(capacidadDePasajeros);
        String capacidadGasolina = avionGUI.getTblDatosAviones().getValueAt(fila, 4).toString();
        avionGUI.getTflCapacidadGasolina().setText(capacidadGasolina);
        String consumoMilla = avionGUI.getTblDatosAviones().getValueAt(fila, 5).toString();
        avionGUI.getTflConsumoPorMilla().setText(consumoMilla);
    }
}
