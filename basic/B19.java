
package basic;

import java.util.*;

public class B19 {
    public static void main(String[] args) {
        int n,b[]=new int[1001],box,maxi=0,maxv=0;
        Random r=new Random();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            box=r.nextInt(900)+100;
            if(set.contains(box)){
                b[box]++;
            }
            else{
                set.add(box);
                b[box]++;
            }
        }
        for (Integer i : set) {
            System.out.println(i+" "+b[i]);
            if(maxi<b[i]){
                maxi=b[i];
                maxv=i;
            }
        }
        System.out.println("Phan tu xuat hien nhieu nhat: "+maxv+" "+maxi);
    }
}
