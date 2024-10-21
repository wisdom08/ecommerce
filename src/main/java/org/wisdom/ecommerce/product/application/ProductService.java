package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.order.application.OrderItemService;
import org.wisdom.ecommerce.product.domain.Product;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderItemService orderItemService;

    public ProductService(ProductRepository productRepository, OrderItemService orderItemService) {
        this.productRepository = productRepository;
        this.orderItemService = orderItemService;
    }

    public Product getProductBy(long productId) {
        return productRepository.getProductBy(productId);
    }

    public List<Long> getBestOfProducts() {
        return orderItemService.bestItemsForThreeDays();
    }

    public List<ProductServiceDto> getProductsBy(List<Long> productIds) {
        return productRepository.getProductsBy(productIds).stream().map(ProductServiceDto::from).toList();
    }
}
