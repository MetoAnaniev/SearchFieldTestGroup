package Lection5;

public class BiggestArray {
    public static void main(String[] args) {
        String[] animalNames = {"cat", "rabbit", "horse", "goat", "rooster", "ooooooooooooooo"};
        String a = getLongestString(animalNames);
        System.out.println(a);
    }
    public static String getLongestString(String []animalNames) {
        //  String animalNames[] =  {"cat","chicken","horse","ooooooooo" };

        int j = 0;
        for (j = 0; j <= animalNames.length; j++) {
            if (animalNames[j].length() > animalNames[j + 1].length()) {
                return (animalNames[j]);
            }
        }
        return null;
    }
}



