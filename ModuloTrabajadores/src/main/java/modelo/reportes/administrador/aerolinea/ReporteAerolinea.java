package modelo.reportes.administrador.aerolinea;

import datos.aeropuerto.AeropuertoDAOImpl;
import datos.avion.AvionDAOImpl;
import datos.distancia.DistanciaDAOImpl;
import datos.pasaporte.PasaporteDAOImpl;
import datos.reservacion.ReservacionDAOImpl;
import datos.vuelo.VueloDAOImpl;
import modelo.base.*;

import java.util.ArrayList;
import java.util.List;

public class ReporteAerolinea {
    DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();
    VueloDAOImpl vueloDAO = new VueloDAOImpl();
    AvionDAOImpl avionDAO = new AvionDAOImpl();
    PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
    ReservacionDAOImpl reservacionDAO = new ReservacionDAOImpl();

    public String obtenerRuta() {
        List<Distancia> distancias = distanciaDAO.obtenerList();
        List<Vuelo> vuelos =  vueloDAO.obtenerList();
        List<Reservacion> reservacions = reservacionDAO.obtenerList();

        String rutaMaxima = "No hay vuelos";
        int cantidadRutaMaxima = 0;

        for (Distancia d : distancias) {
            String nombreDistancia = d.getIdentificadorDistancia();
            int cantidadVuelosPorRuta = 0;
            for (Vuelo v : vuelos) {
                String trayectoVuelo = v.getNombreAeropuertoOrigen() + "-" + v.getNombreAeropuertoDestino();
                if (nombreDistancia.equalsIgnoreCase(trayectoVuelo)) {
                    for (Reservacion r : reservacions) {
                        if (v.getCodigoVuelo().equalsIgnoreCase(r.getCodigoVuelo())) {
                            cantidadVuelosPorRuta++;
                        }
                    }
                }
            }
            if (cantidadVuelosPorRuta > cantidadRutaMaxima) {
                rutaMaxima = nombreDistancia;
                cantidadRutaMaxima = cantidadVuelosPorRuta;
            }
        }

        return rutaMaxima;
    }

    public int obtenerCantidadPasajerosRuta() {
        List<Distancia> distancias = distanciaDAO.obtenerList();
        List<Vuelo> vuelos =  vueloDAO.obtenerList();
        List<Reservacion> reservacions = reservacionDAO.obtenerList();

        String rutaMaxima = "No hay vuelos";
        int cantidadRutaMaxima = 0;

        for (Distancia d : distancias) {
            String nombreDistancia = d.getIdentificadorDistancia();
            int cantidadVuelosPorRuta = 0;
            for (Vuelo v : vuelos) {
                String trayectoVuelo = v.getNombreAeropuertoOrigen() + "-" + v.getNombreAeropuertoDestino();
                if (nombreDistancia.equalsIgnoreCase(trayectoVuelo)) {
                    for (Reservacion r : reservacions) {
                        if (v.getCodigoVuelo().equalsIgnoreCase(r.getCodigoVuelo())) {
                            cantidadVuelosPorRuta++;
                        }
                    }
                }
            }
            if (cantidadVuelosPorRuta > cantidadRutaMaxima) {
                rutaMaxima = nombreDistancia;
                cantidadRutaMaxima = cantidadVuelosPorRuta;
            }
        }

        return cantidadRutaMaxima;
    }

    private List obtenerListaDeAviones() {
        List<Avion> aviones = avionDAO.obtenerList();
        List<Avion> avionesDeRuta = new ArrayList<>();
        
        List<Vuelo> vuelos = vueloDAO.obtenerList();
        String ruta = obtenerRuta();
        
        for (Vuelo v : vuelos) {
            String trayectoVuelo = v.getNombreAeropuertoOrigen() + "-" + v.getNombreAeropuertoDestino();
            if (ruta.equalsIgnoreCase(trayectoVuelo)) {
                for (Avion a : aviones) {
                    if (v.getCodigoAvion().equalsIgnoreCase(a.getCodigoAvion())) {
                        avionesDeRuta.add(a);
                    }
                }
            }
        }

        return avionesDeRuta;
    }

    private List obtenerListaDePasajeros() {
        List<Pasaporte> pasaportes = pasaporteDAO.obtenerList();
        List<Pasaporte> pasaportesDeRuta = new ArrayList<>();
        List<Reservacion> reservacions = reservacionDAO.obtenerList();

        List<Vuelo> vuelos = vueloDAO.obtenerList();
        String ruta = obtenerRuta();

        for (Vuelo v : vuelos) {
            String trayectoVuelo = v.getNombreAeropuertoOrigen() + "-" + v.getNombreAeropuertoDestino();
            if (ruta.equalsIgnoreCase(trayectoVuelo)) {
                for (Reservacion r : reservacions) {
                    if (v.getCodigoVuelo().equalsIgnoreCase(r.getCodigoVuelo())) {
                        //Aca agregamos el objeto pasaporte al List a retornar
                        for (Pasaporte p : pasaportes) {
                            if (r.getNO_Pasaporte().equalsIgnoreCase(p.getNoPasaporte())) {
                                pasaportesDeRuta.add(p);
                            }
                        }
                    }
                }
            }
        }
        
        return pasaportesDeRuta;
    }

    public List generarAerolineaRP() {
        List<AerolineaRP> aerolineaRPS = new ArrayList<>();
        List<Pasaporte> pasaportes = obtenerListaDePasajeros();

        for (Pasaporte p : pasaportes) {
            AerolineaRP aerolineaRP = new AerolineaRP(p);
            aerolineaRPS.add(aerolineaRP);
        }

        return aerolineaRPS;
    }

    public List generarAerolineaRA() {
        List<AerolineaRA> aerolineaRAS = new ArrayList<>();
        List<Avion> aviones = obtenerListaDeAviones();

        for (Avion a : aviones) {
            AerolineaRA aerolineaRA = new AerolineaRA(a);
            aerolineaRAS.add(aerolineaRA);
        }

        return aerolineaRAS;
    }
}
