
package pop;

import java.util.*;

public class B32 {
    public static void main(String[] args) {
        String s,as[];
        Scanner in=new Scanner(System.in);
        s=in.nextLine();
        as=s.split(" ");
        s=as[2]+" "+as[1]+" "+as[0];
        System.out.println(s);
    }
}
