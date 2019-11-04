package gui.contest_2.monhoc;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    private LinkedList<MonHoc> list;
    private DefaultTableModel modelTable;
    private JTable table;

    public FormHienThi(LinkedList<MonHoc> list) throws HeadlessException {
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
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String string : MonHoc.FIELD) {
            modelTable.addColumn(string);
        }
        
    }

    private void initData() {
        readFile("M.txt");
        for (MonHoc monHoc : list) {
            String row[]={""+monHoc.getMaMon(),monHoc.getTenMon(),monHoc.getNhomMon(),""+monHoc.getSoTinChi()};
            modelTable.addRow(row);
        }
    }

    private void initEvent() {
        
    }
    private void readFile(String file){
        try {
            Scanner r=new Scanner(new File(file));
            while(r.hasNextLine()){
                list.add(new MonHoc(Integer.parseInt(r.nextLine()), r.nextLine(), r.nextLine(), Integer.parseInt(r.nextLine())));
            }
            r.close();
        } catch (FileNotFoundException ex) {
            
        } catch (MonHocException ex) {
            
        }
        
    }
}
