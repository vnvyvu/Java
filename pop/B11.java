
package pop;

import java.util.*;

public class B11 {
    public static void main(String[] args) {
        int n;
        Fibo a=new Fibo();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        if(n==0) System.out.println("0");
        else{
            a=a.find(n);
            System.out.println(a.getFibo());
        }
    }
}
class Fibo {
    private long[][] basis=new long[2][2];
    public Fibo(){
        this.basis[0][0]=this.basis[1][0]=this.basis[0][1]=1;
        this.basis[1][1]=0;
    }
    public long getFibo(){
        return this.basis[0][1];
    }
    private Fibo multiply(Fibo a){
        Fibo res=new Fibo();
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                res.basis[i][j]=0;
                for(int k=0;k<2;k++)
                    res.basis[i][j]=res.basis[i][j]+this.basis[i][k]*a.basis[k][j];
            }
        }
        return res;
    }
    public Fibo find(int n){
        if(n==1) return this;
        Fibo s=find(n/2);
        if(n%2==0) return s.multiply(s);
        return s.multiply(s).multiply(this);
    }
}
