
package basic;

import java.util.*;

public class B22 {
    public static void main(String[] args) {
        int N,M;
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        int a[]=new int[N];
        for(int i=0;i<a.length;i++){
            a[i]=in.nextInt();
        }
        M=in.nextInt();
        int b[]=new int[M];
        for(int i=0;i<b.length;i++){
            b[i]=in.nextInt();
        }
        int p;
        p=in.nextInt();
        for(int i=0;i<p;i++){
            System.out.print(a[i]+" ");
        }
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        for(int i=p;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
}
