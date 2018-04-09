package problem2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tester {
    private String test1Data = "{\n" +
            "    \"a\": 3,\n" +
            "    \"text\": \"sdf\",\n" +
            "    \"list\": [\n" +
            "        \"AB\",\n" +
            "        \"CD\",\n" +
            "        \"EF\"\n" +
            "    ],\n" +
            "    \"numbers\": [\n" +
            "        3,\n" +
            "        6,\n" +
            "        9\n" +
            "    ]\n" +
            "}\n";

    private String test2Data = "{\n" +
            "    \"field0\": 10,\n" +
            "    \"field1\": 11.1,\n" +
            "    \"calendar\": 09.04.2018,\n" +
            "    \"strings\": [\n" +
            "        \"First text\",\n" +
            "        \"Second text\",\n" +
            "        \"End\"\n" +
            "    ]\n" +
            "}\n" +
            "{\n" +
            "    \"a\": 3,\n" +
            "    \"text\": \"sdf\",\n" +
            "    \"list\": [\n" +
            "        \"AB\",\n" +
            "        \"CD\",\n" +
            "        \"EF\"\n" +
            "    ],\n" +
            "    \"numbers\": [\n" +
            "        3,\n" +
            "        6,\n" +
            "        9\n" +
            "    ]\n" +
            "}\n";

    @Test
    public void test1() {
        JsonGenerator jsonGenerator = new JsonGenerator();
        assertEquals(test1Data, jsonGenerator.objectToJson(new SampleClass()));
    }

    @Test
    public void test2() {
        JsonGenerator jsonGenerator = new JsonGenerator();
        assertEquals(test2Data, jsonGenerator.objectToJson(new SampleClass2()));
    }
}
