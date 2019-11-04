package gui.contest_2.mathang;

/**
 *
 * @author VyVu
 */
public class MatHang {
    private int maHang;
    private String ten,nhom;
    private double giaBan;
    public final static String[] TYPE={"hang tieu dung","hang thoi trang","dien tu - dien lanh"};
    public final static String[] FIELD_MH={"Mã","Tên","Nhóm","Giá"};
    public MatHang() {
    }

    public MatHang(int m, String t, String nhom, double gia) throws MatHangException {
        if(String.valueOf(m).length()!=4){
            throw new MatHangException("Wrong");
        }
        if("".equals(t)){
            throw new MatHangException("Wrong");
        }
        boolean check=true;
        for (int i=0; i<TYPE.length ;i++) {
            if(TYPE[i].equalsIgnoreCase(nhom)){
                check=false;
                break;
            }
        }
        if(check==true){
            throw new MatHangException("Wrong");
        }
        if(gia<=0){
            throw new MatHangException("Wrong");
        }
        this.maHang = m;
        this.ten = t;
        this.nhom = nhom;
        this.giaBan = gia;
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

    public double getGiaBan() {
        return giaBan;
    }
    
    
    public int cmp(MatHang cmpMH){
        if(this.nhom.compareToIgnoreCase(cmpMH.nhom)==0){
            return Double.compare(this.giaBan, cmpMH.giaBan)>0?-1:1;
        }
        else return this.nhom.compareToIgnoreCase(cmpMH.nhom);
    }
}
