
package pop;

import java.util.*;

public class B4 {
    public static void main(String[] args) {
        long S=0;
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        int i;
        if(n%2==0) i=2;
        else i=1;
        for(i=i;i<=n;i+=2) S+=i;
        System.out.println(S);
    }
}
