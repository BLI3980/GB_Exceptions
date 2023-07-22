package Homework.Homework03.DB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToFile {
    public void saveToTxt(String[] userDetails) {
        String fileName = userDetails[0]+".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (String item : userDetails) {
                writer.append('<' + item + '>');
            }
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println("Saving done to file \"" + fileName + "\".");
    }
}
