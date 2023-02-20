package Lection5;


public class SumOfDiagonalMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int sumOfDiag = arr[0][0] + arr[1][1] + arr[2][2] + arr[3][3];
        System.out.println(sumOfDiag);
    }
}
