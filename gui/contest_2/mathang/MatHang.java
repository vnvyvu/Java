/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contest_2.mathang;

/**
 *
 * @author VyVu
 */
public class MatHang {
    private int maHang;
    private String ten,nhom;
    private double giaBan;
    public static final String TYPE[]={"hàng tiêu dùng","hàng thời trang","điện tử - điện lạnh"};
    public static final String FIELD[]={"Mã","Tên","Nhóm","Giá"};

    public MatHang() {
    }

    public MatHang(int m, String t, String nhom, double gia) throws MatHangException {
        if(String.valueOf(m).length()!=4){
            throw new MatHangException();
        }
        if("".compareToIgnoreCase(t)==0){
            throw new MatHangException();
        }
        boolean check=true;
        for (String string : TYPE) {
            if(string.compareToIgnoreCase(nhom)==0){
                check=false;
                break;
            }
        }
        if(check){
            throw new MatHangException();
        }
        if(gia<=0){
            throw new MatHangException();
        }
        this.maHang = m;
        this.ten = t;
        this.nhom = nhom;
        this.giaBan = gia;
    }
    public int cmp(MatHang cmpMH){
        if(this.nhom.compareToIgnoreCase(cmpMH.nhom)==0){
            //return this.ten.compareToIgnoreCase(cmpMH.ten);
            return Double.compare(this.giaBan, cmpMH.giaBan);
        }
        else return this.nhom.compareToIgnoreCase(cmpMH.nhom);
    }

    public int getMaHang() {
        return maHang;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }

    public double getGia() {
        return giaBan;
    }
}
