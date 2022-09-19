import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product items1 = new Book(5, "Book", 1000, "Author1");
    Product items2 = new Book(2, "Book", 11000, "Author2");
    Product items3 = new Book(3, "Book", 7000, "Author1");
    Product items4 = new Smartphone(12, "Smartphone", 99000, "Apple");
    Product items5 = new Smartphone(9, "Smartphone", 56000, "Samsung");


    @BeforeEach
    public void setup() {
        manager.add(items1);
        manager.add(items2);
        manager.add(items3);
        manager.add(items4);
        manager.add(items5);
    }

    @Test
    public void testAdd() {
        Product[] expected = {items1, items2, items3, items4, items5};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDelById() {
        manager.del(items4.getId());

        Product[] expected = {items1, items2, items3, items5};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDelById1() {
        manager.del(items1.getId());
        manager.del(items3.getId());

        Product[] expected = {items2, items4, items5};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDelById2() {
        manager.del(items1.getId());
        manager.del(items2.getId());
        manager.del(items3.getId());
        manager.del(items4.getId());
        manager.del(items5.getId());

        Product[] expected = {};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements() {
        Product[] expected = {items4};
        Product[] actual = manager.searchBy1("Apple");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements1() {
        Product[] expected = {};
        Product[] actual = manager.searchBy1("Book");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements2() {
        Product[] expected = {};
        Product[] actual = manager.searchBy1("Book1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements3() {
        Product[] expected = {items1, items3};
        Product[] actual = manager.searchBy1("Author1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements4() {
        Product[] expected = {items5};
        Product[] actual = manager.searchBy1("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindElements5() {
        Product[] expected = {};
        Product[] actual = manager.searchBy1("Smartphone");
        Assertions.assertArrayEquals(expected, actual);
    }
}
