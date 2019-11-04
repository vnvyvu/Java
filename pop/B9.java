
package pop;

import java.util.*;

public class B9 {
    public static void main(String[] args) {
        int n,i=2;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        while(n>1){
            if(B7.nguyenTo(i)){
                if(n%i==0){
                    System.out.print(i+" ");
                    n/=i;
                }
                else i++;
            }
            else i++;
        }
    }
}
