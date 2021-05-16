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

public class GenerarObjetos {
    static final String LINEA = "Linea ";
    static final String ERROR_DE_CANTIDAD_DE_PARAMETROS = "Cantidad de parametros erronea.";
    static final String ERROR_COINCIDENCIA_NULA = "Tipo de dato invalido";
    static ArrayList<String> errores;

    public static void generarReservacion(String[] parametros, int indice) {
        if (parametros.length ==  4) {
            String erroresTarjeta= validarReservacion(parametros);
            if ("".equals(erroresTarjeta)) {
                Reservacion reservacion = new Reservacion(Long.parseLong(parametros[0]), Integer.parseInt(parametros[1]),
                        Long.parseLong(parametros[2]), Integer.parseInt(parametros[3]));
                ReservacionDAOImpl reservacionDAO= new ReservacionDAOImpl();
                reservacionDAO.crear(reservacion);
            } else {
                errores.add(lineaMasIndice(indice) + erroresTarjeta);
            }
        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public static void generarRenovacionPasaporte(String[] parametros, int indice) {
        if (parametros.length ==  2) {
            String erroresTarjeta = validarRenovacionPasaporte(parametros);
            if ("".equals(erroresTarjeta)) {
                RenovacionPasaporte renovacionPasaporte = new RenovacionPasaporte(Long.parseLong(parametros[0]),
                        LocalDate.parse(parametros[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                RenovacionPasaporteDAOImpl renovacionPasaporteDAO =  new RenovacionPasaporteDAOImpl();
                renovacionPasaporteDAO.crear(renovacionPasaporte);
            } else {
                errores.add(lineaMasIndice(indice) + erroresTarjeta);
            }
        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public static void generarTarjeta(String[] parametros, int indice) {
        if (parametros.length ==  4) {
            String erroresTarjeta= validarTarjeta(parametros);
            if ("".equals(erroresTarjeta)) {
                Tarjeta tarjeta = new Tarjeta(Long.parseLong(parametros[0]), Long.parseLong(parametros[1]),
                        Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]));
                TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();
                tarjetaDAO.crear(tarjeta);
            } else {
                errores.add(lineaMasIndice(indice) + erroresTarjeta);
            }
        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public static void generarPasaporte(String[] parametros, int indice) {
        if (parametros.length == 12) {
            String erroresPasaporte = validarPasaporte(parametros);
            if ("".equals(erroresPasaporte)) {
                Pasaporte pasaporte = new Pasaporte(Long.parseLong(parametros[0]), parametros[1],
                        LocalDate.parse(parametros[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), parametros[3],
                        EstadoCivil.valueOf(parametros[4]), parametros[5], parametros[6], Sexo.valueOf(parametros[7]),
                        LocalDate.parse(parametros[8], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        LocalDate.parse(parametros[9], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        parametros[10], Integer.parseInt(parametros[11]));
                PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
                pasaporteDAO.crear(pasaporte);
            } else {
                errores.add(lineaMasIndice(indice) + erroresPasaporte);
            }

        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }


    }

    public static void generarVuelo(String[] parametros, int indice) {
        if (parametros.length == 6) {
            String erroresVuelo = validarVuelo(parametros);
            if ("".equals(erroresVuelo)) {
                Vuelo vuelo = new Vuelo(Integer.parseInt(parametros[0]), Integer.parseInt(parametros[1]),
                        parametros[2], parametros[3], Integer.parseInt(parametros[4]),
                        LocalDate.parse(parametros[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                VueloDAOImpl vueloDAO = new VueloDAOImpl();
                vueloDAO.crear(vuelo);
            } else {
                errores.add(lineaMasIndice(indice) + erroresVuelo);
            }

        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }


    }

    public static void generarDistancia(String[] parametros, int indice) {
        if (parametros.length == 3) {
            String erroresDistancia = validarDistancia(parametros);
            if ("".equals(erroresDistancia)) {
                Distancia distancia = new Distancia(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
                DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();
                distanciaDAO.crear(distancia);
            } else {
                errores.add(lineaMasIndice(indice) + erroresDistancia);
            }

        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public static void generarAvion(String[] parametros, int indice) {
        if (parametros.length == 6) {
            String erroresAvion = validarAvion(parametros);
            if ("".equals(erroresAvion)) {
                Avion avion = new Avion(parametros[0], parametros[1], Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]), Integer.parseInt(parametros[4]), Integer.parseInt(parametros[5]));
                AvionDAOImpl avionDAO = new AvionDAOImpl();
                avionDAO.crear(avion);
            } else {
                errores.add(lineaMasIndice(indice) + erroresAvion);
            }

        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }

    }

    public static void generarAerolinea(String[] parametros, int indice) {
        if (parametros.length == 2) {
            String erroresAerolinea = validarAerolinea(parametros);
            if ("".equals(erroresAerolinea)) {
                Aerolinea aerolinea = new Aerolinea(parametros[0], parametros[1]);
                AerolineaDAOImpl aerolineaDOA = new AerolineaDAOImpl();
                aerolineaDOA.crear(aerolinea);
            } else {
                errores.add(lineaMasIndice(indice) + erroresAerolinea);
            }

        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
    }

    public static void generarAeropuerto(String[] parametros, int indice) {
        if (parametros.length == 3) {
            String erroresAeropuerto = validarAeropuerto(parametros);
            if ("".equals(erroresAeropuerto)) {
                Aeropuerto aeropuerto = new Aeropuerto(parametros[0], parametros[1], parametros[2]);
                AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
                aeropuertoDAO.crear(aeropuerto);
            } else {
                errores.add(lineaMasIndice(indice) + erroresAeropuerto);
            }
        } else {
            errores.add(lineaMasIndice(indice) + ERROR_DE_CANTIDAD_DE_PARAMETROS);
        }
        System.out.println();
    }

    public static void errorCoincidenciaNula(int indice) {
        errores.add(lineaMasIndice(indice) + ERROR_COINCIDENCIA_NULA);
    }

    private static String lineaMasIndice(int indice) {
        return LINEA + String.valueOf(indice) + ". ";
    }
}
