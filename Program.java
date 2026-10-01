import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;

public class Program {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Annual Day Details
        FileHandler annualDay = new FileHandler("src/annualDayDetails.txt");

        StringBuilder title = new StringBuilder("\nThe Annual Day Details : ");
        StringBuilder venue = new StringBuilder("Auditorium");
        StringBuilder date = new StringBuilder("28.9.26");
        StringBuilder chiefGuest = new StringBuilder("Sankara");
        StringBuilder time = new StringBuilder("14:00 - 18:00");

        StringBuilder[] arr = {title, venue, date, chiefGuest, time};

        annualDay.write(arr);
        annualDay.displayContent();

        System.out.println("Updating the title");

        title.replace(0, title.length(),
                "\nNew Annual Day Details :");

        chiefGuest.replace(0, chiefGuest.length(),
                "Narayana");

        annualDay.write(arr);
        annualDay.displayContent();


        //student details
        System.out.println("\nStudent Records: \n");
        FileHandler studentDetails = new FileHandler("src/studentDetails.txt");

        studentDetails.add("101,Arun,18,Computer Science");
        studentDetails.add("102,Ravi,19,Mathematics");
        studentDetails.add("103,Meena,18,Physics");

        studentDetails.displayContent();

        System.out.print("\nEnter student ID to modify: ");
        String id = input.nextLine();

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student age: ");
        String age = input.nextLine();

        System.out.print("Enter student course: ");
        String course = input.nextLine();

        String newRecord = id + "," + name + "," + age + "," + course;

        studentDetails.modify(id, newRecord);
        studentDetails.displayContent();

        input.close();

        File img = new File("image.png");
        BufferedImage image = null;
    }
}