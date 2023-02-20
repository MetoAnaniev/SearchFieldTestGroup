package Lection6;

public class Lection6 {

    public static void main(String[] args) {

       midString("Metodi e s golqm krak.");

        //return count;

    }

    public static Double WhatIsSmallestNumber(Double numA, Double numB,Double numC){
        double smallestNumber = numA;
        if (smallestNumber > numB){
            smallestNumber = numB;
        }
        if (smallestNumber> numC){
            smallestNumber = numC;
        }
        return smallestNumber;
    }

    public static int computeAverageOfTreeN(int a,int b, int c){

        int average = (a + b + c)/3;
        return average;
    }

    public static boolean isEven(int even){
      return even % 2 == 0;}

    public static String midString (String text){
        int count = text.length() - text.replace(".", "").length();
       // for (int i = 0; i < ; i++) {

        //}
        return text;
    }
}
