package gui.contest_2.mathang;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VyVu
 */
public class FormSapXep extends JFrame{
    private LinkedList<MatHang> list;
    private JComboBox combo;
    private DefaultTableModel modelTable;
    private JTable table;
    private DefaultComboBoxModel<String> modelCombo;

    public FormSapXep(LinkedList<MatHang> list) throws HeadlessException {
        this.list = list;
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initUI() {
        setTitle("Sắp xếp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initJP() {
        setLayout(new BorderLayout());
        add(combo=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<String>()),BorderLayout.SOUTH);
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        for (String s : MatHang.FIELD_MH) {
            this.modelTable.addColumn(s);
        }
    }

    private void initData() {
        readFile("MH.txt");
        this.modelCombo.addElement("None");
        this.modelCombo.addElement("All");
        this.list.sort(MatHang::cmp);
        HashSet<String> temp=new HashSet<>();
        for (MatHang m : list) {
            temp.add(m.getNhom());
        }
        for (String string : temp) {
            this.modelCombo.addElement(string);
        }
    }

    private void initEvent() {
        this.combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sellected=modelCombo.getSelectedItem().toString();
                modelTable.setNumRows(0);
                if("All".compareToIgnoreCase(sellected)==0){
                    for (MatHang m : list) {
                        String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGiaBan()};
                        modelTable.addRow(row);
                    }
                }
                else if("None".compareToIgnoreCase(sellected)!=0){
                    for (MatHang m : list) {
                        if(sellected.compareToIgnoreCase(m.getNhom())==0){
                            String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGiaBan()};
                            modelTable.addRow(row);
                        }
                    }
                }
            }
        });
    }
    private void readFile(String file){
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
