public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String department;
    private double hourlyRate;
    private double hoursWorked;

    public Employee(int employeeID, String firstName, String lastName,
                    String department, double hourlyRate, double hoursWorked) {

        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%nName: %s %s%nDepartment: %s%nHourly Rate: $%.2f%nHours Worked: %.2f",
                employeeID,
                firstName,
                lastName,
                department,
                hourlyRate,
                hoursWorked
        );
    }
}
