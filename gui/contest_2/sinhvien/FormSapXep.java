package gui.contest_2.sinhvien;

import java.awt.*;
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
public class FormSapXep extends JFrame {

    private DefaultTableModel modelTable;
    private JTable table;
    private JComboBox sortBox;
    private JPanel button;
    private LinkedList<SinhVien> list;
    private DefaultComboBoxModel<String> modelBox;

    public FormSapXep(LinkedList<SinhVien> list) throws HeadlessException {
        initUI();
        initJP();
        this.list=list;
        initData();
        initEvent();
        pack();
    }
    
    public void initUI(){
        setTitle("Sắp xếp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void initJP() {
        setLayout(new BorderLayout());
        button=new JPanel(new FlowLayout());
        add(button, BorderLayout.SOUTH);
        modelTable=new DefaultTableModel();
        table=new JTable(modelTable);
        for (String s : SinhVien.FIELD_SV) {
            modelTable.addColumn(s);
        }
        add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
    }
    
    public void initEvent(){
        this.sortBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelTable.setNumRows(0);
                String sellected=modelBox.getSelectedItem().toString();
                if(sellected.compareTo("All")==0){
                    for (SinhVien sv : list) {
                        String[] row={""+sv.getMaSV(),sv.getTen(),sv.getLop(),""+sv.getDtb()};
                        modelTable.addRow(row);
                    }
                }
                else if(sellected.compareTo("None")!=0){
                    for (SinhVien sv : list) {
                        if(sv.getLop().compareToIgnoreCase(sellected)==0){
                            String[] row={""+sv.getMaSV(),sv.getTen(),sv.getLop(),""+sv.getDtb()};
                            modelTable.addRow(row);
                        }
                    }
                }
            }
        });
    }
    
    public void initData(){
        list=new LinkedList<>();
        readFile("SV.txt");
        list.sort(SinhVien::cmp);
        HashSet<String> item=new HashSet<String>();
        list.forEach((t) -> {
            item.add(t.getLop().toLowerCase());
        });
        String a[]=new String[item.size()];
        item.toArray(a);
        modelBox=new DefaultComboBoxModel<String>();
        modelBox.addElement("None");
        modelBox.addElement("All");
        for (String s : a) {
            modelBox.addElement(s);
        }
        button.add(sortBox=new JComboBox<String>(modelBox));
    }
    public void readFile(String file){
        try {
            Scanner input=new Scanner(new File("SV.txt"));
            while(input.hasNextLine()){
                try {
                    list.add(new SinhVien(Integer.parseInt(input.nextLine()), input.nextLine(), input.nextLine(), Double.parseDouble(input.nextLine())));
                } catch (SinhVienException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Dữ liệu file không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
        }
    }
}
