package fr.esgi.feature.standard;

import fr.esgi.feature.Potter;
import fr.esgi.potter.book.Book;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultBooksStep {

    private final Potter potter;
    private Scenario scenario;

    public DefaultBooksStep(final Potter potter) {
        this.potter = potter;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("default books are used")
    public void defaultBooksAreUsed() {
        createDefaultBooks();
    }

    @Before("@default_books")
    public void createDefaultBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter and The Philosopher s Stone", 8));
        books.add(new Book("Harry Potter and The Chamber of Secrets", 8));
        books.add(new Book("Harry Potter and The Prisoner of Azkaban", 8));
        books.add(new Book("Harry Potter and The Goblet of Fire", 8));
        books.add(new Book("Harry Potter and The Order of the Phoenix", 8));
        potter.setBooks(books);
    }

    @Then("the available books should be at least:$")
    public void theAvailablePropertiesShouldBeAtLeast(List<Book> books) {
        Assertions.assertThat(potter.books()).containsAll(books);
    }

    @DataTableType
    public Book book(Map<String, String> entry) {
        return new Book(entry.get("title"),
                Integer.parseInt(entry.get("price")));
    }
}
