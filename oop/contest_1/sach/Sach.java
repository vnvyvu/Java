package oop.contest_1.sach;


/**
 *
 * @author VyVu
 */
public class Sach {
    private int maSach;
    private String tenSach,chuyenNganh;
    private final static String types[]={"giao khoa","van hoc","ky thuat"};
    private double giaBan;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String chuyenNganh, double giaBan) throws SachException {
        if(Math.floor(Math.log10(maSach))+1!=4){
            throw new SachException("Invalid format");
        }
        if("".equalsIgnoreCase(tenSach)){
            throw new SachException("Invalid format");
        }
        boolean check=false;
        for(int i=0;i<types.length;i++){
            if(types[i].compareToIgnoreCase(chuyenNganh)==0) check=true;
        }
        if(check){
            throw new SachException("Invalid format");
        }
        if(Double.compare(giaBan, 0)<=0){
            throw new SachException("Invalid format");
        }
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.chuyenNganh = chuyenNganh;
        this.giaBan = giaBan;
    }
    
    @Override
    public String toString(){
        return ""+this.maSach+" "+this.tenSach+" "+this.chuyenNganh+" "+this.giaBan;
    }
    
    public int cmpGiaSach(Sach cmpSach){
        return Double.compare(this.giaBan, cmpSach.giaBan)>0?-1:1;
    }
    
    public int cmpTenSach(Sach cmpSach){
        return this.tenSach.compareToIgnoreCase(cmpSach.tenSach);
    }
    
    public int cmpChuyenNganh(Sach cmpSach){
        return this.chuyenNganh.compareToIgnoreCase(cmpSach.chuyenNganh);
    }
    
    public int cmpTSCN(Sach cmpSach){
        if(this.cmpChuyenNganh(cmpSach)==0){
            return this.cmpTenSach(cmpSach);
        }
        else return this.cmpChuyenNganh(cmpSach);
    }
}
