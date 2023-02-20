package Lection8.Shape;

public class Square extends Shape {

    @Override
    public Double getPerimeter(Double side) {
        Double totalPerimeter = side * side;
        return totalPerimeter;
    }

    @Override
    public Double getArea(Double side) {
        Double totalArea = 4* side;
        return totalArea;
    }
}
