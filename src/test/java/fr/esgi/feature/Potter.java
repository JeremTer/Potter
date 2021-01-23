package fr.esgi.feature;

import fr.esgi.potter.Basket;
import fr.esgi.potter.book.Book;

import java.util.List;

public class Potter {
    private final Basket basket;
    private List<Book> books;

    public Potter(final Basket basket) {
        this.basket = basket;
    }

    public Basket basket() {
        return basket;
    }

    public List<Book> books() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
