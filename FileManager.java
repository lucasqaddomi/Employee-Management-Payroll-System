import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {

    public static void saveEmployees(EmployeeManager manager, String fileName) {

        try {
            PrintWriter writer = new PrintWriter(fileName);

            for (Employee employee : manager.getEmployees()) {

                writer.println(
                        employee.getEmployeeID() + "," +
                        employee.getFirstName() + "," +
                        employee.getLastName() + "," +
                        employee.getDepartment() + "," +
                        employee.getHourlyRate() + "," +
                        employee.getHoursWorked()
                );
            }

            writer.close();

            System.out.println("Employees saved successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save employee data.");
        }
    }


    public static void loadEmployees(EmployeeManager manager, String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String department = data[3];
                double hourlyRate = Double.parseDouble(data[4]);
                double hoursWorked = Double.parseDouble(data[5]);

                Employee employee = new Employee(
                        id,
                        firstName,
                        lastName,
                        department,
                        hourlyRate,
                        hoursWorked
                );

                manager.addEmployee(employee);
            }

            scanner.close();

            System.out.println("Employees loaded successfully.");

        } catch (Exception e) {
            System.out.println("Unable to load employee data.");
        }
    }
}