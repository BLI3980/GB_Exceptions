package Seminars.Seminar03;

public class EmptyArrayElement extends NullPointerException {
    public EmptyArrayElement() {
        super("Exception. Trying to access empty element of the array.");
    }
}
