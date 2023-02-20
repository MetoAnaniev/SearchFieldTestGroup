package Uprajneniq.Pets;

public class Pets {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Brady",3,"Terrier","Brown");
        Dog dog2 = new Dog("Roshko", 5,"Pudel","Black");
        System.out.println(dog2.name);
        dog2.sleep();
        dog1.bark();
        Cat cat1 = new Cat();
        System.out.println(cat1.name);
        cat1.name = "Pisana";
        System.out.println("Сменяме името на котката:");
        System.out.println(cat1.name);
        System.out.println(dog2.breed);
        cat1.eat();
        cat1.bark();
    }
}
