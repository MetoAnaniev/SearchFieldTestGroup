package HelloWorld;

public class main {
    public static void main(String[] args) {

        Person person = new Person("Dea","woman","orthodox","bulgarian","Kapibara","bulgarian","Bulgaria",8103245060l);

        Italian italian = new Italian("Ciara","female","Catholic","alenatore","Italy",8303101111L);
        Bulgarian bulgarian = new Bulgarian("Metodi","male","orthodox","Sport","Bulgaria",8602170000L);
        American american = new American("Stivan","male","catholic","TAXI driver","USA",6605050000L);
        Child child = new Child("Mila","female","orthodox","bulgarian","Bulgaria","Bulgaria",2012120000L);

        executePersonActions(person);
        System.out.println(" ");
        executePersonActions(italian);
        System.out.println(" ");
        executePersonActions(bulgarian);
        System.out.println(" ");
        executePersonActions(american);
        System.out.println(" ");
        executePersonActions(child);

    }

    private static void executePersonActions(Person person) {
        System.out.println("Execute actions for class " + person.getClass().getSimpleName());
        person.sayHello();
        person.celebrateEaster();
        person.canTakeLoan();
        person.isAdult();
        person.haveJob();
    }
}
