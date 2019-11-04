
package pop;

import java.util.*;

public class B24 {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,4);
        a.Input();
        a=a.T();
        a.Output();
    }
}
class Matrix {
    private double  a[][];
    private int m,n;
    public Matrix(){
        m=n=0;
    }
    public Matrix(int m,int n){
        this.m=m;
        this.n=n;
        a=new double[m][n];
    }
    public void Input(){
        Scanner in=new Scanner(System.in);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) a[i][j]=in.nextInt();
        }
    }
    public void Output(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public Matrix T(){
        Matrix res=new Matrix(n,m);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) res.a[j][i]=a[i][j];
        }
        return res;
    }
    public Matrix multiply(Matrix b){
        Matrix c=new Matrix(m,b.n);
        for(int i=0;i<m;i++){
            for(int j=0;j<b.n;j++){
                c.a[i][j]=0;
                for(int k=0;k<n;k++) c.a[i][j]=c.a[i][j]+a[i][k]*b.a[k][j];
            }
        }
        return c;
    }
    public Matrix eddy(){
        int j=0,k=n-1,t=0,loop=n/2;
        while(loop>0){
            for(int i=j;i<k;i++) a[j][i]=t++;
            for(int i=j;i<k;i++) a[i][k]=t++;
            for(int i=k;i>j;i--) a[k][i]=t++;
            for(int i=k;i>j;i--) a[i][j]=t++;
            j++;k--;
            loop--;
        }
        if(n%2!=0) a[n/2][n/2]=n*n-1;
        return this;
    }
}