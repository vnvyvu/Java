package gui.colorselect;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author VyVu
 */
public class ListChooser extends JFrame{
    private HashMap<String, Color> color= new HashMap<String, Color>();

    public ListChooser() throws HeadlessException {
        initUI();
        initJX();
    }
    public void initUI() {
        setTitle("ListColor");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
    }
    public void initJX(){
        setLayout(new FlowLayout());
        color.put("BLUE", Color.blue);
        color.put("RED", Color.red);
        color.put("GREEN", Color.green);
        color.put("BLACK", Color.black);
        color.put("GRAY", Color.GRAY);
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list =new JList<>(model);
        color.forEach((t, u) -> {
            model.addElement(t);    
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    getContentPane().setBackground(color.get(list.getSelectedValue()));
                }
            });
        });
        add(list);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListChooser lc=new ListChooser();
                lc.pack();
                lc.setVisible(true);
            }
        });
    }

}
