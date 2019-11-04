
package pop;

import java.util.*;

public class B33 {
    private static final int index[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String LA_MA[]={"M","DM","D","CD","C","LC","L","XL","X","IX","V","IV","I"};
    public static void main(String[] args) {
        String s;
        int n=0,box;
        Scanner in=new Scanner(System.in);
        s=in.nextLine();
        for(int i=1;i<LA_MA.length;i+=2){
            box=s.indexOf(LA_MA[i]);
            if(box!=-1){
                n+=index[i];
                s=s.substring(0,box)+s.substring(box+2);
            }
        }
        for(int i=0;i<LA_MA.length;i+=2){
            box=s.indexOf(LA_MA[i]);
            if(box!=-1){
                n+=index[i];
                s=s.substring(0,box)+s.substring(box+1);
            }
        }
        System.out.println(n);
    }
}
