package oop.stackofintegers;

import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class main {
    public static void main(String[] args) {
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        StackOfIntegers s=new StackOfIntegers(n);
        
        /*    
        for(int i=2;i<=n;i++){
            if(sNT(i)) s.push(i);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println("");
        */
        
        /*
        int i=2;
        while(n!=1){
            if(n%i==0){
                n/=i;
                s.push(i);
            }
            else{
                i++;
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println("");
        */
        
        
        while(n>0){
            if(n%2==0){
                s.push(0);
            }
            else{
                s.push(1);
            }
            //n/=2;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
        System.out.println("");
        
    }
    public static boolean sNT(int n){
        if(n<2) return false;
        double s=Math.sqrt(n);
        for(int i=2;i<=s;i++) if(n%i==0) return false;
        return true;
    }
}
