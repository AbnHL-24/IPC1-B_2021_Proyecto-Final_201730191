package controlador.validaciones;

import datos.pasaporte.PasaporteDAOImpl;
import datos.tarjeta.TarjetaDAOImpl;

public class ValidacionTarjeta extends Validacion{

    public static String validarTarjeta(String[] parametros) {
        String validacion = "";
        TarjetaDAOImpl tarjetaDAO = new TarjetaDAOImpl();
        PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();

        if (isLong(parametros[0])) {
            if (tarjetaDAO.existe(parametros[0])) {
                validacion = anyadirError(validacion,"El numero del tarjeta ya existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero del pasaporte no es un numero largo");
        }

        if (isLong(parametros[1])) {
            if (!pasaporteDAO.existe(parametros[1])) {
                validacion = anyadirError(validacion,"El numero del pasaporte no existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero del pasaporte no es un numero largo");
        }

        if (!isInt(parametros[2])) {
            validacion = anyadirError(validacion,"El numero del dinero actual no es un numero entero");
        }
        if (!isInt(parametros[3])) {
            validacion = anyadirError(validacion,"El codigo CVC no es un numero entero");
        }

        return validacion;
    }
}
