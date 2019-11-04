package gui.colorselect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author VyVu
 */
public class ComboBoxChooser extends JFrame{
    HashMap<String,Color> color=new HashMap<>();

    public ComboBoxChooser() throws HeadlessException {
        initUI();
        initFX();
    }
    public void initUI(){
        setTitle("ComboBoxChooser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
    }
    public void initFX(){
        setLayout(new BorderLayout());
        color.put("BLUE", Color.blue);
        color.put("RED", Color.red);
        color.put("GREEN", Color.green);
        color.put("BLACK", Color.black);
        color.put("GRAY", Color.GRAY);
        DefaultComboBoxModel<String> model=new DefaultComboBoxModel<>();
        JComboBox<String> combo=new JComboBox<>(model);
        combo.addItem("DEFAULT");
        color.forEach((t, u) -> {
            model.addElement(t);
            combo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getContentPane().setBackground(color.get(combo.getSelectedItem()));
                }
            });
        });
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(combo);
        add(frame.getContentPane(),BorderLayout.NORTH);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComboBoxChooser cb=new ComboBoxChooser();
                cb.pack();
                cb.setVisible(true);
            }
        });
    }
}
