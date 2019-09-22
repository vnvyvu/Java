
package basic;

import java.util.*;

public class B2 {
    public static void main(String[] args) {
        int cao;
        Scanner in=new Scanner(System.in);
        cao=in.nextInt();
        paint(cao);
    }
    public static void paint(int cao){
        int space;
        for(int i=1;i<=cao;i++){
            space=cao-i;
            for(int k=1;k<=space;k++){
                System.out.print("  ");
            }
            for(int j=1;j<i;j++){
                System.out.print(j+" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }
}
