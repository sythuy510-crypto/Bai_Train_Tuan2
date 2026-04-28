package Service;

import Model.Product;
import Repository.ProductRepository;
import Exception.ProductNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
    private void validate(Product p) {
        if (p.getName() == null || p.getName().isBlank())
            throw new IllegalArgumentException("Name is empty");

        if (p.getPrice() <= 0)
            throw new IllegalArgumentException("Price must be > 0");
    }

    public void add(Product p) {
        validate(p);
        repo.add(p);
    }

    public Product getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Not found: " + id));
    }
    public List<Product> findByCategory(String category) {
        return repo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> getTopExpensive(int n) {
        return repo.findAll().stream()
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public int getTotalValue() {
        return repo.findAll().stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
