/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contest_2.mathang;

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
    private MatHang mH;
    private JPanel inputLayout;
    private JButton saveButton;
    private JTextField tMa;
    private JTextField tTen;
    private DefaultComboBoxModel<String> modelCombo;
    private JComboBox<String> tNhom;
    private JTextField tGia;

    public FormNhap(MatHang mH) throws HeadlessException {
        this.mH = mH;
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
        add(inputLayout=new JPanel(new GridLayout(4, 2)),BorderLayout.CENTER);
        add(saveButton=new JButton("Lưu file"),BorderLayout.SOUTH);
        inputLayout.add(new JLabel("Mã"));
        inputLayout.add(tMa=new JTextField(20));
        inputLayout.add(new JLabel("Tên"));
        inputLayout.add(tTen=new JTextField(20));
        inputLayout.add(new JLabel("Nhóm"));
        inputLayout.add(tNhom=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<String>()));
        inputLayout.add(new JLabel("Giá"));
        inputLayout.add(tGia=new JTextField(20));
        
    }

    private void initData() {
        
        for (String string : MatHang.TYPE) {
            modelCombo.addElement(string);
        }
        
    }

    private void initEvent() {
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mH=new MatHang(Integer.parseInt(tMa.getText()), tTen.getText(), modelCombo.getSelectedItem().toString(), Double.parseDouble(tGia.getText()));
                    writeFile("MH.txt");
                } catch (MatHangException ex) {
                    JOptionPane.showMessageDialog(new JPanel(), "Dữ liệu không hợp lệ","Cảnh báo",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void writeFile(String file){
        PrintWriter w=null;
        try {
            w = new PrintWriter(new FileWriter(file,true));
            w.write(""+mH.getMaHang()+"\n"+mH.getTen()+"\n"+mH.getNhom()+"\n"+mH.getGia()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(FormNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            w.close();
        }
    }
}
