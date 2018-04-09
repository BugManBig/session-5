package problem2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class JsonGenerator {
    private Set<String> simpleClassTypes = new HashSet<>();
    private String result = "";

    public JsonGenerator() {
        simpleClassTypes.add("Integer");
        simpleClassTypes.add("Long");
        simpleClassTypes.add("Double");
        simpleClassTypes.add("String");
    }

    public void objectToJson(Object object) {
        generate(object, 0);
        System.out.println(result);
        
    }

    private boolean isEmptyLine() {
        if (result.length() == 0) return true;
        return result.charAt(result.length() - 1) == '\n';
    }

    private String getClassName(Object object) {
        String className = object.getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1);
    }

    private void generate(Object object, int shift) {
        if (object instanceof List) {
            generate(((List) (object)).toArray(), shift);
            return;
        }
        if (object instanceof Set) {
            generate(((Set) (object)).toArray(), shift);
            return;
        }
        String className = getClassName(object);
        if (simpleClassTypes.contains(className)) {
            if (isEmptyLine()) {
                if (Objects.equals(className, "String")) {
                    printLine("\"" + object.toString() + "\"", shift);
                } else {
                    printLine(object.toString(), shift);
                }
            } else {
                if (Objects.equals(className, "String")) {
                    result += "\"" + object.toString() + "\"";
                } else {
                    result += object.toString();
                }
            }
            return;
        }
        if (isArray(object)) {
            if (isEmptyLine()) {
                printLine("[\n", shift);
            } else {
                result += "[" + "\n";
            }
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                generate(Array.get(object, i), shift + 4);
                if (i < length - 1) {
                    result += ",";
                }
                result += "\n";
            }
            printLine("]", shift);
        } else {
            if (isEmptyLine()) {
                printLine("{\n", shift);
            } else {
                result += "{" + "\n";
            }
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                printLine("\"" + fields[i].getName() + "\"" + ": ", shift + 4);
                try {
                    generate(fields[i].get(object), shift + 4);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (i < fields.length - 1) {
                    result += ",";
                }
                result += "\n";
            }
            printLine("}", shift);
        }
    }

    private boolean isArray(Object object) {
        return object.getClass().isArray();
    }


    private void printLine(String line, int shift) {
        String spaces = "";
        for (int i = 0; i < shift; i++) {
            spaces += " ";
        }
        result += spaces + line;
    }
}
