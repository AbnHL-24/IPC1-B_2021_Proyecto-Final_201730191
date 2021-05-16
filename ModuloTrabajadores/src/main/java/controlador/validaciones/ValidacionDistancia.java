package controlador.validaciones;

import datos.aeropuerto.AeropuertoDAOImpl;

public class ValidacionDistancia extends Validacion {

    public static String validarDistancia(String[] parametros) {
        String validacion = "";
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();

        if (!aeropuertoDAO.existe(parametros[0])) {
            validacion = anyadirError(validacion, "Aeropuerto origen no existe");
        }
        if (!aeropuertoDAO.existe(parametros[1])) {
            validacion = anyadirError(validacion, "Aeropuerto destino no existe");
        }
        if (!isInt(parametros[2])) {
            validacion = anyadirError(validacion,"No es un entero");
        }

        return validacion;

    }
}
