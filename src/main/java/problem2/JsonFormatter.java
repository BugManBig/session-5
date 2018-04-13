package problem2;

public interface JsonFormatter {
    String marshall(Object obj);
    <T> boolean addType(Class<T> clazz, JsonTypeFormatter<T> format);
}
