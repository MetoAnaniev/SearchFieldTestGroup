package HelloWorld;

public class Child extends Person{

    public Child(String name, String sex, String religion, String language, String nationality, String country, long egn) {
        super(name,sex,religion,language,null,nationality, country, egn);
    }

    @Override
    public boolean isAdult() {
        System.out.println("This is not an adult, it`s child!");
        return false;
    }

    @Override
    public boolean canTakeLoan() {
        System.out.println("Child can`t take a loan!");
        return false;
    }

    @Override
    public void setJob(String job) {
        throw new IllegalArgumentException("Child can`t get legal job!");
    }
    public void play(String toy) {
        System.out.println("I`m playing with a " + toy);
    }
}
