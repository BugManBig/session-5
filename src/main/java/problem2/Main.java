package problem2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JsonFormatter formatter = new JsonFormatterImpl();
        System.out.println(formatter.marshall(new SampleClass()));
    }
}
