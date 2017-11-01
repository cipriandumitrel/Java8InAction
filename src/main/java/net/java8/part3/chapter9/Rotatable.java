package net.java8.part3.chapter9;

/**
 * Created by Ciprian on 11/1/2017.
 */
public interface Rotatable {

    void setRotationAngle(int angleInDegrees);

    int getRotationAngle();

    default void rotateBy(int angleInDegrees) {
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
