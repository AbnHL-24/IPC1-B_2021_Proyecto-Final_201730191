package controlador.validaciones;

import datos.aeropuerto.AeropuertoDAOImpl;

/**
 * Valida si los datos para crear un aeropuerto son correctos.
 * @author abnerhl
 */
public class ValidacionAeropuerto extends Validacion{

    public static String validarAeropuerto(String[] parametros) {
        String validacion = "";
        AeropuertoDAOImpl aeropuertoDAOImpl = new AeropuertoDAOImpl();

        if (aeropuertoDAOImpl.existe(parametros[0])) {
            validacion = anyadirError(validacion,"Aeropuerto existente");
        }

        return validacion;
    }
}
