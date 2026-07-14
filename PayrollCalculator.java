public class PayrollCalculator {
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double REGULAR_HOURS = 40.0;

    // Calculate regular pay
    public static double calculateRegularPay(Employee employee) {

        double regularHours = Math.min(employee.getHoursWorked(), REGULAR_HOURS);

        return regularHours * employee.getHourlyRate();
    }

    // Calculate overtime pay
    public static double calculateOvertimePay(Employee employee) {

        if (employee.getHoursWorked() <= REGULAR_HOURS) {
            return 0;
        }

        double overtimeHours = employee.getHoursWorked() - REGULAR_HOURS;

        return overtimeHours * employee.getHourlyRate() * OVERTIME_MULTIPLIER;
    }

    // Calculate total gross pay
    public static double calculateGrossPay(Employee employee) {

        return calculateRegularPay(employee) + calculateOvertimePay(employee);
    }
}
