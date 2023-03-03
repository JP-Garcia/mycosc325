import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class ShapeSwingProgram extends JFrame {

    public ShapeSwingProgram(String title) {
        super(title);
    }

    public static void main(String[] args) {
        ShapeSwingProgram paintprogram = new ShapeSwingProgram("Shape Dropper Paint Program");
        paintprogram.setSize(800, 600);
        paintprogram.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paintprogram.setLayout(new FlowLayout());
        paintprogram.add(new JButton("button1"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.add(new JButton("button2"));
        paintprogram.setVisible(true);
    }
}
