package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CartServiceDto> getCartItems(long validCartId) {
        return repository.getCartItems(validCartId).stream().map(CartServiceDto::from).toList();
    }

    @Transactional
    public void removeItem(long cartId, long productId) {
        repository.removeItem(cartId, productId);
    }

    @Transactional
    public void addItem(long validCartId, long productId, int quantity) {
        repository.save(validCartId, productId, quantity);
    }
}
