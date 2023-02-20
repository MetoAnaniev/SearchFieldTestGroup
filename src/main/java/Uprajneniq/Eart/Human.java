package Uprajneniq.Eart;

public class Human {
    String name;
    int age;
    int heightCm;
    String eyeColor;

    public Human(String name, int age, int heightCm, String eyeColor) {
        this.name = name;
        this.age = age;
        this.heightCm = heightCm;
        this.eyeColor = eyeColor;
    }

    public void speak() {
        System.out.println("Hello My name is "+ name);
        System.out.println("I`m " + heightCm + " centimeters tall");
        System.out.println("I`m " + age + " years old" );
        System.out.println("My eye color is " + eyeColor);
    }
    public void eat (){
        System.out.println("Eating....");
    }
    public void walk(){
        System.out.println("Walking....");
    }
    public void work() {
        System.out.println("Working....");
    }

}
