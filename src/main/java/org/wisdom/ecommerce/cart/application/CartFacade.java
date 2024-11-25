package org.wisdom.ecommerce.cart.application;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.product.domain.Product;

@Component
public class CartFacade {

  private final CartService cartService;
  private final CartItemService cartItemService;
  private final ProductService productService;

  public CartFacade(CartService cartService, CartItemService cartItemService, ProductService productService) {
    this.cartService = cartService;
    this.cartItemService = cartItemService;
    this.productService = productService;
  }

  public Page<CartInfo> getCartBy(Long userId, int page, int size) {
    val pageRequest = PageRequest.of(page, size);
    val validCartId = cartService.getCartsBy(userId);
    val cartItems = cartItemService.getCartItems(validCartId, pageRequest);
    val productIds = cartItems.stream().map(CartInfo::productId).toList();
    val products = productService.getProductsBy(productIds);

    val productIdToProductMap = products.stream()
        .collect(Collectors.toMap(Product::id, product -> product));

    ArrayList<CartInfo> res = new ArrayList<>();
    cartItems.forEach(cartItem -> {
      val product = productIdToProductMap.get(cartItem.productId());
      if (product != null) {
        res.add(CartInfo.from(product, cartItem));
      }
    });

    return new PageImpl<>(res, pageRequest, cartItems.getTotalElements());
  }

  public void removeProductFromCart(Long userId, Long productId) {
    val validCartId = cartService.getCartsBy(userId);
    cartItemService.removeItem(validCartId, productId);
  }

  public void addProductToCart(Long userId, Long productId, Integer quantity) {
    val validCartId = cartService.getCartsBy(userId);
    val validProductId = productService.getProductBy(productId).id();
    cartItemService.addItem(validCartId, validProductId, quantity);
  }
}
