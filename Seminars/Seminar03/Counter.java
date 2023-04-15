package Seminars.Seminar03;

import java.io.IOException;
import java.sql.SQLOutput;

public class Counter implements AutoCloseable{
    private int value = 0;
    private boolean closed = false;

    public int add() throws IOException {
        if (isClosed()) {
            throw new IOException("Resource is already closed.");
        }
        return value++;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Counter value: " + getValue();
    }

    @Override
    public void close() throws Exception {
        closed = true;
    }
}


