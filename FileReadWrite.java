import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        // Replace "input.txt" and "output.txt" with your file paths
        String sourceFilePath = "";
        String destinationFilePath = "output.txt";

        try {
            // Reading from the file
            try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process the line as needed
                    // For now, let's just print the line
                    System.out.println("Read from file: " + line);
                }
            }

            // Writing to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
                // Writing sample content to the file
                writer.write("Hello, this is a sample text.\n");
                writer.write("Writing to a file in Java is easy!\n");
                System.out.println("Write to file successful.");
            }
        } catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
        }
    }
}
