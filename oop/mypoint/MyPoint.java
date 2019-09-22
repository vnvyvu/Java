package oop.mypoint;

/**
 *
 * @author VyVu
 */
public class MyPoint {
    private double x,y;

    public MyPoint() {
        x=0;y=0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint p) {
        this.x=p.x;
        this.y=p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance(MyPoint secondPoint){
        if(this==secondPoint) return 0;
        return Math.sqrt(Math.pow(x-secondPoint.x,2)+Math.pow(y-secondPoint.y,2));
    }
    
    public static double distance(MyPoint p1,MyPoint p2){
        if(p1==p2) return 0;
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    
    @Override
    public String toString(){
        return "("+x+" ,"+y+")";
    }
}
