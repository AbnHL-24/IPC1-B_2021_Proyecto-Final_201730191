/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.vistas.datos.usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
        tflTipoUsuario = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tblDatosUsuarios = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblNombreUsuario.setText("Nombre usuario:");

        lblContrasenya.setText("Contraseña:");

        lblTipoUsuario.setText("Tipo de usuario:");

        btnAgregar.setText("Agregar");

        btnActualizar.setText("Actualizar");

        btnBorrar.setText("Borrar");

        btnLimpiar.setText("Limpiar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatosUsuarios.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblContrasenya)
                    .addComponent(lblTipoUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tflNombreUsuario)
                    .addComponent(pflContrasenya, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(tflTipoUsuario))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(27, 27, 27)
                .addComponent(btnBorrar)
                .addGap(28, 28, 28)
                .addComponent(btnLimpiar)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(tblDatosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
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
                    .addComponent(tflTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBorrar)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addComponent(tblDatosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblContrasenya;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPasswordField pflContrasenya;
    private javax.swing.JScrollPane tblDatosUsuarios;
    private javax.swing.JTextField tflNombreUsuario;
    private javax.swing.JTextField tflTipoUsuario;
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
        return jTable1;
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

    public JTextField getTflTipoUsuario() {
        return tflTipoUsuario;
    }

    
    
}