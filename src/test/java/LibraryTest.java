import org.junit.Before;
import org.junit.Test;

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
    public void libraryHasBookByTitle() {
        library.addBook(book);
        library.addBook(book2);
        assertEquals(true, library.isBookInLibrary("Lord of the Rings"));
    }

    @Test
    public void libraryDoesNotHaveBookByTitle() {
        library.addBook(book);
        assertEquals(false, library.isBookInLibrary("Game of Thrones"));
    }

    @Test
    public void getCountOfBooksByFantasyGenre() {
        library.addBook(book);
        library.addBook(book2);
        assertEquals(2, library.getCountGenre("Fantasy"));
    }

    @Test
    public void getCountOfBooksByRomanceGenre() {
        library.addBook(book3);
        assertEquals(1, library.getCountGenre("Romance"));
    }
    @Test
    public void getCountOfBooksByHorrorGenre() {
        assertEquals(0, library.getCountGenre("Horror"));
    }

}