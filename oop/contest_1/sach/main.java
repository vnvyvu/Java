package oop.contest_1.sach;

import java.io.*;
import java.util.*;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Sach> ds=new LinkedList<>();
        Scanner in=new Scanner(new File("SACH.INP"));
        while(in.hasNextLine()){
            try {
                ds.add(new Sach(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            } catch (SachException ex) {
                
            } catch (NoSuchElementException ex){
                
            }
        }
        in.close();
        
        for(int i=0;i<ds.size();i++){
            System.out.println(ds.get(i).toString());
        }
        
        Collections.sort(ds,Sach::cmpGiaSach);
        PrintWriter out=new PrintWriter("SXS.OUT");
        for(int i=0;i<ds.size();i++){
            out.write(ds.get(i).toString()+"\n");
        }
        out.close();
        
        out=new PrintWriter("CN.OUT");
        Collections.sort(ds,Sach::cmpTSCN);
        for(int i=0;i<ds.size();i++){
            out.write(ds.get(i).toString()+"\n");
        }
        out.close();
    }
}
