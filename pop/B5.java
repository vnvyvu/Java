
package pop;

import java.util.*;

public class B5 {
    public static void main(String[] args) {
        int n;
        double S=0;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        for(int i=1;i<=n;i++) S+=1.0*1/i;
        System.out.println(S);
    }
}
