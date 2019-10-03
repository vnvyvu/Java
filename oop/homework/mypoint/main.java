package oop.homework.mypoint;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        /*
        int n;
        n=in.nextInt();
        MyPoint p[]=new MyPoint[n];
        for(int i=0;i<n;i++) p[i]=new MyPoint(in.nextDouble(),in.nextDouble());
        double f[][]=new double[n][n];
        int i=0,j=0,io=0,jo=0;
        double box=0;
        f[0][0]=0;
        for(j=1;j<n;j++){
            f[i][j]=f[i][j-1];
            box=MyPoint.distance(p[i], p[j]);
            if(box>f[i][j]) {
                f[i][j]=box;
                io=i;jo=j;
            }
        }
        for(i=1;i<n;i++){
            for(j=i;j<n;j++){
                if(j==i) f[i][j]=f[i-1][n-1];
                else f[i][j]=f[i][j-1];
                box=MyPoint.distance(p[i], p[j]);
                if(box>f[i][j]) {
                f[i][j]=box;
                io=i;jo=j;
                }
            }
        }
        System.out.println("Đoạn thẳng dài nhất là: |"+p[io]+" ; "+p[jo]+"|= "+f[n-1][n-1]);
        */
        
        System.out.println("Nhập 3 điểm bất kỳ: ");
        MyPoint p1=new MyPoint(in.nextDouble(),in.nextDouble()),p2=new MyPoint(in.nextDouble(),in.nextDouble()),p3=new MyPoint(in.nextDouble(),in.nextDouble());
        double c12=edge(p1,p2),c23=edge(p2,p3),c31=edge(p1,p3);
        double d12=angle(p1, p2),d23=angle(p2, p3),d31=angle(p3, p1);
        if(isTriangle(p1, p2, p3)){
            if(isEqual(c12, c23, c31)){
                System.out.println("Tạo thành tam giác đều");
            }
            else{
                if(isScales(c12, c23, c31)&&isSquare(d12, d23, d31)){
                    System.out.println("Tạo thành tam giác vuông cân");
                }
                else{
                    if(isScales(c12, c23, c31)){
                        System.out.println("Tạo thành tam giác cân");
                    }
                    else{
                        if(isSquare(d12, d23, d31)){
                            System.out.println("Tạo thành tam giác vuông");
                        }
                        else System.out.println("Tạo thành tam giác");
                    }
                }
            }
        }
        else System.out.println("Không tạo thành tam giác");
    }
    
    public static boolean isTriangle(MyPoint p1,MyPoint p2,MyPoint p3){
        MyPoint p12=vector(p1,p2),p23=vector(p2,p3);
        return Double.compare(p12.getX()/p23.getX(), p12.getY()/p23.getY())!=0;
    }
    public static boolean isSquare(double d12,double d23,double d31){
        return Double.compare(d12, 90)==0||Double.compare(d23, 90)==0||Double.compare(d31, 90)==0;
    }
    public static boolean isScales(double c12,double c23,double c31){
        return Double.compare(c12, c23)==0||Double.compare(c23, c31)==0||Double.compare(c31, c12)==0;
    }
    public static boolean isEqual(double c12,double c23,double c31){
        return Double.compare(c12, c23)==0&&Double.compare(c23,c31)==0&&Double.compare(c31,c12)==0;
    }
    
    public static MyPoint vector(MyPoint p1,MyPoint p2){
        return new MyPoint(p1.getX()-p2.getX(),p1.getY()-p2.getY());
    }
    
    public static double edge(MyPoint p1,MyPoint p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()-p2.getY(), 2));
    }
    public static double angle(MyPoint vt1,MyPoint vt2){
        MyPoint o=new MyPoint();
        return Math.toDegrees(Math.acos((vt1.getX()*vt2.getX()+vt1.getY()*vt2.getY())/(vt1.distance(o)*vt2.distance(o))));
    }
}
