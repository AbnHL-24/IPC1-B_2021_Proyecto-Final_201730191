package controlador.interfaz;

import datos.usuario.UsuarioDAOImpl;
import modelo.tablas.GeneradorTabla;
import modelo.trabajadores.Administrador;
import modelo.trabajadores.Gerente;
import modelo.trabajadores.Operador;
import modelo.trabajadores.Usuario;
import vista.vistas.datos.usuario.UsuarioGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioCTRL implements ActionListener {
    private UsuarioGUI usuarioGUI;
    private UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
    private final String[] TITULOS = {"usuario", "tipo de usuario"};
    private GeneradorTabla<Usuario> generadorTabla;

    public UsuarioCTRL(UsuarioGUI usuarioGUI) {
        this.usuarioGUI = usuarioGUI;

        this.usuarioGUI.getBtnAgregar().addActionListener(this);
        this.usuarioGUI.getBtnActualizar().addActionListener(this);
        this.usuarioGUI.getBtnBorrar().addActionListener(this);

        this.generadorTabla = new GeneradorTabla<>(this.usuarioGUI.getTblDatos(), TITULOS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuarioGUI.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == usuarioGUI.getBtnActualizar()) {
            actualizar();
        } else if (e.getSource() == usuarioGUI.getBtnBorrar()) {
            borrar();
        }
    }


    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        usuarioGUI.setSize(parent.getSize());
        usuarioGUI.setVisible(true);
        parent.add(usuarioGUI);
        parent.validate();
        usuarioGUI.limpiarCampos();
        generadorTabla.generar(usuarioDAO.obtenerList());
    }

    private void agregar() {
        char[] contra = usuarioGUI.getPflContrasenya().getPassword();
        String pass = new String(contra);
        if ("Administrador".equals(usuarioGUI.getCmbTIpoUsuario().getSelectedItem())) {
            Administrador administrador = new Administrador(usuarioGUI.getTflNombreUsuario().getText(),
                    pass);
            usuarioDAO.crear(administrador);
        } else if ("Gerente".equals(usuarioGUI.getCmbTIpoUsuario().getSelectedItem())) {
            Gerente gerente = new Gerente(usuarioGUI.getTflNombreUsuario().getText(),pass,
                    usuarioGUI.getCmbAeroX().getSelectedItem().toString());
            usuarioDAO.crear(gerente);
        } else if ("Operador".equals(usuarioGUI.getCmbTIpoUsuario().getSelectedItem())) {
            Operador operador = new Operador(usuarioGUI.getTflNombreUsuario().getText(),pass,
                    usuarioGUI.getCmbAeroX().getSelectedItem().toString());
            usuarioDAO.crear(operador);
        }
    }

    private void actualizar() {
        generadorTabla.generar(usuarioDAO.obtenerList());
    }

    private void borrar() {
        String id =  usuarioGUI.getTflNombreUsuario().getText();
        usuarioDAO.borrar(id);
    }
}
