
package oop.homework.sinhvien;

import java.util.Scanner;

public class SinhVien {
    private String maSV,hoTen,lop;
    private int khoa;
    SinhVien(){
        maSV=hoTen=lop="";
        khoa=0;
    }
    SinhVien(String maSV,String hoTen,String lop,int khoa){
        this.maSV=maSV;
        this.hoTen=hoTen;
        this.lop=lop;
        this.khoa=khoa;
    }
    public void in(){
        Scanner inp=new Scanner(System.in);
        System.out.print("Ma sinh vien: ");
        setMaSV(inp.nextLine());
        System.out.print("Ho va ten: ");
        setHoTen(inp.nextLine());
        System.out.print("Lop: ");
        setLop(inp.nextLine());
        System.out.print("Khoa: ");
        setKhoa(inp.nextInt());
    }
    @Override
    public String toString(){
        return maSV+" "+hoTen+" "+lop+" "+khoa;
    }
    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLop() {
        return lop;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }
    
}
