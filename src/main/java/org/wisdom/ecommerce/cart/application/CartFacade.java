package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.product.application.ProductServiceDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<CartServiceDto> getCartBy(long userId) {
        long validCartId = cartService.getCartsBy(userId);
        List<CartServiceDto> cartItems = cartItemService.getCartItems(validCartId);

        List<Long> productIds = cartItems.stream().map(CartServiceDto::productId).toList();
        List<ProductServiceDto> products = productService.getProductsBy(productIds);


        Map<Long, ProductServiceDto> productIdToProductMap = products.stream()
                .collect(Collectors.toMap(ProductServiceDto::id, product -> product));

        ArrayList<CartServiceDto> res = new ArrayList<>();
        cartItems.forEach(cartItem -> {
            ProductServiceDto product = productIdToProductMap.get(cartItem.productId());
            if (product != null) {
                res.add(CartServiceDto.from(product, cartItem));
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
        long validProductId = productService.getProductBy(productId).productId();

        cartItemService.addItem(validCartId, validProductId, quantity);

    }
}
