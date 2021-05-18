package controlador.interfaz;

import controlador.archivos.CargarDatosDesdeArchivo;
import datos.usuario.UsuarioDAOImpl;
import modelo.tablas.GeneradorTabla;
import modelo.trabajadores.Usuario;
import vista.vistas.cargainformacion.CargarInformacion;
import vista.vistas.datos.usuario.UsuarioGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarArchivoCTRL implements ActionListener {
    private CargarInformacion cargarinformacion;

    public CargarArchivoCTRL(CargarInformacion cargarinformacion) {
        this.cargarinformacion = cargarinformacion;

        this.cargarinformacion.getBtnAceptar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        cargarinformacion.setSize(parent.getSize());
        cargarinformacion.setVisible(true);
        parent.add(cargarinformacion);
        parent.validate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cargarinformacion.getBtnAceptar()) {
            CargarDatosDesdeArchivo cargarDatosDesdeArchivo = new CargarDatosDesdeArchivo();
            cargarDatosDesdeArchivo.cargarDatos(cargarinformacion.getTflRuta().getText());
        }
    }
}
