package basic;

import java.util.*;

public class B20 {
    public static void main(String[] args) {
        int a[]=new int[500],x,n;
        Random r=new Random();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(8999)+1000;
        }
        x=in.nextInt();
        int radius=1000000,index=-1;
        for(int i=0;i<n;i++){
            if(B7.nguyenTo(a[i])){
                if(a[i]-x<radius){
                    radius=a[i]-x;
                    index=i;
                }
            }
        }
        System.out.println(+a[index]+"["+index+"]");
    }
}
