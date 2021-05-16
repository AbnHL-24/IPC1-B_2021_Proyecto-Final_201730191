package controlador.validaciones;

import datos.aeropuerto.AeropuertoDAOImpl;
import datos.avion.AvionDAOImpl;
import datos.pasaporte.PasaporteDAOImpl;
import datos.vuelo.VueloDAOImpl;

public class ValidacionPasaporte extends Validacion{

    public static String validarPasaporte (String[] parametros) {
        String validacion = "";
        AeropuertoDAOImpl aeropuertoDAO = new AeropuertoDAOImpl();
        AvionDAOImpl avionDAO = new AvionDAOImpl();
        VueloDAOImpl vueloDAO = new VueloDAOImpl();
        PasaporteDAOImpl pasaporteDAO = new PasaporteDAOImpl();

        if (isLong(parametros[0])) {
            if (pasaporteDAO.existe(parametros[0])) {
                validacion = anyadirError(validacion,"El numero del pasaporte ya existe");
            }
        } else {
            validacion = anyadirError(validacion,"El numero del pasaporte no es un numero largo");
        }
        if (!isFecha(parametros[2])) {
            validacion = anyadirError(validacion,"La fecha de nacimiento no es un formato correcto");
        }
        if(!esUnEstadoCivil(parametros[4])) {
            validacion = anyadirError(validacion,"El estado civil es incorrecto");
        }
        if (!esUnSexo(parametros[7])) {
            validacion = anyadirError(validacion,"El sexo no es valido");
        }
        if (!isFecha(parametros[8])) {
            validacion = anyadirError(validacion,"La fecha de vencimiento no es un formato correcto");
        }
        if (!isFecha(parametros[9])) {
            validacion = anyadirError(validacion,"La fecha de emision no es un formato correcto");
        }
        if (!isInt(parametros[1])) {
            validacion = anyadirError(validacion,"el numero de millas tiene un formato incorrecto");
        }

        return validacion;
    }
}
