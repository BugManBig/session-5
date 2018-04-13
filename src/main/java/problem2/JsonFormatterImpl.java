package problem2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonFormatterImpl implements JsonFormatter {
    private Map<Class, JsonTypeFormatter> types = new HashMap<>();

    public JsonFormatterImpl() {
        types.put(Date.class, new JsonDateFormatter());
        types.put(Object.class, new JsonObjectFormatter());
    }

    @Override
    public String marshall(Object obj) {
        if (obj == null) {
            return "";
        }

        Map<String, Object> ctx = new HashMap<>();
        ctx.put("shiftCount", 0);
        ctx.put("shiftType", "    ");

        if (!types.containsKey(obj.getClass())) {
            return types.get(Object.class).format(obj, this, ctx);
        }

        return types.get(obj.getClass()).format(obj, this, ctx);
    }

    @Override
    public <T> boolean addType(Class<T> clazz, JsonTypeFormatter<T> format) {
        return false;
    }
}
