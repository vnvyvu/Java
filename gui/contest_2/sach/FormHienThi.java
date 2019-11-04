package gui.contest_2.sach;

import java.awt.BorderLayout;
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
    private LinkedList<Sach> list;
    private JTable table;
    private DefaultTableModel modelTable;

    public FormHienThi(LinkedList<Sach> list) throws HeadlessException {
        this.list = list;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initEvent() {
        
    }

    private void initData() {
        readFile("Sach.txt");
        for (Sach sach : list) {
            String row[]={""+sach.getMaSach(),sach.getTenSach(),sach.getChuyenNganh(),""+sach.getGiaBan()};
            modelTable.addRow(row);
        }
    }

    private void initJP() {
        setLayout(new FlowLayout());
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String string : Sach.FIELD) {
            modelTable.addColumn(string);
        }
    }

    private void initUI() {
        setTitle("Hiển thị");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public void readFile(String file){
        try {
            Scanner r=new Scanner(new File(file));
            while(r.hasNextLine()){
                list.add(new Sach(Integer.parseInt(r.nextLine()), r.nextLine(), r.nextLine(), Double.parseDouble(r.nextLine())));
                
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormSapXep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SachException ex) {
            Logger.getLogger(FormSapXep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
