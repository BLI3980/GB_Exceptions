package Seminars.Seminar03;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("Unacceptable division by zero. ");
    }
}
