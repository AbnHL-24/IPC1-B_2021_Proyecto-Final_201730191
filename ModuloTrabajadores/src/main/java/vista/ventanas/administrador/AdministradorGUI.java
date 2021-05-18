/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventanas.administrador;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author abnerhl
 */
public class AdministradorGUI extends javax.swing.JFrame {

    /**
     * Creates new form administrador
     */
    public AdministradorGUI() {
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

        pnlBase = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnAdministracion = new javax.swing.JMenu();
        mnAeropuertos = new javax.swing.JMenuItem();
        mnAerolineas = new javax.swing.JMenuItem();
        mnAviones = new javax.swing.JMenuItem();
        mnDistancias = new javax.swing.JMenuItem();
        mnPasaportes = new javax.swing.JMenuItem();
        mnRenovacionPasaportes = new javax.swing.JMenuItem();
        mnReservacion = new javax.swing.JMenuItem();
        mnTarjetas = new javax.swing.JMenuItem();
        mnVuelos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );

        jmnAdministracion.setText("Administracion");

        mnAeropuertos.setText("Aeropuertos");
        jmnAdministracion.add(mnAeropuertos);

        mnAerolineas.setText("Aerolineas");
        jmnAdministracion.add(mnAerolineas);

        mnAviones.setText("Aviones");
        jmnAdministracion.add(mnAviones);

        mnDistancias.setText("Distancias");
        jmnAdministracion.add(mnDistancias);

        mnPasaportes.setText("Pasaportes");
        jmnAdministracion.add(mnPasaportes);

        mnRenovacionPasaportes.setText("Renovacion de Pasaportes");
        jmnAdministracion.add(mnRenovacionPasaportes);

        mnReservacion.setText("Reservacion");
        jmnAdministracion.add(mnReservacion);

        mnTarjetas.setText("Tarjetas");
        jmnAdministracion.add(mnTarjetas);

        mnVuelos.setText("Vuelos");
        jmnAdministracion.add(mnVuelos);

        jMenuBar1.add(jmnAdministracion);

        jMenu2.setText("Operacion");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmnAdministracion;
    private javax.swing.JMenuItem mnAerolineas;
    private javax.swing.JMenuItem mnAeropuertos;
    private javax.swing.JMenuItem mnAviones;
    private javax.swing.JMenuItem mnDistancias;
    private javax.swing.JMenuItem mnPasaportes;
    private javax.swing.JMenuItem mnRenovacionPasaportes;
    private javax.swing.JMenuItem mnReservacion;
    private javax.swing.JMenuItem mnTarjetas;
    private javax.swing.JMenuItem mnVuelos;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JMenuItem getjMenuItem1() {
        return mnAviones;
    }

   /** public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }*/

    public JMenu getJmnAdministracion() {
        return jmnAdministracion;
    }

    public JMenuItem getJmnAeropuertos() {
        return mnAeropuertos;
    }

    public JPanel getPnlBase() {
        return pnlBase;
    }

    public JMenuItem getMnAviones() {
        return mnAviones;
    }

    public JMenuItem getMnAerolineas() {
        return mnAerolineas;
    }

    public JMenuItem getMnAeropuertos() {
        return mnAeropuertos;
    }

    public JMenuItem getMnDistancias() {
        return mnDistancias;
    }

    public JMenuItem getMnPasaportes() {
        return mnPasaportes;
    }

    public JMenuItem getMnRenovacionPasaportes() {
        return mnRenovacionPasaportes;
    }

    public JMenuItem getMnReservacion() {
        return mnReservacion;
    }

    public JMenuItem getMnTarjetas() {
        return mnTarjetas;
    }

    public JMenuItem getMnVuelos() {
        return mnVuelos;
    }

    
    
}