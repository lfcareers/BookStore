import java.util.Scanner;

// test/driver class
public class TestBook {
    private static String[] args;

    // main method
    public static void main(String[] args) {
        TestBook.args = args;
        // create an array to store 100 books
        Book[] books = new Book[100];

        // instantiate Scanner
        Scanner sc = new Scanner(System.in);

        // display a welcome message
        System.out.println("Welcome to the book program!");

        // required variables
        int n = 0, countBB = 0, countLB = 0;
        String choice;

        // loop till the user wishes to enter book details
        do {
            // prompt the user whether they would like to enter book details
            System.out.print("\nWould you like to create a book object? (yes/no): ");
            choice = sc.next();
            // validate the choice of the user
            while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                System.out.print("Im sorry but "+choice+" is not a valid answer! Please enter either yes or no: ");
                choice = sc.next();
            }

            // break the loop if choice is no
            if (choice.equalsIgnoreCase("no"))
                break;

            sc.nextLine();
            // input the book details from the user
            System.out.print("\nPlease enter the author, title and the isbn of the book separated by /: ");
            String details = sc.nextLine();
            System.out.println("Got it!");
            // split the input with respect to '/'
            String[] tokens = details.split("/");

            // input whether the book is a BookStore book or Library book
            System.out.print("Now, tell me if it is a bookstore book or a library book(enter BB for bookstore book or LB for library book): ");
            String type = sc.next();
            // validate the type of the book
            while (!type.equalsIgnoreCase("BB") && !type.equalsIgnoreCase("LB")) {
                // re-input the type if it is invalid
                System.out.print("Oops! That's not a valid entry. Please try again: ");
                type = sc.next();
            }
            System.out.println("Got it!");

            // if the book is a bookstore book
            if(type.equalsIgnoreCase("BB")) {
                countBB++;
                // input the price of the book
                System.out.print("Please enter the list price of "+tokens[1].toUpperCase()+" by "+tokens[0].toUpperCase()+": ");
                double price = sc.nextDouble();
                // input whether the book is on sale
                boolean isSale = false;
                System.out.print("Is it on sale? (y/n): ");
                char sale = sc.next().charAt(0);
                // input the deduction percentage if the book is on sale
                double deduct = 0;
                if (sale == 'y') {
                    // input the deduction percentage
                    System.out.print("Deduction percentage: ");
                    String[] deduction = sc.next().split("%");
                    deduct = Double.parseDouble(deduction[0]);
                    // set isSale to true
                    isSale = true;
                }
                System.out.println("Got it!");

                // create a BookstoreBook object with the inputted details & save it in the array
                books[n] = new BookstoreBook(tokens[0], tokens[1], tokens[2], price, deduct, isSale);

                // display the book information
                System.out.println("\nHere is your bookstore book information");
                System.out.println(books[n]);
            }

            // else if the book is a library book
            else if(type.equalsIgnoreCase("LB")) {
                countLB++;
                // create a LibraryBook object with the inputted details & save it in the array
                books[n] = new LibraryBook(tokens[0], tokens[1], tokens[2]);

                // display the book information
                System.out.println("\nHere is your library book information");
                System.out.println(books[n]);
            }

            // increment the number of books in the array
            n++;
        } while(!choice.equalsIgnoreCase("no"));
        System.out.println("Sure!\n");

        System.out.println("Here are all your books...");
        // first display all the library books
        System.out.println("Library Books ("+countLB+")");
        // loop through the books stored in the array
        for (int i = 0; i < n; i++) {
            // print the book details if the current book is a library book
            if (books[i] instanceof LibraryBook)
                System.out.println("\t"+books[i].toString());
        }
        System.out.println("----");

        // secondly display all the bookstore books
        System.out.println("Bookstore Books ("+countBB+")");
        // loop through the books stored in the array
        for (int i = 0; i < n; i++) {
            // print the book details if the current book is a bookstore book
            if (books[i] instanceof BookstoreBook)
                System.out.println("\t"+books[i].toString());
        }
        System.out.println("----");

        System.out.println("Take care now!");
    }
}