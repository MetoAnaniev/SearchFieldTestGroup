package Lection8.Employee;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    double salaryPerMonth;

    public Employee(int id, String firstName, String lastName, double salaryPerMonth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryPerMonth = salaryPerMonth;
    }

    public String getName(){return firstName +" "+lastName;}
    public double raiseSalary(double raisePercent) {
        salaryPerMonth = salaryPerMonth + (salaryPerMonth * (raisePercent/ 100));
        return salaryPerMonth;
    }

    public double getAnnualSalary(){return salaryPerMonth * 12;}

    public String  toString(){
       return "Employee: "+
               " Id: " + id +
               " Name - " + getName() +" "+ '\'' +
               "Salary - " + salaryPerMonth + "лв." + '\'';
    }

}
