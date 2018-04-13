package problem2;

import java.lang.reflect.Field;
import java.util.Map;

public class JsonObjectFormatter implements JsonTypeFormatter<Object> {
    @Override
    public String format(Object object, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        String result = "{\n";
        OftenActions.shiftChange(ctx, 1);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field elem : fields) {
            elem.setAccessible(true);
            result += OftenActions.getTrueShift(ctx) + elem.getName() + ": " + getValue(elem, object, jsonFormatter, ctx) + ",\n\n";
        }
        result = OftenActions.cutLastComma(result);
        OftenActions.shiftChange(ctx, -1);
        result += OftenActions.getTrueShift(ctx) + "}";
        return result;
    }

    private String getValue(Field field, Object object, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jsonFormatter.generateNext(result, ctx);
    }
}
