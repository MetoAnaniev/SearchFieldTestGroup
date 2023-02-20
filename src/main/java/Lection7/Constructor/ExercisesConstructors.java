package Lection7.Constructor;




public class ExercisesConstructors {
    public static void main(String[] args) {
        Car bmw = new Car("bmw","blue",2020,200,true);
        Car car1 = new Car();
        System.out.println(bmw.color+" "+ bmw.secondHand);
        System.out.println(car1.color+  " " + car1.horsPower);
        Car car2 = new Car("Ford","Red",false);
        Car car3 = new Car("Ferrari","Red",2020,560);
        Car car4 = new Car("Mazda",2012,180,true);

    }
}