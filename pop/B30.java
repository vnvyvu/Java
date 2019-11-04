
package pop;

import java.util.*;

public class B30 {
    public static void main(String[] args) {
        String s,as[];
        Scanner in=new Scanner(System.in);
        s=in.nextLine();
        s=s.replaceAll("\\s{2,}"," ").trim().toLowerCase();
        as=s.split("\\s+");s="";
        for(String x : as){
            x=x.substring(0,1).toUpperCase()+x.substring(1);
            s=s+x+" ";
        }
        System.out.println(s);
    }
}
