package AbnerUtils.crono;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertidorALocalDateTime {

    public static LocalDateTime desdeDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}