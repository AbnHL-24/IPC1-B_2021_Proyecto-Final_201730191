package controlador.base;

import datos.tarjeta.TarjetaDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Tarjeta;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.tarjeta.TarjetaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionTarjeta.validarTarjeta;

public class TarjetaCTRL implements ActionListener {
    private TarjetaGUI tarjetaGUI;
    private TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();
    private final String[] TITULOS = {"no_Tarjeta", "no_Pasaporte", "dineroActual",
            "codigoCV"};
    private GeneradorTabla<Tarjeta> generadorTabla;

    public TarjetaCTRL(TarjetaGUI tarjetaGUI) {
        this.tarjetaGUI = tarjetaGUI;

        this.tarjetaGUI.getBtnAgreggar().addActionListener(this);
        this.tarjetaGUI.getBtnActualizar().addActionListener(this);
        this.tarjetaGUI.getBtnBorrar().addActionListener(this);

        this.generadorTabla = new GeneradorTabla<>(this.tarjetaGUI.getTblDatosTarjeta(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tarjetaGUI.getBtnAgreggar()) {
            agregar();
        } else if (e.getSource() == tarjetaGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == tarjetaGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        tarjetaGUI.setSize(parent.getSize());
        tarjetaGUI.setVisible(true);
        parent.add(tarjetaGUI);
        parent.validate();
        tarjetaGUI.limpiarCampos();
        generadorTabla.generar(tarjetaDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosTarjeta();
        String erroresTarjeta= validarTarjeta(parametros);
        if ("".equals(erroresTarjeta)) {
            Tarjeta tarjeta = new Tarjeta(Long.parseLong(parametros[0]), Long.parseLong(parametros[1]),
                    Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]));
            TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();
            tarjetaDAO.crear(tarjeta);
            generadorTabla.generar(tarjetaDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(tarjetaGUI, erroresTarjeta, "Error en los datos ingresados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        generadorTabla.generar(tarjetaDAO.obtenerList());
    }

    private void borrar() {
        String id = tarjetaGUI.getTflNoTarjeta().getText();
        tarjetaDAO.borrar(id);
    }

    private String[] obtenerParametrosTarjeta() {
        String[] parametros =  new String[4];
        parametros[0] = tarjetaGUI.getTflNoTarjeta().getText();
        parametros[1] = tarjetaGUI.getTflNoPasaporte().getText();
        parametros[2] = tarjetaGUI.getTflDineroActual().getText();
        parametros[3] = tarjetaGUI.getTflCodigoCVC().getText();
        return parametros;
    }
}
