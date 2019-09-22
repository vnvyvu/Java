
package basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B15 {
    public static void main(String[] args) {
        done(1001,9999,7);
        System.out.println("");
        done(1001,9999,8);
        System.out.println("");
        done(10001,99999,9);
        System.out.println("");
    }
    public static boolean sum10(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
        }
        return sum%10==0;
    }
    public static boolean c068(String s){
        String regex="[069]+";
        return Pattern.compile(regex).matcher(s).matches();
    }
    public static String gen(int n,int scs){
        String s=Integer.toString(n);
        StringBuilder rev=new StringBuilder(s.substring(0, scs/2));
        return s+rev.reverse().toString();
    }
    public static void done(int s,int e,int scs){
        String p;
        for(int i=s;i<=e;i++){
            p=gen(i,scs);
            //if(c068(p)&&sum10(p))
                System.out.print(p+" ");
        }
    }
}