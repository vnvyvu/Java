package oop.contest_1.monhoc;

import java.util.Arrays;

/**
 *
 * @author VyVu
 */
public class MonHoc {
    private int maMon;
    private String tenMon,nhomMon;
    private final static String types[]={"co ban","co so nganh","chuyen nganh","ky nang mem"};
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinChi) throws MonHocException {
        if(Math.floor(Math.log10(maMon))+1!=4){
            throw new MonHocException("Invalid format");
        }
        if("".equalsIgnoreCase(tenMon)){
            throw new MonHocException("Invalid format");
        }
        if(Arrays.binarySearch(types, nhomMon.toLowerCase())==-1){
            throw new MonHocException("Invalid format");
        }
        if(soTinChi<=0||soTinChi>=7){
            throw new MonHocException("Invalid format");
        }
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinChi = soTinChi;
    }
    
    @Override
    public String toString(){
        return ""+this.maMon+" "+this.tenMon+" "+this.nhomMon+" "+this.soTinChi;
    }
    
    public int cmpSoTinChi(MonHoc cmpMonHoc){
        return cmpMonHoc.soTinChi-this.soTinChi;
    }
    
    public int cmpNhomMon(MonHoc cmpMonHoc){
        return this.nhomMon.compareToIgnoreCase(cmpMonHoc.nhomMon);
    }
    
    public int cmpTenMon(MonHoc cmpMonHoc){
        return this.tenMon.compareToIgnoreCase(cmpMonHoc.tenMon);
    }
    
    public int cmpNMTM(MonHoc cmpMonHoc){
        if(this.cmpNhomMon(cmpMonHoc)==0){
            return this.cmpTenMon(cmpMonHoc);
        }
        else return this.cmpNhomMon(cmpMonHoc);
    }
}
