/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.informes.administrador.vuelo;

import datos.reservacion.ReservacionDAOImpl;
import datos.vuelo.VueloDAO;
import datos.vuelo.VueloDAOImpl;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modelo.base.Reservacion;
import modelo.base.Vuelo;
import modelo.reportes.administrador.pasajero.PasajeroR;
import modelo.reportes.administrador.vuelo.VueloR;
import modelo.tablas.GeneradorTabla;

/**
 *
 * @author abnerhl
 */
public class VueloRGUI extends javax.swing.JPanel {

    private ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();
    private GeneradorTabla<VueloR> generadorTabla;
    private final String[] TITULOS = {"Pasajeros"};
    
    /**
     * Creates new form VueloRGUI
     */
    public VueloRGUI() {
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

        cmbSeleccionarVuelo = new javax.swing.JComboBox<>();
        lblSeleccionarVuelo = new javax.swing.JLabel();
        tblDatosPasajerosEnVuelo = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        cmbSeleccionarVuelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeleccionarVueloItemStateChanged(evt);
            }
        });

        lblSeleccionarVuelo.setText("Seleccione un vuelo:");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatosPasajerosEnVuelo.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(tblDatosPasajerosEnVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lblSeleccionarVuelo)
                        .addGap(130, 130, 130)
                        .addComponent(cmbSeleccionarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeleccionarVuelo)
                    .addComponent(cmbSeleccionarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(tblDatosPasajerosEnVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSeleccionarVueloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeleccionarVueloItemStateChanged
        this.generadorTabla = new GeneradorTabla<>(this.getTblDatos(), TITULOS);
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String vueloEscogido = this.cmbSeleccionarVuelo.getSelectedItem().toString();
            List<Reservacion> reservaciones = reservacionDAO.obtenerList();
            List<VueloR> pasajeros = new ArrayList<>();
            for (Reservacion reservacion : reservaciones) {
                if (vueloEscogido.equalsIgnoreCase(reservacion.getCodigoVuelo())) {
                    VueloR pasajero = new VueloR(reservacion.getNO_Pasaporte());
                    pasajeros.add(pasajero);
                }
            }
            generadorTabla.generar(pasajeros);
        }
    }//GEN-LAST:event_cmbSeleccionarVueloItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSeleccionarVuelo;
    private javax.swing.JLabel lblSeleccionarVuelo;
    private javax.swing.JTable tblDatos;
    private javax.swing.JScrollPane tblDatosPasajerosEnVuelo;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getCmbSeleccionarVuelo() {
        return cmbSeleccionarVuelo;
    }

    public JLabel getLblSeleccionarVuelo() {
        return lblSeleccionarVuelo;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public JScrollPane getTblDatosPasajerosEnVuelo() {
        return tblDatosPasajerosEnVuelo;
    }

    

}