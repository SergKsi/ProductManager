public class Product {
    protected int id;
    protected String nameProduct;
    protected int costProduct;

    public Product(int id, String nameProduct, int costProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNameProduct() {
        return nameProduct;
    }

//    public void setNameProduct(String nameProduct) {
//        this.nameProduct = nameProduct;
//    }

//    public int getCostProduct() {
//        return costProduct;
//    }

//    public void setCostProduct(int costProduct) {
//        this.costProduct = costProduct;
//    }
//
//    public boolean isToExpensive() {
//        if (costProduct > 1_000_000) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void used () {
//        System.out.println("Проудкт " + nameProduct + "используется" );
//    }
//
//
//    public void save(Product item) {
//        save(item);
//    }
}
