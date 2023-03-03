package shapes;

public class Oval extends Shape {

    protected int width = 10;
    protected int height = 5;

    public Oval(int width, int height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("drawing a " + width + "x" + height + " " + color + " oval");
    }
    
}
