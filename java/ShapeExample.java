import shapes.*;
import java.util.ArrayList;

public class ShapeExample {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>(); 
        shapes.add(new Rectangle(25, 5, "red"));
        shapes.add(new Oval(15, 5, "red"));
        shapes.add(new Rectangle(8, 5, "red"));
        shapes.add(new Rectangle(3, 4, "green"));
        shapes.add(new Square(10, "blue"));
        shapes.add(new Triangle(1, 1, 4, 2, 3, 3, "yellow"));
        for (Shape s : shapes) {
            s.draw(); // polymorphism! we have one line of code here that can call many different draw() methods depending on the specific shape s.
        }
    }  
}
