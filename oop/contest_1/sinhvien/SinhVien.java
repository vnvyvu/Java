package oop.contest_1.sinhvien;

import java.util.regex.Pattern;

/**
 *
 * @author VyVu
 */
public class SinhVien {
    private int maSV;
    private String ten,lop;
    private double dtb;
    public final double GIOI=8,KHA=7,TB=5;
    public SinhVien() {
    }

    public SinhVien(int maSV, String ten, String lop, double dtb) throws SinhVienException {
        if(Math.floor(Math.log10(maSV))+1!=4){
            throw new SinhVienException("Format Invalid!");
        }
        if("".equalsIgnoreCase(ten)){
            throw new SinhVienException("Format Invalid!");
        }
        if(!Pattern.compile("D\\d{2}CQ\\w{2}\\d{2}-{0,1}.{0,1}$").matcher(lop).matches()){
            throw new SinhVienException("Format Invalid!");
        }
        if(Double.compare(dtb, 0)<0||Double.compare(dtb, 10)>0){
            throw new SinhVienException("Format Invalid!");
        }
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }
    
    public String getTen(){
        String crack[]=this.ten.split(" ");
        return crack[crack.length-1];
    }
    
    public String getHoDem(){
        String crack[]=this.ten.split(" "),res="";
        for(int i=0;i<crack.length-1;i++){
            res+=crack[i]+" ";
        }
        return res;
    }
    
    @Override
    public String toString(){
        return ""+this.maSV+" "+this.ten+" "+this.lop+" "+this.dtb;
    }
    
    public int compareLop(SinhVien cmpSinhVien){
        if(this.lop.equalsIgnoreCase(cmpSinhVien.lop)) return Double.compare(this.dtb, cmpSinhVien.dtb);
        else return this.lop.compareToIgnoreCase(cmpSinhVien.lop);
    }
    
    public int compareTen(SinhVien cmpSinhVien){
        if(this.getTen().compareTo(cmpSinhVien.getTen())==0){
            return this.getHoDem().compareToIgnoreCase(cmpSinhVien.getHoDem());
        }
        else return this.getTen().compareToIgnoreCase(cmpSinhVien.getHoDem());        
    }
    
    public int compareDTB(SinhVien cmpSinhVien){
        if(Double.compare(this.dtb, 8)>=0&&Double.compare(cmpSinhVien.dtb, 8)>=0){
            return this.compareTen(cmpSinhVien);
        }
        else{
            if(Double.compare(this.dtb, 7)>=0&&Double.compare(cmpSinhVien.dtb, 7)>=0){
                return this.compareTen(cmpSinhVien);
            }
            else{
                if(Double.compare(this.dtb, 5)>=0&&Double.compare(cmpSinhVien.dtb, 5)>=0){
                    return this.compareTen(cmpSinhVien);
                }
                else{
                    if(Double.compare(this.dtb, 5)<0&&Double.compare(cmpSinhVien.dtb, 5)<0){
                        return this.compareTen(cmpSinhVien);
                    }
                    else return Double.compare(this.dtb, cmpSinhVien.dtb);
                }
            }
        }
    }
}
