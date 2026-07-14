import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees;


    public EmployeeManager() {
        employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


    public boolean employeeExists(int employeeID) {
        return findEmployee(employeeID) != null;
    }


    public Employee findEmployee(int employeeID) {

        for (Employee employee : employees) {

            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }

        return null;
    }


    public boolean removeEmployee(int employeeID) {

        Employee employee = findEmployee(employeeID);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }


    public boolean updateHours(int employeeID, double hoursWorked) {

        Employee employee = findEmployee(employeeID);

        if (employee != null) {
            employee.setHoursWorked(hoursWorked);
            return true;
        }

        return false;
    }


    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("----------------------------");
            System.out.println(employee);
        }

    }


    public ArrayList<Employee> getEmployees() {
        return employees;
    }



}