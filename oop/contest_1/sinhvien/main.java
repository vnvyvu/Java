package oop.contest_1.sinhvien;

import java.io.*;
import java.util.*;


/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in=new Scanner(new File("SV.INP"));
        List<SinhVien> ds=new LinkedList<SinhVien>();
        while(in.hasNextLine()){
            try {
                ds.add(new SinhVien(Integer.parseInt(in.nextLine()),in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine())));
            } catch (SinhVienException ex) {
                
            } catch (NoSuchElementException ex){
                
            }
        }
        in.close();
        
        for(int j=0;j<ds.size();j++){
            System.out.println(ds.get(j));
            System.out.println(ds.get(j).getTen()+" "+ds.get(j).getHoDem());
        }
        Collections.sort(ds, SinhVien::compareLop);
        PrintWriter out=new PrintWriter(new File("SX.OUT"));
        for(int j=0;j<ds.size();j++){
            out.write(ds.get(j).toString()+"\n");
        }
        out.close();
        
        out=new PrintWriter(new File("XEPLOAI.OUT"));
        Collections.sort(ds, SinhVien::compareDTB);
        for(int j=0;j<ds.size();j++){
            out.write(ds.get(j).toString()+"\n");
        }
        out.close();
    }
}
