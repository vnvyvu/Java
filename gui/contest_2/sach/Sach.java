package gui.contest_2.sach;

import java.util.Arrays;

/**
 *
 * @author VyVu
 */
public class Sach {
    private int maSach;
    private String tenSach,chuyenNganh;
    private double giaBan;
    public final static String TYPE[]={"giao khoa","ky thuat","van hoc"};
    public final static String FIELD[]={"Mã","Tên","Chuyên ngành","Giá bán"};
    public Sach() {
    }

    
    public Sach(int m, String t, String cn, double gia) throws SachException {
        if(String.valueOf(m).length()!=4){
            throw new SachException();
        }
        if("".compareTo(t)==0){
            throw new SachException();
        }
        if(Arrays.binarySearch(TYPE, cn)<0){
            throw new SachException();
        }
        if(gia<=0){
            throw new SachException();
        }
        this.maSach = m;
        this.tenSach = t;
        this.chuyenNganh = cn;
        this.giaBan = gia;
    }
    public int cmp(Sach cmpSach){
        if(this.chuyenNganh.compareToIgnoreCase(cmpSach.chuyenNganh)==0){
            //return this.tenSach.compareToIgnoreCase(cmpSach.tenSach);
            return Double.compare(this.giaBan, cmpSach.giaBan)>0?-1:1;
        }
        else return this.chuyenNganh.compareToIgnoreCase(cmpSach.chuyenNganh);
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    
}
