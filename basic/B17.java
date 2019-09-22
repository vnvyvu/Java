
package basic;

public class B17 {
    public static void main(String[] args) {
        
    }
    public static long Ckn(int k,int n){
        if(k==1) return n;
        if(k==0||k==n) return 1;
        return Ckn(k,n-1)+Ckn(k-1,n-1);
    }
}
