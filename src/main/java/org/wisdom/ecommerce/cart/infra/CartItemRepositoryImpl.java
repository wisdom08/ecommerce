package org.wisdom.ecommerce.cart.infra;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.cart.application.CartItemRepository;
import org.wisdom.ecommerce.cart.domain.CartItem;

import java.util.List;

@Repository
public class CartItemRepositoryImpl implements CartItemRepository {

    private final CartItemJpaRepository repository;

    public CartItemRepositoryImpl(CartItemJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<CartItem> getCartItems(long validCartId) {
        return repository.findAllByCartId(validCartId)
                .stream()
                .map(CartItemEntity::toDomain)
                .toList()
                ;
    }

    @Override
    public void removeItem(long cartId, long productId) {
        repository.deleteByCartIdAndProductId(cartId, productId);
    }

    @Override
    public void save(long validCartId, long productId, int quantity) {
        repository.save(CartItemEntity.of(validCartId, productId, quantity));
    }
}
