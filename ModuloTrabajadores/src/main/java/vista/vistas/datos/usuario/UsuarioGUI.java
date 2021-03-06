/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.vistas.datos.usuario;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.base.Aerolinea;
import modelo.base.Aeropuerto;

/**
 *
 * @author abnerhl
 */
public class UsuarioGUI extends javax.swing.JPanel {


    /**
     * Creates new form UsuarioGUI
     */
    public UsuarioGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreUsuario = new javax.swing.JLabel();
        tflNombreUsuario = new javax.swing.JTextField();
        lblContrasenya = new javax.swing.JLabel();
        pflContrasenya = new javax.swing.JPasswordField();
        lblTipoUsuario = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tblDatosUsuarios = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        cmbTIpoUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbAeroX = new javax.swing.JComboBox<>();

        lblNombreUsuario.setText("Nombre usuario:");

        lblContrasenya.setText("Contraseña:");

        lblTipoUsuario.setText("Tipo de usuario:");

        btnAgregar.setText("Agregar");

        btnActualizar.setText("Actualizar");

        btnBorrar.setText("Borrar");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatosUsuarios.setViewportView(tblDatos);

        cmbTIpoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Operador" }));
        cmbTIpoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTIpoUsuarioItemStateChanged(evt);
            }
        });

        jLabel1.setText("Aerolinea/Aeropuerto (si aplica):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(lblTipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblContrasenya, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tflNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimpiar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pflContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbAeroX, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbTIpoUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE))))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(248, 248, 248))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(tblDatosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreUsuario)
                            .addComponent(tflNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContrasenya)
                            .addComponent(pflContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoUsuario)
                            .addComponent(cmbTIpoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(cmbAeroX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBorrar)
                    .addComponent(btnActualizar))
                .addGap(27, 27, 27)
                .addComponent(tblDatosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbTIpoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTIpoUsuarioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if ("Administrador".equals(this.cmbTIpoUsuario.getSelectedItem())) {
                this.cmbAeroX.removeAllItems();
            } else if ("Gerente".equals(this.cmbTIpoUsuario.getSelectedItem())) {
                this.getCmbAeroX().removeAllItems();
                List<Aerolinea> aerolineas = aerolineaDAO.obtenerList();
                for (Aerolinea a : aerolineas) {
                    this.getCmbAeroX().addItem(a.getNombreAerolinea());
                }
            } else if ("Operador".equals(this.cmbTIpoUsuario.getSelectedItem())) {
                this.getCmbAeroX().removeAllItems();
                List<Aeropuerto> aeropuertos = aeropuertoDAO.obtenerList();
                for (Aeropuerto a : aeropuertos) {
                    this.getCmbAeroX().addItem(a.getNombreAeropuerto());
                }
            }
        }
    }//GEN-LAST:event_cmbTIpoUsuarioItemStateChanged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbAeroX;
    private javax.swing.JComboBox<String> cmbTIpoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContrasenya;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPasswordField pflContrasenya;
    private javax.swing.JTable tblDatos;
    private javax.swing.JScrollPane tblDatosUsuarios;
    private javax.swing.JTextField tflNombreUsuario;
    private AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();
    private AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
    // End of variables declaration//GEN-END:variables

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JTable getjTable1() {
        return tblDatos;
    }

    public JLabel getLblContrasenya() {
        return lblContrasenya;
    }

    public JLabel getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public JLabel getLblTipoUsuario() {
        return lblTipoUsuario;
    }

    public JPasswordField getPflContrasenya() {
        return pflContrasenya;
    }

    public JScrollPane getTblDatosUsuarios() {
        return tblDatosUsuarios;
    }

    public JTextField getTflNombreUsuario() {
        return tflNombreUsuario;
    }

       public void limpiarCampos() {
        getTflNombreUsuario().setText("");
        getPflContrasenya().setText("");
    }

    public JComboBox<String> getCmbTIpoUsuario() {
        return cmbTIpoUsuario;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public JComboBox<String> getCmbAeroX() {
        return cmbAeroX;
    }
    
       
}
