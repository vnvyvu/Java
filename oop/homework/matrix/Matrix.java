package oop.homework.matrix;

import java.util.Scanner;

/**
 *
 * @author VyVu
 */
public class Matrix {
    private float a[][];

    public Matrix() {
        a=new float[2][2];
    }

    public Matrix(int rows,int cols) {
        a=new float[rows][cols];
    }
    
    public Matrix add(Matrix m){
        int aRows=a.length,aCols=a[0].length,mRows=m.a.length,mCols=m.a[0].length;
        if(aRows==mRows&&aCols==mCols){
            Matrix res=new Matrix(aRows,aCols);
            for(int i=0;i<aRows;i++){
                for(int j=0;j<aCols;j++) res.a[i][j]=a[i][j]+m.a[i][j];
            }
            return res;
        }
        else{
            System.out.println("Invalid Matrix!");
            System.exit(0);
            return (Matrix) null;
        }
    }
    
    public Matrix sub(Matrix m){
        int aRows=a.length,aCols=a[0].length,mRows=m.a.length,mCols=m.a[0].length;
        if(aRows==mRows&&aCols==mCols){
            Matrix res=new Matrix(aRows,aCols);
            for(int i=0;i<aRows;i++){
                for(int j=0;j<aCols;j++) res.a[i][j]=a[i][j]-m.a[i][j];
            }
            return res;
        }
        else{
            System.out.println("Invalid Matrix!");
            System.exit(0);
            return (Matrix) null;
        }
    }
    
    public Matrix neg(){
        Matrix res=new Matrix(this.a.length,this.a[0].length);
        for(int i=0;i<this.a.length;i++){
            for(int j=0;j<this.a[0].length;j++){
                res.a[i][j]=-1*a[i][j];
            }
        }
        return res;
    }
    
    public Matrix transpose(){
        Matrix res=new Matrix(a[0].length,a.length);
        for(int i=0;i<res.a.length;i++){
            for(int j=0;j<res.a[0].length;j++){
                res.a[i][j]=a[j][i];
            }
        }
        return res;
    }
    /*
        m       a
       `2x3     3x4        2x4
        1 2 3   1 2 1 2    * * * *
        3 2 1   4 2 5 5    * * * *
                3 7 2 4
    */
    public Matrix mul(Matrix m){
        int aRows=a.length,aCols=a[0].length,mRows=m.a.length,mCols=m.a[0].length;
        Matrix res=new Matrix();
        if(aCols==mRows){
            res=new Matrix(aRows,mCols);
            for(int i=0;i<res.a.length;i++){
                for(int j=0;j<res.a[0].length;j++){
                    for(int k=0;k<aCols;k++){
                        res.a[i][j]+=a[i][k]*m.a[k][j];
                    }
                }
            }
        }
        else if(aRows==mCols){
            res=new Matrix(mRows,aCols);
            for(int i=0;i<res.a.length;i++){
                for(int j=0;j<res.a[0].length;j++){
                    for(int k=0;k<aRows;k++){
                        res.a[i][j]+=m.a[i][k]*a[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Invalid Matrix");
            System.exit(0);
        }
        return res;
    }
    
    public void print(){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++) System.out.print(a[i][j]+" ");
            System.out.println("");
        }
    }
    
    public void input(){
        Scanner in=new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++) a[i][j]=in.nextFloat();
        }
    }
}
