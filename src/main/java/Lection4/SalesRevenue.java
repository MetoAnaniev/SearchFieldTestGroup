package Lection4;

import java.util.Scanner;

public class SalesRevenue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int unitPrize = 0;
        double quantity = 0;
        double finalPrize = 0;
        System.out.println("Enter unit price: ");
        unitPrize = scanner.nextInt();
        System.out.println("Enter quantity: ");
        quantity = scanner.nextDouble();

        finalPrize = unitPrize * quantity;

        double discount1 = finalPrize * 0.15;
        double discount2 = finalPrize * 0.20;
        if (quantity <100){
            System.out.println("The revenue from sale is: "+ finalPrize);
            System.out.println("Discount: 0$");
        } else if (quantity >= 100 && quantity < 120) {
            double revenue = finalPrize - discount1;
            System.out.println("The revenue from sale is: "+ revenue );
            System.out.println("Discount: " + discount1 +"$(15%)");
        } else if (quantity >= 120) {
            double revenue = finalPrize - discount2;
            System.out.println("The revenue from sale is: "+ revenue );
            System.out.println("Discount: " + discount2 +"$(20%)");
        }
    }
}
