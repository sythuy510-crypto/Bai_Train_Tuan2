package Model;

public class Product {
    private String id;
    private String name;
    private int price;
    private String category;

    public Product(String id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public void setPrice(int price) {this.price = price;}
    public String getId() {return id;}
    public int getPrice() {return price;}
    public void setId(String id) {this.id = id;}

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}
