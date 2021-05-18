package controlador.reportes;

import datos.pasaporte.PasaporteDAO;
import datos.pasaporte.PasaporteDAOImpl;
import datos.reservacion.ReservacionDAO;
import datos.reservacion.ReservacionDAOImpl;
import datos.vuelo.VueloDAOImpl;
import modelo.base.Pasaporte;
import modelo.base.Reservacion;
import modelo.base.Vuelo;
import modelo.base.soporte.EstadoCivil;
import modelo.base.soporte.Sexo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ReportePasajero {
    VueloDAOImpl vueloDAO = new VueloDAOImpl();
    ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();
    PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();

    private void reportePorEstadoCivil() {
        List<Vuelo> vuelos = vueloDAO.obtenerList();
        List<Reservacion> reservaciones = reservacionDAO.obtenerList();
        List<Pasaporte> pasaportes = pasaporteDAO.obtenerList();
        int solteros = 0;
        int casados = 0;
        int divorciado = 0;


        //Recorro la lista de vuelos
        for (Vuelo vuelo : vuelos) {
            //obtengo el codigo de un vuelo
            String codVuelo = vuelo.getCodigoVuelo();
            //recorro la lista de reservaciones
            for (Reservacion reservacion : reservaciones) {
                //obtengo el pasaporte de una reservacion
                String pasaporteReservacion = String.valueOf(reservacion.getNO_Pasaporte());
                //si codigo de vuelo =  codigo reservacion
                if (codVuelo.equals(reservacion.getCodigoVuelo())) {
                    //Recorro la lista de pasaportes
                    for (Pasaporte pasaporte : pasaportes) {
                        //Si No. pasaporte reservacion = No.pasaporte de pasaporte
                        if (pasaporteReservacion.equals(pasaporte.getNoPasaporte())) {
                            if (EstadoCivil.SOLTERO.equals(pasaporte.getEstadoCivil())) {
                                solteros++;
                            } else if (EstadoCivil.CASADO.equals(pasaporte.getEstadoCivil())) {
                                casados++;
                            } else if(EstadoCivil.DIVORCIADO.equals(pasaporte.getEstadoCivil())) {
                                divorciado++;
                            }
                        }
                    }
                }
            }
        }

        //ponerlo en tablas
    }

    private void reportePorSexo() {
        List<Vuelo> vuelos = vueloDAO.obtenerList();
        List<Reservacion> reservaciones = reservacionDAO.obtenerList();
        List<Pasaporte> pasaportes = pasaporteDAO.obtenerList();
        int masculino = 0;
        int femenino = 0;
        int no_definido = 0;


        //Recorro la lista de vuelos
        for (Vuelo vuelo : vuelos) {
            //obtengo el codigo de un vuelo
            String codVuelo = vuelo.getCodigoVuelo();
            //recorro la lista de reservaciones
            for (Reservacion reservacion : reservaciones) {
                //obtengo el pasaporte de una reservacion
                String pasaporteReservacion = String.valueOf(reservacion.getNO_Pasaporte());
                //si codigo de vuelo =  codigo reservacion
                if (codVuelo.equals(reservacion.getCodigoVuelo())) {
                    //Recorro la lista de pasaportes
                    for (Pasaporte pasaporte : pasaportes) {
                        //Si No. pasaporte reservacion = No.pasaporte de pasaporte
                        if (pasaporteReservacion.equals(pasaporte.getNoPasaporte())) {
                            if (Sexo.MASCULINO.equals(pasaporte.getSexo())) {
                                masculino++;
                            } else if (Sexo.FEMENINO.equals(pasaporte.getSexo())) {
                                femenino++;
                            } else if(Sexo.SIN_DEFINIR.equals(pasaporte.getSexo())) {
                                no_definido++;
                            }
                        }
                    }
                }
            }
        }

        //ponerlo en tablas
    }

}
