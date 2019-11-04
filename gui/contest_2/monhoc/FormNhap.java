package gui.contest_2.monhoc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author VyVu
 */
public class FormNhap extends JFrame{
    private MonHoc mon;
    private JButton saveButton;
    private JPanel input;
    private JTextField tMa;
    private JTextField tTen;
    private DefaultComboBoxModel<String> modelNhom;
    private JComboBox<String> tNhom;
    private JTextField tSTC;

    public FormNhap(MonHoc mon) throws HeadlessException {
        this.mon = mon;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initUI() {
        setTitle("Nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initJP() {
        setLayout(new BorderLayout());
        add(input=new JPanel(new GridLayout(4,2)),BorderLayout.CENTER);
        add(saveButton=new JButton("Lưu file"),BorderLayout.SOUTH);
        input.add(new JLabel("Mã"));
        input.add(tMa=new JTextField(20));
        input.add(new JLabel("Tên môn"));
        input.add(tTen=new JTextField(20));
        input.add(new JLabel("Nhóm"));
        input.add(tNhom=new JComboBox<String>(modelNhom=new DefaultComboBoxModel<String>()));
        input.add(new JLabel("Số tín chỉ"));
        input.add(tSTC=new JTextField(20));
        for (String string : MonHoc.TYPE) {
            modelNhom.addElement(string);
        }
    }

    private void initData() {
        
    }

    private void initEvent() {
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mon=new MonHoc(Integer.parseInt(tMa.getText()), tTen.getText(), modelNhom.getSelectedItem().toString(), Integer.parseInt(tSTC.getText()));
                    writeFile("M.txt");
                } catch (MonHocException ex) {
                    Logger.getLogger(FormNhap.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(new JPanel(), "Dữ liệu không hợp lệ","Cảnh báo",JOptionPane.ERROR_MESSAGE);
                }
                 
            }
        });
    }
    private void writeFile(String file){
        PrintWriter w=null;
        try {
            w = new PrintWriter(new FileWriter(file, true));
            w.write(mon.getMaMon()+"\n"+mon.getTenMon()+"\n"+mon.getNhomMon()+"\n"+mon.getSoTinChi()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(FormNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            w.close();
        }
    }
}
