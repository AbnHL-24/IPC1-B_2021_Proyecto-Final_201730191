package controlador.validaciones;

import datos.aerolinea.AerolineaDAOImpl;
import datos.aeropuerto.AeropuertoDAOImpl;
import datos.avion.AvionDAOImpl;
import datos.vuelo.VueloDAOImpl;

public class ValidacionVuelo extends Validacion {

    public static String validarVuelo(String[] parametros) {
        String validacion = "";
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
        AvionDAOImpl avionDAO = new AvionDAOImpl();
        VueloDAOImpl vueloDAO = new VueloDAOImpl();

        if (isInt(parametros[0])) {
            if (vueloDAO.existe(parametros[0])) {
                validacion = anyadirError(validacion,"El codigo del vuelo ya ha sido utilizado");
            }
        } else {
            validacion = anyadirError(validacion,"El codigo del avion tiene un formato incorrecto");
        }

        if (isInt(parametros[1])) {
            if (!avionDAO.existe(parametros[1])) {
                validacion = anyadirError(validacion,"El codigo del avion no existe");
            }
        } else {
            validacion = anyadirError(validacion,"El codigo del avion tiene un formato incorrecto");
        }

        if (!aeropuertoDAO.existe(parametros[2])) {
            validacion = anyadirError(validacion, "Aeropuerto origen no existe");
        }
        if (!aeropuertoDAO.existe(parametros[3])) {
            validacion = anyadirError(validacion, "Aeropuerto destino no existe");
        }
        if (!isInt(parametros[4])) {
            validacion = anyadirError(validacion,"El precio del boleto no es un entero");
        }

        if (!isFecha(parametros[5])) {
            validacion = anyadirError(validacion,"La fecha no es un formato correcto");
        }

        return validacion;
    }
}
