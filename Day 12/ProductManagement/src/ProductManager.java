import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    public static final String INCREASING = "INCREASING";
    public static final String DECREASING = "DECREASING";
    public static final String ID_DOES_NOT_EXIST = "Id does not exist!";
    public static final String NAME_DOES_NOT_EXIST = "Name does not exist!";
    public static final String NEW_NAME = "new name: ";
    public static final String NEW_ID = "new ID: ";
    public static final String NEW_LIST_PRICE = "new list price: ";

    private final ProductComparator priceComparator = new ProductComparator();

//    private final ArrayList<Product> products = new ArrayList<>();

//    public boolean add(Product product){
//        if (this.doesExist(product)){
//            return false;
//        }
//        products.add(product);
//        return true;
//    }
//
//    public void edit(int id){
//        int index = searchById(id);
//        Product theProduct = products.get(index);
//        request(NEW_NAME);
//        theProduct.setName(scanner.nextLine());
//        request(NEW_ID);
//        theProduct.setId(scanner.nextInt());
//        request(NEW_LIST_PRICE);
//        theProduct.setListPrice(scanner.nextDouble());
//    }
//
//    public void request(String description){
//        System.out.println("Enter " + description);
//    }
//
//    public void delete(int id){
//        products.remove(searchById(id));
//    }
//
//    public void display(int id){
//        int index = searchById(id);
//        if (index != -1) {
//            System.out.println(products.get(index));
//        } else {
//            System.out.println(ID_DOES_NOT_EXIST);
//        }
//    }
//    public void display(String name){
//        int index = searchByName(name);
//        if (index != -1) {
//            System.out.println(products.get(index));
//        } else {
//            System.out.println(NAME_DOES_NOT_EXIST);
//        }
//    }
//
//    public void displayAll(){
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
//
//    public boolean doesExist(Product product){
//        return searchById(product.getId()) != -1 || searchByName(product.getName()) != -1;
//    }
//
//    public int searchByName(String name){
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getName().equals(name)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int searchById(int id){
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public void sortByPrice(String description) {
//        switch (description){
//            case INCREASING:
//                products.sort(priceComparator);
//                break;
//            case DECREASING:
//                products.sort(priceComparator);
//                Collections.reverse(products);
//                break;
//            default:
//                break;
//        }
//    }

    LinkedList<Product> products = new LinkedList<>();

    public void add(Product product){
        products.addLast(product);
    }

    public void request(String description){
        System.out.println("Enter " + description);
    }

    public void edit(int index){
        request(NEW_NAME);
        products.get(index).setName(scanner.nextLine());
        request(NEW_ID);
        products.get(index).setId(scanner.nextInt());
        request(NEW_LIST_PRICE);
        products.get(index).setListPrice(scanner.nextDouble());
    }

    public void display(int id){
        int index = searchById(id);
        System.out.println(products.get(index));
    }

    public void display(String name){
        int index = searchByName(name);
        System.out.println(products.get(index));
    }

    private int searchById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int searchByName(String name){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().compareTo(name) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void displayAll(){
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void delete (int id){
        int index = searchById(id);
        products.remove(index);
    }

    public void sortByPrice(String description){
        switch (description){
            case INCREASING:
                products.sort(priceComparator);
                break;
            case DECREASING:
//                products.sort(priceComparator);
                Collections.reverse(products);
                break;
            default:
                break;
        }
    }

}
