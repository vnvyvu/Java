
package basic;

public class B14 {
    public static void main(String[] args) {
        for(int i=100000;i<=999999;i++){
            if(sDivided(i)&&B12.thuanNghich(i)) System.out.print(i+" ");
        }
        System.out.println("");
    }
    public static boolean sDivided(int n){
        StringBuilder sB=new StringBuilder("");
        sB.append(n);
        int s=0;
        for(int i=0;i<sB.length();i++){
            s+=sB.charAt(i)-'0';
        }
        return s%10==0;
    }
    public static boolean sDivided(String n){
        int s=0;
        for(int i=0;i<n.length();i++){
            s+=n.charAt(i)-'0';
        }
        return s%10==0;
    }
}
