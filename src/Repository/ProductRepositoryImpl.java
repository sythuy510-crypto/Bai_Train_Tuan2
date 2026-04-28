package Repository;

import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements  ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }
    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void delete(String id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
