import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Product items1 = new Book(5, "book1", 1000, "k1");
    Product items2 = new Book(2, "book2", 11000, "k2");
    Product items3 = new Book(3, "book3", 7000, "k3");
    Product items4 = new Smartphone(12, "Smartphone", 99000, "Apple");
    Product items5 = new Smartphone(9, "Smartphone", 56000, "Samsung");


    @BeforeEach
    public void setup() {
        repo.save(items1);
        repo.save(items2);
        repo.save(items3);
        repo.save(items4);
        repo.save(items5);
    }

    @Test
    public void testSave() {

        Product[] expected = {items1, items2, items3, items4, items5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        repo.removeById(items4.getId());

        Product[] expected = {items1, items2, items3, items5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

}
