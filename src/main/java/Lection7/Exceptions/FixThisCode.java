package Lection7.Exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FixThisCode {

    private static FileWriter getFileWriter(String filePath){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileWriter;
    }

    public static void closeFileWriter(FileWriter fileWriter){
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printToFile(FileWriter fileWriter, String text, int repeat){
        for (int i = 1; i < repeat; i++) {
            try {
                fileWriter.write(text + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        int howManyTimesToPrintTheTextToFile = scanner.nextInt();
        scanner.nextLine();
        String textToAdd = scanner.nextLine();
        printToFile(getFileWriter(filePath),textToAdd,howManyTimesToPrintTheTextToFile);

    }
}
