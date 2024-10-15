package org.wisdom.ecommerce.product.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

  Optional<ProductEntity> findById(long productId);
}
