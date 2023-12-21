import java.io.*;

public class FileReadWrite {
    public static void main(String args[]) {
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");
            int value = fis.read();
            while (value != -1) {
                System.out.print((char) value + "  ");
                fos.write(value);
                value = fis.read();
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("I/O Error!");
        }
    }
}
