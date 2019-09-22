package oop.sophuc;

import java.util.Scanner;

/**
 *
 * @author VyVu
 */
public class SoPhuc {
    private float a,b;

    public SoPhuc() {
        a=0;
        b=0;
    }

    public SoPhuc(float thuc, float ao) {
        this.a = thuc;
        this.b = ao;
    }
    
    public SoPhuc cong(SoPhuc sp2){
        return new SoPhuc(a+sp2.a,b+sp2.b);
    }
    
    public SoPhuc tru(SoPhuc sp2){
        return new SoPhuc(a-sp2.a,b-sp2.b);
    }
    
    public SoPhuc nhan(SoPhuc sp2){
        return new SoPhuc(a*sp2.a-b*sp2.b,a*sp2.b+sp2.a*b);
    }
    
    public SoPhuc chia(SoPhuc sp2){
        return (sp2.a!=0||sp2.b!=0)?new SoPhuc((a*sp2.a+b*sp2.b)/(a*a+b*b),(a*sp2.b-sp2.a*b)/(a*a+b*b)):(SoPhuc) null;
    }
    
    public SoPhuc nghichDao(){
        return (a!=0||b!=0)?new SoPhuc(a/(a*a+b*b),b/(a*a+b*b)):(SoPhuc) null;
    }
    
    public boolean bangNhau(SoPhuc sp2){
        return a==sp2.a&&b==sp2.b;
    }
    
    @Override
    public String toString(){
        return (a==0)?""+b+"i":(b==0)?""+a:(b>0)?""+a+"+"+b+"i":""+a+b+"i";
    }
    
    public void nhap(){
        Scanner in=new Scanner(System.in);
        a=in.nextFloat();
        b=in.nextFloat();
    }
}
