package problem2;

public class Main {
    public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        //jsonGenerator.objectToJson(new int[][]{{5}, {6, 9, 12}, {3, 2}});
        //jsonGenerator.objectToJson(new SampleClass());
        //jsonGenerator.objectToJson("Hate");
        SampleClass sc1 = new SampleClass();
        SampleClass2 sc2 = new SampleClass2();
        jsonGenerator.objectToJson(new Object[]{sc1, sc2});
    }
}
