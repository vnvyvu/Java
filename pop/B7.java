
package pop;

import java.util.*;

public class B7 {
    public static void main(String[] args) {
        int a,b;
        Scanner in=new Scanner(System.in);
        a=in.nextInt();
        if(a<2) a=2;
        b=in.nextInt();
        for(long i=a;i<=b;i++) if(nguyenTo(i)) System.out.print(i+" ");
    }
    public static boolean nguyenTo(long n){
        if(n<2) return false;
        for(long i=2;i<=Math.sqrt(n);i++) if(n%i==0) return false;
        return true;
    }
}
