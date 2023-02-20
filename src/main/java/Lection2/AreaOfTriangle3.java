package Lection2;

import java.util.Scanner;

public class AreaOfTriangle3 {


        public static void main(String[] args)
        {

            Scanner s1= new Scanner(System.in);

            System.out.println("Enter the 1st side:");
            int a= s1.nextInt();

            System.out.println("Enter the 2nd side:");
            int b= s1.nextInt();

            System.out.println("Enter the 3rd side:");
            int c= s1.nextInt();
            if((a+b)>c && (a+c)>b && (b+c)>a)
            {
                int s=(a+b+c)/2;
                double  area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
                System.out.println("Area of Triangle is: " + area);
            }
            else
                System.out.println("Area of Triangle not exit");
        }
    }

