package gui.contest_2.sach;

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
    private Sach sach;
    private JPanel input;
    private JButton saveButton;
    private JTextField tMa;
    private JTextField tTen;
    private DefaultComboBoxModel<String> modelCombo;
    private JTextField tGia;
    private JComboBox<String> tCN;

    public FormNhap(Sach sach) throws HeadlessException {
        this.sach = sach;
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
        add(input=new JPanel(new GridLayout(4, 2)),BorderLayout.CENTER);
        add(saveButton=new JButton("Lưu file"),BorderLayout.SOUTH);
        input.add(new JLabel("Mã"));
        input.add(tMa=new JTextField(20));
        input.add(new JLabel("Tên"));
        input.add(tTen=new JTextField(20));
        input.add(new JLabel("Chuyên ngành"));
        input.add(tCN=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<String>()));
        input.add(new JLabel("Giá"));
        input.add(tGia=new JTextField(20));
    }

    private void initData() {
        for (String string : Sach.TYPE) {
            this.modelCombo.addElement(string);
        }
    }

    private void initEvent() {
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sach=new Sach(Integer.parseInt(tMa.getText()), tTen.getText(), modelCombo.getSelectedItem().toString(), Double.parseDouble(tGia.getText()));
                    writeFile("Sach.txt");
                } catch (SachException ex) {
                    JOptionPane.showMessageDialog(new JPanel(), "Dữ liệu không hợp lệ", "Lỗi",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    public void writeFile(String file){
        PrintWriter w=null;
        try {
            w = new PrintWriter(new FileWriter(file, true));
            w.write(sach.getMaSach()+"\n"+sach.getTenSach()+"\n"+sach.getChuyenNganh()+"\n"+sach.getGiaBan()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(FormNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            w.close();
        }
    }
}
