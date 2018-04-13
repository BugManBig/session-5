package problem2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class JsonDateFormatter implements JsonTypeFormatter<Object> {
    @Override
    public String format(Object date, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        if (date instanceof Calendar) {
            return sdf.format(((Calendar) date).getTime());
        }
        return sdf.format(date);
    }
}
