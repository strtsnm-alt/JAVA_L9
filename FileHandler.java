import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private StringBuilder name;
    private File obj;
    private FileWriter writer;
    private Scanner reader;

    public void displayContent() {
        try {
            reader = new Scanner(obj);
        }
        catch (IOException e) {
            System.out.println("File missing");
            return;
        }

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }

        reader.close();
    }

    public void write(String text) {
        try {
            writer = new FileWriter(new String(name));
        }
        catch (IOException e) {
            System.out.println("Could not open file");
            return;
        }

        try {
            writer.write(text + "\n");
        }
        catch (IOException e) {
            System.out.println("File missing");
        }

        try {
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not close the stream");
        }
    }

    public void write(StringBuilder[] arr) {
        try {
            writer = new FileWriter(new String(name));
        }
        catch (IOException e) {
            System.out.println("Could not open file");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            try {
                writer.write(arr[i] + "\n");
            }
            catch (IOException e) {
                System.out.println("File missing");
            }
        }

        try {
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not close the stream");
        }
    }

    // ADD a new student record without deleting existing records
    public void add(String text) {
        try {
            writer = new FileWriter(new String(name), true);
            writer.write(text + "\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not add record");
        }
    }

    // MODIFY a student record using the student's ID
    public void modify(String id, String newRecord) {
        StringBuilder contents = new StringBuilder();

        try {
            reader = new Scanner(obj);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                // First value in the line is the student ID
                String oldId = line.split(",")[0];

                if (oldId.equals(id)) {
                    contents.append(newRecord);
                }
                else {
                    contents.append(line);
                }

                contents.append("\n");
            }

            reader.close();

            // Rewrite the entire file
            writer = new FileWriter(new String(name));
            writer.write(contents.toString());
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not modify record");
        }
    }

    FileHandler(String name) {
        this.name = new StringBuilder(name);

        try {
            obj = new File(name);
        }
        catch (Exception e) {
            System.out.println("oops");
        }
    }
}