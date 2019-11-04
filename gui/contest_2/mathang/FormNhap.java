package gui.contest_2.mathang;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

/**
 *
 * @author VyVu
 */
public class FormNhap extends JFrame{
    private MatHang matHang;
    private JButton saveFile;
    private JPanel input;
    private JTextField tMa;
    private JTextField tTen;
    private JComboBox tNhom;
    private JTextField tGia;
    private DefaultComboBoxModel<String> modelCombo;

    public FormNhap(MatHang matHang) throws HeadlessException {
        this.matHang = matHang;
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
        add(saveFile=new JButton("Lưu file"),BorderLayout.SOUTH);
        add(input=new JPanel(new GridLayout(4, 2)),BorderLayout.CENTER);
        this.input.add(new JLabel("Mã"));
        this.input.add(tMa=new JTextField(20));
        this.input.add(new JLabel("Tên"));
        this.input.add(tTen=new JTextField(20));
        this.input.add(new JLabel("Nhóm"));
        this.input.add(tNhom=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<>(MatHang.TYPE)));
        this.input.add(new JLabel("Giá"));
        this.input.add(tGia=new JTextField(20));
    }

    private void initData() {
        
    }

    private void initEvent() {
        this.saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    matHang=new MatHang(Integer.parseInt(tMa.getText()), tTen.getText(), modelCombo.getSelectedItem().toString(), Double.parseDouble(tGia.getText()));
                    writeFile("MH.txt");
                } catch (MatHangException ex) {
                    JOptionPane.showMessageDialog(new JPanel(), "Dữ liệu không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void writeFile(String file){
        PrintWriter w=null;
        try {
            w = new PrintWriter(new FileWriter(file, true));
            w.write(this.matHang.getMaHang()+"\n"+this.matHang.getTen()+"\n"+this.matHang.getNhom()+"\n"+this.matHang.getGiaBan()+"\n");
        } catch (IOException ex) {
        } finally {
            w.close();
        }
    }
}
