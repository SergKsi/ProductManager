public class Smartphone extends Product {

    private String manufacturerSmartphone;

//    public String getManufacturerSmartphone() {
//        return manufacturerSmartphone;
//    }
//
//    public void setManufacturerSmartphone(String manufacturerSmartphone) {
//        this.manufacturerSmartphone = manufacturerSmartphone;
//    }


    public Smartphone(int id, String nameProduct, int costProduct, String manufacturerSmartphone) {
        super(id, nameProduct, costProduct);
        this.manufacturerSmartphone = manufacturerSmartphone;
    }
//
//    @Override
//    public void used() {
//        System.out.println("Смарфон " + nameProduct + " звонит");
//        ;
//    }
//
//    @Override
//    public void save(Product item) {
//        super.save(item);
//    }
}
