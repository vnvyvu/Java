/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private LinkedList<MatHang> list;
    private JComboBox<String> combo;
    private DefaultComboBoxModel<String> modelCombo;
    private DefaultTableModel modelTable;
    private JTable table;

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
        add(new JScrollPane(table=new JTable(modelTable=new DefaultTableModel()),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
        add(combo=new JComboBox<String>(modelCombo=new DefaultComboBoxModel<String>()),BorderLayout.SOUTH);
        for (String string : MatHang.FIELD) {
            modelTable.addColumn(string);
        }
        modelCombo.addElement("None");
        modelCombo.addElement("All");
    }

    private void initData() {
        readFile("MH.txt");
        list.sort(MatHang::cmp);
        HashSet<String> temp=new HashSet<>();
        for (MatHang m : list) {
            temp.add(m.getNhom());
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
                    for (MatHang m : list) {
                        String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGia()};
                        modelTable.addRow(row);
                    }
                }else if("None".compareToIgnoreCase(sellected)!=0){
                    for (MatHang m : list) {
                        if(m.getNhom().compareToIgnoreCase(sellected)==0){
                            String row[]={""+m.getMaHang(),m.getTen(),m.getNhom(),""+m.getGia()};
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
