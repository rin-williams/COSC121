public class Hexagon extends Shape {

    private double length;

    Hexagon() {
        this("White", true, 0);

    }

    Hexagon(String color, boolean filled, double length) {
        super(color, filled);
        setLength(length);
    }

    @Override
    public double getArea() {
        return ((3 * Math.sqrt(3)) * (Math.pow(getLength(), 2))) / 2;
    }

    @Override
    public double getPerimeter() {
        return length * 6;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLength: " + length + ". " + "\nArea: " + getArea() + ". " + "\nPerimeter: "
                + getPerimeter()
                + ". ";
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
