import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class LibraryTest {

    Library library;

    private Book book;
    private Book book2;
    private Book book3;

    @Before
    public void before() {

        library = new Library("CodeClan Library");
        book = new Book("Harry Potter", "JK Rowling", "Fantasy");
        book2 = new Book("Lord of the Rings", "J R R Tolkien", "Fantasy");
        book3 = new Book("ACOTAR", "Sarah J Maas", "Romance");
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan Library", library.getName());
    }

    @Test
    public void hasNoBooks() {
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddBook() {
        library.addBook(book);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void libraryHasBookByTitle__true() {
        library.addBook(book);
        library.addBook(book2);
        assertEquals(true, library.isBookInLibrary(book.getTitle()));
    }

    @Test
    public void libraryHasBookByTitle__false() {
        assertEquals(false, library.isBookInLibrary(book.getTitle()));
    }

//    Extension
    @Test
    public void checkGenreFrequencies() {
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);

        HashMap<String, Integer> frequencies = library.genreFrequencies();

        int numberOfClassics = frequencies.get("Fantasy");
        assertEquals(2, numberOfClassics);

        int numberOfMysteries = frequencies.get("Romance");
        assertEquals(1, numberOfMysteries);
    }

}