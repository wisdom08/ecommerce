package org.wisdom.ecommerce.cart.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CartApplicationDto> getCartItems(long validCartId) {
        return repository.getCartItems(validCartId).stream().map(CartApplicationDto::from).toList();
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
