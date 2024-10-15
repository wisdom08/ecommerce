package org.wisdom.ecommerce.product.infra;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {


  @EntityGraph(attributePaths = {"product_detail"})
  Product findById(long productId);
}
