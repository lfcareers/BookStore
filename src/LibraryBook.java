import java.util.Random;

// create a class that represents a Library's book that inherits a Book
public class LibraryBook extends Book {
    // additional private instance field
    private String callNumber;

    // default constructor
    public LibraryBook() {
        // invoke the superclass default constructor to initialize the base class fields
        super();
        // initialize the additional data field to an automated value
        generateCallNumber();
    }

    // parameterized constructor
    public LibraryBook(String author, String title, String isbn) {
        // invoke the superclass parameterized constructor to initialize the base class fields
        super(author, title, isbn);
        // initialize the additional data field to an automated value
        generateCallNumber();
    }

    // getters for the additional instance field
    public String getCallNumber() { return callNumber; }

    // a private method to generate a call number
    private void generateCallNumber() {
        // create a Random class object
        Random rand = new Random();
        // create a random number between 0 and 99
        int floorNum = rand.nextInt(100);
        // get the first three letters of te author's name
        String auth = super.getAuthor().substring(0, 3).toUpperCase();
        // get the last character of the isbn
        char isbnLast = super.getISBN().charAt(super.getISBN().length()-1);
        // set the call number
        callNumber = floorNum+ "."+auth+"."+isbnLast;
    }

    // method that returns the string representation of the object
    @Override
    public String toString() {
        return "["+super.toString()+"-"+callNumber+"]";
    }
}