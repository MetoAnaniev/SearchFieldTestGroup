package Lection8.Shape;

public class Circle extends Shape {
    @Override
    public Double getArea(Double radius) {
        Double area = (radius * radius) * Math.PI;
        return area;
    }

    @Override
    public Double getPerimeter(Double radius) {
        Double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
