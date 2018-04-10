package problem2;

public class Main {
    public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        System.out.println(jsonGenerator.objectToJson(new SampleClass2()));
    }
}
