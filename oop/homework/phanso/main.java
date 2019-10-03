package oop.homework.phanso;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) {
        PhanSo ps1=new PhanSo(),ps2=new PhanSo();
        System.out.print("Nhập phân số thứ nhất: ");
        ps1.nhap();
        System.out.print("Nhập phân số thứ hai: ");
        ps2.nhap();
        
        System.out.println("Tổng: "+ps1.cong(ps2).toiGian());
        System.out.println("Hiệu: "+ps1.tru(ps2).toiGian());
        System.out.println("Tích: "+ps1.nhan(ps2).toiGian());
        System.out.println("Thương: "+ps1.chia(ps2).toiGian());
        System.out.println("Tối giản phân số thứ nhất: "+ps1.toiGian());
        System.out.println("Tối giản phân số thứ hai: "+ps2.toiGian());
        System.out.println("So sánh: "+ps1+"?"+ps2);
        if(ps1.bangNhau(ps2)) System.out.println(ps1+"="+ps2);
        else if(ps1.lonHon(ps2)) System.out.println(ps1+">"+ps2);
        else System.out.println(ps1+"<"+ps2);
    }
}
