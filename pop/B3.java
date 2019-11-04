
package pop;

import java.util.*;

public class B3 {
    public static void main(String[] args) {
        int comp,box;
        Scanner in=new Scanner(System.in);
        comp=in.nextInt();
        Random r=new Random();
        do{
            box=r.nextInt(90)+10;
            System.out.print(box+" ");
        }while(box!=comp);
        System.out.println("");
    }
}
