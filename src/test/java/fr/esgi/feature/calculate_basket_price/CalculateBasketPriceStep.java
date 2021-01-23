package fr.esgi.feature.calculate_basket_price;

import fr.esgi.feature.Potter;
import fr.esgi.potter.book.Book;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

public class CalculateBasketPriceStep {

    private final Potter potter;

    public CalculateBasketPriceStep(final Potter potter) {
        this.potter = potter;
    }

    @Given("My basket contains the books$")
    public void myBasketContainsTheBooks(List<String> bookTitles) {
        final List<Book> books = potter.books()
                .stream()
                .filter(book -> bookTitles.contains(book.getTitle()))
                .collect(Collectors.toList());

        potter.basket().setBooks(books);
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        potter.basket().calculatePrice();
    }

    @Then("I should pay {double}")
    public void iShouldPay(Double sum) {
        Assertions.assertEquals(sum, potter.basket().getPrice());
    }
}
