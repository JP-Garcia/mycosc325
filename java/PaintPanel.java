import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import shapes.*;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener, ComponentListener, Serializable {
    
    protected enum ShapeType {
        RECTANGLE, SQUARE, TRIANGLE, CUSTOM_TRIANGLE, OVAL, CIRCLE
    }
    

    protected ArrayList<Shape> shapes = new ArrayList<>();
    protected ShapeType currentShape = ShapeType.TRIANGLE;
    protected String currentColor = "#ff0000";

    public PaintPanel() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

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
        g.drawOval(centerx-mouth/2, h-thirdy, mouth, nose);

        // hide the top part of the mouth to make it look like a smile
        g.setColor(Color.WHITE);
        g.fillRect(centerx-mouth/2, h-thirdy-20, mouth, 40);


        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public void clearLastShape() {
        int size = shapes.size();
        if(size > 0) {
            shapes.remove(size - 1);
        }
        repaint();
    }

    Boolean firstShape = true;
    int initx = 0;
    int inity = 0;

    public int calculateSideLenght(int width, int height) {
        if (Math.abs(width) > Math.abs(height)) {
            return width;
        }
        return height;
    }

    int[] coord = {0, 0, 0, 0, 0, 0};
    int indexT = 1;
    public int exit;
    public void triangleTracker(int x, int y) {
        if (indexT == 1){
            coord[0] = x;
            coord[1] = y;
        }
        else if (indexT == 2){
            coord[2] = x;
            coord[3] = y;
        }
        else if (indexT == 3){
            coord[4] = x;
            coord[5] = y;
            for (int i = 0; i < coord.length; i++) {
                System.out.print(" " + coord[i]);
            }
        }
        else System.out.println("Error, index out of bounds");
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        // handled in mouseClicked
        System.out.println("MousePressed");
        initx = e.getX();
        inity = e.getY();
        firstShape = true;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { // Comments idicade how shape is placed in relation to mouse
        // int mousex = e.getX();
        // int mousey = e.getY();
        int width = 40;
        int height = 20;
        int midw = width / 2;
        int midh = height / 2;
        int sidelength = calculateSideLenght(width, height);
        Shape s;
        if (currentShape == ShapeType.RECTANGLE) {
            s = new Rectangle(initx, inity, width, height, currentColor); // Top-left
        }
        else if (currentShape == ShapeType.SQUARE) {
            s = new Square(initx, inity, width, height, currentColor); // Top-left
        } 
        else if (currentShape == ShapeType.OVAL) {
            s = new Oval(initx, inity, width, height, currentColor); // Middle
        } 
        else if (currentShape == ShapeType.CIRCLE) {
            s = new Circle(initx - sidelength, inity - sidelength, sidelength, currentColor); // Middle
        } 
        else if (currentShape == ShapeType.TRIANGLE) {
            s = new Triangle(initx - width, inity + height, initx, inity - height, initx + width, inity + height, currentColor); // Middle
        }
        else if (currentShape == ShapeType.CUSTOM_TRIANGLE) {
            if (indexT <= 3) {
                triangleTracker(initx, inity);
                System.out.println("Got coord "+ indexT);
                s = new Rectangle(initx - 1, inity - 1, 3, 3, currentColor);
                if (indexT == 3) {
                    clearLastShape();
                    clearLastShape();
                    s = new Triangle(coord[0], coord[1], coord[2], coord[3], coord[4], coord[5], currentColor); // Middle
                    indexT = 0;
                }
                indexT++;
            }
            else {
                System.out.println("Error, index out of bounds");
                s = new Rectangle(initx - 4, inity - 4, 9, 9, currentColor);
                // indexT = 0;
            }
        }
        else s = new Rectangle(initx, inity, width, height, currentColor);
        shapes.add(s);
        s.draw(getGraphics());
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // handled in mouseClicked
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // ignored
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // ignored
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // int screenW = this.getWidth();
        // int screenH = this.getHeight();
        System.out.println("mouseDragged");
        int mousex = e.getX();
        int mousey = e.getY();
        int width = mousex - initx;
        int height = mousey - inity;
        int midw = width / 2;
        int midh = height / 2;
        int sidelength = calculateSideLenght(width, height);
        System.out.println(mousex + " " + mousey);

        if (firstShape == true) {
            System.out.println("firstShape");
            firstShape = false;
        }
        else {
            System.out.print("looping");
            clearLastShape();
        }
        Shape s;
        if (currentShape == ShapeType.RECTANGLE) {
            s = new Rectangle(initx, inity, width, height, currentColor); // Top-left
        }
        else if (currentShape == ShapeType.SQUARE) {
            s = new Square(initx, inity, width, height, currentColor); // Top-right
        } 
        else if (currentShape == ShapeType.OVAL) {
            s = new Oval(initx - width, inity - height, width * 2, height * 2, currentColor); // Middle
        } 
        else if (currentShape == ShapeType.CIRCLE){
            s = new Circle(initx - sidelength, inity - sidelength, sidelength, currentColor); // Middle
        }  
        else if ((currentShape == ShapeType.TRIANGLE) || (currentShape == ShapeType.CUSTOM_TRIANGLE)) {
            s = new Triangle(initx - width, inity + height, initx, inity - height, initx + width, inity + height, currentColor); // Middle
        }
        else s = new Rectangle(initx, inity, width, height, currentColor);
        shapes.add(s);
        s.draw(getGraphics());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Ignored  b  
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // For loop to change width + height, manually call repaint?
        // repaint();
        // System.out.println("manually repainted");
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub
    }  
}
