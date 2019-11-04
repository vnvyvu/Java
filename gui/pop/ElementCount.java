package gui.pop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author VyVu
 */
public class ElementCount extends JFrame{
    private HashMap<String,Integer> map;
    private JButton enterButton;
    private JTextField text;
    private JTextArea area;

    public ElementCount(HashMap<String, Integer> map) throws HeadlessException {
        this.map = map;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initUI() {
        setTitle("Element Count");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initEvent() {
        this.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.clear();
                String key[]=text.getText().split(" ");
                for (String s : key) {
                    if(map.containsKey(s)){
                        map.put(s, map.get(s)+1);
                    }
                    else{
                        map.put(s, 1);
                    }
                }
                map.forEach((t, u) -> {
                    area.append(""+t+" "+u+"\n");
                });
            }
        });
    }

    private void initJP() {
        setLayout(new BorderLayout());
        add(area=new JTextArea(20,20),BorderLayout.SOUTH);
        add(text=new JTextField(20),BorderLayout.CENTER);
        add(enterButton=new JButton("Enter"),BorderLayout.EAST);
    }

    private void initData() {
        
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElementCount(new HashMap<>());
            }
        });
    }
}
