package AbnerUtils.crono;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertidorALocalDate {

    public static LocalDate desdeDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}