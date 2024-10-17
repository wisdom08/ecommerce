package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.application.ProductRepository;
import org.wisdom.ecommerce.product.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product getProductBy(long productId) {
        return productJpaRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(productId + "의 상품이 없습니다"))
                .toDomain();
    }

}