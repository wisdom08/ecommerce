package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public long getCartsBy(long userId) {
        return cartRepository.getCartBy(userId);
    }
}
