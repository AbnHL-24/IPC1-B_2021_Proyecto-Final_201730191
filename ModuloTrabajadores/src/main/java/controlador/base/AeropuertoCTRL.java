package controlador.base;

import controlador.validaciones.ValidacionAeropuerto;
import datos.aeropuerto.AeropuertoDAO;
import datos.aeropuerto.AeropuertoDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Aeropuerto;
import modelo.tablas.GeneradorTabla;
import vista.ventanas.administrador.AdministradorGUI;
import vista.vistas.datos.aeropuerto.AeropuertoGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controlador.validaciones.ValidacionAeropuerto.validarAeropuerto;

public class AeropuertoCTRL extends MouseAdapter implements ActionListener {
    private AeropuertoGUI aeropuertoGUI;
    private AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
    private final String[] TITULOS = {"nombreAeropuerto", "ciudad", "pais"};
    private GeneradorTabla<Aeropuerto> generadorTabla;

    public AeropuertoCTRL(AeropuertoGUI aeropuertoGUI) {
        this.aeropuertoGUI = aeropuertoGUI;

        this.aeropuertoGUI.getBtnAgregar().addActionListener(this);
        this.aeropuertoGUI.getBtnActualizar().addActionListener(this);
        this.aeropuertoGUI.getBtnBorrar().addActionListener(this);
        aeropuertoGUI.getTblDatosAeropuertos().addMouseListener(this);

        this.generadorTabla = new GeneradorTabla(this.aeropuertoGUI.getTblDatosAeropuertos(), TITULOS);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        aeropuertoGUI.setSize(parent.getSize());
        aeropuertoGUI.setVisible(true);
        parent.add(aeropuertoGUI);
        parent.validate();
        aeropuertoGUI.limpiarCampos();
        generadorTabla.generar(aeropuertoDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosAeropuerto();
        String erroresAeropuerto = validarAeropuerto(parametros);
        if ("".equals(erroresAeropuerto)) {
            Aeropuerto aeropuerto = new Aeropuerto(parametros[0], parametros[1], parametros[2]);
            AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
            aeropuertoDAO.crear(aeropuerto);
            generadorTabla.generar(aeropuertoDAO.obtenerList());
        }  else {
            JOptionPane.showMessageDialog(aeropuertoGUI, erroresAeropuerto, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private String[] obtenerParametrosAeropuerto() {
        String[] parametros = new String[3];
        parametros[0] = aeropuertoGUI.getTflNombreAeropuerto().getText();
        parametros[1] = aeropuertoGUI.getTflCiudad().getText();
        parametros[2] = aeropuertoGUI.getTflPais().getText();
        return parametros;
    }

    private void actualizar() {
        generadorTabla.generar(aeropuertoDAO.obtenerList());
    }

    private void borrar() {
        String id = aeropuertoGUI.getTflNombreAeropuerto().getText();
        aeropuertoDAO.borrar(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aeropuertoGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == aeropuertoGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == aeropuertoGUI.getBtnBorrar()) {
            borrar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = aeropuertoGUI.getTblDatosAeropuertos().getSelectedRow();
        String nombreAeropuerto = aeropuertoGUI.getTblDatosAeropuertos().getValueAt(fila, 0).toString();
        aeropuertoGUI.getTflNombreAeropuerto().setText(nombreAeropuerto);
        String ciudad = aeropuertoGUI.getTblDatosAeropuertos().getValueAt(fila, 1).toString();
        aeropuertoGUI.getTflCiudad().setText(ciudad);
        String pais = aeropuertoGUI.getTblDatosAeropuertos().getValueAt(fila, 2).toString();
        aeropuertoGUI.getTflPais().setText(pais);
    }
}
