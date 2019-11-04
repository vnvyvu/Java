package gui.contest_2.sach;

import java.util.LinkedList;

/**
 *
 * @author VyVu
 */
public class SachViewer {
    public static void main(String[] args) {
        FormHienThi ht=new FormHienThi(new LinkedList<>());
        FormNhap nhap=new FormNhap(new Sach());
        FormSapXep sx=new FormSapXep(new LinkedList<>());
    }
}
