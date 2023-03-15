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
        int w = this.getWidth();
        int h = this.getHeight();
        int eye = 30;
        int eyespacing = 30;
        int centerx = w/2;
        int centery = h/2;
        int thirdy = h/3;
        int nose = 40;
        int mouth = 120;

        // draw the face (red)
        g.setColor(Color.RED);
        g.drawOval(10,10,w-20,h-20);

        // draw the eyes (blue rectangles)
        g.setColor(Color.BLUE);
        g.drawRect(centerx-eyespacing-eye,thirdy-eye,eye,eye);
        g.drawRect(centerx+eyespacing,thirdy-eye,eye,eye);

        // draw the nose (purple triangle)
        g.setColor(Color.MAGENTA);
        g.drawLine(centerx, centery, centerx + nose/2, centery + nose/2);
        g.drawLine(centerx + nose/2, centery + nose/2, centerx - nose/2, centery + nose/2);
        g.drawLine(centerx-nose/2, centery+nose/2, centerx, centery);

        // draw the mouth (black oval ... partially hidden)        
        g.setColor(Color.BLACK);
        g.drawOval(centerx-mouth/2, centery + (int) Math.round(nose*2.5), mouth, nose);

        // hide the top part of the mouth to make it look like a smile
        g.setColor(Color.WHITE);
        g.fillRect(centerx-mouth/2, centery + (int) Math.round(nose*2), mouth, 40);
    }  

}
