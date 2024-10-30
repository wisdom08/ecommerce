package org.wisdom.ecommerce.product.application;

import java.util.List;
import lombok.val;
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

  public ProductInfo getProductBy(Long productId) {
    return ProductInfo.from(productService.getProductBy(productId));
  }

  public List<ProductInfo> getBestOfProducts() {
    val bestProductIds = orderItemService.bestProductsForThreeDays();
    val products = productService.getProductsBy(bestProductIds);
    return products.stream().map(ProductInfo::from).toList();
  }
}
