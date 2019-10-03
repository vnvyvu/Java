package oop.homework.phanso;

import java.util.Scanner;


/**
 *
 * @author VyVu
 */
public class PhanSo {
    private int ts,ms;

    public PhanSo() {
        ts=0;
        ms=1;
    }

    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
        if(ms==0){
            System.out.println("Invalid");
            System.exit(0);
        }
    }
    
    public PhanSo cong(PhanSo sp2){
        return new PhanSo(ts*sp2.ms+sp2.ts*ms,ms*sp2.ms);
    }
    
    public PhanSo tru(PhanSo sp2){
        return new PhanSo(ts*sp2.ms-sp2.ts*ms,ms*sp2.ms);
    }
    
    public PhanSo nhan(PhanSo sp2){
        return new PhanSo(ts*sp2.ts,ms*sp2.ms);
    }
    
    public PhanSo chia(PhanSo sp2){
        return this.nhan(sp2.nghichDao());
    }
    
    public PhanSo nghichDao(){
        return new PhanSo(ms,ts);
    }
    
    public PhanSo doiDau(){
        return new PhanSo(ts*-1,ms);
    }
    
    public PhanSo toiGian(){
        PhanSo res=new PhanSo(ts,ms);
        int i=res.ts;
        while(i>=2){
            if((res.ts%i)==0&&(res.ms%i)==0){
                res.ts/=i;
                res.ms/=i;
            }
            else i--;
        }
        return res;
    }
    
    public boolean bangNhau(PhanSo sp2){
        return this.tru(sp2).ts==0;
    }
    
    public boolean lonHon(PhanSo sp2){
        return this.tru(sp2).ts>0;
    }
    
    public boolean nhoHon(PhanSo sp2){
        return this.tru(sp2).ts<0;
    }
    
    @Override
    public String toString(){
        return (ms==0)?"Mẫu số không hợp lệ (ms=0)":(ts==0)?Integer.toString(ts):(ts==ms)?Integer.toString(ts):""+ts+"/"+ms;
    }
    
    public void nhap(){
        Scanner input=new Scanner(System.in);
        Scanner filter=new Scanner(input.nextLine()).useDelimiter("/");
        this.ts=Integer.parseInt(filter.next());
        this.ms=Integer.parseInt(filter.next());
    }
}
