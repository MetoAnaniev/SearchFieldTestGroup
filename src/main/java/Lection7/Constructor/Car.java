package Lection7.Constructor;

public class Car {
    String name = "N/A";
    String color = "N/A";
    int releaseYear = -1;
    int horsPower = -1;
    boolean secondHand = false;






    public Car(String name, String color, int releaseYear, int horsPower, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsPower = horsPower;
        this.secondHand = secondHand;
    }

    public Car(String name, String color, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.secondHand = secondHand;
    }

    public Car(String name, String color, int releaseYear, int horsPower) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsPower = horsPower;
    }

    public Car(String name, int releaseYear, int horsPower, boolean secondHand) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.horsPower = horsPower;
        this.secondHand = secondHand;
    }

    public Car() {

    }

}
