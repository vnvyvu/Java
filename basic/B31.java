package basic;

import java.util.*;

public class B31 {
    public static void main(String[] args) {
        String s;
        Scanner in=new Scanner(System.in);
        s=in.nextLine();s=s.replaceAll("\\s{2,}", " ").trim();
        System.out.println("Do dai charmax: "+maxIndex(s)[0]+"\nVi tri: "+maxIndex(s)[1]);
    }
    public static String[] maxIndex(String a){
        int max=0,len;
        String box,index=null,s=a;
        s=s.replaceAll("\\s{2,}", " ").trim();
        StringTokenizer st=new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            box=st.nextToken();
            len=box.length();
            if(max<len){
                max=len;
                index=box;
            }
        }
        String[] res=new String[2];
        res[0]=String.valueOf(max);
        res[1]=String.valueOf(a.indexOf(index)+1);
        return res;
    }
}
