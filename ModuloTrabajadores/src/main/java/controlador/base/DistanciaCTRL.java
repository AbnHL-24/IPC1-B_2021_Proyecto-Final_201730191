package controlador.base;

import datos.distancia.DistanciaDAOImpl;
import modelo.base.Distancia;
import vista.vistas.datos.distancia.DistanciaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controlador.validaciones.ValidacionDistancia.validarDistancia;

public class DistanciaCTRL implements ActionListener {
    private DistanciaGUI distanciaGUI;
    private DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();

    public DistanciaCTRL(DistanciaGUI distanciaGUI) {
        this.distanciaGUI = distanciaGUI;

        this.distanciaGUI.getBtnAgregar().addActionListener(this);
        this.distanciaGUI.getBtnActualizar().addActionListener(this);
        this.distanciaGUI.getBtnBorrar().addActionListener(this);
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

    private void agregar() {
        String[] parametros = obtenerParametrosDistancia();
        String erroresDistancia = validarDistancia(parametros);
        if ("".equals(erroresDistancia)) {
            Distancia distancia = new Distancia(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
            DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();
            distanciaDAO.crear(distancia);
        } else {
            JOptionPane.showMessageDialog(distanciaGUI, erroresDistancia, "Error en la entrada de texto",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {

    }

    private void borrar() {

    }

    private String[] obtenerParametrosDistancia() {
        String[] pametros = new  String[3];
        pametros[0] = distanciaGUI.getTflombreAeropuertoOrigen().getText();
        pametros[1] = distanciaGUI.getTflombreAeropuertoDestino().getText();
        pametros[2] = distanciaGUI.getTflCantidadMillas().getText();
        return pametros;
    }
}
