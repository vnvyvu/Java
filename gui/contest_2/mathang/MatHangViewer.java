/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contest_2.mathang;

import java.util.LinkedList;

/**
 *
 * @author VyVu
 */
public class MatHangViewer {
    public static void main(String[] args) {
        FormHienThi ht=new FormHienThi(new LinkedList<>());
        FormNhap nhap=new FormNhap(new MatHang());
        FormSapXep sx=new FormSapXep(new LinkedList<>());
    }
}
