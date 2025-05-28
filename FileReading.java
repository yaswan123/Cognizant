import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("output.txt")) {
            int ch;
            System.out.println("Contents of output.txt:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}