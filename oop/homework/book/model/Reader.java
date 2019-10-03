package oop.homework.book.model;

/**
 *
 * @author VyVu
 */
public class Reader {
    private static long readerID=10000000;
    public static final String file="READER.DAT";
    private String fullName,address,phoneNumber;

    public Reader() {
    }

    public Reader(String fullName, String address, String phoneNumber) throws PhoneNumberException {
        if(phoneNumber.replaceAll("[-+]", "").length()!=10){
            throw new PhoneNumberException("Invalid! The length of phoneNumber must be: 10");
        }
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        Reader.readerID++;
    }
    
    public String toString(){
        return ""+readerID+" "+fullName+" "+address+" "+phoneNumber;
    }
}
