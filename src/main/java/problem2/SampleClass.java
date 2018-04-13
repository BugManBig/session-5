package problem2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleClass extends SampleClass2 {
    private int a = 3;
    public String text = "sdf";
    private List<String> list = new ArrayList<>();
    {
        list.add("AB");
        list.add("CD");
        list.add("EF");
    }
    public Set<Double> set = new HashSet<>();
    {
        set.add(1.2);
        set.add(3.4);
        set.add(5.6);
    }
    public int[] numbers = {3, 6, 9};
    private SampleClass2 sampleClass2 = new SampleClass2();
}
