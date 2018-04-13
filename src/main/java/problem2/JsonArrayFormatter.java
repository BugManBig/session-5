package problem2;

import java.lang.reflect.Array;
import java.util.Map;

public class JsonArrayFormatter implements JsonTypeFormatter<int[]> {
    @Override
    public String format(int[] objects, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        String result = getTrueShift(ctx) + "[\n";

        int shiftCount = (int) ctx.get("shiftCount");
        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount + 1);

        for (Object elem : objects) {
            result += getTrueShift(ctx) + elem.toString() + ",\n";
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
