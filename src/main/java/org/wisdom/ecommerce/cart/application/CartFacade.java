package org.wisdom.ecommerce.cart.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.product.application.ProductApplicationDto;
import org.wisdom.ecommerce.product.application.ProductService;

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

    public List<CartApplicationDto> getCartBy(long userId) {
        long validCartId = cartService.getCartsBy(userId);
        List<CartApplicationDto> cartItems = cartItemService.getCartItems(validCartId);

        List<Long> productIds = cartItems.stream().map(CartApplicationDto::productId).toList();
        List<ProductApplicationDto> products = productService.getProductsBy(productIds);

        Map<Long, ProductApplicationDto> productIdToProductMap = products.stream()
            .collect(Collectors.toMap(ProductApplicationDto::id, product -> product));

        ArrayList<CartApplicationDto> res = new ArrayList<>();
        cartItems.forEach(cartItem -> {
            ProductApplicationDto product = productIdToProductMap.get(cartItem.productId());
            if (product != null) {
                res.add(CartApplicationDto.from(product, cartItem));
            }
        });

        return res;
    }

    public void removeProductFromCart(long userId, long productId) {
        long validCartId = cartService.getCartsBy(userId);
        cartItemService.removeItem(validCartId, productId);
    }

    public void addProductToCart(long userId, long productId, int quantity) {
        long validCartId = cartService.getCartsBy(userId);
        long validProductId = productService.getProductBy(productId).id();

        cartItemService.addItem(validCartId, validProductId, quantity);

    }
}
