import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import shapes.Shape;

public class PaintPanel extends JPanel {
    
    protected ArrayList<Shape> shapes = new ArrayList<>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("painting....");
        g.setColor(Color.RED);
        int w = this.getWidth();
        int h = this.getHeight();
        int eye = 10;
        g.drawOval(10,10,w-20,h-20);

        g.setColor(Color.BLUE);
        g.drawRect(w/2-30,h/3+10,10,10);
        g.drawRect(w/2+20,h/3+10,10,10);
    }

    

}
