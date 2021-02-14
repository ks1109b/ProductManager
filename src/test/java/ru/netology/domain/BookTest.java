package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldMatchesByAuthor() {
        Book book = new Book(1, "Book 1", 345, "Author");
        assertEquals(true, book.matches("Author"));
    }

    @Test
    public void shouldMatchesByName() {
        Book book = new Book(1, "Book 1", 345, "Author");
        assertEquals(true, book.matches("Book 1"));
    }

    @Test
    public void shouldMatchesIfNone() {
        Book book = new Book(2, "Book 2", 676, "Author");
        assertEquals(false, book.matches("Book 1"));
    }
}