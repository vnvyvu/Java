
package basic;

import java.util.*;

public class B12 {
    public static void main(String[] args) {
        for(int i=100000;i<=999999;i++){
            if(thuanNghich(i)) System.out.print(i+" ");
        }
        System.out.println("");
    }
    public static boolean thuanNghich(int n){
        StringBuilder a = new StringBuilder("");
        a=a.append(n);
        String s = a.toString();
        int head=0,last=s.length()-1;
        while(head<last){
            if(s.charAt(head)!=s.charAt(last)) return false;
            head++;
            last--;
        }
        return true;
    }
    public static boolean thuanNghich(String s){
        int head=0,last=s.length()-1;
        while(head<last){
            if(s.charAt(head)!=s.charAt(last)) return false;
            head++;
            last--;
        }
        return true;
    }
}
