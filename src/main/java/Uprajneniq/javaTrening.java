package Uprajneniq;

public class javaTrening {
    public static void main(String[] args) {
        int sum;
        double sumD;

        sumD = calculateSum(5,5.9);
        sum = calculateSum(3,4,7);
    }

    static void checkAge (int age) {

        if (age < 18) {
            System.out.println("Access denied ");
        }else {
            System.out.println("Access granted");
        }
    }
    static double calculateSum(double x, double y){
        return x + y;
    }
    static int calculateSum(int x, int y, int z){
        System.out.println("");
        return x + y + z;
    }
}
