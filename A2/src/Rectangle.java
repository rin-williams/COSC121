public class Rectangle extends Shape {

    private double width;
    private double height;

    Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        setWidth(width);
        setHeight(height);
    }

    Rectangle() {
        this("White", true, 0, 0);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width * 2) + (height * 2);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWidth: " + width + ", " + "Height: " + height + "\nArea: " + getArea() + ". "
                + "Perimeter: " + getPerimeter() + ". ";
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
