
package basic;

import java.util.*;

public class B34 {
    public static void main(String[] args) {
        String s,as[]=new String[20];
        Scanner in=new Scanner(System.in);
        s=in.nextLine();
        s.replaceAll("\\s{2,}"," ").trim();
        as=s.split(" ");
        Arrays.sort(as);
        for(String a : as){
            System.out.println(a);
        }
    }
}
