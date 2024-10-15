package org.wisdom.ecommerce.product.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.domain.Product;

@Repository
public interface ProductRepository {

  Product getProductBy(long productId);
}
