package gui.contest_2.sinhvien;

import java.util.regex.Pattern;

/**
 *
 * @author VyVu
 */
public class SinhVien {
    private int maSV;
    private String ten,lop;
    private double dtb;
    public static final String[] FIELD_SV={"Mã","Tên","Lớp","Điểm TB"};
    public SinhVien() {
    }
    
    public SinhVien(int m, String t, String l, double d) throws SinhVienException {
        if(String.valueOf(m).length()!=4){
            throw new SinhVienException("ma");
        }
        if(!Pattern.compile("([a-z]+ [a-z]+ [a-z]+$)|([a-z]+ [a-z]+$)").matcher(t.toLowerCase()).matches()){
            throw new SinhVienException("ten");
        }
        if(!Pattern.matches("[a-z]{1}[0-9]{2}[a-z]{4}[0-9]{2}(($)|(-[a-z]{1}$))", l.toLowerCase())){
            throw new SinhVienException("lop");
        }
        if(Double.compare(d,0)<0||Double.compare(d, 10)>0){
            throw new SinhVienException("diem");
        }
        this.maSV = m;
        this.ten = t;
        this.lop = l;
        this.dtb = d;
    }
    public int cmp(SinhVien cmpSV){
        if(this.lop.compareToIgnoreCase(cmpSV.lop)==0){
            return Double.compare(dtb, cmpSV.dtb)>0?-1:1;
        }
        else return this.lop.compareToIgnoreCase(cmpSV.lop);
    }

    public int getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }
        
}
