package problem2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        ArrayList<String> al = new ArrayList<>();
        al.add("One");
        jsonGenerator.objectToJson(al);
    }
}
