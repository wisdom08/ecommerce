package org.wisdom.ecommerce.product.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository {

  Product getProductBy(long productId);

  List<Product> getProductsBy(List<Long> productIds);
}
