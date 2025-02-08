package Common.Common.mkyong.time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
public class CurrentDate {
    private static final String DATE_FORMAT = "M/d/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static String getFormattedDate() {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(8);
        Date datePlus = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return dateFormat.format(datePlus);
    }
}
