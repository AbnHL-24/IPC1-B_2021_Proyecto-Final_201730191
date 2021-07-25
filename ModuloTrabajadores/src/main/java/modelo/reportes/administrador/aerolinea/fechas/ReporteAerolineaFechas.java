package modelo.reportes.administrador.aerolinea.fechas;

import AbnerUtils.crono.ConvertidorALocalDate;
import datos.aerolinea.AerolineaDAOImpl;
import datos.avion.AvionDAOImpl;
import datos.vuelo.VueloDAOImpl;
import modelo.base.Aerolinea;
import modelo.base.Avion;
import modelo.base.Vuelo;
import vista.informes.administrador.aerolinea.AerolineaMasUsadaRGUI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteAerolineaFechas {
    AvionDAOImpl avionDAO = new AvionDAOImpl();
    AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();
    VueloDAOImpl vueloDAO = new VueloDAOImpl();
    
    public List obtenerAvion(Date fInicio, Date fLimite) {
        List<Aerolinea> aerolineaRetorno = new ArrayList<>();
        List<Aerolinea> aerolineas = aerolineaDAO.obtenerList();
        List<Avion> aviones = avionDAO.obtenerList();
        List<Vuelo> vuelos = vueloDAO.obtenerList();
        LocalDate fechaInicio = ConvertidorALocalDate.desdeDate(fInicio);
        LocalDate fechaLimite = ConvertidorALocalDate.desdeDate(fLimite);

        AerolineaMasUsadaRGUI aerolineaMasUsadaRGUI = new AerolineaMasUsadaRGUI();
        String feha = aerolineaMasUsadaRGUI.getDtcFechaInicio().getDate().toString();

        for (Aerolinea ae : aerolineas) {
            for (Avion av : aviones) {
                //Si el nombre de la aerolinea de ae es igual al de av
                if (av.getNombreAerolinea().equalsIgnoreCase(ae.getNombreAerolinea())) {
                    for (Vuelo v : vuelos) {
                        //Si el codigo de avion de av es igual al de v
                        if (av.getCodigoAvion().equalsIgnoreCase(v.getCodigoAvion())) {
                            //Si fecha de inicio es anterior o igual a la del vuelo
                            if (fechaInicio.isBefore(v.getFechaSalida()) | fechaInicio.isEqual(v.getFechaSalida())) {
                                //Si la fecha limite es despues o igual a la fecha del vuelo
                                if (fechaLimite.isAfter(v.getFechaSalida()) | fechaLimite.isEqual(v.getFechaSalida())) {

                                }
                            }
                        }
                    }
                }
            }
        }

        return aerolineaRetorno;
    } 
}
