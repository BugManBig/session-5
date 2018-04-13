package problem2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tester {
    private String test1 = "{\n" +
            "    a: 3,\n" +
            "\n" +
            "    text: \"sdf\",\n" +
            "\n" +
            "    list: [\n" +
            "        \"AB\",\n" +
            "        \"CD\",\n" +
            "        \"EF\"\n" +
            "    ],\n" +
            "\n" +
            "    set: [\n" +
            "        1.2,\n" +
            "        5.6,\n" +
            "        3.4\n" +
            "    ],\n" +
            "\n" +
            "    numbers: [\n" +
            "        3,\n" +
            "        6,\n" +
            "        9\n" +
            "    ],\n" +
            "\n" +
            "    sampleClass2: {\n" +
            "        field0: 10,\n" +
            "\n" +
            "        field1: 11.1,\n" +
            "\n" +
            "        calendar: 09.04.2018,\n" +
            "\n" +
            "        strings: [\n" +
            "            \"First text\",\n" +
            "            \"Second text\",\n" +
            "            \"End\"\n" +
            "        ]\n" +
            "    }\n" +
            "}\n" +
            "{\n" +
            "    field0: 10,\n" +
            "\n" +
            "    field1: 11.1,\n" +
            "\n" +
            "    calendar: 09.04.2018,\n" +
            "\n" +
            "    strings: [\n" +
            "        \"First text\",\n" +
            "        \"Second text\",\n" +
            "        \"End\"\n" +
            "    ]\n" +
            "}\n";

    private String test2 = "{\n" +
            "    field0: 10,\n" +
            "\n" +
            "    field1: 11.1,\n" +
            "\n" +
            "    calendar: 09.04.2018,\n" +
            "\n" +
            "    strings: [\n" +
            "        \"First text\",\n" +
            "        \"Second text\",\n" +
            "        \"End\"\n" +
            "    ]\n" +
            "}\n";

    @Test
    public void test1() {
        assertEquals(test1, new JsonFormatterImpl().marshall(new SampleClass()));
    }

    @Test
    public void test2() {
        assertEquals(test2, new JsonFormatterImpl().marshall(new SampleClass2()));
    }
}
