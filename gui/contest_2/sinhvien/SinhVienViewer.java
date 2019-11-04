package gui.contest_2.sinhvien;

import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author VyVu
 */
public class SinhVienViewer {
    public static void main(String[] args) {
        FormSapXep sx=new FormSapXep(new LinkedList<>());
        FormHienThi ht=new FormHienThi(new LinkedList<>());
        FormNhap n=new FormNhap(new SinhVien());
        
    }
}
