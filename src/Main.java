import Model.Product;
import Repository.*;
import Service.*;

public class Main {
    public static void main(String[] args) {

        ProductService service =
                new ProductService(new ProductRepositoryImpl());

        service.add(new Product("1", "Laptop", 25000000, "Electronics"));
        service.add(new Product("2", "iPhone", 20000000, "Electronics"));
        service.add(new Product("3", "iPad", 15000000, "Electronics"));
        service.add(new Product("4", "Chair", 2000000, "Home"));

        System.out.println("Top 3 san pham dat nhat:");
        service.getTopExpensive(3)
                .forEach(System.out::println);

        System.out.println("Tong gia tri kho:");
        System.out.println(service.getTotalValue());

        System.out.println("Electronics:");
        System.out.println(service.findByCategory("Electronics").size() + " san pham");
    }
}
