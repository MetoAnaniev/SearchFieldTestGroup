package Lection5;

import java.util.Comparator;
import java.util.LinkedList;

public class reverceSortArrList {
    public static void main(String[] args) {
        LinkedList<String> Sweets = new LinkedList<>();
        Sweets.add("Cake");
        Sweets.add("Muffin");
        Sweets.add("Candy");
        Sweets.add("Tart");
        Sweets.sort(Comparator.reverseOrder());

        System.out.println(Sweets);
    }
}
