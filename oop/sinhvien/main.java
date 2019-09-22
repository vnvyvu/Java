
package oop.sinhvien;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        /*SinhVien a = new SinhVien();
        a.in();
        a.out();
        System.out.println("");*/
        
        /*SinhVien b=new SinhVien("B17DCAT123","Vu Van A","D17CQAT04-B",2017);
        b.out();
        System.out.println("");*/
        
        int n;
        n=in.nextInt();
        SinhVien ds[]=new SinhVien[n];
        for(int i=0;i<n;i++){
            System.out.println("Sinh vien "+(i+1));
            ds[i]=new SinhVien();
            ds[i].in();
        }
        for(int i=0;i<n;i++){
            System.out.println(ds[i]);
        }
        Arrays.sort(ds,Comparator.comparing(SinhVien::getHoTen));
        for(int i=0;i<n;i++){
            System.out.println(ds[i]);
        }
    }
}
