package modelo.reportes.administrador.pasajero;

import datos.pasaporte.PasaporteDAOImpl;
import datos.reservacion.ReservacionDAOImpl;
import datos.vuelo.VueloDAOImpl;
import modelo.base.Pasaporte;
import modelo.base.Reservacion;
import modelo.base.Vuelo;
import modelo.base.soporte.EstadoCivil;
import modelo.base.soporte.Sexo;

import java.util.ArrayList;
import java.util.List;

public class ReportePasajero {
    VueloDAOImpl vueloDAO = new VueloDAOImpl();
    ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();
    PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
    ArrayList<Vuelo> vuelos = new ArrayList();
    ArrayList<Reservacion> reservaciones = new ArrayList();

    public List obtenerPasajerosReporte() {
        ArrayList<PasajeroR> pasajeroReporte = new ArrayList();
        pasajeroReporte.add(reportePorEstadoCivil());
        pasajeroReporte.add(reportePorSexo());

        return pasajeroReporte;
    }

    public PasajeroR reportePorEstadoCivil() {
        ArrayList<Pasaporte> solteros = new ArrayList();
        ArrayList<Pasaporte> casados = new ArrayList();
        ArrayList<Pasaporte> divorciados = new ArrayList();
        for (Vuelo vuelo : vuelos) {
            for (Reservacion reservacion : reservaciones) {
                if(vuelo.getCodigoVuelo().equals(reservacion.getCodigoVuelo())) {
                    Pasaporte pasaporte = pasaporteDAO.obtenerObjecto(reservacion.getNO_Pasaporte());
                    if (modelo.base.soporte.EstadoCivil.SOLTERO.equals(pasaporte.getEstadoCivil())) {
                        solteros.add(pasaporte);
                    } else if (modelo.base.soporte.EstadoCivil.CASADO.equals(pasaporte.getEstadoCivil())) {
                        casados.add(pasaporte);
                    } else if (modelo.base.soporte.EstadoCivil.DIVORCIADO.equals(pasaporte.getEstadoCivil())) {
                        divorciados.add(pasaporte);
                    }
                }
            }
        }
        if (solteros.size() > divorciados.size() && solteros.size() > casados.size()) {
            PasajeroR pasajeroSoltero = new PasajeroR("Soltero", String.valueOf(solteros.size()));
            return pasajeroSoltero;
        } else if (divorciados.size() > solteros.size() && divorciados.size() > casados.size()) {
            PasajeroR pasajeroDivorciado = new PasajeroR("Divorciado", String.valueOf(divorciados.size()));
            return pasajeroDivorciado;

        } else if (casados.size() > solteros.size() && casados.size() > divorciados.size()){
            PasajeroR pasajeroCasado = new PasajeroR("Casado", String.valueOf(casados.size()));
            return pasajeroCasado;
        } else {
            PasajeroR els = new PasajeroR("Todos estados civiles han viajado igual", String.valueOf(solteros.size()));
            return els;
        }
    }

    public PasajeroR reportePorSexo() {
        ArrayList<Pasaporte> masculino = new ArrayList<>();
        ArrayList<Pasaporte> femenino = new ArrayList<>();
        ArrayList<Pasaporte> no_definido = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            for (Reservacion reservacion : reservaciones) {
                if(vuelo.getCodigoVuelo().equals(reservacion.getCodigoVuelo())) {
                    Pasaporte pasaporte = pasaporteDAO.obtenerObjecto(reservacion.getNO_Pasaporte());
                    if (Sexo.MASCULINO.equals(pasaporte.getSexo())) {
                        masculino.add(pasaporte);
                    } else if (Sexo.FEMENINO.equals(pasaporte.getSexo())) {
                        femenino.add(pasaporte);
                    } else if (Sexo.SIN_DEFINIR.equals(pasaporte.getSexo())) {
                        no_definido.add(pasaporte);
                    }
                }
            }
        }
        if (masculino.size() > femenino.size() && masculino.size() > no_definido.size()) {
            PasajeroR pasajeroMasculino = new PasajeroR("Masculino", String.valueOf(masculino.size()));
            return pasajeroMasculino;
        } else if (femenino.size() > masculino.size() && femenino.size() > no_definido.size()) {
            PasajeroR pasajeroFemenino = new PasajeroR("Femenino", String.valueOf(femenino.size()));
            return pasajeroFemenino;

        } else if (no_definido.size() > masculino.size() && no_definido.size() > femenino.size()){
            PasajeroR pasajeroNoDefinido = new PasajeroR("No definido", String.valueOf(no_definido.size()));
            return pasajeroNoDefinido;
        } else {
            PasajeroR els = new PasajeroR("Todos los sexos han viajado igual", String.valueOf(masculino.size()));
            return els;
        }
    }
}
