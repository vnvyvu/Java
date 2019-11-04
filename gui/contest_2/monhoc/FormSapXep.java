package gui.contest_2.monhoc;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
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
    private LinkedList<MonHoc> list;
    private JComboBox<String> combo;
    private DefaultTableModel modelTable;
    private JTable table;
    private DefaultComboBoxModel<String> modelCombo;

    public FormSapXep(LinkedList<MonHoc> list) throws HeadlessException {
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
        for (String string : MonHoc.FIELD) {
            modelTable.addColumn(string);
        }
        modelCombo.addElement("None");
        modelCombo.addElement("All");
    }

    private void initData() {
        readFile("M.txt");
        list.sort(MonHoc::cmp);
        HashSet<String> temp=new HashSet<>();
        for (MonHoc m : list) {
            temp.add(m.getNhomMon());
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
                    for (MonHoc m : list) {
                        String row[]={""+m.getMaMon(),m.getTenMon(),m.getNhomMon(),""+m.getSoTinChi()};
                        modelTable.addRow(row);
                    }
                }
                else if(!"None".equalsIgnoreCase(sellected)){
                    for (MonHoc m : list) {
                        if(m.getNhomMon().equalsIgnoreCase(modelCombo.getSelectedItem().toString())){
                            String row[]={""+m.getMaMon(),m.getTenMon(),m.getNhomMon(),""+m.getSoTinChi()};
                            modelTable.addRow(row);
                        }
                    }
                }
            }
        });
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
