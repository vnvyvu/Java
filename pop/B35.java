
package pop;

import java.util.*;

public class B35 {
    public static void main(String[] args) {
        String s1,s2;
        Scanner in=new Scanner(System.in);
        s1=in.nextLine();
        s2=in.nextLine();
        char []S1=s1.toCharArray(),S2=s2.toCharArray();
        Set<Character> hop=new HashSet<>(),giao=hop,hieu=giao,box=hieu;
        for (Character c : S1) {
            hop.add(c);
            box.add(c);
        }
        for (Character c : S2) {
            hop.add(c);
            if(box.contains(c)) giao.add(c);
        } 
        hieu=hop;
        for (Character c : giao) {
            if(hop.contains(c)) hieu.remove(c);
        }
        System.out.println("Hop: "+hop+"\nGiao: "+giao+"\nHieu"+hieu);
    }
}
