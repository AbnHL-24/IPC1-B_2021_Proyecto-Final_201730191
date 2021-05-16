package controlador.validaciones;

import datos.pasaporte.PasaporteDAOImpl;

public class ValidacionRanovacionPasaporte extends Validacion {

    public static String validarRenovacionPasaporte (String[] parametros) {
        String validacion = "";
        PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();

        if (isLong(parametros[0])) {
            if (!pasaporteDAO.existe(parametros[0])) {
                validacion = anyadirError(validacion,"El numero del pasaporte no existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero del pasaporte no es un numero largo");
        }
        if (!isFecha(parametros[1])) {
            validacion = anyadirError(validacion,"La fecha nuevo vencimiento no es un formato correcto");
        }

        return validacion;
    }
}
