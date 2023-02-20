package Lection8.Employee;

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee(1,"Metodi","Ananiev",2000);
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);

        double raiseSalary = employee.raiseSalary(-5);
        annualSalary = employee.getAnnualSalary();
        System.out.println(employee);


    }
}
