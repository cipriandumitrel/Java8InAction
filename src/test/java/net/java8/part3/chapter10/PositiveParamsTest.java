package net.java8.part3.chapter10;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ciprian on 11/19/2017.
 */
public class PositiveParamsTest {

    @Test
    public void testMap() {
        Properties properties = new Properties();

        properties.put("a", 5);
        properties.put("b", true);
        properties.put("c", -3);

        assertEquals(5, readDurationImperative(properties, "a"));
        assertEquals(0, readDurationImperative(properties, "b"));
        assertEquals(0, readDurationImperative(properties, "c"));
        assertEquals(0, readDurationImperative(properties, "d"));

        assertEquals(5, readDurationWithOptional(properties, "a"));
        assertEquals(0, readDurationWithOptional(properties, "b"));
        assertEquals(0, readDurationWithOptional(properties, "c"));
        assertEquals(0, readDurationWithOptional(properties, "d"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

    private static int readDurationImperative(Properties properties, String propertyName) {

        Object valueForProperty = properties.get(propertyName);

        if (valueForProperty == null) return 0;

        int value = 0;

        try {
            value = Integer.parseInt(valueForProperty.toString());
            if(value > 0) return value;
            else value = 0;
        }
        catch (NumberFormatException nfe) {
            value = 0;
        }

        return value;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.get(name))
                .flatMap(obj -> stringToInt(obj.toString()))
                .filter(i -> i > 0).orElse(0);
    }
}
