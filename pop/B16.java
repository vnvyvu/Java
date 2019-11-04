package pop;

public class B16 {
    public static void main(String[] args) {
        System.out.println("");
        for(int i=1000000;i<=9999999;i++){
            if(chuSoNT(i)&&B7.nguyenTo(i)&&daoNT(i)) System.out.print(i+" ");
        }
    }
    public static boolean chuSoNT(int n){
        StringBuilder sB=new StringBuilder("");
        sB=sB.append(n);
        int a;
        for(int i=0;i<sB.length();i++){
            a=sB.charAt(i)-'0';
            if(B7.nguyenTo(a)==false) return false;
        }
        return true;
    }
    public static boolean daoNT(int n){
        StringBuilder sB=new StringBuilder("");
        sB=sB.append(n);
        sB=sB.reverse();
        n=Integer.valueOf(sB.toString());
        return B7.nguyenTo(n);
    }
}