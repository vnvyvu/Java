
package basic;

import java.util.*;

public class B13 {
    public static void main(String[] args) {
        double c;int n = 0;
        Scanner in=new Scanner(System.in);
        c=in.nextDouble();
        while(oK(n,c)) n++;
        System.out.println(pi(n));
    }
    private static boolean oK(int n,double c){
        double vP=1.0*1/(2*n+1);
        return c<vP;
    }
    public static long exp(int n,int k){
        if(k==0) return 1;
        long s=exp(n,k/2);
        if(k%2==0) return s*s;
        return s*s*n;
    }
    private static double pi(int n){
        double res=0;
        for(int i=1;i<=2*n+1;i++){
            res+=(1.0*exp(-1,i-1)*1.0/i);
        }
        return 4*res;
    }
}
