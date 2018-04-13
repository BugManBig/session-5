package problem2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class JsonDateFormatter implements JsonTypeFormatter<Date> {
    @Override
    public String format(Date date, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }
}
