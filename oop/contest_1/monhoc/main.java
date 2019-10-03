package oop.contest_1.monhoc;

import java.util.*;
import java.io.*;

/**
 *
 * @author VyVu
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        List<MonHoc> ds=new LinkedList<>();
        Scanner in=new Scanner(new File("MoH.INP"));
        while(in.hasNextLine()){
            try {
                ds.add(new MonHoc(Integer.parseInt(in.nextLine()), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
            } catch (MonHocException ex) {
                
            } catch(NoSuchElementException ex){
                
            }
        }
        in.close();
        
        for (MonHoc d : ds) {
            System.out.println(d);
        }
        
        ds.sort(MonHoc::cmpSoTinChi);
        PrintWriter out=new PrintWriter("SXM.OUT");
        for (MonHoc d : ds) {
            out.write(d.toString()+"\n");
        }
        out.close();
        
        ds.sort(MonHoc::cmpNMTM);
        out=new PrintWriter("NHOMH.OUT");
        for (MonHoc d : ds) {
            out.write(d.toString()+"\n");
        }
    }
}
