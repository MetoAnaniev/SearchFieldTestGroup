package Lection4;

import java.util.Scanner;

public class DaysOfTheWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();

        switch (days) {
            case 1:
                System.out.println("The " + days +" day of the week is Monday");
                break;
            case 2:
                System.out.println("The 2-st day of the week is Tuesday");
                break;
            case 3:
                System.out.println("The 3-st day of the week is Wednesday ");
                break;
            case 4:
                System.out.println("The 4-st day of the week is Thursday");
                break;
            case 5:
                System.out.println("The 5-th day of the week is Friday");
                break;
            case 6:
                System.out.println("The 6-st day of the week is Saturday");
                break;
            case 7:
                System.out.println("The 7-st day of the week is Sunday");
                break;
            default:
                System.out.println(days + "is invalid day of the week!");
        }

        }
    }

