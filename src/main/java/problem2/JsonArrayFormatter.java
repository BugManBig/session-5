package problem2;

import java.lang.reflect.Array;
import java.util.Map;

public class JsonArrayFormatter implements JsonTypeFormatter<Object> {
    @Override
    public String format(Object object, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        String result = "[\n";

        int shiftCount = (int) ctx.get("shiftCount");
        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount + 1);

        for (int i = 0; i < Array.getLength(object); i++) {
            result += getTrueShift(ctx) + Array.get(object, i) + ",\n";
        }

        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount);

        result += getTrueShift(ctx) + "]";

        return result;
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
