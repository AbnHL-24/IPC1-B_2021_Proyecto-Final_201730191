package controlador.validaciones;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import datos.avion.AvionDAOImpl;

public class ValidacionAvion extends Validacion{

    public static String validarAvion(String[] parametros) {
        String validacion = "";
        AerolineaDAOImpl aerolineaDAO = new AerolineaDAOImpl();
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
        AvionDAOImpl avionDAO = new AvionDAOImpl();

        if (!aeropuertoDAO.existe(parametros[1])) {
            validacion = anyadirError(validacion, "Aeropuerto no existe");
        }

        if (!aerolineaDAO.existe(parametros[0] + "-" + parametros[1])) {
            validacion = anyadirError(validacion,"Aerolinea no existente en esta ciudad");
        }

        if (isInt(parametros[2])) {
            if (avionDAO.existe(parametros[2])) {
                validacion = anyadirError(validacion,"El codigo del avion ya ha sido utilizado");
            }
        } else {
            validacion = anyadirError(validacion,"El codigo del avion no tiene un formato correcto");
        }

        if (!isInt(parametros[3])) {
            validacion = anyadirError(validacion,"La capacidad de pasajeros no es un entero");
        }
        if (!isInt(parametros[4])) {
            validacion = anyadirError(validacion,"La capacidad de la gasolina no es un entero");
        }
        if (!isInt(parametros[5])) {
            validacion = anyadirError(validacion,"no es un entero");
        }

        return validacion;
    }
}
