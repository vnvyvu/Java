package gui.contest_2.sach;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VyVu
 */
public class FormSapXep extends JFrame{
    private LinkedList<Sach> list;
    private JComboBox<String> combo;
    private DefaultComboBoxModel<String> modelCombo;
    private DefaultTableModel modelTable;
    private JTable table;

    public FormSapXep(LinkedList<Sach> list) throws HeadlessException {
        this.list = list;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
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

    private void initUI() {
        setTitle("Sắp xếp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initJP() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
        add(combo=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<String>()),BorderLayout.SOUTH);
    }

    private void initData() {
        readFile("Sach.txt");
        list.sort(Sach::cmp);
        for (String string : Sach.FIELD) {
            modelTable.addColumn(string);
        }
        modelCombo.addElement("None");
        modelCombo.addElement("All");
        HashSet<String> temp=new HashSet<>();
        for (Sach sach : list) {
            temp.add(sach.getChuyenNganh());
        }
        for (String string : temp) {
            modelCombo.addElement(string);
        }
        
    }

    private void initEvent() {
        this.combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sellected=modelCombo.getSelectedItem().toString();
                modelTable.setNumRows(0);
                if("All".compareToIgnoreCase(sellected)==0){
                    for (Sach sach : list) {
                        String row[]={""+sach.getMaSach(),sach.getTenSach(),sach.getChuyenNganh(),""+sach.getGiaBan()};
                        modelTable.addRow(row);
                    }
                }else if("None".compareTo(sellected)!=0){
                    for (Sach sach : list) {
                        if(sellected.compareToIgnoreCase(sach.getChuyenNganh())==0){
                            String row[]={""+sach.getMaSach(),sach.getTenSach(),sach.getChuyenNganh(),""+sach.getGiaBan()};
                            modelTable.addRow(row);
                        }
                    }
                }
            }
        });
    }
}
