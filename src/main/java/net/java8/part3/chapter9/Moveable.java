package net.java8.part3.chapter9;

/**
 * Created by Ciprian on 11/1/2017.
 */

public interface Moveable {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    default void moveHorizontally(int distance) {
        setX(getX() + distance);
    }

    default void moveVertically(int distance) {
        setY(getY() + distance);
    }
}
