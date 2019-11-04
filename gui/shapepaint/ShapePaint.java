package gui.shapepaint;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author VyVu
 */
public class ShapePaint extends JFrame{
    private DefaultComboBoxModel<String> comboShapeModel;
    private JComboBox<String> comboShape;
    private JPanel paint;
    private JPanel card;
    private JPanel rectLayout;
    private JPanel elipLayout;
    private JTextArea genText;
    private JTextField tRX;
    private JTextField tRY;
    private JTextField tRW;
    private JTextField tRH;
    private JComboBox<String> comboRectStyle;
    private DefaultComboBoxModel<String> comboRectModel;
    private JTextField tEX;
    private JTextField tEY;
    private JTextField tEW;
    private JTextField tEH;
    private JComboBox<String> comboElipStyle;
    private DefaultComboBoxModel<String> comboElipModel;
    private final String howTo="Cách nhập:\nNhập tọa độ xy cách nhau một khoảng trắng: x[Space]y\nMỗi điểm cách nhau một dấu phẩy: P1,P2";
    private JButton rectButton;
    private JButton elipButton;
    private JPanel genLayout;
    private JButton genButton;
    private JComboBox<String> comboGen;
    private DefaultComboBoxModel<String> comboGenModel;

    public ShapePaint() throws HeadlessException {
        initUI();
        initJP();
        initData();
        initEvent();
        pack();
    }

    private void initUI() {
        setTitle("Shape Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void initJP() {
        setLayout(new BorderLayout());
        add(paint=new JPanel(),BorderLayout.SOUTH);
        add(card=new JPanel(new CardLayout()),BorderLayout.CENTER);
        card.add(comboShape=new JComboBox<String>(comboShapeModel=new DefaultComboBoxModel<String>()),"Main");
        card.add(rectLayout=new JPanel(new GridBagLayout()),"Rectangle");
        card.add(elipLayout=new JPanel(new GridBagLayout()),"Ellipse");
        card.add(genLayout=new JPanel(new BorderLayout()),"Custom");
        this.rectLayout.add(new JLabel("X"));
        this.rectLayout.add(tRX=new JTextField(20));
        this.rectLayout.add(new JLabel("Y"));
        this.rectLayout.add(tRY=new JTextField(20));
        this.rectLayout.add(new JLabel("Width"));
        this.rectLayout.add(tRW=new JTextField(20));
        this.rectLayout.add(new JLabel("Height"));
        this.rectLayout.add(tRH=new JTextField(20));
        this.rectLayout.add(new JLabel("Style"));
        this.rectLayout.add(comboRectStyle=new JComboBox<String>(comboRectModel=new DefaultComboBoxModel<String>()));
        this.rectLayout.add(rectButton=new JButton("OK"));
        this.elipLayout.add(new JLabel("X"));
        this.elipLayout.add(tEX=new JTextField(20));
        this.elipLayout.add(new JLabel("Y"));
        this.elipLayout.add(tEY=new JTextField(20));
        this.elipLayout.add(new JLabel("Width"));
        this.elipLayout.add(tEW=new JTextField(20));
        this.elipLayout.add(new JLabel("Height"));
        this.elipLayout.add(tEH=new JTextField(20));
        this.elipLayout.add(new JLabel("Style"));
        this.elipLayout.add(comboElipStyle=new JComboBox<String>(comboElipModel=new DefaultComboBoxModel<String>()));
        this.elipLayout.add(elipButton=new JButton("OK"));
        this.genLayout.add(this.genText=new JTextArea(howTo),BorderLayout.CENTER);
        this.genLayout.add(genButton=new JButton("OK"),BorderLayout.NORTH);
        this.genLayout.add(comboGen=new JComboBox<String>(comboGenModel=new DefaultComboBoxModel<String>()),BorderLayout.EAST);
        
    }

    private void initData() {
        this.comboShapeModel.addElement("None");
        this.comboShapeModel.addElement("Rectangle");
        this.comboShapeModel.addElement("Ellipse");
        this.comboShapeModel.addElement("Custom");
        this.comboElipModel.addElement("Draw");
        this.comboElipModel.addElement("Fill");
        this.comboRectModel.addElement("Draw");
        this.comboRectModel.addElement("Fill");
        this.comboGenModel.addElement("Draw");
        this.comboGenModel.addElement("Fill");
    }

    private void initEvent() {
        this.comboShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout show=(CardLayout) card.getLayout();
                switch(comboShapeModel.getSelectedItem().toString()){
                    case "Rectangle":{
                        show.show(card, "Rectangle");
                        rectButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int sellect=1;
                                if(comboRectModel.getSelectedItem().toString().compareToIgnoreCase("Fill")==0) sellect=2;
                                JFrame cf=new JFrame("Retangle");
                                cf.add(new RectanglePaint(Double.parseDouble(tRX.getText()), Double.parseDouble(tRY.getText()), Double.parseDouble(tRW.getText()), Double.parseDouble(tRH.getText()), sellect));
                                cf.setSize(500,500);
                                cf.setVisible(true);
                            }
                        });
                        break;
                    }
                    case "Ellipse":{
                        show.show(card, "Ellipse");
                        elipButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int sellect=1;
                                if(comboElipModel.getSelectedItem().toString().compareToIgnoreCase("Fill")==0) sellect=2;
                                JFrame cf=new JFrame("Elip");
                                cf.add(new EllipsePaint(Double.parseDouble(tRX.getText()), Double.parseDouble(tRY.getText()), Double.parseDouble(tRW.getText()), Double.parseDouble(tRH.getText()), sellect));
                                cf.setSize(500,500);
                                cf.setVisible(true);
                            }
                        });
                        break;
                    }
                    case "Custom":{
                        show.show(card, "Custom");
                        genButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String sp[]=genText.getText().split(",");
                                LinkedList<Point2D> pList=new LinkedList<>();
                                for (int i=0;i<sp.length;i++) {
                                    Scanner in=new Scanner(sp[i]).useDelimiter(" ");
                                    pList.add(new Point2D.Double(Double.parseDouble(in.next()), Double.parseDouble(in.next())));
                                }
                                Point2D p[]=new Point2D[pList.size()];
                                pList.toArray(p);
                                int sellect=1;
                                if(comboGenModel.getSelectedItem().toString()=="Fill") sellect=2;
                                CustomPaint cp=new CustomPaint(new GeneralPath(), sellect, p);
                                JFrame cf=new JFrame("GeneralPath");
                                cf.add(cp);
                                cf.setSize(500,500);
                                cf.setVisible(true);
                            }
                        });
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        ShapePaint s=new ShapePaint();
    }
}
