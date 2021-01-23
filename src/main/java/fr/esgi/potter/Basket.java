package fr.esgi.potter;

import fr.esgi.potter.book.Book;

import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Book> books;
    private Double price = 0.0;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addProduct(Book book) {
        this.books.add(book);
    }

    public void calculatePrice() {
        for (Book book : books) {
            this.price += book.getPrice();
        }
        if (books.size() > 1) {
            this.price -= this.price * discount() / 100;
        }
    }

    public Double getPrice() {
        return price;
    }

    public Integer discount() {
        if (books.size() == 2) {
            return 5;
        } else if (books.size() == 3) {
            return 10;
        } else if (books.size() == 4) {
            return 20;
        } else if (books.size() == 5) {
            return 25;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(books, basket.books) && Objects.equals(price, basket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, price);
    }
}
