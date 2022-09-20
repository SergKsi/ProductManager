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

    // получать все сохранённые элементы
    @Test
    public void testGetAllElements() {
        Product[] expected = {items1, items2, items3, items4, items5};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    // добавление элемента
    @Test
    public void testAdd() {

        Product items6 = new Smartphone(19, "Smartphone", 96500, "Sony");

        manager.add(items6);

        Product[] expected = {items1, items2, items3, items4, items5, items6};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    // удаление элемента по id
    @Test
    public void testDelById() {
        manager.del(items4.getId());

        Product[] expected = {items1, items2, items3, items5};
        Product[] actual = manager.getProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    // поиск по названию - находится несколько товаров
    @Test
    public void testFindElements() {
        Product[] expected = {items4, items5};
        Product[] actual = manager.searchBy("Smartphone");
        Assertions.assertArrayEquals(expected, actual);
    }

    // находится ровно один товар
    @Test
    public void testFindElement() {
        Product[] expected = {items2};
        Product[] actual = manager.searchBy("book2");
        Assertions.assertArrayEquals(expected, actual);
    }

    // находится 0 товаров, т.е. ни один товар не подходит
    @Test
    public void testFindNullElement() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("book22");
        Assertions.assertArrayEquals(expected, actual);
    }

}
