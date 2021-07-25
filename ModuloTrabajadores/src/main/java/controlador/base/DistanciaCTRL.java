package controlador.base;

import datos.distancia.DistanciaDAOImpl;
import modelo.base.Distancia;
import modelo.tablas.GeneradorTabla;
import vista.vistas.datos.distancia.DistanciaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controlador.validaciones.ValidacionDistancia.validarDistancia;

public class DistanciaCTRL extends MouseAdapter implements ActionListener {
    private DistanciaGUI distanciaGUI;
    private DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();
    private final String[] TITULOS = {"nombreAeropuertoOrigen", "nombreAeropuertoDestino", "cantidadMillas"};
    private GeneradorTabla<Distancia> generadorTabla;

    public DistanciaCTRL(DistanciaGUI distanciaGUI) {
        this.distanciaGUI = distanciaGUI;

        this.distanciaGUI.getBtnAgregar().addActionListener(this);
        this.distanciaGUI.getBtnActualizar().addActionListener(this);
        this.distanciaGUI.getBtnBorrar().addActionListener(this);
        this.distanciaGUI.getTblDatosDistancias().addMouseListener(this);

        this.generadorTabla = new GeneradorTabla(this.distanciaGUI.getTblDatosDistancias(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == distanciaGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == distanciaGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == distanciaGUI.getBtnBorrar()) {
            borrar();
        }
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        distanciaGUI.setSize(parent.getSize());
        distanciaGUI.setVisible(true);
        parent.add(distanciaGUI);
        parent.validate();
        distanciaGUI.limpiarCampos();
        generadorTabla.generar(distanciaDAO.obtenerList());
    }

    private void agregar() {
        String[] parametros = obtenerParametrosDistancia();
        String erroresDistancia = validarDistancia(parametros);
        if ("".equals(erroresDistancia)) {
            Distancia distancia = new Distancia(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
            distanciaDAO.crear(distancia);
            generadorTabla.generar(distanciaDAO.obtenerList());
        } else {
            JOptionPane.showMessageDialog(distanciaGUI, erroresDistancia, "Error en la entrada de texto",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        generadorTabla.generar(distanciaDAO.obtenerList());
    }

    private void borrar() {
        String id = distanciaGUI.getTflombreAeropuertoOrigen().getText() + "-" + distanciaGUI.getTflombreAeropuertoDestino().getText();
        distanciaDAO.borrar(id);
    }

    private String[] obtenerParametrosDistancia() {
        String[] pametros = new  String[3];
        pametros[0] = distanciaGUI.getTflombreAeropuertoOrigen().getText();
        pametros[1] = distanciaGUI.getTflombreAeropuertoDestino().getText();
        pametros[2] = distanciaGUI.getTflCantidadMillas().getText();
        return pametros;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = distanciaGUI.getTblDatosDistancias().getSelectedRow();
        String aeropuertoOrigen = distanciaGUI.getTblDatosDistancias().getValueAt(fila, 0).toString();
        distanciaGUI.getTflombreAeropuertoOrigen().setText(aeropuertoOrigen);
        String aeropuertoDestino = distanciaGUI.getTblDatosDistancias().getValueAt(fila, 1).toString();
        distanciaGUI.getTflombreAeropuertoDestino().setText(aeropuertoDestino);
        String cantMillas = distanciaGUI.getTblDatosDistancias().getValueAt(fila, 2).toString();
        distanciaGUI.getTflCantidadMillas().setText(cantMillas);
    }
}
