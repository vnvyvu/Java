package oop.homework.rectangle;
/**
 *
 * @author PREDATOR
 */
public class Rectange {
    private double width,height;
    private String color;
    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    @Override
    public String toString(){
        return "Chieu rong: "+getWidth()+"\nChieu dai: "+getHeight()+"\nMau: "+getColor()+"\nDien tich: "+findArea()+"\nChu vi: "+findPerimeter();
    }
    public Rectange() {
        this.width=this.height=1;
    }
    public double findArea(){
        return 1.0*this.width*this.height;
    }
    public double findPerimeter(){
        return 1.0*2*(this.width+this.height);
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public String getColor() {
        return color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
