
package basic;

import java.util.*;
import java.math.*;
public class B28 {
    public static void main(String[] args) {
        BigInteger a,b;
        a=Gen(20,1000);
        b=Gen(20,1000);
        System.out.println("a= "+a+"\nb= "+b);
        System.out.println("a+b= "+a.add(b).toString()+"\na-b=: "+a.subtract(b).toString());
    }
    public static BigInteger Gen(int sCS,int eCS){
        Random r=new Random();
        int n=r.nextInt(eCS-sCS)+sCS;
        StringBuilder s=new StringBuilder("");
        s.append(r.nextInt(8)+1);n--;
        while(n>0){
            s.append(r.nextInt(9)+0);
            n--;
        }
        BigInteger res=new BigInteger(s.toString());
        return res;
    }
}
