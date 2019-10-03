package oop.homework.book.model;

/**
 *
 * @author VyVu
 */
public class BookReaderManagerment{
    public static final String file="BRM.DAT";
    private Reader reader;
    private Book book;

    public BookReaderManagerment() {
    }

    public BookReaderManagerment(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
    }
    
}
