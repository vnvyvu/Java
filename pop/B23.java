
package pop;

import java.util.*;

public class B23 {
    public static void main(String[] args) {
        int f[]=new int[1001],a[]=new int[1001],opt=0,index=1;
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        f[0]=1;
        for(int i=1;i<n;i++){
            f[i]=f[i-1];
            if(a[i]>=a[i-1]){
                f[i]++;
            }
            else{
                if(opt<f[i]){
                    opt=f[i];
                    index=i-opt;
                }
                f[i]=1;
            }
        }
        System.out.println(index+" "+opt);
    }
}
