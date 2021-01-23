package fr.esgi.potter;

import fr.esgi.potter.book.Book;

import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addProduct(Book book) {
        this.books.add(book);
    }

    public Double calculatePrice() {
        return 0.0;
    }

    public Double getDiscount() {
        return 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(books, basket.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
