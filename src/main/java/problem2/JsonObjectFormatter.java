package problem2;

import java.lang.reflect.Field;
import java.util.Map;

public class JsonObjectFormatter implements JsonTypeFormatter<Object> {
    @Override
    public String format(Object object, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        String result = "{\n";
        int shiftCount = (int) ctx.get("shiftCount");
        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount + 1);

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field elem : fields) {
            elem.setAccessible(true);
            result += getTrueShift(ctx) + elem.getName() + ": " + getValue(elem, object) + "\n";
        }

        result += "}";

        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount);

        return result;
    }

    private String getValue(Field field, Object object) {
        try {
            return field.get(object).toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getTrueShift(Map<String, Object> ctx) {
        String result = "";
        int shiftCount = (int) ctx.get("shiftCount");
        String shiftType = (String) ctx.get("shiftType");
        for (int i = 0; i < shiftCount; i++) {
            result += shiftType;
        }
        return result;
    }
}
