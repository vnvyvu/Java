package oop.contest_1.mathang;

import java.util.Arrays;

/**
 *
 * @author VyVu
 */
public class MatHang {
    private int maHang;
    private String ten,nhom;
    public final static String types[]={"hang tieu dung","hang thoi trang","dien tu - dien lanh"};
    private double giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String ten, String nhom, double giaBan) throws MatHangException{
        if(Math.floor(Math.log10(maHang))+1!=4){
            throw new MatHangException("Invalid format");
        }
        if("".equalsIgnoreCase(ten)){
            throw new MatHangException("Invalid format");
        }
        if(Arrays.binarySearch(types,nhom.toLowerCase())==-1){
            throw new MatHangException("Invalid format");
        }
        if(Double.compare(giaBan, 0)<=0){
            throw new MatHangException("Invalid format");
        }
        this.maHang = maHang;
        this.ten = ten;
        this.nhom = nhom;
        this.giaBan = giaBan;
    }
    
    @Override
    public String toString(){
        return ""+this.maHang+" "+this.ten+" "+this.nhom+" "+this.giaBan;
    }
    
    public int cmpGiaBan(MatHang cmpMatHang){
        return Double.compare(this.giaBan, cmpMatHang.giaBan)>0?-1:1;
    }
    
    public int cmpTen(MatHang cmMatHang){
        return this.ten.compareToIgnoreCase(cmMatHang.ten);
    }
    
    public int cmpNhom(MatHang cmpMatHang){
        return this.nhom.compareToIgnoreCase(cmpMatHang.nhom);
    }
    
    public int cmpNT(MatHang cmMatHang){
        if(this.cmpNhom(cmMatHang)==0){
            return this.cmpTen(cmMatHang);
        }
        else return this.cmpNhom(cmMatHang);
    }
}
