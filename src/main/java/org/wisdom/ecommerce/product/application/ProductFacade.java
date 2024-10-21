package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.order.application.OrderItemService;

@Component
public class ProductFacade {

    private final OrderItemService orderItemService;
    private final ProductService productService;


    public ProductFacade(OrderItemService orderItemService, ProductService productService) {
        this.orderItemService = orderItemService;
        this.productService = productService;
    }

    public ProductApplicationDto getProductBy(long productId) {
        return productService.getProductBy(productId);
    }

    public List<Long> getBestOfProducts() {
        return orderItemService.bestItemsForThreeDays();
    }

    public List<ProductApplicationDto> getProductsBy(List<Long> productIds) {
        return productService.getProductsBy(productIds);
    }


}
