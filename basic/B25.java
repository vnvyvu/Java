
package basic;

import java.util.*;

public class B25 {
    public static void main(String[] args) {
        int m,n,k;
        Scanner in=new Scanner(System.in);
        System.out.println("Nhap m,n: ");
        m=in.nextInt();
        n=in.nextInt();
        System.out.println("Nhap A[][]:");
        Matrix A=new Matrix(m,n);
        A.Input();
        System.out.println("Nhap k:");
        k=in.nextInt();
        System.out.println("Nhap B[][]:");
        Matrix B=new Matrix(n,k);
        B.Input();
        System.out.println("Tich A*B la: ");
        A.multiply(B).Output();
    }
}
