package problem2;

import java.util.List;
import java.util.Map;

public class JsonListFormatter implements JsonTypeFormatter<List> {
    @Override
    public String format(List list, JsonFormatter jsonFormatter, Map<String, Object> ctx) {
        String result = getTrueShift(ctx) + "{\n";

        int shiftCount = (int) ctx.get("shiftCount");
        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount + 1);

        Object[] array = list.toArray();
        for (Object elem : array) {
            result += getTrueShift(ctx) + elem + ",\n";
        }

        ctx.remove("shiftCount");
        ctx.put("shiftCount", shiftCount);

        result += getTrueShift(ctx) + "}";

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
