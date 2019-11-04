package gui.contest_2.sinhvien;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VyVu
 */
public class FormNhap extends JFrame{
    private SinhVien sinhVien;
    private DefaultTableModel modelTable;
    private JTable table;
    private JTextField tMa;
    private JTextField tTen;
    private JTextField tLop;
    private JTextField tDTB;
    private JPanel input;
    private JPanel button;
    private JButton saveButton;
    public FormNhap(SinhVien sinhVien) throws HeadlessException {
        initUI();
        initJP();
        this.sinhVien=sinhVien;
        initData();
        initEvent();
        pack();
    }
    public void initUI(){
        setTitle("Nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public void initJP(){
        setLayout(new BorderLayout());
        add(input=new JPanel(new GridLayout(4, 2)), BorderLayout.CENTER);
        add(button=new JPanel(new FlowLayout()), BorderLayout.SOUTH);
        input.add(new JLabel("Mã"));
        input.add(tMa=new JTextField(20));
        input.add(new JLabel("Tên"));
        input.add(tTen=new JTextField(20));
        input.add(new JLabel("Lớp"));
        input.add(tLop=new JTextField(20));
        input.add(new JLabel("ĐiểmTB"));
        input.add(tDTB=new JTextField(20));
        button.add(saveButton=new JButton("Lưu file"));
    }
    public void initData(){
        sinhVien=new SinhVien();
    }
    public void writeFile(String file){
        try {
            PrintWriter out=new PrintWriter(new FileWriter(file, true));
            out.write(sinhVien.getMaSV()+"\n"+sinhVien.getTen()+"\n"+sinhVien.getLop()+"\n"+sinhVien.getDtb()+"\n");
            out.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
    public void initEvent(){
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sinhVien=new SinhVien(Integer.parseInt(tMa.getText()), tTen.getText(), tLop.getText(), Double.parseDouble(tDTB.getText()));
                    writeFile("SV.txt");
                } catch (SinhVienException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Dữ liệu nhập không phù hợp. Tên không được có dấu", "Cảnh báo!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
