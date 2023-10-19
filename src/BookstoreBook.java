// create a class that represents a Bookstore's book that inherits a Book
public class BookstoreBook extends Book {
    // additional private instance fields
    private double price, deductionPercent;
    private boolean isOnSale;

    // default constructor
    public BookstoreBook() {
        // invoke the superclass default constructor to initialize the base class fields
        super();
        // initialize the additional data fields to the default values
        setPrice(0);
        setDeductionPercent(0);
        setIsOnSale(false);
    }

    // parameterized constructor
    public BookstoreBook(String author, String title, String isbn, double price, double deductionPercent, boolean isOnSale) {
        // invoke the superclass parameterized constructor to initialize the base class fields
        super(author, title, isbn);
        // initialize the additional data fields to the given parameters
        setPrice(price);
        setDeductionPercent(deductionPercent);
        setIsOnSale(isOnSale);
    }

    // getters for the additional instance fields
    public double getPrice() { return price; }
    public double getDeductionPercent() { return deductionPercent; }
    public boolean getIsOnSale() { return isOnSale; }

    // setters for the additional instance fields
    public void setPrice(double price) { this.price = price; }
    public void setDeductionPercent(double deductionPercent) { this.deductionPercent = deductionPercent; }
    public void setIsOnSale(boolean isOnSale) { this.isOnSale = isOnSale; }

    // method that returns the string representation of the object
    @Override
    public String toString() {
        double finalPrice = price;
        // apply the deduction percentage on the price if the book is on sale
        if (isOnSale)
            finalPrice -= (price * (deductionPercent / 100.0));
        return "["+super.toString()+String.format(", $%.2f listed for $%.2f]", price, finalPrice);
    }
}