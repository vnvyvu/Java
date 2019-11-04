package gui.contest_2.mathang;

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
    LinkedList<MatHang> list;
    private DefaultTableModel modelTable;
    private JTable table;

    public FormHienThi(LinkedList<MatHang> list) throws HeadlessException {
        this.list = list;
        initUI();
        initJP();
        initData();
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
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String f : MatHang.FIELD_MH) {
            modelTable.addColumn(f);
        }
    }
    public void initData(){
        readFile("MH.txt");
        for (MatHang m : list) {
            String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGiaBan()};
            this.modelTable.addRow(row);
        }
    }
    public void readFile(String file){
        try {
            Scanner in=new Scanner(new File(file));
            while(in.hasNextLine()){
                this.list.add(new MatHang(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            }
            in.close();
        } catch (FileNotFoundException ex) {
        } catch (MatHangException ex) {
        }
    }
}
