package controlador.validaciones;

import datos.pasaporte.PasaporteDAOImpl;
import datos.tarjeta.TarjetaDAO;
import datos.tarjeta.TarjetaDAOImpl;
import datos.vuelo.VueloDAOImpl;

public class ValidacionReservacion extends Validacion {

    public static String validarReservacion(String[] parametros) {
        String validacion = "";
        PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();
        VueloDAOImpl vueloDAO = new VueloDAOImpl();
        TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();

        if (isLong(parametros[0])) {
            if (!pasaporteDAO.existe(parametros[0])) {
                validacion = anyadirError(validacion,"El numero del pasaporte no existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero del pasaporte no es un numero largo");
        }

        if (!vueloDAO.existe(parametros[1])) {
            validacion = anyadirError(validacion,"El codigo del vuelo no existe");
        }

        if (isLong(parametros[2])) {
            if (!tarjetaDAO.existe(parametros[2])) {
                validacion = anyadirError(validacion,"El numero del tarjeta no existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero de la tarjeta no es un numero largo");
        }

        if (!isInt(parametros[3])) {
            validacion = anyadirError(validacion,"El numero de asiento no es un entero");
        }

        return validacion;
    }
}
