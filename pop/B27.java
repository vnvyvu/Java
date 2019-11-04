
package pop;

import java.util.*;

public class B27 {
    public static void main(String[] args) {
        for(int i=100001;i<=999999;i+=11){
            if(checkTN(i)) System.out.println(Integer.toString(i)+" ");;
        }
    }
    private static boolean checkTN(int n){
        StringBuilder s=new StringBuilder("");
        s.append(n);
        int h=0,l=s.length()-1;
        while(h<l){
            if(s.charAt(h)!=s.charAt(l)) return false;
            h++;l--;
        }
        return true;
    }
}
