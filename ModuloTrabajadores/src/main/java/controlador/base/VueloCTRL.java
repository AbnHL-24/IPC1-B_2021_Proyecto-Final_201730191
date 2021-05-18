package controlador.base;

import datos.vuelo.VueloDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Vuelo;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.vuelo.VueloGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static controlador.validaciones.ValidacionVuelo.validarVuelo;

public class VueloCTRL implements ActionListener {
    private VueloGUI vueloGUI;
    private VueloDAOImpl vueloDAO = new VueloDAOImpl();
    private final String[] TITULOS = {"codigoVuelo", "codigoAvion", "nombreAeropuertoOrigen", "nombreAeropuertoDestino",
            "precioBoleto", "fechaSalida" };
    private GeneradorTabla<Vuelo> generadorTabla;

    public VueloCTRL(VueloGUI vueloGUI) {
        this.vueloGUI = vueloGUI;

        vueloGUI.getBtnActualizar().addActionListener(this);
        vueloGUI.getBtnAgregar().addActionListener(this);
        vueloGUI.getBtnBorrar().addActionListener(this);

        this.generadorTabla = new GeneradorTabla(this.vueloGUI.getjTable1(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vueloGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == vueloGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == vueloGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        vueloGUI.setSize(parent.getSize());
        vueloGUI.setVisible(true);
        parent.add(vueloGUI);
        parent.validate();
        vueloGUI.limpiarCampos();
        generadorTabla.generar(vueloDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosVuelo();
        String erroresVuelo = validarVuelo(parametros);
        if ("".equals(erroresVuelo)) {
            Vuelo vuelo = new Vuelo(parametros[0], parametros[1],
                    parametros[2], parametros[3], Integer.parseInt(parametros[4]),
                    LocalDate.parse(parametros[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            VueloDAOImpl vueloDAO = new VueloDAOImpl();
            vueloDAO.crear(vuelo);
            generadorTabla.generar(vueloDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(vueloGUI, erroresVuelo, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        generadorTabla.generar(vueloDAO.obtenerList());
    }

    private void borrar() {
        generadorTabla.generar(vueloDAO.obtenerList());
    }

    private String[] obtenerParametrosVuelo() {
        String [] parametros = new String[6];
        parametros[0] = vueloGUI.getTflCodigoVuelo().getText();
        parametros[1] = vueloGUI.getTflCodigoAvion().getText();
        parametros[2] = vueloGUI.getTflNombreAeropuertoOrigen().getText();
        parametros[3] = vueloGUI.getTflNombreAeropuertoDestino().getText();
        parametros[4] = vueloGUI.getTflPrecioBoleto().getText();
        parametros[5] = vueloGUI.getTflFechaSalida().getText();
        return parametros;
    }
}
