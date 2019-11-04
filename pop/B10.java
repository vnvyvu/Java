
package pop;

import java.util.*;

public class B10 {
    public static void main(String[] args) {
        int n;
        long i=2;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        while(n>0){
            if(B7.nguyenTo(i)){
                System.out.print(i+" ");
                n--;
            }
            i++;
        }
    }
}
