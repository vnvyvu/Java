package oop.sophuc;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) {
        SoPhuc ps1=new SoPhuc(),ps2=new SoPhuc();
        System.out.println("Nhập số phức thứ nhất: [Phần thực][Phần ảo]");
        ps1.nhap();
        System.out.println("Nhập số phức thứ hai: [Phần thực][Phần ảo]");
        ps2.nhap();
        
        System.out.println("Tổng: "+ps1.cong(ps2));
        System.out.println("Hiệu: "+ps1.tru(ps2));
        System.out.println("Tích: "+ps1.nhan(ps2));
        System.out.println("Thương: "+ps1.chia(ps2));
        System.out.println("Nghịch đảo số phức thứ nhất: "+ps1.nghichDao());
        System.out.println("Nghịch đảo số phức thứ hai: "+ps2.nghichDao());
        System.out.println("So sánh: "+ps1+"?"+ps2);
        if(ps1.bangNhau(ps2)) System.out.println(ps1+"="+ps2);
        else System.out.println(ps1+"!="+ps2);
    }
}
