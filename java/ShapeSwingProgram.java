import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.Border;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionEvent;

public class ShapeSwingProgram extends JFrame implements ActionListener {

    private static PaintPanel paintPanel = new PaintPanel();

    public ShapeSwingProgram(String title) {
        super(title);
    }

    public static void main(String[] args) {
        ShapeSwingProgram paintprogram = new ShapeSwingProgram("Shape Dropper Paint Program");
        paintprogram.setSize(800, 600);
        paintprogram.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paintprogram.setLayout(new BorderLayout());        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button1 = new JButton("button1");
        button1.addActionListener(paintprogram);
        buttonPanel.add(button1);
        JButton button2 = new JButton("button2");
        button2.addActionListener(paintprogram);
        buttonPanel.add(button2);
        paintprogram.add(buttonPanel, BorderLayout.PAGE_START);
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
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save", MenuKeyEvent.VK_S);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save As...", MenuKeyEvent.VK_A);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Exit", MenuKeyEvent.VK_X);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);

        //Build our shape menu
        menu = new JMenu("Shape");
        menuItem = new JMenuItem("Rectangle", MenuKeyEvent.VK_R);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Square", MenuKeyEvent.VK_S);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Oval", MenuKeyEvent.VK_O);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Circle", MenuKeyEvent.VK_C);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);
        menuItem = new JMenuItem("Triangle", MenuKeyEvent.VK_T);
        menuItem.addActionListener(paintprogram);
        menu.add(menuItem);

        // Create the color submenu
        menu.addSeparator();        
        submenu = new JMenu("Color");

        // create a group so you can only select one color at a time
        ButtonGroup group = new ButtonGroup();
        menuItem = new JMenuItem("Red", MenuKeyEvent.VK_R);
        menuItem.addActionListener(paintprogram);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Yellow", MenuKeyEvent.VK_Y);
        menuItem.addActionListener(paintprogram);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Green", MenuKeyEvent.VK_G);
        menuItem.addActionListener(paintprogram);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("Black", MenuKeyEvent.VK_B);
        menuItem.addActionListener(paintprogram);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JMenuItem("White", MenuKeyEvent.VK_W);
        menuItem.addActionListener(paintprogram);
        group.add(menuItem);
        submenu.add(menuItem);

        // Turn submenu into an actual submenu by adding it to another menu (specifically, our second menu)
        menu.add(submenu);
        menuBar.add(menu);

        paintPanel.setPreferredSize(new Dimension(500,500));
        paintPanel.setBackground(Color.WHITE);
        paintprogram.getContentPane().add(paintPanel, BorderLayout.CENTER);

        paintprogram.setJMenuBar(menuBar);
        paintprogram.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
//        paintPanel.invalidate();
//        paintPanel.repaint();
        System.out.println(e.getActionCommand());
    }
}
