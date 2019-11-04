
package pop;

import java.util.*;

public class B6 {
    public static void main(String[] args) {
        int a,b;
        Scanner in=new Scanner(System.in);
        a=in.nextInt();
        b=in.nextInt();
        System.out.println(Uc(a,b)+" "+a*b/Uc(a,b));
    }
    public static int Uc(int a,int b){
        if(a==b) return a;
        if(a>b) return Uc(a-b,b);
        return Uc(a,b-a);
    }
}
