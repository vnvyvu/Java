package oop.homework.stackofintegers;

/**
 *
 * @author PREDATOR
 */
public class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers() {
        this.elements=new int[16];
        this.size=0;
    }

    public StackOfIntegers(int capacity) {
        this.elements = new int[capacity];
        this.size=0;
    }
    
    public boolean isEmpty(){
        return this.size==0;
    }
    
    public boolean isFull(){
        return this.size==this.elements.length;
    }
    
    public int peak(){
        if(!this.isEmpty()) return this.elements[this.size-1];
        return (Integer)null;
    }
    
    public void push(int value){
        if(!this.isFull()){
            this.size++;
            this.elements[this.size-1]=value;
        }
        else{
            System.out.println("Full!");
            System.exit(0);
        }
    }
    
    public int pop(){
        if(!this.isEmpty()){
            this.size--;
            return this.elements[this.size];
        }
        return (Integer)null;
    }
    public int getSize() {
        return this.size;
    }
}
