package oop.homework.matrix;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int rows,cols,key;
        Matrix a1,a2;
        String list[]={"Tính tổng và hiệu hai ma trận;","Tính tích hai ma trận","Tìm chuyển vị của một ma trận","Kết thúc chương trình"};
        while(1<2){
            for(int i=0;i<list.length;i++){
                System.out.println((i+1)+"."+list[i]);
            }
            System.out.print("Nhập lựa chọn: ");
            key=in.nextInt();
            switch(key){
                case 1:{
                    System.out.println("Nhập ma trận A: [Nhập hàng cột][Nhập giá trị]");
                    rows=in.nextInt();
                    cols=in.nextInt();
                    a1=new Matrix(rows,cols);
                    a1.input();
                
                    System.out.println("Nhập ma trận B: [Nhập hàng cột][Nhập giá trị]");
                    rows=in.nextInt();
                    cols=in.nextInt();
                    a2=new Matrix(rows,cols);
                    a2.input();

                    System.out.println("A+B");
                    a1.add(a2).print();
                    System.out.println("");
                    System.out.println("A-B");
                    a1.sub(a2).print();
                    
                    break;
                }
                case 2:{
                    System.out.println("Nhập ma trận A: [Nhập hàng/cột][Nhập giá trị]");
                    rows=in.nextInt();
                    cols=in.nextInt();
                    a1=new Matrix(rows,cols);
                    a1.input();

                    System.out.println("Nhập ma trận B: [Nhập hàng/cột][Nhập giá trị]");
                    rows=in.nextInt();
                    cols=in.nextInt();
                    a2=new Matrix(rows,cols);
                    a2.input();

                    System.out.println("A*B");
                    a1.mul(a2).print();

                    break;
                }
                case 3:{
                    System.out.println("Nhập ma trận A: [Nhập hàng/cột][Nhập giá trị]");
                    rows=in.nextInt();
                    cols=in.nextInt();
                    a1=new Matrix(rows,cols);
                    a1.input();

                    System.out.println("A^T");
                    a1.transpose().print();
                    break;
                }
                case 4:{
                    System.exit(0);
                }
            }
        }
    }
}