package gui.contest_2.monhoc;

/**
 *
 * @author VyVu
 */
public class MonHoc {
    private int maMon;
    private String tenMon,nhomMon;
    private int soTinChi;
    public final static String TYPE[]={"cơ sở","cơ sở chuyên ngành","chuyên ngành","kỹ năng mềm"};
    public static final String FIELD[]={"Mã","Tên môn","Nhóm","Số tín chỉ"};

    public MonHoc(int m, String t, String nhom, int so) throws MonHocException {
        if(String.valueOf(m).length()!=4){
            throw new MonHocException();
        }
        if("".equalsIgnoreCase(t)){
            throw new MonHocException();
        }
        boolean check=true;
        for (String string : TYPE) {
            if(string.equalsIgnoreCase(nhom)){
                check=false;
                break;
            }
        }
        if(check){
            throw new MonHocException();
        }
        if(so<0||so>7){
            throw new MonHocException();
        }
        this.maMon = m;
        this.tenMon = t;
        this.nhomMon = nhom;
        this.soTinChi = so;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getNhomMon() {
        return nhomMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public MonHoc() {
    }
    
    public int cmp(MonHoc cmpMonHoc){
        if(this.nhomMon.compareToIgnoreCase(cmpMonHoc.nhomMon)==0){
            //return this.tenMon.compareToIgnoreCase(cmpMonHoc.tenMon);
            return this.soTinChi>cmpMonHoc.soTinChi?-1:1;
        }
        else return this.nhomMon.compareToIgnoreCase(cmpMonHoc.nhomMon);
    }
    
}
