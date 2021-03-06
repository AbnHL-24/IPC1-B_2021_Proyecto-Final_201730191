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
        mnUsuarios = new javax.swing.JMenuItem();
        mnVuelos = new javax.swing.JMenuItem();
        jmnOperacion = new javax.swing.JMenu();
        mnCargarArchivo = new javax.swing.JMenuItem();
        jmnReportes = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mnRutaMasConcurrida = new javax.swing.JMenuItem();
        mnAerolineaMasusada = new javax.swing.JMenuItem();
        mnAerolineasPorAviones = new javax.swing.JMenuItem();
        mnReportePasajero = new javax.swing.JMenuItem();
        mnReporteVuelo = new javax.swing.JMenuItem();
        mnReporteAvion = new javax.swing.JMenuItem();
        mnReporteAeropuerto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBase.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
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

        mnUsuarios.setText("Usuarios");
        jmnAdministracion.add(mnUsuarios);

        mnVuelos.setText("Vuelos");
        jmnAdministracion.add(mnVuelos);

        jMenuBar1.add(jmnAdministracion);

        jmnOperacion.setText("Operacion");

        mnCargarArchivo.setText("Cargar desde archivo");
        jmnOperacion.add(mnCargarArchivo);

        jMenuBar1.add(jmnOperacion);

        jmnReportes.setText("Reportes");

        jMenu1.setText("Reporte por aerolinea");

        mnRutaMasConcurrida.setText("Ruta mas concurrida");
        jMenu1.add(mnRutaMasConcurrida);

        mnAerolineaMasusada.setText("Aerolinea mas usada");
        jMenu1.add(mnAerolineaMasusada);

        mnAerolineasPorAviones.setText("Aerolineas por aviones");
        jMenu1.add(mnAerolineasPorAviones);

        jmnReportes.add(jMenu1);

        mnReportePasajero.setText("Reporte por pasajero");
        jmnReportes.add(mnReportePasajero);

        mnReporteVuelo.setText("Reporte por vuelo");
        jmnReportes.add(mnReporteVuelo);

        mnReporteAvion.setText("Reporte por avion");
        jmnReportes.add(mnReporteAvion);

        mnReporteAeropuerto.setText("Reporte por aeropuerto");
        jmnReportes.add(mnReporteAeropuerto);

        jMenuBar1.add(jmnReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmnAdministracion;
    private javax.swing.JMenu jmnOperacion;
    private javax.swing.JMenu jmnReportes;
    private javax.swing.JMenuItem mnAerolineaMasusada;
    private javax.swing.JMenuItem mnAerolineas;
    private javax.swing.JMenuItem mnAerolineasPorAviones;
    private javax.swing.JMenuItem mnAeropuertos;
    private javax.swing.JMenuItem mnAviones;
    private javax.swing.JMenuItem mnCargarArchivo;
    private javax.swing.JMenuItem mnDistancias;
    private javax.swing.JMenuItem mnPasaportes;
    private javax.swing.JMenuItem mnRenovacionPasaportes;
    private javax.swing.JMenuItem mnReporteAeropuerto;
    private javax.swing.JMenuItem mnReporteAvion;
    private javax.swing.JMenuItem mnReportePasajero;
    private javax.swing.JMenuItem mnReporteVuelo;
    private javax.swing.JMenuItem mnReservacion;
    private javax.swing.JMenuItem mnRutaMasConcurrida;
    private javax.swing.JMenuItem mnTarjetas;
    private javax.swing.JMenuItem mnUsuarios;
    private javax.swing.JMenuItem mnVuelos;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables

    public JMenu getjMenu2() {
        return jmnOperacion;
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

    public JMenuItem getMnUsuarios() {
        return mnUsuarios;
    }

    public JMenuItem getMnCargarArchivo() {
        return mnCargarArchivo;
    }

    public JMenu getJmnOperacion() {
        return jmnOperacion;
    }

    public JMenu getJmnReportes() {
        return jmnReportes;
    }

    public JMenuItem getMnReporteAeropuerto() {
        return mnReporteAeropuerto;
    }

    public JMenuItem getMnReporteAvion() {
        return mnReporteAvion;
    }

    public JMenuItem getMnReportePasajero() {
        return mnReportePasajero;
    }

    public JMenuItem getMnReporteVuelo() {
        return mnReporteVuelo;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public JMenuItem getMnAerolineaMasusada() {
        return mnAerolineaMasusada;
    }

    public JMenuItem getMnAerolineasPorAviones() {
        return mnAerolineasPorAviones;
    }

    public JMenuItem getMnRutaMasConcurrida() {
        return mnRutaMasConcurrida;
    }

     
    
}
