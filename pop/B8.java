
package pop;

import java.util.*;

public class B8 {
    public static void main(String[] args) {
        String s;
        Scanner in=new Scanner(System.in);
        s=in.nextLine();
        int t=0;
        for(int i=0;i<s.length();i++){
            t+=s.charAt(i)-'0';
        }
        System.out.println(t);
    }
}
