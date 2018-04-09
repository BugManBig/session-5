package problem2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        jsonGenerator.objectToJson(new SampleClass());
    }
}
