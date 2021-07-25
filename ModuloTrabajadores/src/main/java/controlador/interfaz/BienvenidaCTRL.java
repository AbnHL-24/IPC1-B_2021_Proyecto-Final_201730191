package controlador.interfaz;

import vista.inicio.BienvenidaGUI;
import vista.inicio.PantallaInicioGUI;
import vista.ventanas.administrador.AdministradorGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BienvenidaCTRL implements ActionListener {
    private BienvenidaGUI bienvenidaGUI;

    public BienvenidaCTRL(BienvenidaGUI bienvenidaGUI) {
        this.bienvenidaGUI = bienvenidaGUI;

        this.bienvenidaGUI.getBtnIniciarSesion().addActionListener(this);
    }

    public void iniciar() {
        bienvenidaGUI.setResizable(false);
        bienvenidaGUI.setLocationRelativeTo(null);
        bienvenidaGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] contra = bienvenidaGUI.getPflContrasenya().getPassword();
        String pass = new String(contra);
        if (e.getSource() == bienvenidaGUI.getBtnIniciarSesion()) {
            if ("admin".equals(bienvenidaGUI.getTflNombreUsuario().getText()) & "admin".equals(pass)) {
                bienvenidaGUI.setVisible(false);
                AdministradorGUI administradorGUI = new AdministradorGUI();
                AdministradorCTRL administradorCTRL = new AdministradorCTRL(administradorGUI);
                administradorCTRL.iniciar();
            }
        }
    }
}
