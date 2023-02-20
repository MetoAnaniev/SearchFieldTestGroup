package Uprajneniq.Zoo;

public class Animal {
    String typeOfAnimal;
    String gender;
    int age;
    double weight;
    String color;
    String habitat;

    public Animal(String typeOfAnimal, String gender, int age, double weight, String habitat) {
        this.typeOfAnimal = typeOfAnimal;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }


    public void eat() {

        System.out.println(typeOfAnimal + " eat");
    }
    public void sleep(){
        System.out.println(typeOfAnimal + " sleep...");
    }
    public void walk(){
        System.out.println(typeOfAnimal+ " is walking and running");
    }
}
