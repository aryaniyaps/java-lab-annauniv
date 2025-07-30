class Shape {
    public double area() {
        return 0;
    }
}


class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

public class ShapeMain {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.area());
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        printArea(s1);
        printArea(s2);
    }
}
