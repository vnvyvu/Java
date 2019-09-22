package oop.stackofchars;

import java.util.Scanner;
import oop.mypoint.*;

/**
 *
 * @author PREDATOR
 */
public class main {
    public static void main(String[] args) {
        String inFix,postFix;
        Scanner in=new Scanner(System.in);
        inFix=in.nextLine();
        postFix=postFix(inFix);
        System.out.println(postFix);
        System.out.println(calc(postFix));     
        
    }
    private static int calc(String postFix){
        char box;int res=0,a,b;StackOfChars s=new StackOfChars(100);
        for(int i=0;i<postFix.length();i++){
            box=postFix.charAt(i);
            if(fill(box)==-1){
                s.push(box);
            }
            else{
                if(!s.isEmpty()&&fill(box)>=1){
                    b=s.pop()-'0';
                    a=s.pop()-'0';
                    switch(box){
                        case '+':{
                            res=a+b;
                            break;
                        }
                        case '-':{
                            res=a-b;
                            break;
                        }
                        case '*':{
                            res=a*b;
                            break;
                        }
                        case '/':{
                            res=a/b;
                            break;
                        }
                    }
                    s.push((char)(res+'0'));
                }
            }
        }
        return res;
    }
    private static String postFix(String inFix){
        char box;String res="";StackOfChars s=new StackOfChars(100);
        for(int i=0;i<inFix.length();i++){
            box=inFix.charAt(i);
            if(fill(box)==-1){
                res+=inFix.charAt(i);
            }
            else{
                if(box=='(') s.push(box);
                else if(box==')'){
                    while(!s.isEmpty()&&s.peak()!='('){
                        res+=s.pop();
                    }
                    s.pop();
                }
                else{
                    while(!s.isEmpty()&&fill(box)<=fill(s.peak())){
                        res+=s.pop();
                    }
                    s.push(box);
                }
            }
        }
        while(!s.isEmpty()){
            res+=s.pop();
        }
        return res;
}
    private static int fill(char a){
        if(a>='0'&&a<='9') return -1;
        if(a=='+'||a=='-') return 1;
        if(a=='*'||a=='/') return 2;
        return 0;
    }
}


