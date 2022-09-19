public class ProductManager {
    // позиции продукта будет хранить Не самостоятельно, а
    // через репозиторий
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;               // конструктор
    }

    // добавление элемента
    public void add(Product product) {
        repo.save(product);
    }

    public void del(int id) {
        repo.removeById(id);
    }

    // показать все элементы
    public Product[] getProd() {
        return repo.getItems();
    }

//    public Product[] searchBy(String text) {
//        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукт
//        for (Product product : getProd()) {
//            if (matches(product, text)) {
//                add(product); // записать элемент найденный по запросу
//            }
//        }
//        return result;
//    }

    public Product[] searchBy1(String text) {
        Product[] all = getProd(); // в product грузим все элементы
        int count = 0;                  // счетчик для определения длины нового массива
        for (int i = 0; i < all.length; i++) {
            if (matches(all[i], text)) {
                count++;
            }
        }
        Product[] result = new Product[count]; // в result массив нужной длины
        int countElements = 0;
        for (int i = 0; i < all.length; i++) {
            if (matches(all[i], text)) {
                result[countElements] = all[i]; // копируем все элементы
                countElements++; //
            }
        }
        return result;
    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
//        return product.getNameProduct().contains(search);
    }


}
