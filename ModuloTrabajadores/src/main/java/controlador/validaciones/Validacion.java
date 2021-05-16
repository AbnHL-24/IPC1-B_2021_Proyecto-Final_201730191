package controlador.validaciones;

import modelo.base.soporte.EstadoCivil;
import modelo.base.soporte.EstadoVuelo;
import modelo.base.soporte.Sexo;

import javax.swing.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Validacion {

    //Verifica si la cadena es un float
    public static boolean isFloat(String f) {
        try {
            Float.parseFloat(f);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Verifica si la cadena es un entero
    public static boolean isInt(String i) {
        try {
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Verifica si la cadena es un largo
    public static boolean isLong(String i) {
        try {
            Long.parseLong(i);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Verifica si el formato de la fecha es correcto
    public static boolean isFecha(String f) {
        try {
            LocalDate.parse(f);
            return true;
        } catch (Exception e) {
                LocalDate.parse(f, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return true;
        }
    }

    //Verifica si el formato de la hora es correcto
    public static boolean isHora(String h) {
        try {
            LocalTime.parse(h);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean exists(String nameFile) {
        File file = new File("/tmp/" + nameFile);
        return file.exists();
    }

    //Verifica si el numero es mayor a cero
    public static boolean isMayorACero(String s) {
        return (Float.parseFloat(s) > 0);
    }

    public static String anyadirError(String validaciones,String error) {
        if (validaciones.startsWith("Errores: ")) {
            return validaciones += ", " + error;
        } else {
            return validaciones = "Errores: " +error;
        }
    }

    public static boolean esUnSexo (String sexo) {

        for (Sexo s : Sexo.values()) {
            if (s.name().equals(sexo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean esUnEstadoCivil(String s) {
        for (EstadoCivil sc : EstadoCivil.values()) {
            if (sc.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean esUnEstadoVuelo(String s) {
        for (EstadoVuelo sv : EstadoVuelo.values()) {
            if (sv.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
