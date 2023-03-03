package shapes;

public class Rectangle extends Shape {

    protected int width  = 10; // default width is 10
    protected int height = 5;  // default height is 5

    public Rectangle() {
        // nothing to do, but required by java!
    }

    public Rectangle(int width, int height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("drawing a " + width + "x" + height + " " + color + " rectangle");
    }
    
}
