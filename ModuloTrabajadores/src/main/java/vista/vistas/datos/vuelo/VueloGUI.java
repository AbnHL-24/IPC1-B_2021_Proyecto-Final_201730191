/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.vistas.datos.vuelo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author abnerhl
 */
public class VueloGUI extends javax.swing.JPanel {

    /**
     * Creates new form VueloGUI
     */
    public VueloGUI() {
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

        lblCodigoVuelo = new javax.swing.JLabel();
        tflCodigoVuelo = new javax.swing.JTextField();
        tflCodigoAvion = new javax.swing.JTextField();
        lblCodigoAvion = new javax.swing.JLabel();
        tflNombreAeropuertoOrigen = new javax.swing.JTextField();
        lblNombreAeropuertoOrigen = new javax.swing.JLabel();
        tflFechaSalida = new javax.swing.JTextField();
        tflPrecioBoleto = new javax.swing.JTextField();
        lblFechaSalida = new javax.swing.JLabel();
        tflNombreAeropuertoDestino = new javax.swing.JTextField();
        lblNombreAeropuertoDestino = new javax.swing.JLabel();
        lblPrecioBoleto = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tblDatosVuelos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblCodigoVuelo.setText("Codigo de vuelo:");

        lblCodigoAvion.setText("Codigo del avion:");

        lblNombreAeropuertoOrigen.setText("Nombre del aeropuerto de origen:");

        lblFechaSalida.setText("Fecha de salida(dd/MM/yyyy):");

        lblNombreAeropuertoDestino.setText("Nombre del aeropuerto destino:");

        lblPrecioBoleto.setText("Precio del boleto:");

        btnAgregar.setText("Agregar");

        btnActualizar.setText("Actualizar");

        btnBorrar.setText("Borrar");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatosVuelos.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAeropuertoOrigen)
                            .addComponent(lblCodigoAvion)
                            .addComponent(lblCodigoVuelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tflNombreAeropuertoOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tflCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tflCodigoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAeropuertoDestino)
                            .addComponent(lblPrecioBoleto)
                            .addComponent(lblFechaSalida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tflFechaSalida)
                            .addComponent(tflPrecioBoleto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tflNombreAeropuertoDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnAgregar)
                .addGap(41, 41, 41)
                .addComponent(btnActualizar)
                .addGap(46, 46, 46)
                .addComponent(btnBorrar)
                .addGap(41, 41, 41)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(tblDatosVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflCodigoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoVuelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoAvion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflNombreAeropuertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreAeropuertoOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflNombreAeropuertoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreAeropuertoDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrecioBoleto)
                    .addComponent(tflPrecioBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaSalida))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnBorrar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(tblDatosVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigoAvion;
    private javax.swing.JLabel lblCodigoVuelo;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblNombreAeropuertoDestino;
    private javax.swing.JLabel lblNombreAeropuertoOrigen;
    private javax.swing.JLabel lblPrecioBoleto;
    private javax.swing.JScrollPane tblDatosVuelos;
    private javax.swing.JTextField tflCodigoAvion;
    private javax.swing.JTextField tflCodigoVuelo;
    private javax.swing.JTextField tflFechaSalida;
    private javax.swing.JTextField tflNombreAeropuertoDestino;
    private javax.swing.JTextField tflNombreAeropuertoOrigen;
    private javax.swing.JTextField tflPrecioBoleto;
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

    public JLabel getLblCodigoAvion() {
        return lblCodigoAvion;
    }

    public JLabel getLblCodigoVuelo() {
        return lblCodigoVuelo;
    }

    public JLabel getLblFechaSalida() {
        return lblFechaSalida;
    }

    public JLabel getLblNombreAeropuertoDestino() {
        return lblNombreAeropuertoDestino;
    }

    public JLabel getLblNombreAeropuertoOrigen() {
        return lblNombreAeropuertoOrigen;
    }

    public JLabel getLblPrecioBoleto() {
        return lblPrecioBoleto;
    }

    public JScrollPane getTblDatosVuelos() {
        return tblDatosVuelos;
    }

    public JTextField getTflCodigoAvion() {
        return tflCodigoAvion;
    }

    public JTextField getTflCodigoVuelo() {
        return tflCodigoVuelo;
    }

    public JTextField getTflFechaSalida() {
        return tflFechaSalida;
    }

    public JTextField getTflNombreAeropuertoDestino() {
        return tflNombreAeropuertoDestino;
    }

    public JTextField getTflNombreAeropuertoOrigen() {
        return tflNombreAeropuertoOrigen;
    }

    public JTextField getTflPrecioBoleto() {
        return tflPrecioBoleto;
    }

    public void limparCampos() {
        getTflCodigoVuelo().setText("");
        getTflCodigoAvion().setText("");
        getTflNombreAeropuertoDestino().setText("");
        getTflNombreAeropuertoOrigen().setText("");
        getTflPrecioBoleto().setText("");
        getTflFechaSalida().setText("");
    }

}
