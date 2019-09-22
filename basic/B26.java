package basic;

import java.util.*;

public class B26 {
    public static void main(String[] args) {
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        Matrix A=new Matrix(n,n);
        A.eddy().Output();
    }
}
