package shapes;

public class Square extends Rectangle {

    public Square(int sidelength, String color) {
        super(sidelength, sidelength, color);
    }

    @Override
    public void draw() {
        System.out.println("drawing a " + width + "x" + height + " " + color + " square");
    }
    
}
