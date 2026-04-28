package Repository;

import Model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void add(Product product);
    Optional<Product> findById(String id);
    List<Product> findAll();
    void delete(String id);
}