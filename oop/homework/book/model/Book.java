package oop.homework.book.model;

import java.util.Arrays;

/**
 *
 * @author VyVu
 */
public class Book {
    private static int iD=100000;
    public final static String file="BOOK.DAT";
    private String bookName,author,specialization,quantity;
    private int bookID,publishYear;
    private final String specializeList[]={"Science","Art","Economic","IT"};
    public Book(String bookName, String author,String specialization, int publishYear, String quantity) throws SpecializeException{
        this.specialization=specialization;
        if(Arrays.binarySearch(specializeList, specialization)==-1){
            throw new SpecializeException("Invalid! The value of specialization must be one of :"+Arrays.toString(specializeList));
        }
        this.bookName = bookName;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.bookID=iD++;
    }

    public Book() {
        
    }
    
    
    @Override
    public String toString(){
        return ""+bookID+" "+bookName+" "+author+" "+specialization+" "+publishYear+" "+quantity;
    }
}
