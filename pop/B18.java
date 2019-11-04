
package pop;

import java.util.*;

public class B18 {
    public static void main(String[] args) {
        int a[]=new int[50],n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        Random r=new Random();
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(899)+100;
            System.out.print(a[i]+" ");
        }
        System.out.println("\n"+doiXung(a));
    }
    public static boolean doiXung(int[] a){
        int head=0,last=a.length-1;
        while(head<last){
            if(a[head]!=a[last]) return false;
            last--;
            head++;
        }
        return true;
    }
}
