package oop.homework.book.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import oop.homework.book.model.*;

/**
 *
 * @author VyVu
 */
public class DataController {
    private String file;

    public DataController(String file) {
        this.file = file;
    }
    
    
    public void write(Object a) throws FileNotFoundException{
        PrintWriter w=new PrintWriter(file);
        w.append(a+"\n");
        w.close();
    }
    public void read(Object a) throws FileNotFoundException, SpecializeException, PhoneNumberException{
        String obj;
        Scanner r=new Scanner(new File(file));
        if(r.hasNextLine()){
            obj=r.nextLine();
            Scanner i=new Scanner(obj).useDelimiter(" ");
            if(file.equals(Book.file)){
                a=new Book(i.next(), i.next(), i.next(), Integer.parseInt(i.next()), i.next());
            }
            else if(file.equals(Reader.file)){
                a=new Reader(i.next(), i.next(), i.next());
            }
            else if(file.equals(BookReaderManagerment.file)){
                a=new BookReaderManagerment(new Reader(i.next(), i.next(), i.next()), new Book(i.next(), i.next(), i.next(), Integer.parseInt(i.next()), i.next()));
            }
        }
        else{
            System.out.println("Empty file!");
        }
        r.close();
    }
}
