package Lection8.Shape;

public class main {
    public static void main(String[] args) {
        Circle s1 = new Circle();
        System.out.println(s1.getArea(3.0));
        System.out.println(s1);
        System.out.println("");

        Shape s2 = new Circle();
        System.out.println(s2.getArea(3.0));
        System.out.println(s2);

        System.out.println(" ");

        Circle s3 = (Circle) s2;
        System.out.println(s3);
        System.out.println(s2.getPerimeter(3.0));
        System.out.println(" ");

        Square s4 = new Square();
        System.out.println(s4.getPerimeter(25.4));
        System.out.println(" ");
        Square s5 = new Square();
        System.out.println(s5.getArea(6.0));
        System.out.println(s5.getPerimeter(6.0));
    }
}
