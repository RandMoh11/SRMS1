import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveToFile(String fileName, ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("id,name,gpa,department,year"); // header

            for (Student s : students) {
                writer.println(s.toString());
            }

            System.out.println("File saved successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadFromFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // skip header if exists
            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length < 5) continue;

                String id = data[0].trim();
                String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                String department = data[3].trim();
                int year = Integer.parseInt(data[4].trim());

                students.add(new Student(id, name, gpa, department, year));
            }

            System.out.println("File loaded successfully: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
        }

        return students;
    }
}
