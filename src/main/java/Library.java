import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private ArrayList<Book> books;


    public Library(String name) {
        this.name = name;
//        Empty collection of books
        this.books = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int bookCount() {
        return this.books.size();
    }


    public void addBook(Book book) {
        this.books.add(book);
    }

    public HashMap<String, Integer> genreFrequencies() {
        HashMap<String, Integer> frequencies = new HashMap<>();
        for (Book book : this.books) {
            String genre = book.getGenre();
            if(!frequencies.containsKey(genre)) {
                frequencies.put(genre, 1);
            } else {
                int previousFrequency = frequencies.get(genre);
                int newFrequency = previousFrequency + 1;
                frequencies.replace(genre, newFrequency);
            }
        }
        return frequencies;
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
