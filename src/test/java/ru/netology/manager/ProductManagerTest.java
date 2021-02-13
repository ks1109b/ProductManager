package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Book 1", 345, "Author");
    private Book secondBook = new Book(2, "Book 2", 676, "Author");
    private Smartphone firstSmartphone = new Smartphone(3, "X", 10000, "Samsung");
    private Smartphone secondSmartphone = new Smartphone(4, "17 Pro", 150000, "Meizu");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Book 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = manager.searchBy("Author");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturer() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("Meizu");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("X");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNone() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("666");
        assertArrayEquals(expected, actual);
    }
}