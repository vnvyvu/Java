package pop;

import java.util.*;
import java.math.*;

public class B29 {
    public static void main(String[] args) {
        BigInteger a,b;
        a=B28.Gen(20, 1000);
        b=B28.Gen(20, 1000);
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        System.out.println("a*b= "+a.multiply(b));
    }
}
