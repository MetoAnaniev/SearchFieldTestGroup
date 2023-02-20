package Uprajneniq.Pets;

public class Dog {
    String name;
    int age;
    String breed;
    String color;

    public Dog(String name, int age, String breed, String color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    public void bark(){
        System.out.println("Waf-Waf-grrrr");
    }
    public void eat (){
        System.out.println("Eat meat");
    }
    public void sleep (){
        System.out.println("Sleep during night");
    }

}
