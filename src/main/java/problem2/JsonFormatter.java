package problem2;

import java.util.Map;

public interface JsonFormatter {
    String marshall(Object obj);
    String generateNext(Object object, Map<String, Object> ctx);
    <T> boolean addType(Class<T> clazz, JsonTypeFormatter<T> format);
}
