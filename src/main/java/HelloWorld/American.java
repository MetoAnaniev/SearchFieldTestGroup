package HelloWorld;

public class American extends Person{

    public American(String name, String sex, String religion, String job, String country, long egn){
        super(name, sex, religion,"English", job, "American", country,egn);
    }

    public void eatBurger() {
        System.out.println("We love to eat fast food (and to be fat :) ). Most of all Burgers!");
    }
}
