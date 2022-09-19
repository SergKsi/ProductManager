import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product items1 = new Book(5, "book1", 1000, "k1");
    Product items2 = new Book(2, "book2", 11000, "k2");
    Product items3 = new Book(3, "book3", 7000, "k3");
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
    public void testFindElements() {
        Product[] expected = {items4, items5};
        Product[] actual = manager.searchBy1("Smartphone");
        Assertions.assertArrayEquals(expected, actual);
    }
}
