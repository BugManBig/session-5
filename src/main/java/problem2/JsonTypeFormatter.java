package problem2;

import java.util.Map;

public interface JsonTypeFormatter<T> {
    String format(T t, JsonFormatter jsonFormatter, Map<String, Object> ctx);
}
