package oop.homework.rectangle;

import java.util.*;

/**
 *
 * @author PREDATOR
 */
public class main {
    public static void main(String[] args) {
        Rectange hcn=new Rectange();
        Scanner in=new Scanner(System.in);
        System.out.print("Chieu rong: ");
        hcn.setWidth(Double.parseDouble(in.nextLine()));
        System.out.print("Chieu dai: ");
        hcn.setHeight(Double.parseDouble(in.nextLine()));
        System.out.print("Mau: ");
        hcn.setColor(in.nextLine());
        System.out.println(hcn);
    }
}
