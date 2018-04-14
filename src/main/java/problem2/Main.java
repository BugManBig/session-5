package problem2;

public class Main {
    public static void main(String[] args) {
        JsonFormatter formatter = new JsonFormatterImpl();
        String json = formatter.marshall(new SampleClass());
        System.out.println(json);
    }
}
