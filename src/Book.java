// create an abstract class that represents a Book
public abstract class Book {
    // private instance fields
    private String author, title, isbn;

    // default constructor
    public Book() {
        // initialize instance fields to the default values
        setAuthor("N/A");
        setTitle("N/A");
        setISBN("N/A");
    }

    // constructor
    public Book(String author, String title, String isbn) {
        // initialize instance fields to the given parameters
        setAuthor(author);
        setTitle(title);
        setISBN(isbn);
    }

    // getters for the instance fields
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getISBN() { return isbn; }

    // setters for the instance fields
    public void setAuthor(String author) { this.author = author.toUpperCase(); }
    public void setTitle(String title) { this.title = title.toUpperCase(); }
    public void setISBN(String isbn) { this.isbn = isbn; }

    // method that returns the string representation of the Book object
    @Override
    public String toString() {
        return isbn+"-"+title.toUpperCase()+" by "+author.toUpperCase();
    }
}
