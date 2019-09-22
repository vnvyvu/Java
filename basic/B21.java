
package basic;

import java.util.*;

public class B21 {
    public static void main(String[] args) {
        int n;
        PriorityQueue< Integer > q;
        q = new PriorityQueue<  >();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        Random r=new Random();
        for(int i=0;i<n;i++){
            q.add(r.nextInt(899)+100);
        }
        int box;
        while(!q.isEmpty()){
            box=q.remove();
            System.out.print(box+" ");
            if(!q.isEmpty()) while(q.peek()==box){
                q.remove();
            }
        }
        System.out.println("");
    }
}
