package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.domain.Product;

@Repository
public interface ProductRepository {

  Product getProductBy(Long productId);

  List<Product> getProductsBy(List<Long> productIds);

  void updateStock(Product product, Integer quantity);
}
