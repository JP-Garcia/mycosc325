import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionEvent;

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
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("File");
        menu.setMnemonic(MenuKeyEvent.VK_F);
        menuBar.add(menu);

        //a group of file-related menu items 
        menuItem = new JMenuItem("Open", MenuKeyEvent.VK_O);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save", MenuKeyEvent.VK_S);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save As...", MenuKeyEvent.VK_A);
        menu.add(menuItem);
        menuItem = new JMenuItem("Exit", MenuKeyEvent.VK_X);
        menu.add(menuItem);

        //Build our shape menu
        menu = new JMenu("Shape");
        menuItem = new JMenuItem("Rectangle", MenuKeyEvent.VK_R);
        menu.add(menuItem);
        menuItem = new JMenuItem("Square", MenuKeyEvent.VK_S);
        menu.add(menuItem);
        menuItem = new JMenuItem("Oval", MenuKeyEvent.VK_O);
        menu.add(menuItem);
        menuItem = new JMenuItem("Circle", MenuKeyEvent.VK_C);
        menu.add(menuItem);
        menuItem = new JMenuItem("Triangle", MenuKeyEvent.VK_T);
        menu.add(menuItem);

        // Create the color submenu
        menu.addSeparator();        
        submenu = new JMenu("Color");

        // create a group so you can only select one color at a time
        ButtonGroup group = new ButtonGroup();
        menuItem = new JMenuItem("Red", MenuKeyEvent.VK_R);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Yellow", MenuKeyEvent.VK_Y);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Green", MenuKeyEvent.VK_G);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Black", MenuKeyEvent.VK_B);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("White", MenuKeyEvent.VK_W);
        group.add(menuItem);
        submenu.add(menuItem);

        // Turn submenu into an actual submenu by adding it to another menu (specifically, our second menu)
        menu.add(submenu);
        menuBar.add(menu);

        paintprogram.setJMenuBar(menuBar);
        paintprogram.setVisible(true);
    }
}
