public class ProductRepository {

    private Product[] items = new Product[0]; // изначально массив = 0

    // добавить элемент к массиву
    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1]; // новый массив на 1 больше, чем старый.
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];                          // копируем все из старого массива в новый
        }
        tmp[tmp.length - 1] = item; // заполняем последнююю ячейку
        items = tmp;            // "переносим" элементы в массив
    }

    // удаляет элемент по id
    public void removeById(int id) {
        int count = 0; //  счетчик элементов в новом массиве
        Product[] tmp = new Product[items.length - 1]; // новый массив на 1 меньше, чем старый
        for (int i = 0; i < items.length; i++) {
            if (!(items[i].id == id)) {
                tmp[count] = items[i];
                count++;
            }
        }
        items = tmp;
    }

    // возвращает все запомненные элементы
    public Product[] getItems() {
        return items;
    }

    // полностью вычищает репозиторий
//    public Product[] removeAll() {
//        Product[] product = new Product[0];
//        return product;
//    }

//    public boolean matches1(Product prod, String search) {
//        return prod.getNameProduct().contains(search);
//    }
}
