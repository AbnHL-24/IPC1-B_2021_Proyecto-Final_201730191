package controlador.archivos;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import datos.avion.AvionDAOImpl;
import datos.distancia.DistanciaDAOImpl;
import datos.pasaporte.PasaporteDAOImpl;
import datos.renovacionpasaporte.RenovacionPasaporteDAOImpl;
import datos.reservacion.ReservacionDAOImpl;
import datos.tarjeta.TarjetaDAOImpl;
import datos.vuelo.VueloDAOImpl;
import modelo.base.*;
import modelo.base.soporte.EstadoCivil;
import modelo.base.soporte.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static controlador.validaciones.ValidacionAerolinea.validarAerolinea;
import static controlador.validaciones.ValidacionAeropuerto.validarAeropuerto;
import static controlador.validaciones.ValidacionAvion.validarAvion;
import static controlador.validaciones.ValidacionDistancia.validarDistancia;
import static controlador.validaciones.ValidacionPasaporte.validarPasaporte;
import static controlador.validaciones.ValidacionRanovacionPasaporte.validarRenovacionPasaporte;
import static controlador.validaciones.ValidacionReservacion.validarReservacion;
import static controlador.validaciones.ValidacionTarjeta.validarTarjeta;
import static controlador.validaciones.ValidacionVuelo.validarVuelo;

/**
 * Contiene metodos para crear los datos de los distintos objetos que maneja el programa.
 * @author abnerhl
 */
public class GenerarObjetos {
    final String LINEA = "Linea ";
    final String ERROR_DE_CANTIDAD_DE_PARAMETROS = "Cantidad de parametros erronea.";
    final String ERROR_COINCIDENCIA_NULA = "Tipo de dato invalido";
    ArrayList<String> resutadosDeCargaDeDatos = new ArrayList<>();

    public void generarReservacion(String[] parametros, int indice) {
        if (parametros.length ==  4) {
            String erroresReservacion = validarReservacion(parametros);
            if ("".equals(erroresReservacion)) {
                Reservacion reservacion = new Reservacion(parametros[0], parametros[1],
                        Long.parseLong(parametros[2]), Integer.parseInt(parametros[3]));
                ReservacionDAOImpl reservacionDAO= new ReservacionDAOImpl();
                reservacionDAO.crear(reservacion);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Reservacion cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresReservacion);
            }
        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public void generarRenovacionPasaporte(String[] parametros, int indice) {
        if (parametros.length ==  2) {
            String erroresRenovacionPasaporte = validarRenovacionPasaporte(parametros);
            if ("".equals(erroresRenovacionPasaporte)) {
                RenovacionPasaporte renovacionPasaporte = new RenovacionPasaporte(Long.parseLong(parametros[0]),
                        LocalDate.parse(parametros[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                RenovacionPasaporteDAOImpl renovacionPasaporteDAO =  new RenovacionPasaporteDAOImpl();
                renovacionPasaporteDAO.crear(renovacionPasaporte);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Renovacion de pasaporte cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresRenovacionPasaporte);
            }
        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public void generarTarjeta(String[] parametros, int indice) {
        if (parametros.length ==  4) {
            String erroresTarjeta= validarTarjeta(parametros);
            if ("".equals(erroresTarjeta)) {
                Tarjeta tarjeta = new Tarjeta(Long.parseLong(parametros[0]), Long.parseLong(parametros[1]),
                        Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]));
                TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();
                tarjetaDAO.crear(tarjeta);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Tarjeta cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresTarjeta);
            }
        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public void generarPasaporte(String[] parametros, int indice) {
        if (parametros.length == 12) {
            String erroresPasaporte = validarPasaporte(parametros);
            if ("".equals(erroresPasaporte)) {
                Pasaporte pasaporte = new Pasaporte(parametros[0], parametros[1],
                        LocalDate.parse(parametros[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), parametros[3],
                        EstadoCivil.valueOf(parametros[4].toUpperCase()), parametros[5], parametros[6], Sexo.valueOf(parametros[7].toUpperCase()),
                        LocalDate.parse(parametros[8], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        LocalDate.parse(parametros[9], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        parametros[10], Integer.parseInt(parametros[11]));
                PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
                pasaporteDAO.crear(pasaporte);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Pasaporte cargado exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresPasaporte);
            }

        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }


    }

    public void generarVuelo(String[] parametros, int indice) {
        if (parametros.length == 6) {
            String erroresVuelo = validarVuelo(parametros);
            if ("".equals(erroresVuelo)) {
                Vuelo vuelo = new Vuelo(parametros[0], parametros[1],
                        parametros[2], parametros[3], Integer.parseInt(parametros[4]),
                        LocalDate.parse(parametros[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                VueloDAOImpl vueloDAO = new VueloDAOImpl();
                vueloDAO.crear(vuelo);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Vuelo cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresVuelo);
            }

        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }


    }

    public void generarDistancia(String[] parametros, int indice) {
        if (parametros.length == 3) {
            String erroresDistancia = validarDistancia(parametros);
            if ("".equals(erroresDistancia)) {
                Distancia distancia = new Distancia(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
                DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();
                distanciaDAO.crear(distancia);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Distancia cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresDistancia);
            }

        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public void generarAvion(String[] parametros, int indice) {
        if (parametros.length == 6) {
            String erroresAvion = validarAvion(parametros);
            if ("".equals(erroresAvion)) {
                Avion avion = new Avion(parametros[0], parametros[1], parametros[2], Integer.parseInt(parametros[3]),
                        Integer.parseInt(parametros[4]), Integer.parseInt(parametros[5]));
                AvionDAOImpl avionDAO = new AvionDAOImpl();
                avionDAO.crear(avion);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Avion cargado exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresAvion);
            }

        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }

    }

    public void generarAerolinea(String[] parametros, int indice) {
        if (parametros.length == 2) {
            String erroresAerolinea = validarAerolinea(parametros);
            if ("".equals(erroresAerolinea)) {
                Aerolinea aerolinea = new Aerolinea(parametros[0], parametros[1]);
                AerolineaDAOImpl aerolineaDOA = new AerolineaDAOImpl();
                aerolineaDOA.crear(aerolinea);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Aerolinea cargada exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresAerolinea);
            }

        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public void generarAeropuerto(String[] parametros, int indice) {
        if (parametros.length == 3) {
            String erroresAeropuerto = validarAeropuerto(parametros);
            if ("".equals(erroresAeropuerto)) {
                Aeropuerto aeropuerto = new Aeropuerto(parametros[0], parametros[1], parametros[2]);
                AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
                aeropuertoDAO.crear(aeropuerto);
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + "Aeropuerto cargado exitosamente");
            } else {
                resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + erroresAeropuerto);
            }
        } else {
            resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
        System.out.println();
    }

    public void errorCoincidenciaNula(int indice) {
        resutadosDeCargaDeDatos.add(lineaMasIndice(indice) + ERROR_COINCIDENCIA_NULA);
    }

    private String lineaMasIndice(int indice) {
        return LINEA + indice + ". ";
    }

    public ArrayList<String> getResutadosDeCargaDeDatos() {
        return resutadosDeCargaDeDatos;
    }


}
