package fr.esgi.potter;

import fr.esgi.potter.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Book> singleBooks;
    private final List<Book> duplicateBooks;

    private Double price;

    public Basket() {
        singleBooks = new ArrayList<>();
        duplicateBooks = new ArrayList<>();
        price = 0.0;
    }

    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>();
        allBooks.addAll(singleBooks);
        allBooks.addAll(duplicateBooks);
        return allBooks;
    }

    public void setBooks(List<Book> books) {
        for (Book book : books) {
            addBook(book);
        }
    }

    public void addBook(Book book) {
        if (singleBooks.contains(book)) {
            duplicateBooks.add(book);
        } else {
            singleBooks.add(book);
        }
    }

    private void calculateSingleBooksPrice() {
        for (Book book : singleBooks) {
            this.price += book.getPrice();
        }
        if (singleBooks.size() > 1) {
            this.price -= this.price * getDiscount() / 100;
        }
    }

    public void calculatePrice() {
        calculateSingleBooksPrice();
        for (Book book : duplicateBooks) {
            this.price += book.getPrice();
        }
    }

    public Double getPrice() {
        return price;
    }

    public Integer getDiscount() {
        if (singleBooks.size() == 2) {
            return 5;
        } else if (singleBooks.size() == 3) {
            return 10;
        } else if (singleBooks.size() == 4) {
            return 20;
        } else if (singleBooks.size() == 5) {
            return 25;
        }
        return 1;
    }

    
}
