package Seminars.Seminar03;

import java.io.FileNotFoundException;

public class NonExistentSource extends FileNotFoundException {
    public NonExistentSource() {
        super("Exception. Trying to access non-existent source.");
    }
}
