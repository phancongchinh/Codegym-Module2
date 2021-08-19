public class Main {
    public static void main(String[] args) {
        Product iphone = new Product("iphone",11,40);
        Product samsung  = new Product("samsung",22,35);
        Product blackberry = new Product("blackberry",33,50);
        Product nokia = new Product("nokia",44,76);
        Product xiaomi = new Product("xiaomi",55,22);
        Product vertu = new Product("vertu",66,24);

        int index;

        ProductManager productManager = new ProductManager();
        productManager.add(iphone);
        productManager.add(samsung);
        productManager.add(blackberry);
        productManager.add(nokia);
        productManager.add(xiaomi);
        productManager.add(vertu);


        productManager.displayAll();

        System.out.println("================");
        productManager.delete(22);
        productManager.displayAll();

        System.out.println("================");
        productManager.display("iphone");

        System.out.println("================");
        productManager.display("nokia");

        System.out.println("================");
        productManager.display("blackberry");

        System.out.println("================");
        productManager.display(44);

        System.out.println("================");
        productManager.display(55);

        System.out.println("================");
        System.out.println(productManager.searchByName("iphone"));

        System.out.println("================");
        productManager.sortByPrice(ProductManager.INCREASING);
        productManager.displayAll();

        System.out.println("================");
        productManager.sortByPrice(ProductManager.DECREASING);
        productManager.displayAll();

        System.out.println("================");
        productManager.edit(3);
        productManager.displayAll();
    }
}
