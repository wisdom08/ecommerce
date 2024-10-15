package org.wisdom.ecommerce.product.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.infra.Product;

@Repository
public interface ProductRepository {

  Product findBy(long productId);
}
