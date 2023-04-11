import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private ArrayList<Book> books;

    private HashMap<String, Integer> countGenre;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.countGenre = new HashMap<>();
    }
    public String getName() {
        return this.name;
    }

    public int bookCount() {
        return this.books.size();
    }


    public void addBook(Book book) {
        this.books.add(book);
//        everytime you add a book you want to update the genre also add the genre count
        String genre = book.getGenre();
        if(this.countGenre.containsKey(genre)) {
            // gets the value of the given key
//          // setting count as the value pair for the key
            int count = this.countGenre.get(genre);
            // inserts new entry into the HashMap and the value of count
            this.countGenre.put(genre, count + 1);
        } else {
//            count will remain as one until it has to change
            this.countGenre.put(genre, 1);
        }

    }

    public int getCountGenre(String genre) {
        if (this.countGenre.containsKey(genre)) {
            return this.countGenre.get(genre);
        } else {
            return 0;
        }
    }

    public boolean isBookInLibrary(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
