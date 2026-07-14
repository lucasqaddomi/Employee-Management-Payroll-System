import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManager manager = new EmployeeManager();
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {

        FileManager.loadEmployees(manager, FILE_NAME);

        boolean running = true;

        while (running) {

            printMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    removeEmployee();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateHours();
                    break;

                case 5:
                    manager.displayEmployees();
                    break;

                case 6:
                    calculatePayroll();
                    break;

                case 7:
                    FileManager.saveEmployees(manager, FILE_NAME);
                    break;

                case 8:
                    FileManager.saveEmployees(manager, FILE_NAME);
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }


    private static void printMenu() {

        System.out.println("\n==============================");
        System.out.println(" Employee Management System");
        System.out.println("==============================");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Hours");
        System.out.println("5. Display All Employees");
        System.out.println("6. Calculate Payroll");
        System.out.println("7. Save Employees");
        System.out.println("8. Exit");
    }


    private static void addEmployee() {

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (manager.employeeExists(id)) {
            System.out.println("Employee ID already exists.");
            return;
        }

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();

        System.out.print("Hours Worked: ");
        double hoursWorked = scanner.nextDouble();
        scanner.nextLine();


        Employee employee = new Employee(
                id,
                firstName,
                lastName,
                department,
                hourlyRate,
                hoursWorked
        );


        manager.addEmployee(employee);

        System.out.println("Employee added successfully.");
    }


    private static void removeEmployee() {

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (manager.removeEmployee(id)) {
            System.out.println("Employee removed.");
        } 
        else {
            System.out.println("Employee not found.");
        }
    }


    private static void searchEmployee() {

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = manager.findEmployee(id);

        if (employee != null) {
            System.out.println(employee);
        } 
        else {
            System.out.println("Employee not found.");
        }
    }


    private static void updateHours() {

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();

        System.out.print("New Hours Worked: ");
        double hours = scanner.nextDouble();
        scanner.nextLine();


        if (manager.updateHours(id, hours)) {
            System.out.println("Hours updated.");
        } 
        else {
            System.out.println("Employee not found.");
        }
    }


    private static void calculatePayroll() {

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        Employee employee = manager.findEmployee(id);


        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }


        System.out.println("\nPayroll Information");
        System.out.println("-------------------------");

        System.out.println("Name: " + employee.getFullName());

        System.out.printf("Regular Pay: $%.2f%n",
                PayrollCalculator.calculateRegularPay(employee));

        System.out.printf("Overtime Pay: $%.2f%n",
                PayrollCalculator.calculateOvertimePay(employee));

        System.out.printf("Gross Pay: $%.2f%n",
                PayrollCalculator.calculateGrossPay(employee));
    }
}