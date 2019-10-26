package oop.contest_1.mathang;

import java.io.*;
import java.util.*;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        List<MatHang> ds=new LinkedList<>();
        Scanner in=new Scanner(new File("MH.INP"));
        while(in.hasNextLine()){
            try {
                ds.add(new MatHang(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            } catch (MatHangException | NoSuchElementException ex) {
                
            }
        }
        in.close();
        for(int i=0;i<ds.size();i++){
            System.out.println(ds.get(i));
        }
        
        Collections.sort(ds,MatHang::cmpGiaBan);
        
        PrintWriter out=new PrintWriter(new File("SX.OUT"));
        for(int i=0;i<ds.size();i++){
            out.write(ds.get(i).toString()+"\n");
        }
        out.close();
        
        Collections.sort(ds,MatHang::cmpNT);
        out=new PrintWriter("NHOM.OUT");
        for(int i=0;i<ds.size();i++){
            out.write(ds.get(i).toString()+"\n");
        }        
        out.close();
    }
}
