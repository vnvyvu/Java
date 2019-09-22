
package basic;

import java.util.*;

public class B1 {
    public static void main(String[] args) {
        int chieuRong,chieuCao;
        Scanner in=new Scanner(System.in);
        chieuRong=in.nextInt();
        chieuCao=in.nextInt();
        paint(chieuRong,chieuCao);
        System.out.println("");
    }
    public static void paint(int rong,int cao){
        for(int i=1;i<=rong;i++) System.out.print("*");
        System.out.println("");
        
        for(int i=2;i<cao;i++)
        {
            for(int j=1;j<=rong;j++)
            {
                if(j==1||j==rong) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }
        
        for(int i=1;i<=rong;i++) System.out.print("*");
    }
}
