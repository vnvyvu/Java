/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contest_2.mathang;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VyVu
 */
public class FormHienThi extends JFrame{
    private LinkedList<MatHang> list;
    private JTable table;
    private DefaultTableModel modelTable;

    public FormHienThi(LinkedList<MatHang> list) throws HeadlessException {
        this.list = list;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initUI() {
        setTitle("Hiển thị");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initJP() {
        setLayout(new FlowLayout());
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String string : MatHang.FIELD) {
            modelTable.addColumn(string);
        }
    }

    private void initData() {
        readFile("MH.txt");
        for (MatHang m : list) {
            String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGia()};
            modelTable.addRow(row);
        }
    }

    private void initEvent() {
        
    }
    private void readFile(String file){
        try {
            Scanner in=new Scanner(new File(file));
            while(in.hasNextLine()){
                list.add(new MatHang(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormSapXep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MatHangException ex) {
            Logger.getLogger(FormSapXep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
