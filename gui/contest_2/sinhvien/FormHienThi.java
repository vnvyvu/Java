package gui.contest_2.sinhvien;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VyVu
 */
public class FormHienThi extends JFrame{
    private LinkedList<SinhVien> list;
    private DefaultTableModel modelTable;
    private JTable table;
    public FormHienThi(LinkedList<SinhVien> list) throws HeadlessException {
        initUI();
        initJP();
        this.list=list;
        initData();
        initEvent();
        pack();
    }
    public void initUI(){
        setTitle("Hiển thị");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public void initJP(){
        setLayout(new FlowLayout());
        modelTable=new DefaultTableModel();
        add(new JScrollPane(table=new JTable(modelTable),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String s : SinhVien.FIELD_SV) {
            modelTable.addColumn(s);
        }
    }
    public void initData(){
        list=new LinkedList<>();
        readFile("SV.txt");
        table.setLayout(new FlowLayout());
        for (SinhVien sv : list) {
            String row[]={""+sv.getMaSV(),sv.getTen(),sv.getLop(),""+sv.getDtb()};
            modelTable.addRow(row);
        }
    }
    public void readFile(String file){
        try {
            Scanner in=new Scanner(new File("SV.txt"));
            while(in.hasNextLine()){
                list.add(new SinhVien(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            }
            in.close();
        } catch (FileNotFoundException ex) {
        } catch (SinhVienException ex) {
        }
    }
    public void initEvent(){
        
    }
    public static void main(String[] args) {
        FormHienThi v=new FormHienThi(new LinkedList<>());
    }
}
