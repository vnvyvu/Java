package basic;

import java.util.Scanner;

/**
 *
 * @author VyVu
 */
public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt(),b=in.nextInt();
        Swap(a,b);
        System.out.println(a+" "+b);
    }
    public static void Swap(int a,int b){
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a+" "+b);
    }
}
