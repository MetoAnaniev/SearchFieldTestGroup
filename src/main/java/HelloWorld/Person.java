package HelloWorld;


import java.time.LocalDate;

public class Person {
    private String name;
    private String sex;
    private String religion;
    private String language;
    private String job;
    private String nationality;
    private String dateOfBirth;
    private String country;
    private long egn;
    private int age;

    public Person(String name, String sex, String religion, String language, String job, String nationality, String country, long egn) {
        this.name = name;
        this.religion = religion;
        this.language = language;
        this.job = job;
        this.nationality = nationality;
        this.country = country;
        setEgn(egn);
        setAge(egn);
        setDateOfBirth(egn);
        setSex(sex);
    }

    private void setAge(long egn) {
       int currentYear = LocalDate.now().getYear();
       String birthYear = "19" +  Long.toString(egn).substring(0,2);
       ;
        this.age = currentYear -Integer.parseInt(birthYear);
    }
    private void setDateOfBirth(long egn) {
        String date = Long.toString(egn).substring(4,6);
        String month = Long.toString(egn).substring(2,4);
        this.dateOfBirth = month + "-" + date;
    }
    private void setEgn(long egn){
        int egnLength = Long.toString(egn).length();
        if (egnLength== 10) {
            this.egn = egn;
        } else {
            throw new RuntimeException("The EGN you provide is not valid. EGN must be 10 digits! ");
        }
    }

    private void validateSex(String sex) throws Exception {
        String male = "Male";
        String female = "Female";

        if (!sex.equalsIgnoreCase(male) && !sex.equalsIgnoreCase(female)){
            throw new Exception("Please enter a valid value of sex!");
        }
    }

    private void  setSex(String sex) {
        try {
            validateSex(sex);
            this.sex = sex;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sayHello(){System.out.println("Hello!");}

    public void celebrateEaster() {
        if (religion.equalsIgnoreCase("orthodox") || religion.equalsIgnoreCase("catholic")) {
            System.out.println("I`m celebrating Easter");
        } else {
            System.out.println("I`m not celebrating Easter");
        }
    }
    public void haveJob(){
        System.out.println("Is working like a " + job);}

    public void setJob(String job) { this.job = job; }
    public boolean canTakeLoan() {return job != null;}

    public void setCountry(String country) {this.country = country;}

    public boolean isAdult(){
        switch (country) {
            case "Bulgaria":
            case "Italy":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("Insufficient information about " + country);
        }
    }
}

