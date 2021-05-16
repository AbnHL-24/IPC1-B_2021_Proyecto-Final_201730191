package controlador.validaciones;

import datos.aeropuerto.AeropuertoDAOImpl;
import datos.distancia.DistanciaDAOImpl;

public class ValidacionDistancia extends Validacion {

    public static String validarDistancia(String[] parametros) {
        String validacion = "";
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
        DistanciaDAOImpl distanciaDAO = new DistanciaDAOImpl();

        if (!aeropuertoDAO.existe(parametros[0])) {
            validacion = anyadirError(validacion, "Aeropuerto origen no existe");
        }
        if (!aeropuertoDAO.existe(parametros[1])) {
            validacion = anyadirError(validacion, "Aeropuerto destino no existe");
        }
        if (distanciaDAO.existe(parametros[0] + "-" + parametros[1])) {
            validacion = anyadirError(validacion,"La distancia ya existe");
        }
        if (!isInt(parametros[2])) {
            validacion = anyadirError(validacion,"No es un entero");
        }

        return validacion;

    }
}
