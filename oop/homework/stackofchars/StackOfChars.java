package oop.homework.stackofchars;

import java.util.Arrays;

/**
 *
 * @author PREDATOR
 */
public class StackOfChars {
    private char []elements;
    private int size;

    public StackOfChars() {
        size=0;
        elements=new char[16];
    }

    public StackOfChars(int capacity) {
        this.size=0;
        this.elements=new char[capacity];
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public boolean isFull(){
        return size==elements.length;
    }
    
    public char peak(){
        if(!isEmpty()){
            return elements[size-1];
        }
        else{
            System.out.println("Empty!");
            System.exit(0);
            return 0;
        }
    }
    
    public void push(char ch){
        if(!isFull()){
            elements[size]=ch;
            size++;
        }
        else{
            System.out.println("Full!");
            System.exit(0);
        }
    }
    
    public char pop(){
        if(!isEmpty()){
            size--;
            return elements[size];
        }
        else{
            return (Character) null;
        }
    }
    
    public int getSize(){
        return size;
    }
    
    @Override
    public String toString(){
        return ""+Arrays.toString(elements);
    }
}
