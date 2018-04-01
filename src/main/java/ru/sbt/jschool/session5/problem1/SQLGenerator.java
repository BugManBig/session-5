package ru.sbt.jschool.session5.problem1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class SQLGenerator {
    public <T> String insert(Class<T> clazz) {
        String result = "INSERT INTO " + getName(clazz) + "(";
        String splitter = ", ";
        List<String> fieldNames = getFieldNames(clazz, true, true);
        for (String elem : fieldNames) {
            result += elem + splitter;
        }
        result = removeLastSplitter(result, splitter);
        result += ") VALUES (";
        splitter = ", ";
        for (int i = 0; i < fieldNames.size(); i++) {
            result += "?" + splitter;
        }
        result = removeLastSplitter(result, splitter) + ")";
        return result;
    }

    public <T> String update(Class<T> clazz) {
        String result = "UPDATE " + getName(clazz);
        String splitter = ", ";
        List<String> fieldNames = getFieldNames(clazz, false, true);
        result += " SET ";
        for (String elem : fieldNames) {
            result += elem + " = ?" + splitter;
        }
        result = removeLastSplitter(result, splitter);
        result += " WHERE " + getFieldNames(clazz, true, false).get(0) + " = ?";
        return result;
    }

    public <T> String delete(Class<T> clazz) {
        return "DELETE FROM " + getName(clazz) + " WHERE " + getFieldNames(clazz, true, false).get(0) + " = ?";
    }

    public <T> String select(Class<T> clazz) {
        String result = "SELECT ";
        List<String> fieldNames = getFieldNames(clazz, false, true);
        String splitter = ", ";
        for (String elem : fieldNames) {
            result += elem + splitter;
        }
        result = removeLastSplitter(result, splitter);
        result += " FROM " + getName(clazz) + " WHERE " + getFieldNames(clazz, true, false).get(0) + " = ?";
        return result;
    }

    private String getName(Class clazz) {
        String name = clazz.getAnnotations()[0].toString();
        name = name.substring(name.indexOf("\"") + 1, name.lastIndexOf("\""));
        return name;
    }

    private List<String> getFieldNames(Class clazz, boolean isPrimaryKeyIncludes, boolean isColumnsIncludes) {
        List<String> resultFields = new ArrayList<>();
        String field;
        Field[] fields = clazz.getDeclaredFields();
        for (Field elem : fields) {
            if (elem.isAnnotationPresent(Column.class) && isColumnsIncludes
                    || elem.isAnnotationPresent(PrimaryKey.class) && isPrimaryKeyIncludes) {
                field = elem.toString();
                field = field.substring(field.lastIndexOf(".") + 1);
                resultFields.add(field.toLowerCase());
            }
        }
        return resultFields;
    }

    private String removeLastSplitter(String string, String splitter) {
        return string.substring(0, string.length() - splitter.length());
    }
}
