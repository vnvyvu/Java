package gui.colorselect;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author VyVu
 */
public class ColorChooser extends JFrame{

    private HashMap<String, Color> color=new HashMap<>();
    public ColorChooser() throws HeadlessException {
        initUI();
        initJX();
    }
    public void initUI(){
        setTitle("ColorSelect");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initJX(){
        setLayout(new BorderLayout());
        JButton set=new JButton("Set");
        color.put("BLUE", Color.blue);
        color.put("RED", Color.red);
        color.put("GREEN", Color.green);
        color.put("BLACK", Color.black);
        color.put("GRAY", Color.GRAY);
        JFrame f=new JFrame("");
        f.setLayout(new FlowLayout());
        color.forEach((t, u) -> {
            JButton box=new JButton(t);
            f.add(box);
            box.addActionListener((e) -> {
                getContentPane().setBackground(u);
            });
        });
        add(f.getContentPane(),BorderLayout.NORTH);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorChooser c=new ColorChooser();
                c.pack();
                c.setVisible(true);
            }
        });
    }
}
