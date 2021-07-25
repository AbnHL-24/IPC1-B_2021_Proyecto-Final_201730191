package controlador.interfaz;

import controlador.base.*;
import controlador.reportes.administrador.AerolineaRCTRLRuta;
import controlador.reportes.administrador.PasajeroRCTRL;
import controlador.reportes.administrador.VueloRCTRL;
import vista.informes.administrador.aerolinea.AerolineaRGUI;
import vista.informes.administrador.pasajero.PasajeroRGUI;
import vista.informes.administrador.vuelo.VueloRGUI;
import vista.ventanas.administrador.AdministradorGUI;
import vista.vistas.cargainformacion.CargarInformacion;
import vista.vistas.datos.aerolinea.AerolineaGUI;
import vista.vistas.datos.aeropuerto.AeropuertoGUI;
import vista.vistas.datos.avion.AvionGUI;
import vista.vistas.datos.distancia.DistanciaGUI;
import vista.vistas.datos.pasaporte.PasaporteGUI;
import vista.vistas.datos.renovacionpasaporte.RenovacionPasaporteGUI;
import vista.vistas.datos.reservacion.ReservacionGUI;
import vista.vistas.datos.tarjeta.TarjetaGUI;
import vista.vistas.datos.usuario.UsuarioGUI;
import vista.vistas.datos.vuelo.VueloGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorCTRL implements ActionListener {
    AdministradorGUI administradorGUI;

    public AdministradorCTRL(AdministradorGUI administradorGUI) {
        this.administradorGUI = administradorGUI;

        this.administradorGUI.getMnAerolineas().addActionListener(this);
        this.administradorGUI.getMnAeropuertos().addActionListener(this);
        this.administradorGUI.getMnAviones().addActionListener(this);
        this.administradorGUI.getMnDistancias().addActionListener(this);
        this.administradorGUI.getMnPasaportes().addActionListener(this);
        this.administradorGUI.getMnPasaportes().addActionListener(this);
        this.administradorGUI.getMnRenovacionPasaportes().addActionListener(this);
        this.administradorGUI.getMnReservacion().addActionListener(this);
        this.administradorGUI.getMnTarjetas().addActionListener(this);
        this.administradorGUI.getMnVuelos().addActionListener(this);
        this.administradorGUI.getMnUsuarios().addActionListener(this);
        this.administradorGUI.getMnCargarArchivo().addActionListener(this);
        this.administradorGUI.getMnReportePasajero().addActionListener(this);
        this.administradorGUI.getMnReporteVuelo().addActionListener(this);
        this.administradorGUI.getMnReporteAvion().addActionListener(this);
        this.administradorGUI.getMnReporteAeropuerto().addActionListener(this);
        this.administradorGUI.getMnRutaMasConcurrida().addActionListener(this);
        this.administradorGUI.getMnAerolineaMasusada().addActionListener(this);
        this.administradorGUI.getMnAerolineasPorAviones().addActionListener(this);

    }

    public void iniciar() {
        administradorGUI.setResizable(false);
        administradorGUI.setLocationRelativeTo(null);
        administradorGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == administradorGUI.getMnAeropuertos()) {
            AeropuertoGUI aeropuertoGUI = new AeropuertoGUI();
            AeropuertoCTRL aeropuertoCTRL = new AeropuertoCTRL(aeropuertoGUI);
            aeropuertoCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnAviones()) {
            AvionGUI avionGUI = new AvionGUI();
            AvionesCTRL avionesCTRL = new AvionesCTRL(avionGUI);
            avionesCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnAerolineas()) {
            AerolineaGUI aerolineaGUI = new AerolineaGUI();
            AerolineaCTRL aerolineaCTRL = new AerolineaCTRL(aerolineaGUI);
            aerolineaCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnDistancias()) {
            DistanciaGUI distanciaGUI = new DistanciaGUI();
            DistanciaCTRL distanciaCTRL = new DistanciaCTRL(distanciaGUI);
            distanciaCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnPasaportes()) {
            PasaporteGUI pasaporteGUI = new PasaporteGUI();
            PasaporteCTRL pasaporteCTRL = new PasaporteCTRL(pasaporteGUI);
            pasaporteCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnRenovacionPasaportes()) {
            RenovacionPasaporteGUI renovacionPasaporteGUI = new RenovacionPasaporteGUI();
            RenovacionPasaporteCTRL renovacionPasaporteCTRL = new RenovacionPasaporteCTRL(renovacionPasaporteGUI);
            renovacionPasaporteCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnReservacion()) {
            ReservacionGUI reservacionGUI = new ReservacionGUI();
            ReservacionCTRL reservacionCTRL = new ReservacionCTRL(reservacionGUI);
            reservacionCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnTarjetas()) {
            TarjetaGUI tarjetaGUI = new TarjetaGUI();
            TarjetaCTRL tarjetaCTRL = new TarjetaCTRL(tarjetaGUI);
            tarjetaCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnVuelos()) {
            VueloGUI vueloGUI = new VueloGUI();
            VueloCTRL vueloCTRL = new VueloCTRL(vueloGUI);
            vueloCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnUsuarios()) {
            UsuarioGUI usuarioGUI = new UsuarioGUI();
            UsuarioCTRL usuarioCTRL = new UsuarioCTRL(usuarioGUI);
            usuarioCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnCargarArchivo()) {
            CargarInformacion cargarInformacion = new CargarInformacion();
            CargarArchivoCTRL cargarArchivoCTRL = new CargarArchivoCTRL(cargarInformacion);
            cargarArchivoCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnReportePasajero()) {
            PasajeroRGUI pasajeroRGUI = new PasajeroRGUI();
            PasajeroRCTRL pasajeroRCTRL = new PasajeroRCTRL(pasajeroRGUI);
            pasajeroRCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnReporteVuelo()) {
            VueloRGUI vueloRGUI = new VueloRGUI();
            VueloRCTRL vueloRCTRL = new VueloRCTRL(vueloRGUI);
            vueloRCTRL.iniciar(administradorGUI.getPnlBase());
        } else if (e.getSource() == administradorGUI.getMnRutaMasConcurrida()) {
            AerolineaRGUI aerolineaRGUI = new AerolineaRGUI();
            AerolineaRCTRLRuta aerolineaRCTRLRuta = new AerolineaRCTRLRuta(aerolineaRGUI);
            aerolineaRCTRLRuta.iniciar(administradorGUI.getPnlBase());
        }
    }
}
