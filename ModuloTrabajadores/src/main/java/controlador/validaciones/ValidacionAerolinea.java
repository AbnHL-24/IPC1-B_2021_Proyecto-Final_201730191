package controlador.validaciones;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;

/**
 * Valida si los datos para crear una aeroliinea son correctos.
 * @author abnerhl
 */
public class ValidacionAerolinea extends Validacion{

    public static String validarAerolinea(String[] parametros) {
        String validacion = "";
        AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();

        if (aeropuertoDAO.existe(parametros[0])) {
            //Verificamos si la aerolinea ya existe en el aeropuerto, formato aerolinea-aeropuerto.
            if (aerolineaDAO.existe(parametros[1] + "-" + parametros[0])) {
                validacion = anyadirError(validacion,"Aerolinea existente en esta ciudad");
            }
        } else {
            validacion = anyadirError(validacion, "Aeropuerto no existe");
        }
        return validacion;
    }
}
