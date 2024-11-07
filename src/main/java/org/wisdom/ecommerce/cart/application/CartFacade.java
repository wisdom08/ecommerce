package org.wisdom.ecommerce.cart.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.val;
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

  public List<CartInfo> getCartBy(Long userId) {
    val validCartId = cartService.getCartsBy(userId);
    val cartItems = cartItemService.getCartItems(validCartId);
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

    return res;
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
