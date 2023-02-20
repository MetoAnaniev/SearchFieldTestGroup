package HelloWorld;

public class Italian extends Person{

    public Italian(String name, String sex, String religion, String job, String country, long egn){
        super(name, sex, religion, "Italian", job, "Italian", country, egn);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao!");
    }

    //public void eatPasta
}
