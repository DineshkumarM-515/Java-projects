import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class DSALogger {
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
while (true) {
System.out.println("---DSA LOGGER---");
System.out.println("1.Add Entry");
System.out.println("2.View Log");
System.out.println("3.Exit");
System.out.print("Enter your choice: ");

int choice = -1; // Initialize with default invalid value

    try {
            choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter proper integer input");
                continue; // Skip to next loop
            }

            switch (choice) {
                case 1:
                    addLog();
                    break;
                case 2:
                    viewLog();
                    break;
                case 3:
                    System.out.println("Bye!! Keep coding!!!");
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        }
    }

    static void addLog() {
        try {
            System.out.print("Enter date (DD-MM-YYYY): ");
            String date = sc.nextLine().trim();
            if(date.isEmpty()){
                System.out.println("Date must not be empty");
                date = sc.nextLine().trim();
            }
            System.out.print("Enter Topics Covered: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter problem solved: ");
            String prblm = sc.nextLine().trim();

            FileWriter writer = new FileWriter("dsa_log.txt", true);
            writer.write(date + " | " + name + " | " + prblm + "\n"); // Added newline
            writer.close();
            System.out.println("Log added successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

    static void viewLog() {
        try {
            File file = new File("dsa_log.txt");
            if (!file.exists()) {
                System.out.println("Log file doesn't exist yet. Add some entries first.");
                return;
            }

            Scanner fileread = new Scanner(file);
            System.out.println("\n---DSA LOG---");
            while (fileread.hasNextLine()) {
                System.out.println(fileread.nextLine());
            }
            fileread.close();
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}
