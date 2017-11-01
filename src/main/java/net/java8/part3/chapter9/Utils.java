package net.java8.part3.chapter9;

import java.util.List;

/**
 * Created by Ciprian on 11/1/2017.
 */

public class Utils {

    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42, 42);
            r.draw();
        });

        //TODO: uncomment, read the README for instructions
        list.forEach(r -> { r.setRelativeSize(2, 2); });
    }
}
