public class Rectangle {
    int length, breadth;

    public Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    int area() {
        return length * breadth;
    }

    int area(int l, int b) {
        return l * b;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3);
        System.out.println("Area using object: " + r1.area());
        System.out.println("Area using method with parameters: " + r1.area(7, 4));
    }
}