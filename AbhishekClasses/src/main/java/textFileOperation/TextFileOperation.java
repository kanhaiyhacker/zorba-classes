package textFileOperation;

import java.io.File;
import java.io.FileInputStream;

public class TextFileOperation {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/file_input_out_operations.txt");
            FileInputStream fis = new FileInputStream(file);
            byte buffer;
            while ((buffer = (byte) fis.read()) != -1) {
                System.out.print((char)(buffer));
            }
        } catch (Exception e) {

        }
    }
}
